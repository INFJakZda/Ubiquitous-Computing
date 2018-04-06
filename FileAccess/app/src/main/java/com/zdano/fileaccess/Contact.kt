package com.zdano.fileaccess

class Contact {
    var name: String? = null
    var phone: String? = null

    constructor() {}

    constructor(name: String?, phone: String?) {
        this.name = name
        this.phone = phone
    }

    constructor(line: String?) {
        if(line != null) {
            val tokens = line.split(";")
            if (tokens.size == 2) {
                name = tokens[0]
                phone = tokens[1]
            }
        }
    }

    override fun toString(): String {
        return "Contact $name @ $phone"
    }

    fun toCSV(): String {
        return "$name;$phone\n"
    }
}