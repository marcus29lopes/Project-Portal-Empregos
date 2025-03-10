
package com.marcus.jobportal.services;

import com.marcus.jobportal.entity.JobSeekerProfile;
import com.marcus.jobportal.entity.RecruiterProfile;
import com.marcus.jobportal.entity.Users;
import com.marcus.jobportal.repository.JobSeekerProfileRepository;
import com.marcus.jobportal.repository.RecruiterProfileRepository;
import com.marcus.jobportal.repository.UsersRepository;

import java.util.Date;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    public UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        int userTypeId = users.getUserTypeId().getUserTypeId();
        Users savedUser = usersRepository.save(users);
        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));

        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }


    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
