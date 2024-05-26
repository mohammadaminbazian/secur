package ir.bma.security.users.service;

import ir.bma.security.users.repository.UsersReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private UsersReopsitory usersReopsitory;

    @Autowired
    public UsersService(UsersReopsitory usersReopsitory) {
        this.usersReopsitory = usersReopsitory;
    }
}
