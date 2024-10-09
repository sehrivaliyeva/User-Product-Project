package az.codebridge.task.repository;

import az.codebridge.task.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
}
