package mockito.example.service;

import java.util.UUID;
import lombok.AllArgsConstructor;
import mockito.example.exceptions.UnicornNotFoundException;
import mockito.example.pojo.CreateUnicornRequest;
import mockito.example.pojo.Unicorn;
import mockito.example.pojo.UnicornsInfo;
import mockito.example.repository.UnicornRepository;

@AllArgsConstructor
public class UnicornService {

  private final UnicornRepository repository;

  public void updateUnicornSize(UUID id, int size) {
    var unicorn = getUnicorn(id);
    unicorn.setSize(size);
    repository.save(unicorn);
  }

  public Unicorn getUnicorn(UUID id) {
    return repository.findById(id)
      .orElseThrow(() -> new UnicornNotFoundException("Cannot find unicorn with id:" + id));
  }

  public UUID createUnicorn(CreateUnicornRequest request) {
    var unicorn = new Unicorn();
    unicorn.setId(UUID.randomUUID());
    unicorn.setSize(request.size());
    unicorn.setName(request.name());
    unicorn = repository.save(unicorn);
    return unicorn.getId();
  }

  public long getUnicornTotalCount() {
    return repository.count();
  }

  public UnicornsInfo getInfo() {
    return new UnicornsInfo(
            repository.count(),
            UnicornUtils.averageSize(UnicornGender.FEMALE),
            UnicornUtils.averageSize(UnicornGender.MALE));
  }
}
