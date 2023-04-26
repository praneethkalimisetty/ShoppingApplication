package std.application.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import std.application.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
