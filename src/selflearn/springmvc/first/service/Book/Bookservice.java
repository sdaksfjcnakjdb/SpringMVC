package selflearn.springmvc.first.service.Book;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import selflearn.springmvc.first.Dao.book.BookDao;
import selflearn.springmvc.first.Dao.userbook.UserBookDao;
import selflearn.springmvc.first.bean.Book;
import selflearn.springmvc.first.bean.User;
import selflearn.springmvc.first.bean.UserBook;

import java.util.ArrayList;
import java.util.List;

public class Bookservice {
    public static ApplicationContext context;
    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
    }
    @After
    public void after(){
        System.out.println ("CRUD");
    }


    //返回book实例
    public static Book getBook(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        return  (Book) context.getBean ("book");
    }

    //新增书籍
    public static void insert(Book book){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        bookDao.add (book);
    }

    //修改书籍
    public static void update(Book book){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        bookDao.update(book);
    }

    //查找所有书籍
    public static ArrayList<Book> selectAll(User user){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        ArrayList<Book> bookList =  bookDao.selectAll (user);
        return bookList;
    }

    //依据书名查找书籍
    public static List<Book> selectByname(Book book){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        List<Book>  bookList = bookDao.selectByName (book);
        return bookList;
    }
    //依据作者查找书籍
    public static List<Book> selectByauthor(Book book){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        List<Book>  bookList = bookDao.selectByauthor (book);
        return bookList;
    }

    
    //动态sql查询书籍
    public static List<Book> selectBy(Book book){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        List<Book>  bookList = bookDao.selectBy (book);
        return bookList;
    }



    //动态sql删除书籍
    public static void delete(Book book){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        bookDao.delete (book);
    }

    //点击量记录
    public static void pontchange(int id){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        Book book = (Book)context.getBean ("book");
        book.setId (id);
        bookDao.pontchange (book);
    }


    //订阅书籍
    public static void  addbook(UserBook userBook){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        UserBookDao userbookDao = (UserBookDao) context.getBean ("userbookDao");
        userbookDao.add (userBook);
    }

    @Test
    public void  test(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        UserBookDao userbookDao = (UserBookDao) context.getBean ("userbookDao");
        UserBook userBook = (UserBook)context.getBean ("userbook");
        userBook.setBookid (63);
        userBook.setPersonid (1);
        userbookDao.add (userBook);
    }
    

    
@Test
    public void insertT(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        Book book = (Book)context.getBean ("book");
        book.setName ("测试名称");
        book.setAuthor ("我1");
        book.setFileUrl ("文件路径");
        book.setImg ("图谱路径");
        bookDao.add (book);
    }
    @Test
    public void updateT(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
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
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        User user = (User) context.getBean ("user");
//        user.setId (1);
        List<Book> bookList =  bookDao.selectAll (user);
        System.out.println (bookList);
    }


@Test
    public void selectBynameT(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        Book book = (Book)context.getBean ("book");
        book.setName ("测试名称");
        List<Book>  bookList = bookDao.selectByName (book);
        System.out.println (bookList);
    }


    @Test
    public void selectByauthorT(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        Book book = (Book)context.getBean ("book");
        book.setAuthor ("我");
        List<Book>  bookList = bookDao.selectByauthor (book);
        System.out.println (bookList);
    }


    //动态sql
    @Test
    public void selectBy(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        Book book = (Book)context.getBean ("book");
        book.setAuthor ("我");
//        book.setName ("测试名称");
        List<Book>  bookList = bookDao.selectBy (book);
        System.out.println (bookList);
    }


    //动态sql
    @Test
    public void delete(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        Book book = (Book)context.getBean ("book");
        book.setAuthor ("我");
        bookDao.delete (book);
    }

    @Test
    public void pontchangeT(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        BookDao bookDao = (BookDao) context.getBean ("bookDao");
        Book book = (Book)context.getBean ("book");
        book.setId (50);
        bookDao.pontchange (book);
    }
}
