package com.oocl.web.sampleWebApp.repository;

import com.oocl.web.sampleWebApp.entity.SingleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static com.oocl.web.sampleWebApp.jpaSample.AssertHelper.assertThrows;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SingleEntityRepositoryTest {

    @Autowired
    SingleEntityRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void should_not_save_when_name_exist_length_limit(){
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.name = "THIS IS TO LONGGGGGGGGGGGGGGGGGGGGGGGGGG";

        entityManager.clear();

        assertThrows(Exception.class, () -> {
            repository.save(singleEntity);
            repository.flush();
        });

    }

    @Test
    public void should_save_one(){
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.name = "Hello!!";

        entityManager.clear();
        repository.save(singleEntity);
        repository.flush();

        assertEquals(singleEntity.name, repository.getOne(1L).name);

    }
}
