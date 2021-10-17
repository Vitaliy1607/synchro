package com.example.synchronize;

import com.example.synchronize.primary.entity.PersonEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
;

@Component
public class MyCustomProcessor implements ItemProcessor<PersonEntity, com.example.synchronize.secondary.entity.PersonEntity> {

    @Override
    public com.example.synchronize.secondary.entity.PersonEntity process(PersonEntity emp) throws Exception {
        System.out.println("MyBatchProcessor : Processing data : "+emp);
        com.example.synchronize.secondary.entity.PersonEntity manager = new com.example.synchronize.secondary.entity.PersonEntity();
        //manager.setId(emp.getId());
        manager.setFirstName(emp.getFirstName().toUpperCase());
        manager.setLastName(emp.getLastName());
        manager.setGender(emp.getGender());
        return manager;
    }
}
