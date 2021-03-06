package team_VK.application.core.services.admin_services;

import team_VK.application.core.domain.Book;
import team_VK.application.core.requests.GetBookListRequest;
import team_VK.application.core.responses.CoreError;
import team_VK.application.core.responses.GetBookListResponse;
import team_VK.application.database.database_Admin.Database;

import java.util.ArrayList;
import java.util.List;

public class GetBooksListService {

    private final Database database;
    private final GetBookListServiceValidator validator;

    public GetBooksListService(Database database, GetBookListServiceValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public GetBookListResponse getBooksList(GetBookListRequest request) {

        List<CoreError> errors = new ArrayList<>();

        GetBookListResponse response = new GetBookListResponse(errors);

        if (errors.size() == 0) {
            System.out.println("Book list:");
            for (Book book : database.getListBooks()) {
                System.out.println(book);
            }
            System.out.println("End of list");
        }
        return response;
    }
}