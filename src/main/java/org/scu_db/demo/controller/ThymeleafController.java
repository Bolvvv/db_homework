package org.scu_db.demo.controller;

import org.scu_db.demo.model.Book;
import org.scu_db.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class ThymeleafController {

    @Autowired
    BookService bookService;

    @RequestMapping(path = "/index" , method = RequestMethod.GET)
    public String getHtml(Model model){

        model.addAttribute("books" ,bookService.findAllBooks());

        return "index";

    }

    //搜索指定数据
    @RequestMapping(path = "/search" , method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam("id") Integer id){
        ModelAndView mav=new ModelAndView("index");
        mav.addObject("books",bookService.findBookById(id));
        mav.addObject("keyValue",id);
        return mav;
    }

    //删除指定数据
    @RequestMapping(path = "/del")
    public String del(@RequestParam(name = "bookId") Integer bookId){
        bookService.deleteBookById(bookId);
        return "redirect:/index";

    }

    //根据edit或add方法，对数据进行更新
    @RequestMapping(path = "/save" ,method = RequestMethod.POST)
    public ModelAndView add_save(@ModelAttribute Book book, @RequestParam(name = "method") Integer method){
        Integer result;
        result = bookService.updateBook(book, method);
        if(result != 0){
            ModelAndView mav=new ModelAndView("error");
            if(result == 1){
                mav.addObject("msg", "数据库中已有对应id的书!");
            }
            else if(result == 2){
                mav.addObject("msg", "数据库中不存在对应的人员编号!");
            }
            else if(result ==3){
                mav.addObject("msg", "数据库中不存在对应的索引号码!");
            }
            return mav;
        }
        else {
            ModelAndView mav=new ModelAndView("index");
            mav.addObject("books" ,bookService.findAllBooks());
            return mav;
        }
    }

    //向数据库中添加数据
    @RequestMapping(path = "/add" , method = RequestMethod.GET)
    public String add(ModelMap modelMap){
            Book book=new Book();
            modelMap.addAttribute("book",book);
            return "add";
    }
    //修改数据库对应数据
    @RequestMapping(path = "/edit" , method = RequestMethod.GET)
    public String edit(ModelMap modelMap ,@RequestParam(name = "id") Integer id){
        modelMap.addAttribute("book",bookService.findBookById(id));
        return "update";
    }
}