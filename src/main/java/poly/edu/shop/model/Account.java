package poly.edu.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account")
@Service
public class Account {
    @Id
    String id;
    @Column(columnDefinition = "NVARCHAR(255)")
    String useName;
    @Column(columnDefinition = "NVARCHAR(255)")
    String fullName;
    String passwordA;
    String email;
    int phone;
    @Column(columnDefinition = "NVARCHAR(255)")
    String adressA;
    @Column(columnDefinition = "NVARCHAR(255)")
    String photo;

    @ManyToOne
    @JoinColumn(name = "idRoles")
    Roles Roles;

}
