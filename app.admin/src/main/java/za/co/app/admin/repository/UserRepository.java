package za.co.app.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import za.co.app.admin.model.User;

public interface UserRepository extends MongoRepository<User, String> {

  User findByUsername(String username);
}
