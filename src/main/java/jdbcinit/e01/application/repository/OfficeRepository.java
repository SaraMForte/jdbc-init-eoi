package jdbcinit.e01.application.repository;

import jdbcinit.e01.application.exception.DataAccessException;
import jdbcinit.e01.domain.Office;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository {
    List<Office> findAll() throws DataAccessException;

    Optional<Office> findById(String id) throws DataAccessException;

    void create(Office oficina) throws DataAccessException;

    Office updateById(Office oficina) throws DataAccessException;

    public Office updateFieldById(String id, String field, String value) throws DataAccessException;

    void deleteById(String id) throws DataAccessException;
}
