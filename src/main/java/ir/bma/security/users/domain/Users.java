package ir.bma.security.users.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Users implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;

}
