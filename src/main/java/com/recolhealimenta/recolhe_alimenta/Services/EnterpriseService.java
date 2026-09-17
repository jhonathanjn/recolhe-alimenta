package com.recolhealimenta.recolhe_alimenta.Services;

import com.recolhealimenta.recolhe_alimenta.Dtos.EnterpriseDTO;
import com.recolhealimenta.recolhe_alimenta.Dtos.UserDTO;
import com.recolhealimenta.recolhe_alimenta.Models.Enterprise;
import com.recolhealimenta.recolhe_alimenta.Models.User;
import com.recolhealimenta.recolhe_alimenta.Repositories.EnterpriseRepositorie;
import com.recolhealimenta.recolhe_alimenta.Repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepositorie repo;

    public List<Enterprise> getAll(){
        List<Enterprise> enterprise = repo.findAll()  ;
        return enterprise;
    }

    public Enterprise getById(Long id){
        Enterprise enterprise = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return enterprise;
    }

    public Enterprise addEnterprise(EnterpriseDTO dto){
        Enterprise enterprise = new Enterprise();

        if (dto.getName() == null || dto.getName().isEmpty()
                || dto.getAddress() == null || dto.getAddress().isEmpty()
                || dto.getCnpj() == null || dto.getCnpj().isEmpty()
                || dto.getType() == null){
            throw new RuntimeException("Preencha os campos obrigatórios!");
        }else if (repo.existsByCnpj(dto.getCnpj())){
            throw new RuntimeException("CNPJ ja em uso!");
        }else {

            enterprise.setName(dto.getName());
            enterprise.setCnpj(dto.getCnpj());
            enterprise.setAddress(dto.getAddress());
            enterprise.setType(dto.getType());
        }

        return repo.save(enterprise);
    }

    public Enterprise updateUser(Long id, EnterpriseDTO dto){
        Enterprise enterprise = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (dto.getName() == null || dto.getName().isEmpty()
                || dto.getAddress() == null || dto.getAddress().isEmpty()
                || dto.getCnpj() == null || dto.getCnpj().isEmpty()
                || dto.getType() == null){
            throw new RuntimeException("Preencha os campos obrigatórios!");
        }else if (repo.existsByCnpj(dto.getCnpj())){
            throw new RuntimeException("CNPJ ja em uso!");
        }else {

            enterprise.setName(dto.getName());
            enterprise.setCnpj(dto.getCnpj());
            enterprise.setAddress(dto.getAddress());
            enterprise.setType(dto.getType());
        }

        return repo.save(enterprise);
    }

    public void deleteById(Long id){
        Enterprise user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        repo.delete(user);
    }

}
