package internet_store.core.services.customer;

import internet_store.core.requests.customer.FindAllCustomersByNameAndSurnameRequest;
import internet_store.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;

public class FindAllCustomersByNameAndSurnameValidator {

    public List<CoreError> validate(FindAllCustomersByNameAndSurnameRequest findAllCustomersByNameAndSurnameRequest){
        List<CoreError> errors = new ArrayList<>();

        if (findAllCustomersByNameAndSurnameRequest.getName() == null ||
        findAllCustomersByNameAndSurnameRequest.getName().isEmpty()){
            errors.add(new CoreError("name", "Not valid input for name"));
        }

        if (findAllCustomersByNameAndSurnameRequest.getSurname() == null ||
                findAllCustomersByNameAndSurnameRequest.getSurname().isEmpty()){
            errors.add(new CoreError("name", "Not valid input for name"));
        }

        return errors;
    }
}
