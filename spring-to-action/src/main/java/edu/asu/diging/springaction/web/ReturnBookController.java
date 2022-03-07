package edu.asu.diging.springaction.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.asu.diging.simpleusers.core.model.IUser;
import edu.asu.diging.simpleusers.core.service.IUserManager;
import edu.asu.diging.springaction.core.model.Book;
import edu.asu.diging.springaction.core.model.impl.BookImpl;
import edu.asu.diging.springaction.core.service.BookManager;
import edu.asu.diging.springaction.core.service.impl.BookManagerImpl;

@Controller
public class ReturnBookController {
	@Autowired
    private BookManager bookManager;
    
    @Autowired
    private IUserManager userManager;
    
    @RequestMapping(value="/auth/book/{bookId}/return", method=RequestMethod.POST)
    public String returnBook(@PathVariable("bookId") String bookId, Principal principal, RedirectAttributes redirectAttrs) {
        Book book = bookManager.get(new Long(bookId));
        if (book != null) {
            if (!book.isAvailable()) {
                bookManager.Return(book);
                redirectAttrs.addFlashAttribute("msg", "Book is Returned");
            } else  {
                redirectAttrs.addFlashAttribute("msg", "Book has already been returned.");
            }
        }
        return "redirect:/admin/books/findBookByUser";	

}
    @RequestMapping(value = "/admin/books/findBookByUser")
    public String home(Model model ,Principal principal) {
    	model.addAttribute("books", bookManager.findByUser(userManager.findByUsername(principal.getName())));
        return "admin/books/findBookByUser";
        
        
    }
    
    
    
}
