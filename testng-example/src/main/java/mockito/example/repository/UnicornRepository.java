package mockito.example.repository;

import java.util.Optional;
import java.util.UUID;

import mockito.example.pojo.Unicorn;

public interface UnicornRepository {

  long count();

  Unicorn save(Unicorn unicorn);

  void delete(UUID id);

  Optional<Unicorn> findById(UUID id);

}
