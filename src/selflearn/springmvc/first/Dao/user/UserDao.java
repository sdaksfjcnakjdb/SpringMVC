package selflearn.springmvc.first.Dao.user;

import org.springframework.stereotype.Repository;
import selflearn.springmvc.first.bean.User;

import java.util.List;

@Repository
public interface UserDao {
    public List<User> selectAll();

    public void  add(User bean);

    public void update(User bean);

    public void  delete(User bean);

    public User selectById(User bean);

    public User selectByName(User bean);
}
