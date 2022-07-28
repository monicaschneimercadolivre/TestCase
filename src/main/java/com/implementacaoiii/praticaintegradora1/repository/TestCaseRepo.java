package com.implementacaoiii.praticaintegradora1.repository;

import com.implementacaoiii.praticaintegradora1.model.TestCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepo extends CrudRepository<TestCase, Long> {
}
