package selflearn.springmvc.first.service.serviceimpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import selflearn.springmvc.first.Dao.BookDao;
import selflearn.springmvc.first.Dao.UserBookDao;
import selflearn.springmvc.first.bean.Book;
import selflearn.springmvc.first.bean.User;
import selflearn.springmvc.first.bean.UserBook;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
@Service
@Component
public class Bookservice {
    public  ApplicationContext context;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserBook userBook;

    @Autowired
    private Book book;

    @Autowired
    private User user;

    @Qualifier("UserBookDao")
    @Autowired
    private UserBookDao userbookDao;

    private static Bookservice bookservice;

    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {
        bookservice = this;
    }


    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext ("spring/spring-dao.xml");
    }
    @After
    public void after(){
        System.out.println ("CRUD");
    }


    //返回book实例
    public  Book getBook(){
//        before();
//        Book book = (Book)context.getBean ("book");
        return  bookservice.book;
    }

    //返回userbook实例
    public  UserBook getuserbook(){
        before();
        return  bookservice.userBook;
    }


    //新增书籍,加入订阅
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public int insert(Book book, UserBook userBook){
//        before();
//        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        bookservice.bookDao.add (book);
        //人为制造错误
//        System.out.println(1/0);
        userBook.setBookid(book.getId());
        addbook(userBook);
        return book.getId ();
        }


    //修改书籍
    public  void update(Book book){
//        before();
//        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        bookservice.bookDao.update(book);
    }

    //查找所有书籍
    public  ArrayList<Book> selectAll(User user){
//        before();
//        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        ArrayList<Book> bookList =  bookservice.bookDao.selectAll (user);
        return bookList;
    }

    //依据书名查找书籍
    public  List<Book> selectByname(Book book){
//        before();
//        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        List<Book>  bookList = bookservice.bookDao.selectByName (book);
        return bookList;
    }
    //依据作者查找书籍
    public  List<Book> selectByauthor(Book book){
//        before();
//        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        List<Book>  bookList = bookservice.bookDao.selectByauthor (book);
        return bookList;
    }

    
    //动态sql查询书籍
    public  List<Book> selectBy(Book book){
//        before();
//        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        List<Book>  bookList = bookservice.bookDao.selectBy (book);
        return bookList;
    }



    //动态sql删除书籍
    public  void delete(Book book){
//        before();
//        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        bookservice.bookDao.delete (book);
    }

    //点击量记录
    public  void pontchange(int id){
//        before();
//        BookDao bookDao = (BookDao) context.getBean ("BookDao");
//        Book book = (Book)context.getBean ("book");
        bookservice.book.setId (id);
        bookservice.bookDao.pontchange (bookservice.book);
    }


    //订阅书籍
    public  void  addbook(UserBook userBook){
//        before();
//        UserBookDao userbookDao = (UserBookDao) context.getBean ("userBookDao");
        bookservice.userbookDao.add (userBook);

    }

    //查询书籍是否在用户仓库中
    public  boolean search(UserBook userBook){
//        before();
//        UserBookDao userbookDao = (UserBookDao) context.getBean ("userBookDao");
        List<UserBook> bookList = bookservice.userbookDao.selectby (userBook);
        if (bookList.size () == 0){
            return false;
        }
        return true;
    }







    @Test
    public void  test(){
//        before();
        UserBookDao userbookDao = (UserBookDao) context.getBean ("userBookDao");
        UserBook userBook = (UserBook)context.getBean ("userbook");
        userBook.setBookid (63);
        userBook.setPersonid (12);
        List<UserBook> bookList = userbookDao.selectby (userBook);
    }
    

    
    @Test
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void insertT(){
//    before();
//    Book book = (Book)context.getBean ("book");
    bookservice.book.setName ("测试名称");
    bookservice.book.setAuthor ("我1");
    bookservice.book.setFileUrl ("文件路径");
    bookservice.book.setImg ("图谱路径");
    bookservice.bookDao.add (bookservice.book);
        throw new RuntimeException("huigun");

    }
    @Test
    public void updateT(){
//        before();
        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        Book book = (Book)context.getBean ("book");
        book.setName ("测试名称");
        book.setAuthor ("我");
        book.setFileUrl ("文件路径");
        book.setImg ("图谱路径");
        book.setId (1);
        bookDao.update(book);
    }
@Test
    public void selectAllT(){
//    before();
        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        User user = (User) context.getBean ("user");
//        user.setId (1);
        List<Book> bookList =  bookDao.selectAll (user);
        System.out.println (bookList);
    }


@Test
    public void selectBynameT(){
//    before();
        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        Book book = (Book)context.getBean ("book");
        book.setName ("测试名称");
        List<Book>  bookList = bookDao.selectByName (book);
        System.out.println (bookList);
    }


    @Test
    public void selectByauthorT(){
//        before();
        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        Book book = (Book)context.getBean ("book");
        book.setAuthor ("我");
        List<Book>  bookList = bookDao.selectByauthor (book);
        System.out.println (bookList);
    }


    //动态sql
    @Test
    public void selectBy(){
//        before();
        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        Book book = (Book)context.getBean ("book");
        book.setAuthor ("我");
//        book.setName ("测试名称");
        List<Book>  bookList = bookDao.selectBy (book);
        System.out.println (bookList);
    }


    //动态sql
    @Test
    public void delete(){
//        before();
        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        Book book = (Book)context.getBean ("book");
        book.setAuthor ("我");
        bookDao.delete (book);
    }

    @Test
    public void pontchangeT(){
//        before();
        BookDao bookDao = (BookDao) context.getBean ("BookDao");
        Book book = (Book)context.getBean ("book");
        book.setId (50);
        bookDao.pontchange (book);
    }
}
