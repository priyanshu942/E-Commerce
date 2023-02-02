package com.example.chatapp

class User {
    var uid:String?=null
    var email:String?=null
    var password:String?=null

    constructor() {}

    constructor(uid:String,email:String,password:String)
    {
        this.uid=uid
        this.email=email
        this.password=password
    }
        }