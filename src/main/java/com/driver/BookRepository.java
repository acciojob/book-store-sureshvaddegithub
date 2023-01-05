package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public BookRepository(){
        
    }
    HashMap<Integer,Book> booksDb = new HashMap<>();
    public Book save(Book book){
        booksDb.put(book.getId(),book);
        return book;
    }

    public Book findBookById(int id){

        return booksDb.get(id);
    }

    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        for(Book book :booksDb.values())
            books.add(book);
        return books;
    }

    public void deleteBookById(int id){
        booksDb.remove(id);
        return;
    }

    public void deleteAll(){
        booksDb.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books = new ArrayList<>();
        for(Book book :booksDb.values())
        {
            if(book.getAuthor().equals(author)){
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books = new ArrayList<>();
        for(Book book :booksDb.values())
        {
            if(book.getGenre().equals(genre)){
                books.add(book);
            }
        }
        return books;
    }
}
