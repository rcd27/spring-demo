package com.github.rcd27.demo.model

import javax.persistence.*

@Entity
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        val title: String,
        val isbn: String,
        val publisher: String,

        @ManyToMany
        val authors: Set<Author>
)
