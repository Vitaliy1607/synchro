package com.example.synchronize;

import com.example.synchronize.secondary.entity.PersonEntity;
import com.example.synchronize.secondary.repository.PsinaRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyCustomWriter implements ItemWriter<PersonEntity> {

    @Autowired
    PsinaRepository psinaRepository;

    @Override
    public void write(List<? extends PersonEntity> list) throws Exception {
        for (PersonEntity data : list) {
            System.out.println("MyCustomWriter    : Writing data    : " + data.getId()+" : "+data.getFirstName()+" : "+data.getLastName());
            psinaRepository.save(data);
        }
    }
}
