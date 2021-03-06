package application.core.services.validators;

import application.core.requests.DeleteProductRequest;
import application.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeleteProductValidator {

    public List<CoreError> validate(DeleteProductRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(DeleteProductRequest request) {
        if (request.getProductIdToDelete() <=0 ||
                (request.getProductIdToDelete() % 2 != 1 && request.getProductIdToDelete() % 2 != 0)) {
            return Optional.of(new CoreError("ID", "Must not be empty, negative or fractional"));
        }

        if (request.getProductIdToDelete() > (10^18))  {
            return Optional.of(new CoreError("ID", "Must be less than 18 characters"));
        }
        return Optional.empty();
    }

}

