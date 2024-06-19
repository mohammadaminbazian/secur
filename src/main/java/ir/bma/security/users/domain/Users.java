package ir.bma.security.users.domain;

import ir.bma.security.enums.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Users implements Serializable, UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private Boolean enabled = true;

    @ElementCollection(targetClass = UserRoles.class,fetch = FetchType.EAGER) // Moadel Table
    @CollectionTable( name = "authorities",
            joinColumns = @JoinColumn(name = "email",referencedColumnName = "email")
    )
    @Enumerated(EnumType.STRING) // bargardandan meghdar string
    private List<UserRoles> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRoles ;
    }

    @Override
    public String getUsername() {
        return null;
    }
}
