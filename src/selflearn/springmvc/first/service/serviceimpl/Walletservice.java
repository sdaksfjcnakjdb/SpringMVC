package selflearn.springmvc.first.service.serviceimpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import selflearn.springmvc.first.Dao.UserBookDao;
import selflearn.springmvc.first.Dao.UserDao;
import selflearn.springmvc.first.bean.User;
import selflearn.springmvc.first.bean.UserBook;

import javax.annotation.PostConstruct;


@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
@Service
@Component
public class Walletservice {
    public ApplicationContext context;

    @Autowired
    private User user;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBook userBook;

    @Autowired
    private UserBookDao userbookDao;

    @Autowired
    private Loadservice loadservice;

    private static Walletservice userservice;

    @PostConstruct
    public void init(){
        userservice = this;
    }

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }
    @After
    public void after(){
        System.out.println ("CRUD");
    }


// 用户交易书籍

    //用户参数设置
//    user1  收款人
//    user2  付款人
//    money  定价
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void transaction(int  user1,int user2,int money,UserBook userBook){
        userservice.user.setMoney(money);
        userservice.user.setId(user1);
        if (userservice.loadservice.selectById(userservice.user).getType()==1){//如果为会员则本次交易打八折
            money = (int)(money*0.8);
            userservice.user.setMoney(money);
        }
        userservice.userDao.changemoney(userservice.user);
        userservice.user.setMoney(-1*money);
        userservice.user.setId(user2);
        userservice.userDao.changemoney(userservice.user);
        userservice.userbookDao.add (userBook);
    }


    //用户金额变动
    public void changemoney(User user,int money){
        user.setMoney(money);
        userservice.userDao.changemoney(user);
    }

    //用户充值vip
    public void getmember(User user){
        user.setType(1);
        userservice.userDao.member(user);
        userservice.userDao.changemoney(user);
    }

    //用户vip过期
    public void losemember(User user){
        user.setType(0);
        userservice.userDao.member(user);
    }




    @Test
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void test(){
        User user = new User();
        User user0 = new User();
        user.setId(1);
        user0.setId(2);
//        this.transaction(user,user0,100);

    }
}
