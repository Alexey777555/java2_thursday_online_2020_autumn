package internet_store.application.core.services;

import internet_store.application.core.requests.DeleteByProductIdRequest;
import internet_store.application.core.responses.*;
import internet_store.application.database.Database;

import java.util.List;

public class DeleteByProductIdService {

    private final Database database;
    private final DeleteByProductIdValidator validator;

    public DeleteByProductIdService(Database database, DeleteByProductIdValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public DeleteByProductIdResponse deleteByProductId(DeleteByProductIdRequest productIdRequest) {
        List<CoreError> errors = validator.validate(productIdRequest);
        if (!errors.isEmpty()){
            return new DeleteByProductIdResponse(errors);
        }
        boolean isRemoved = database.deleteByProductId(productIdRequest.getProductId());

        return  new DeleteByProductIdResponse(isRemoved);
    }

}
