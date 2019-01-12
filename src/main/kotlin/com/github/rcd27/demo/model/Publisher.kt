package com.github.rcd27.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Publisher(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
) {

    lateinit var name: String
        private set


    lateinit var address: String
        private set

    constructor(name: String, address: String) : this() {
        this.name = name
        this.address = address
    }
}