package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.controller.AddressBookController;
import com.bridgelabz.addressbookapplication.model.AddressBook;
import com.bridgelabz.addressbookapplication.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;

    // Save the address book entry
    public AddressBook addAddressBook(AddressBook addressBook){
        return addressBookRepository.save(addressBook);
    }

    // Get all address book entries
    public List<AddressBook> getAllAddressBook(){
        return addressBookRepository.findAll();
    }

    // Get address book entry by ID
    public Optional<AddressBook> getAddressBookById(Long id) {
        return addressBookRepository.findById(id);
    }

    // Update the address book entry
    public AddressBook updateAddressBook(Long id, AddressBook updatedAddressBook) {
        Optional<AddressBook> optionalAddressBook = addressBookRepository.findById(id);
        if (optionalAddressBook.isPresent()) {
            AddressBook addressBook = optionalAddressBook.get();
            addressBook.setAddressBookName(updatedAddressBook.getAddressBookName());

            return addressBookRepository.save(addressBook);
        } else {
            return null;
        }
    }

    // Delete address book entry
    public void deleteAddressBook(Long id) {
        addressBookRepository.deleteById(id);
    }
}
