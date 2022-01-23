package selflearn.springmvc.first.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes(value = {"book"})
@Controller
@RequestMapping("/book")
public class BookContoller {

}
