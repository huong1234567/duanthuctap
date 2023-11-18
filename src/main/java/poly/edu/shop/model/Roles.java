package poly.edu.shop.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Roles")
@Service
public class Roles implements Serializable {
    @Id
    String id;
    String nameRoles;

    @OneToMany(mappedBy = "Roles")
    List<Account> Account;

}
