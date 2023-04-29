package  com.example.car.services;


import com.example.car.entity.Marque;

import java.util.List;

public interface MarqueService {

    List<Marque> listAllMarques();

    Marque getMarqueId(Integer id);

    Marque saveMarque(Marque marque);
    void deleteMarque(Integer id);
    
}
