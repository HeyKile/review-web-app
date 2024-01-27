package com.heykile.reviewgame.repository;

import com.heykile.reviewgame.Model.*;
import com.heykile.reviewgame.repository.SetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations="classpath:application-test.properties")
public class SetRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SetRepository setRepository;

    @Test
    public void whenFindByUserId_thenReturnVocabSet() {
        // given
        User testUser = createTestUser();
        entityManager.persist(testUser);
        entityManager.flush();

        VocabSet testVocabSet = createTestVocabSet(testUser);
        entityManager.persist(testVocabSet);
        entityManager.flush();

        // when
        List<VocabSet> found = setRepository.findByUserId(testVocabSet.getId());
        assertThat(found.get(0).getId()).isEqualTo(testVocabSet.getId());
    }

    // Write more tests for other methods in SetRepository
    
    private User createTestUser() {
        User testUser = new User();
        testUser.setId(1);
        testUser.setFirstName("John");
        testUser.setLastName("Cena");
        testUser.setEmail("jcena@gmail.com");
        testUser.setUsername("cant_c_me");
        testUser.setPassword("BigMan25");
        return testUser;
    }

    private VocabSet createTestVocabSet(User user) {
        VocabSet testSet = new VocabSet();
        testSet.setId(user.getId());
        testSet.setSetName("Foods");
        testSet.setUser(user);
        testSet.setVocabTerms(createTestTerms());
        return testSet;
    }

    private List<Term> createTestTerms() {
        Term term1 = new Term();
        term1.setWord("Apple");
        term1.setDefinition("A round, typically red fruit. Grows in the fall and comes in many varieties");
        
        Term term2 = new Term();
        term2.setWord("Banana");
        term2.setDefinition("Yellow fruit, traditionally loved by primates!");
        
        Term term3 = new Term();
        term3.setWord("Blueberry");
        term3.setWord("A small berry, popular for its distinct color and uses in baked goods like cobbler and muffins");
    
        List<Term> list = new ArrayList<>();
        list.add(term1);
        list.add(term2);
        list.add(term3);
        return list;
    }
}
