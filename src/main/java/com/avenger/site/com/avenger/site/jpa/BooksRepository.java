package com.avenger.site.com.avenger.site.jpa;

import com.avenger.site.com.avenger.site.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Long>{

    List<Book> findByReader(String reader);
}
