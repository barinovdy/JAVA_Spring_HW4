package ru.gb.sem4_hw;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserRepository {
    private Map<Long, User> userMap = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    public List<User> findAll(){
        return new ArrayList<>(userMap.values());
    }

    public User findById(Long id){
        return userMap.get(id);
    }

    public User save(User user){
        if (user.getId() == null) {
            user.setId((long)counter.incrementAndGet());
        }
        userMap.put(user.getId(), user);
        return user;
    }
}
