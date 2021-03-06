package internet_store.core.services.product;

import internet_store.core.requests.product.FindAnyByTitleRequest;
import internet_store.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;

public class FindAnyByTitleRequestValidator {

    public List<CoreError> validate (FindAnyByTitleRequest findAnyByTitleRequest){

        List <CoreError> errors = new ArrayList<>();

        if (findAnyByTitleRequest.getTitle() == null || findAnyByTitleRequest.getTitle().isEmpty()){
            errors.add(new CoreError("title", "Not valid input for title"));
        }

        return errors;
    }
}
