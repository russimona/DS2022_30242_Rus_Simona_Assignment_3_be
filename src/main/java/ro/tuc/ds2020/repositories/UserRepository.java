package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import ro.tuc.ds2020.entities.User;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
    List<User> findByName(String name);

    Optional<User> findByEmail(String email);
    Optional<List<User>> findByPassword(String password);
    void deleteById(UUID uuid);
    /**
     * Example: Write Custom Query
     */
    @Query(value = "SELECT u " +
            "FROM User u " +
            "WHERE u.email = :email and u.password = :password "
            )
    Optional<User> findUserByEmailAndPassword(@Valid @RequestBody String email, @Valid @RequestBody String password);
}
