package dental_clinic.core.services;

import dental_clinic.core.requests.GetSpecificPatientHistoryRequest;
import dental_clinic.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;

public class GetSpecificPatientValidator {

    public List<CoreError> validate (GetSpecificPatientHistoryRequest getSpecificPatientHistoryRequest){

        List <CoreError> errors = new ArrayList<>();

        long id = getSpecificPatientHistoryRequest.getId();

        if (id < 1){
            errors.add(new CoreError("id", "Not valid input for id"));
        }

        return errors;
    }
}
