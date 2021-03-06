package dental_clinic.core.services;

import dental_clinic.core.requests.DeletePatientRequest;
import dental_clinic.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeletePatientValidatorTest {

    DeletePatientValidator deletePatientValidator = new DeletePatientValidator();

    @Test
    public void testNotValidId(){
        CoreError expectedError = new CoreError("id", "Not valid input for id");

        DeletePatientRequest deletePatientRequest = new DeletePatientRequest(-8);
        List<CoreError> errors = deletePatientValidator.validate(deletePatientRequest);

        assertTrue(errors.size() == 1);
        assertTrue(errors.contains(expectedError));
    }

    @Test
    public void testValidId(){

        DeletePatientRequest deletePatientRequest = new DeletePatientRequest(1);
        List<CoreError> errors = deletePatientValidator.validate(deletePatientRequest);

        assertTrue(errors.isEmpty());
    }

}