package com.connectto.mobile;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {PersistenceContext.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("todo-entries.xml")
/**
 * Created by Serozh on 5/3/2017.
 */
public class ITFindBySearchTermTest {/*

    @Autowired
    private TodoRepository repository;

    @Test
    public void findBySearchTerm_TitleOfFirstTodoEntryContainsGivenSearchTerm_ShouldReturnOneTodoEntry() {
        List<Todo> searchResults = repository.findBySearchTerm("iTl");
        assertThat(searchResults).hasSize(1);
    }

    @Test
    public void findBySearchTerm_TitleOfFirstTodoEntryContainsGivenSearchTerm_ShouldReturnFirstTodoEntry() {
        List<Todo> searchResults = repository.findBySearchTerm("iTl");

        Todo found = searchResults.get(0);
        assertThat(found.getId()).isEqualTo(1L);
    }*/
}