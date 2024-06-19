package ir.bma.security.users.service;

import ir.bma.security.users.repository.UsersReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {
    private UsersReopsitory usersReopsitory;

    @Autowired
    public UsersService(UsersReopsitory usersReopsitory) {
        this.usersReopsitory = usersReopsitory;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersReopsitory.findByEmail(username); //email
    }
}
