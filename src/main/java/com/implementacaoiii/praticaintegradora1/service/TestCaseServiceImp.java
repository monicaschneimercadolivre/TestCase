package com.implementacaoiii.praticaintegradora1.service;

import com.implementacaoiii.praticaintegradora1.model.TestCase;
import com.implementacaoiii.praticaintegradora1.repository.TestCaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TestCaseServiceImp implements TestCaseService {
    @Autowired
    TestCaseRepo repo;

    public TestCase getTestById(long id){

        return repo.findById(id).get();
    }

    @Override
    public TestCase createTest(TestCase test) {
        return repo.save(test);
    }

    @Override
    public List<TestCase> retornaTest() {

        return (List<TestCase>) repo.findAll();
    }

    @Override
    public TestCase retornaTestById(long id) {

        return repo.findById(id).get();
    }


    @Override
    public TestCase atualizarTest(TestCase test) {
        TestCase testFound = getTestById(test.getId_case());
        return repo.save(testFound);
    }

   /* @Override
    public TestCase atualizarTest(TestCase test, long id) {
        TestCase testFound = getTestById(id);
        testFound.setTested(test.isTested());
        return repo.save(testFound);
    }*/

    @Override
    public TestCase atualizarTestById(long id, Map<String, Object> changes) {
        TestCase testFound = getTestById(id);

        changes.forEach((atributo, valor)->{
            switch (atributo){
            case "description": testFound.setDescription((String)valor); break;
            case "tested" : testFound.setTested((boolean) valor); break;
            }
        });
        return testFound;
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<TestCase> retornaTestByLastUpdate(Date last_update) {
        return (List<TestCase>) repo.findAll();
    }


}
