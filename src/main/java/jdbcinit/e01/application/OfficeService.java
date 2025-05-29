package jdbcinit.e01.application;

import jdbcinit.e01.application.exception.DataAccessException;
import jdbcinit.e01.application.repository.OfficeRepository;
import jdbcinit.e01.domain.Office;

import java.util.List;
import java.util.Optional;

public class OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> findAll() throws DataAccessException {
        return officeRepository.findAll();
    }

    public Optional<Office> findById(String id) throws DataAccessException {
        return officeRepository.findById(id);
    }

    public void create(Office oficina) throws DataAccessException {
        officeRepository.create(oficina);
    }

    public Office updateById(Office oficina) throws DataAccessException {
        return officeRepository.updateById(oficina);
    }

    public Office updateFieldById(String id, String field, String value) throws DataAccessException  {
        return officeRepository.updateFieldById(id, field, value);
    }

    public void deleteById(String id) throws DataAccessException {
        officeRepository.deleteById(id);
    }
}
