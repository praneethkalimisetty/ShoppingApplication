package std.application.inventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import std.application.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	public List<Inventory> findBySkuCodeIn(List<String> skuCodes);
}
