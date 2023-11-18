package poly.edu.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.shop.model.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
    boolean existsByEmail(String email);

    Account findByEmail(String email);
}
