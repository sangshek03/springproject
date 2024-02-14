package com.againtry.bootstrap;

import com.againtry.domain.Author;
import com.againtry.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.againtry.repositories.AuthorRepository;
import com.againtry.repositories.BookRepository;

@Component
public class BootsratpData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootsratpData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author aric = new Author();
        aric.setFirstName("Abhishek");
        aric.setLastName("Verma");

        Book dd = new Book();
        dd.setTitle("demand draft");
        dd.setIsbn("123");

        Author aricsaved = authorRepository.save(aric);
        Book ddsaved = bookRepository.save(dd);

        Author aric2 = new Author();
        aric.setFirstName("Abhishek2");
        aric.setLastName("Verma2");

        Book dd2 = new Book();
        dd.setTitle("demand draft2");
        dd.setIsbn("6542");

        Author aricsaved2 = authorRepository.save(aric2);
        Book ddsaved2 = bookRepository.save(dd2);

        aricsaved.getBooks().add(ddsaved);
        aricsaved2.getBooks().add(ddsaved2);

        System.out.println("In BootStrap");
        System.out.println(authorRepository.count());
        System.out.println(bookRepository.count());

    }
}
