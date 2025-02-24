package com.bridgelabz.addressbookapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/create")
    public AddressBook addAddressBook(@RequestBody AddressBook addressBook){
        logger.info("Create address endpoint called");
        return addressBookService.addAddressBook(addressBook);
    }

    //Update the address book
    @PutMapping("/update/{id}")
    public AddressBook updateAddressBook(@PathVariable Long id, @RequestBody AddressBook addressBook){
        logger.info("Update address endpoint called");
        return addressBookService.updateAddressBook(id,addressBook);
    }

    //Delete the address book
    @DeleteMapping("/delete/{id}")
    public void deleteAddressBook(@PathVariable Long id){
        logger.info("Delete address endpoint called");
        addressBookService.deleteAddressBook(id);
    }

}