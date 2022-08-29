package accessingdatamysql.DataObjects;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called registerRepository
// CRUD refers Create, Read, Update, Delete

public interface RegisterRepository extends CrudRepository<Register, Integer> {

    void save(Register n);

}
