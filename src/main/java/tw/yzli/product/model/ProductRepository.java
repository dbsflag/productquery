package tw.yzli.product.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ProductRepository extends JpaRepository<Product, Integer> {
	public Page<Product> findByPnameLike(String pname, Pageable pageable);
}
