package com.bridgelabz.addressbookapplication.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public @ToString  class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "AddressBook name Invalid")
    private String addressBookName;
}
