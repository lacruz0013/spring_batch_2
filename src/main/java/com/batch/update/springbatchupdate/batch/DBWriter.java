package com.batch.update.springbatchupdate.batch;


import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch.update.springbatchupdate.model.User;
import com.batch.update.springbatchupdate.repository.UserRepository;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {

        System.out.println("Data Saved for Users: " + users);
        for(User user: users) {
        userRepository.findById(user.getId()).map(userData -> {
        	userData.setName(user.getName());
        	userData.setDept(user.getDept());
        	userData.setSalary(user.getSalary());
        	userData.setTime(user.getTime());
        	User updatedUser = userRepository.save(userData); 
        	return  updatedUser; });
        }
    }
}
