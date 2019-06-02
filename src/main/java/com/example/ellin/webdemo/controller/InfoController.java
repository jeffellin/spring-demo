package com.example.ellin.webdemo.controller;

import com.example.ellin.webdemo.Hello;
import com.example.ellin.webdemo.Info;
import com.example.ellin.webdemo.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class InfoController {

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("/")
    public Info getInfo(){

        Info.InfoBuilder builder = Info.builder();

        String hostname;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            builder.hostname(hostname).ip(ip.toString());
            builder.phrase(helloRepository.findById("hello").orElse(new Hello()).getPhrase());
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

        return builder.build();
    }
}
