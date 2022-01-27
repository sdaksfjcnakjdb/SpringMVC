package selflearn.springmvc.first.Dao;

import org.springframework.stereotype.Repository;
import selflearn.springmvc.first.bean.UserBook;

import java.util.List;

@Repository("UserBookDao")
public interface UserBookDao {
    public void add(UserBook userBook);

    public void delete(UserBook userBook);

    public List<UserBook> selectby(UserBook userBook);
}
