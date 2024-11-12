package ra.bt1md5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.bt1md5.model.Product;
import ra.bt1md5.repository.IRepository;

import java.util.List;

@Service
public class ProductService implements IService<Product, Integer> {
    @Autowired
    private IRepository iRepository;

    @Override
    public List<Product> findAll() {
        return iRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return iRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
    }

    @Override
    public void save(Product product) {

        iRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        iRepository.deleteById(id);
    }
}
