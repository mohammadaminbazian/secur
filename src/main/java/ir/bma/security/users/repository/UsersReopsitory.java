package ir.bma.security.users.repository;

import ir.bma.security.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersReopsitory extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
