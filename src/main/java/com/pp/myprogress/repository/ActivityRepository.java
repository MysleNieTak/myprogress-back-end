package com.pp.myprogress.repository;

import com.pp.myprogress.model.SportActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CRUD - create, read, update, delete, exists
//      - save  , find, save,   delete
// byID, all


@Repository
public interface ActivityRepository extends JpaRepository<SportActivity, Long> {

}
