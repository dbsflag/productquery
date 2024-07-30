package tw.yzli.product.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository pResp;

	public Product findById(Integer id) {
		Optional<Product> op = pResp.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public List<Product> findAll() {
		return pResp.findAll();
	}

	public Page<Product> findAllByPage(Pageable pageable) {
		return pResp.findAll(pageable);
	}

	public Product insert(Product p) {
		return pResp.save(p);
	}

	public Product update(Product p) {
		return pResp.save(p);
	}

	public void delete(Product p) {
		pResp.delete(p);
	}

	//search by product name
	public Page<Product> findByPnameLike(String pname, Pageable pageable) {
		return pResp.findByPnameLike( "%"+pname + "%", pageable);
	}
}