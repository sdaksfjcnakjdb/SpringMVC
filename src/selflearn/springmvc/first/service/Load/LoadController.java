package selflearn.springmvc.first.service.Load;

import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import selflearn.springmvc.first.bean.Book;
import selflearn.springmvc.first.bean.User;
import selflearn.springmvc.first.bean.UserBook;
import selflearn.springmvc.first.mapper.load.LoadInterService;
import selflearn.springmvc.first.service.Book.Bookservice;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@SessionAttributes(value = {"user"})
@Controller
@RequestMapping("/hi")
@Transactional(rollbackFor = { Exception.class })
public class LoadController{
    public static ApplicationContext context=new ClassPathXmlApplicationContext("selflearn/springmvc/first/mapper/spring.xml");;
    private static final Log logger = LogFactory.getLog (LoadController.class);
    public static Loadservice loadservice = (Loadservice) context.getBean("loadservice");
    public static Bookservice bookservice = (Bookservice) context.getBean("bookservice");


    //登陆服务
    @RequestMapping(value = "/getFrom", method = RequestMethod.POST)
    public String test(
            @ModelAttribute("userload") User user,
            Model model,
            HttpServletResponse response) throws Exception {
        logger.info (user);
        User user1 = loadservice.selectByName (user);
        if(user1 != null) {
            if (user1.getPassword ().equals (user.getPassword ())) {//跳转到主页面
                model.addAttribute ("user", user1);
                ArrayList<Book> listbook = bookservice.selectAll (user1);
                JSONArray bookJsonArray = JSONArray.fromObject (listbook);
                model.addAttribute ("listbook",bookJsonArray);
                return "index";
            } else {
                model.addAttribute ("tips", "账户密码错误！请重新输入！");
                model.addAttribute ("name", "登陆页面");

//                response.setContentType("text/html;charset=gb2312");
//                PrintWriter out = response.getWriter();
//                out.print ("<script \"javascript\">alert('登录成功！');window.location.href='/SpringMVC_war_exploded/WEB-INF/jsp/userload/load'</script>");

                return "userload/load";
            }
        }
        else{
            model.addAttribute ("tips", "账户密码错误！请重新输入！");
            model.addAttribute ("name", "登陆页面");
            return "userload/load";
        }
    }


    //注册服务
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            @ModelAttribute("userload") User user,
            Model model) throws Exception{
        logger.info (user);
        if(loadservice.selectByName (user) != null){
            model.addAttribute ("tips","已存在账号，请换一个账号注册");
            return "userload/register";
        }else{
            loadservice.insert (user);
            model.addAttribute ("tips","注册成功！，请输入账号密码登陆");
            return "userload/load";
        }
    }

    //修改密码服务
    @RequestMapping(value = "/repassword", method = RequestMethod.POST)
    public String repassword(
            Model model,
            @ModelAttribute("userload")User user
    ) {
        User user1 = loadservice.selectByName (user);
        if(user1.getName ().equals (user.getName ()) && user.getPhone () == user1.getPhone ()){//账号密码正确
            user.setId (user1.getId ());
            loadservice.update (user);
            model.addAttribute ("tips","密码修改成功！请输入账号密码登陆");
            return "userload/load";
        }else {
            model.addAttribute ("tips","账号预存手机号输入错误，请重新输入！");
            return "userload/repassword";
        }
    }


    //跳转到注册页面
    @RequestMapping(value = "/toregister", method = RequestMethod.GET)
    public String toMain(Model model) {
        model.addAttribute ("name","注册页面");
       return "userload/register";
    }

    //跳转到修改密码页面
    @RequestMapping(value = "/topassword", method = RequestMethod.GET)
    public String topassword(Model model) {
        model.addAttribute ("name","修改密码页面");
        return "userload/repassword";
    }

    //跳转到登陆页面
    @RequestMapping(value = "/load")
    public String say(Model model) {
        model.addAttribute ("name", "登陆界面");
        return "userload/load";
    }

    //跳转到文件上传页面
    @RequestMapping(value = "/fileupload")
    public String fileupload(Model model) {
        model.addAttribute ("name", "文件上传");
        return "bookload/bookupload";
    }

    //跳转到文件下载页面
    @RequestMapping(value = "/filedownload")
    public String filedownload(
            Model model,
            Book book
    ) {
        model.addAttribute ("name", "文件下载");
        model.addAttribute ("book",book);
        return "bookload/bookdownload";
    }

    //跳转到加入书库页面
    @RequestMapping(value = "/chose")
    public String chose(
        Model model,
        Book book
    ){
        model.addAttribute ("name","选择书籍");
        model.addAttribute ("book",book);
        return "search/booksearch";
    }

    //跳转到书籍搜索
    @RequestMapping(value = "/searchbook")
    public String searchbook(
            Model model,
            User user
    ){
        model.addAttribute ("name", "书籍搜索");
        model.addAttribute ("user",user);
        User user1 =  loadservice.getUser();
        ArrayList<Book> listbook = bookservice.selectAll (user1);
        JSONArray bookJsonArray = JSONArray.fromObject (listbook);
        model.addAttribute ("listbook",bookJsonArray);
        return "search/search";
    }


    /**
     * 文件上传功能
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public @ResponseBody
    ModelAndView upload(
            @ModelAttribute("book") String book,
            @ModelAttribute("author") String author,
            @RequestParam("file") MultipartFile file,
            @ModelAttribute("img") MultipartFile img,
            @ModelAttribute("userid")int userid,
            HttpServletRequest request,
            Model model
    ) throws Exception {
        ModelAndView mv = new ModelAndView("bookload/success");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date ());

        System.out.println (file.getName ());
        System.out.println (img.getName ());

        // uploads文件夹位置
        String bookrootPath = request.getSession().getServletContext().getRealPath("upload/book");
        String imgrootPath = request.getSession().getServletContext().getRealPath("upload/img");

        // 原始名称
        String originalFileName = file.getOriginalFilename();
        String imgoriginalFileName = img.getOriginalFilename();
        // 新文件名
        String booknewFileName = "book" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        String imgnewFileName = "img" + res + imgoriginalFileName.substring(imgoriginalFileName.lastIndexOf("."));
        // 创建年月文件夹
        Calendar date = Calendar.getInstance();



        // 书籍新文件
        File booknewFile = new File(bookrootPath + File.separator  + booknewFileName);
        // 判断目标文件所在目录是否存在
        if( !booknewFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            booknewFile.getParentFile().mkdirs();
        }
        System.out.println(booknewFile);
        // 将内存中的数据写入磁盘
        file.transferTo(booknewFile);
        // 完整的url




        // 封面新文件
        File imgnewFile = new File(imgrootPath + File.separator  + imgnewFileName);
        // 判断目标文件所在目录是否存在
        if( !imgnewFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            imgnewFile.getParentFile().mkdirs();
        }
        System.out.println(imgnewFile);
        // 将内存中的数据写入磁盘
        img.transferTo(imgnewFile);
        // 完整的url



        //写入数据库
        Book book1 = bookservice.getBook ();
        book1.setName (book);
        book1.setAuthor (author);
        book1.setImg (imgnewFileName);
        book1.setFileUrl (booknewFileName);
        book1.setLoadperson (userid);

        UserBook userBook = bookservice.getuserbook ();
        userBook.setPersonid (userid);
        userBook.setBookid (bookservice.insert(book1,userBook));
        model.addAttribute ("name","书籍:《"+book+"》上传完成");
        return  mv;
    }



    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down")
    public ModelAndView down(HttpServletRequest request, HttpServletResponse response,String bookname,String bookid,Model model) throws Exception{
        ModelAndView mv = new ModelAndView("bookload/success");
        System.out.println (bookname);
        String fileName = request.getSession().getServletContext().getRealPath("upload/book/")+bookname;
        //获取输入流
        InputStream bis = new BufferedInputStream (new FileInputStream (fileName));
        //假如以中文名下载的话
        String filename = bookname;
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
        model.addAttribute ("name","书籍:《"+bookname+"》下载完成");
        System.out.println ("id:"+bookid);
        bookservice.pontchange(Integer.parseInt (bookid));
        return mv;
    }

    /**
     * 订阅书籍功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/search")
    public ModelAndView  search (HttpServletRequest request, HttpServletResponse response, UserBook userBook, String bookname, Model model) throws Exception{
        ModelAndView mv = new ModelAndView("bookload/success");
        if(bookservice.search (userBook)){// 该用户已订阅该书籍
            model.addAttribute ("name","您已订阅该书籍");
            return mv;
        }else {
            bookservice.addbook(userBook);
            model.addAttribute ("name", "书籍:《" + bookname + "》订阅成功，回到主页面刷新即可查看");
            return mv;
        }
    }


}
