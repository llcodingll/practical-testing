package sample.cafekiosk.spring.domain.order;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.registeredDate >= :startDateTime" +
        " and o.registeredDateTime < :endDateTime" +
        " and o.orderStatus = :orderStatus")
    List<Order> findOrderBy(LocalDateTime startDateTime, LocalDateTime endDateTime, OrderStatus orderStatus);
}
