package com.github.rcd27.demo.bootstrap

import com.github.rcd27.demo.model.Author
import com.github.rcd27.demo.model.Book
import com.github.rcd27.demo.model.Publisher
import com.github.rcd27.demo.repositories.AuthorRepository
import com.github.rcd27.demo.repositories.BookRepository
import com.github.rcd27.demo.repositories.PublisherRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DevBootstrap(val authorRepository: AuthorRepository,
                   val bookRepository: BookRepository,
                   val publisherRepository: PublisherRepository) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        initData()
    }

    private fun initData() {
        val harperCollinsPublisher = Publisher(name = "Harper Collins", address = "Blue Bay, That Girl' House")
        val worksPublisher = Publisher(name = "Worx", address = "San Diego")
        publisherRepository.apply {
            save(harperCollinsPublisher)
            save(worksPublisher)
        }

        // Eric
        val eric = Author(firstName = "Eric", lastName = "Evans")
        val ddd = Book(
                title = "Domain Driven Design",
                isbn = "1234",
                publisher = harperCollinsPublisher)
        eric.books.add(ddd)
        ddd.authors.add(eric)

        authorRepository.save(eric)
        bookRepository.save(ddd)

        // Rod
        val rod = Author(firstName = "Rod", lastName = "Johnson")
        val noEJB = Book(title = "J2EE Development without EJB",
                isbn = "23444",
                publisher = worksPublisher)

        authorRepository.save(rod)
        bookRepository.save(noEJB)
    }
}