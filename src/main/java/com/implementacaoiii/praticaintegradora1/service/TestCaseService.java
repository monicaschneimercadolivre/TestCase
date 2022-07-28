package com.implementacaoiii.praticaintegradora1.service;


import com.implementacaoiii.praticaintegradora1.model.TestCase;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TestCaseService {
    TestCase getTestById(long id);
    TestCase createTest(TestCase test);
    List<TestCase> retornaTest ();
    TestCase retornaTestById(long id);
    TestCase atualizarTest(TestCase test);
    TestCase atualizarTestById(long id, Map<String, Object> changes);
    void deleteById(long id);
    List<TestCase> retornaTestByLastUpdate (Date last_update);

}
