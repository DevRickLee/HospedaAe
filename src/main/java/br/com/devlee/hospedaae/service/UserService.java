package br.com.devlee.hospedaae.service;

import br.com.devlee.hospedaae.dto.EmpresaResponseDTO;
import br.com.devlee.hospedaae.dto.UserResponseDTO;
import br.com.devlee.hospedaae.model.EmpresaModel;
import br.com.devlee.hospedaae.model.UserModel;
import br.com.devlee.hospedaae.repository.EmpresaRepository;
import br.com.devlee.hospedaae.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public List<UserResponseDTO> getAll() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserModel save(@Valid UserModel user) {
        UserModel savedUser = userRepository.save(user);
        EmpresaModel empresaCompleta = empresaRepository.findById(savedUser.getEmpresa().getId()).get();
        savedUser.setEmpresa(empresaCompleta);
        return savedUser;
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public UserModel update(UUID id, @Valid UserModel updatedUser) {
        return userRepository.findById(id).
                map(user -> {
                    user.setNomeCompleto(updatedUser.getNomeCompleto());
                    user.setEmail(updatedUser.getEmail());
                    user.setSenha(updatedUser.getSenha());
                    user.setCpf(updatedUser.getCpf());
                    user.setEmpresa(updatedUser.getEmpresa());
                    user.setAdministrador(updatedUser.isAdministrador());
                    return userRepository.save(user);
                }).orElseThrow(()-> new RuntimeException("Não foi possível identificar nenhum usuário com o ID fornecido."));
    }

    public UserResponseDTO toDTO(UserModel userModel){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(userModel.getId());
        dto.setEmail(userModel.getEmail());
        dto.setCpf(userModel.getCpf());
        dto.setNomeCompleto(userModel.getNomeCompleto());
        dto.setAdministrador(userModel.isAdministrador());

        if(userModel.getEmpresa() != null){
            EmpresaResponseDTO empresaDTO = new EmpresaResponseDTO();
            empresaDTO.setId(userModel.getEmpresa().getId());
            empresaDTO.setNomeFantasia(userModel.getEmpresa().getNomeFantasia());
            empresaDTO.setCnpj(userModel.getEmpresa().getCnpj());
            dto.setEmpresa(empresaDTO);
        }
        return dto;
    }

    public UserModel searchById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível localizar nenhum usuário com o ID fornecido."));
    }
}
