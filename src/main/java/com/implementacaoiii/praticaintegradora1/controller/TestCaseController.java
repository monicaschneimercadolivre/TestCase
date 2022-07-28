package com.implementacaoiii.praticaintegradora1.controller;

import com.implementacaoiii.praticaintegradora1.model.TestCase;
import com.implementacaoiii.praticaintegradora1.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TestCaseController {
    @Autowired
    TestCaseService service;

    @PostMapping ("/new")
    public ResponseEntity<TestCase> inserirTeste (@RequestBody TestCase test) {
        service.createTest(test);
        return ResponseEntity.ok(test);
    }

    @GetMapping ("/testcases")
    public ResponseEntity<List<TestCase>> getAllTests (){
       return ResponseEntity.ok(service.retornaTest());
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCase> getTestById(@PathVariable long id){
       TestCase testCaseById = service.retornaTestById(id);
        return ResponseEntity.ok(testCaseById);
    }

    @PutMapping("/testcases")
    public ResponseEntity<TestCase> updateTest(@RequestBody TestCase test){
        return ResponseEntity.ok(service.atualizarTest(test));
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<TestCase> updateTestById (@PathVariable long id, @RequestBody Map<String, Object> changes){
        return ResponseEntity.ok(service.atualizarTestById(id,changes));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable long id){
        service.deleteById(id);
       return ResponseEntity.noContent().build()  ;
    }

    @GetMapping("/atualizados")
    public ResponseEntity<List<TestCase>> updatedAfterDate(@RequestParam Date last_update){
        return ResponseEntity.ok(service.retornaTestByLastUpdate(last_update));
    }
}
