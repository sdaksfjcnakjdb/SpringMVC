package selflearn.springmvc.first.service.Load;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import selflearn.springmvc.first.Dao.user.UserDao;
import selflearn.springmvc.first.bean.Book;
import selflearn.springmvc.first.bean.User;
import selflearn.springmvc.first.mapper.load.LoadInterService;

import java.util.List;

public class Loadservice implements LoadInterService {
    public static ApplicationContext context;

    @Before
    public void before(){
        System.out.println ("start");
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
    }
    @After
    public void after(){
        System.out.println ("CRUD");
    }

    public List<User> selectAll(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        UserDao userDao = (UserDao) context.getBean ("userDao");
        List<User> userList = userDao.selectAll ();
        return userList;
    }

    //返回user实例
    public  User getUser(){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        return  (User) context.getBean ("user");
    }


    //查询
    public User selectById(User user){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        UserDao userDao = (UserDao) context.getBean ("userDao");
        User user1 = userDao.selectByName (user);
        return user1;
    }


    public  User selectByName(User user){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        UserDao userDao = (UserDao) context.getBean ("userDao");
        User user1 = userDao.selectByName (user);
        return user1;
    }

    //插入
    public  void insert(User user){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        UserDao userDao = (UserDao) context.getBean ("userDao");
        userDao.add(user);
    }

    //修改密码
    public  void update(User user){
        context = new ClassPathXmlApplicationContext ("selflearn/springmvc/first/mapper/spring.xml");
        UserDao userDao = (UserDao) context.getBean ("userDao");
        userDao.update (user);
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
