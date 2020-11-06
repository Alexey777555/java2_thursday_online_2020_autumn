package internet_store.UI.customer;

import internet_store.UI.InputCheckUtility;
import internet_store.UI.UIAction;
import internet_store.database.customer.CustomerDatabase;
import internet_store.domain.Customer;

public class AddCustomerUIAction implements UIAction {

    private CustomerDatabase customerDatabase;
    InputCheckUtility inputCheckUtility = new InputCheckUtility();

    public AddCustomerUIAction(CustomerDatabase personDatabase){
        this.customerDatabase = personDatabase;
    }

    public void execute(){

        String name = inputCheckUtility.inputValidString("Please enter your name: ");

        String surname = inputCheckUtility.inputValidString("Please enter your surname: ");

        String address = inputCheckUtility.inputValidString("Please enter your address: ");

        String email = inputCheckUtility.inputValidString("Please enter your email: ");

        int phoneNumber = inputCheckUtility.inputValidInteger("Please enter your phone number: ");

        Customer newCustomer = new Customer(name, surname, phoneNumber, address, email);

        customerDatabase.addCustomer(newCustomer);

    }
}