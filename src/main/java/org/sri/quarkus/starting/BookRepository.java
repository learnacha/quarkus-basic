package org.sri.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Spirituall")
    String genre;


    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Sri Bhashyam", "Ramanuja", 1000, genre),
                new Book(2, "Ethiraja Vimsathi", "Ramanuja", 1001, genre),
                new Book(3, "Naaliyira Dhivya Prabhandham", "Alwar", 999, genre)
        );
    }


    public int countAllBooks() {
        return getAllBooks().size();
    }


    public Optional<Book> getBook( int id) {
        System.out.println("Calling ID {id}" + id);
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
