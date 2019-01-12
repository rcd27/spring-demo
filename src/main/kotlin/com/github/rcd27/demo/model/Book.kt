package com.github.rcd27.demo.model

import javax.persistence.*

@Entity
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,

        val title: String,
        val isbn: String,

        @OneToOne
        val publisher: Publisher,

        @ManyToMany
        @JoinTable(
                name = "author_book",
                joinColumns = [JoinColumn(name = "book_id")],
                inverseJoinColumns = [JoinColumn(name = "author_id")])
        val authors: MutableSet<Author> = mutableSetOf()
)
