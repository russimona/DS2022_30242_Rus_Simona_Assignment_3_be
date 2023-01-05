package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.services.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin()
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> dtos = userService.findUsers();
        for (UserDTO dto : dtos) {
            Link userLink = linkTo(methodOn(UserController.class)
                    .getUser(dto.getId())).withRel("userDetails");
            dto.add(userLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping(value = "/userByEmailPass")
    public ResponseEntity<HashMap> getUserByEmailAndPassword(@Valid @RequestBody Map<String, String> json) {

        System.out.println(json);
        String email = json.get("email");
        String password = json.get("password");
        String dto = userService.findUserByNameAndPassword(email, password);
        System.out.println(dto);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", dto);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody UserDetailsDTO userDTO) {
        UUID userID = userService.insert(userDTO);
        return new ResponseEntity<>(userID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDetailsDTO> getUser(@PathVariable("id") UUID userId) {
        UserDetailsDTO dto = userService.findUserById(userId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<UUID> deleteProsumer(@PathVariable("id") UUID userId){
        userService.deletUserById(userId);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> updateProsumer(@RequestBody @Valid  UserDetailsDTO userDTO) {
        return new ResponseEntity<>(userService.updateUser(userDTO), HttpStatus.OK);
    }

    @PostMapping(value = "/update/{id_user}/{id_device}")
    public ResponseEntity<?> updateDevices(@RequestBody @PathVariable("id_user") UUID userId, @PathVariable("id_device") UUID deviceId ) {
        return new ResponseEntity<>(userService.updateDevices(userId, deviceId), HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id_user}/{id_device}")
    public ResponseEntity<?> deleteDevice(@RequestBody @PathVariable("id_user") UUID userId, @PathVariable("id_device") UUID deviceId ) {
        return new ResponseEntity<>(userService.deleteDevice(userId, deviceId), HttpStatus.OK);
    }
}
