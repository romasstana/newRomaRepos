package kz.singularity.sendingemail.repository;


import kz.singularity.sendingemail.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByEmail(String email);

    Users findByEmail(String email);

    void deleteByEmail(String email);
}
