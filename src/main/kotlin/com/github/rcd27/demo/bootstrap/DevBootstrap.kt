package com.github.rcd27.demo.bootstrap

import com.github.rcd27.demo.model.Author
import com.github.rcd27.demo.model.Book
import com.github.rcd27.demo.repositories.AuthorRepository
import com.github.rcd27.demo.repositories.BookRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DevBootstrap(val authorRepository: AuthorRepository,
                   val bookRepository: BookRepository) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        initData()
    }

    private fun initData() {
        // Eric
        val eric = Author(firstName = "Eric", lastName = "Evans")
        val ddd = Book(title = "Domain Driven Design", isbn = "1234", publisher = "Harper Collins")
        eric.books.add(ddd)
        ddd.authors.add(eric)

        authorRepository.save(eric)
        bookRepository.save(ddd)

        // Rod
        val rod = Author(firstName = "Rod", lastName = "Johnson")
        val noEJB = Book(title = "J2EE Development without EJB", isbn = "23444", publisher = "Worx")

        authorRepository.save(rod)
        bookRepository.save(noEJB)
    }
}