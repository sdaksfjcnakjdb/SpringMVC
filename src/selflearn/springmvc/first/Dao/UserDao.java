package selflearn.springmvc.first.Dao;

import org.springframework.stereotype.Repository;
import selflearn.springmvc.first.bean.User;

import java.util.List;

@Repository("UserDao")
public interface UserDao {
    public List<User> selectAll();

    public void  add(User bean);

    public void update(User bean);

    public void  delete(User bean);

    public User selectById(User bean);

    public User selectByName(User bean);

    public  void  changemoney(User bean);

    public  void  member(User bean);


}
