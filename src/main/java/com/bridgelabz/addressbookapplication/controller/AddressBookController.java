package com.bridgelabz.addressbookapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbookapplication.model.AddressBook;
import com.bridgelabz.addressbookapplication.service.AddressBookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    //To get all the address book
    @GetMapping
    public List<AddressBook> getAllAddressBook(){
        return addressBookService.getAllAddressBook();
    }

    //TO get address book with id
    @GetMapping("/get/{id}")
    public Optional<AddressBook> getAddressBookById(@PathVariable Long id){
        return addressBookService.getAddressBookById(id);
    }

    @PostMapping("/create")
    public AddressBook addAddressBook(@RequestBody AddressBook addressBook){
        return addressBookService.addAddressBook(addressBook);
    }

    //Update the address book
    @PutMapping("/update/{id}")
    public AddressBook updateAddressBook(@PathVariable Long id, @RequestBody AddressBook addressBook){
        return addressBookService.updateAddressBook(id,addressBook);
    }

    //Delete the address book
    @DeleteMapping("/delete/{id}")
    public void deleteAddressBook(@PathVariable Long id){
        addressBookService.deleteAddressBook(id);
    }

}