package dmit2015.repository;

import common.jpa.AbstractJpaRepository;
import dmit2015.entity.TodoItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class TodoItemRepository extends AbstractJpaRepository<TodoItem, Long> {

    public TodoItemRepository() {
        super(TodoItem.class);
    }

    public List<TodoItem> findAllByUsername(String username) {
        return getEntityManager().createQuery("""
                SELECT t FROM TodoItem t
                WHERE t.username = :username
                ORDER BY t.id
                """, TodoItem.class)
                .setParameter("username", username)
                .getResultList();
    }

}