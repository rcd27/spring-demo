package com.github.rcd27.demo.model

import javax.persistence.*

@Entity
data class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,

        val firstName: String,
        val lastNAme: String,

        @ManyToMany
        val books: Set<Book>
)