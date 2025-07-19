package com.devsuperior.dscommerce_exercise.services;

import com.devsuperior.dscommerce_exercise.dto.ClientDTO;
import com.devsuperior.dscommerce_exercise.entities.Client;
import com.devsuperior.dscommerce_exercise.repositories.ClientRepository;
import com.devsuperior.dscommerce_exercise.services.exceptions.ResourcesNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // ou a annotation @Component
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findByID(Long id) {
            Optional<Client> result = clientRepository.findById(id);
            // Ele vai tentar acessar o objeto e caso não encontre ele vai lançar uma exceção.
            Client client = result.orElseThrow(
                    () -> new ResourcesNotFoundException("Resource not found: " + id));
            ClientDTO clientDTO = new ClientDTO(client);
            return clientDTO;


    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional()
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional()
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = clientRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = clientRepository.save(entity);
            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException("Resource not found: " + id);
        }
    }

    @Transactional()
    public void delete(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new ResourcesNotFoundException("Resource not found: " + id);
        }
       clientRepository.deleteById(id);
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
