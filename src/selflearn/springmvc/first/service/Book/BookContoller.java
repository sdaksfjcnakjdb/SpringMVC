package selflearn.springmvc.first.service.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import selflearn.springmvc.first.bean.Book;
import selflearn.springmvc.first.bean.User;
import selflearn.springmvc.first.service.Load.Loadservice;

import java.util.List;

@SessionAttributes(value = {"book"})
@Controller
@RequestMapping("/book")
public class BookContoller {

}
