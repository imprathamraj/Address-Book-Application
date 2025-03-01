package com.bridgelabz.addressbookapplication.controller;

import com.bridgelabz.addressbookapplication.AddressBookApplication;
import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbookapplication.model.AddressBook;
import com.bridgelabz.addressbookapplication.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private static final Logger logger = LoggerFactory.getLogger(AddressBookController.class);

    @Autowired
    AddressBookService addressBookService;

    //To get all the address book
    @GetMapping("get/all")
    public List<AddressBook> getAllAddressBook(){
        logger.info("All address endpoint called ");
        return addressBookService.getAllAddressBook();
    }

    //TO get address book with id
    @GetMapping("/get/{id}")
    public Optional<AddressBook> getAddressBookById(@PathVariable Long id){
        logger.info("By id address endpoint called ");
        return addressBookService.getAddressBookById(id);
    }

    // To create a new AddressBook
    @PostMapping("/create")
    public ResponseEntity<?> addAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO){
        logger.info("Create address endpoint called");
        return ResponseEntity.ok(addressBookService.addAddressBook(addressBookDTO));
    }

    //Update the address book
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddressBook(@PathVariable Long id, @Valid @RequestBody AddressBookDTO addressBookDTO){
        logger.info("Update address endpoint called");
        AddressBook updatedAddressBook = addressBookService.updateAddressBook(id, addressBookDTO);
        if (updatedAddressBook != null) {
            return ResponseEntity.ok(updatedAddressBook);
        } else {
            logger.warn("No address book found with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Delete the address book
    @DeleteMapping("/delete/{id}")
    public void deleteAddressBook(@PathVariable Long id){
        logger.info("Delete address endpoint called");
        addressBookService.deleteAddressBook(id);
    }

}