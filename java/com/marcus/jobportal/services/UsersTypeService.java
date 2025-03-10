
package com.marcus.jobportal.services;

import com.marcus.jobportal.entity.UsersType;
import com.marcus.jobportal.repository.UsersTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersTypeService {
    private UsersTypeRepository usersTypeRepository;

    @Autowired
    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll() {
        return this.usersTypeRepository.findAll();
    }
}
