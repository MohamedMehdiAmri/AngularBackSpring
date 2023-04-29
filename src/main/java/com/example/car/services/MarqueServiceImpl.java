package  com.example.car.services;

import com.example.car.entity.Car;
import com.example.car.entity.Marque;
import com.example.car.repositroies.CarRepository;
import com.example.car.repositroies.MarqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Product service implement.
 */
@Service
public class MarqueServiceImpl implements MarqueService {
     @Autowired
     private MarqueRepository marqueRepsotiory;

    

    @Override
    public List<Marque> listAllMarques() {
        return marqueRepsotiory.findAll();
    }

    @Override
    public Marque getMarqueId(Integer id) {
        return marqueRepsotiory.findById(id).get();
    }

    @Override
    public Marque saveMarque(Marque marque) {
        return marqueRepsotiory.save(marque);
    }
    @Override
    public void deleteMarque(Integer id ) {
         marqueRepsotiory.deleteById(id);
    }
}
