package com.avenger.site.com.avenger.site.controller;

import com.avenger.site.com.avenger.site.entity.Book;
import com.avenger.site.com.avenger.site.jpa.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/books")
public class BookController {
    private BooksRepository booksRepository;

    @Autowired
    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model){
        List<Book> bookList = booksRepository.findByReader(reader);
        if(!Objects.isNull(bookList)){
            model.addAttribute("books", bookList);
        }
        return "books";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addBook(@PathVariable("reader") String reader, Book book){
        book.setReader(reader);
        booksRepository.save(book);
        return "redirect:/books/{reader}";
    }
}
