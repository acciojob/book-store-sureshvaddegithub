package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        Book book = bookService.findBookById(String.valueOf(id));
        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }
    @GetMapping("get-all-books")
    public ResponseEntity<List<Book>> GetAllBooks(){
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books,HttpStatus.CREATED);
    }
    @GetMapping("get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author){
        List<Book> books = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(books,HttpStatus.CREATED);
    }
    @GetMapping("get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre){
        List<Book> books = bookService.findBooksByAuthor(genre);
        return new ResponseEntity<>(books,HttpStatus.CREATED);
    }
    @DeleteMapping("delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id){
        bookService.deleteBookById(String.valueOf(id));
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
    @DeleteMapping("delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

}
