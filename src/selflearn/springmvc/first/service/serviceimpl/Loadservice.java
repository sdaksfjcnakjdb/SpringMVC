package selflearn.springmvc.first.service.serviceimpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import selflearn.springmvc.first.Dao.BookDao;
import selflearn.springmvc.first.Dao.UserBookDao;
import selflearn.springmvc.first.Dao.UserDao;
import selflearn.springmvc.first.bean.Book;
import selflearn.springmvc.first.bean.User;
import selflearn.springmvc.first.bean.UserBook;
import selflearn.springmvc.first.service.LoadInterService;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class Loadservice implements LoadInterService {
    public static ApplicationContext context;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserBookDao userbookDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBook userBook;

    @Autowired
    private Book book;

    @Autowired
    private User user;



    private static Loadservice loadservicel;
    @PostConstruct
    public void init() {
        loadservicel = this;
    }
    @Before
    public void before(){
        System.out.println ("start");
        context = new ClassPathXmlApplicationContext ("spring/spring-dao.xml");
    }
    @After
    public void after(){
        System.out.println ("CRUD");
    }



    public List<User> selectAll(){
        //context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
//        before();
//        UserDao userDao = (UserDao) context.getBean ("userDao");
        return loadservicel.userDao.selectAll ();
    }

    //返回user实例
    public  User getUser(){
        //context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
//        before();
        return  loadservicel.user;
    }


    //查询
    public User selectById(User user){
        //context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
//        before();
//        UserDao userDao = (UserDao) context.getBean ("userDao");
        return loadservicel.userDao.selectById (user);
    }


    public  User selectByName(User user){
        //context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
//        before();
//            UserDao userDao = (UserDao) context.getBean ("userDao");
        return loadservicel.userDao.selectByName (user);
    }

    //插入
    public  void insert(User user){
        //context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
//        before();
//        UserDao userDao = (UserDao) context.getBean ("userDao");
        loadservicel.userDao.add(user);
    }

    //修改密码
    public  void update(User user){
        //context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
//        before();
//        UserDao userDao = (UserDao) context.getBean ("userDao");
        loadservicel.userDao.update (user);
    }



    @Test
    public void selectAllT(){
        UserDao userDao = (UserDao) context.getBean ("userDao");
        List<User> userList = userDao.selectAll ();
    }


    @Test
    public void selectByIdT(){
        UserDao userDao = (UserDao) context.getBean ("userDao");
        User user = (User) context.getBean ("user");
        user.setId (1);
        User user1 = userDao.selectById (user);
    }

    @Test
    public void selectByNameT(){
        UserDao userDao = (UserDao) context.getBean ("userDao");
        User user = (User) context.getBean ("user");
        user.setName ("asodn");
        User user1 = userDao.selectByName (user);
    }

    @Test
    public void updateT(){
        UserDao userDao = (UserDao) context.getBean ("userDao");
        User user = (User) context.getBean ("user");
        user.setId (4);
        user.setPhone (123456789);
        user.setPassword ("100200");
        user.setName ("李四");
        userDao.update (user);
    }
}
