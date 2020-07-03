package com.greeting.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    private final String template = "Hello %s ! ";
    private final AtomicLong atomicLong = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    public Greeting findGreeting(Long employeeId) {
        return greetingRepository.findById(employeeId).get();
    }

    public Greeting saveGreeting(User user) {
        String message = String.format(template,(user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(atomicLong.incrementAndGet(),message));
    }

}