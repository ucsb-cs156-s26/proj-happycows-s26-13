package edu.ucsb.cs156.happiercows.controllers;

import edu.ucsb.cs156.happiercows.errors.CommonsHiddenException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class ApiControllerTests {

    private final UserCommonsController handler = new UserCommonsController();

    @Test
    void handleBadRequest_withCommonsHiddenException_returnsBadRequestBody() {
        CommonsHiddenException exception = new CommonsHiddenException("Commons is hidden");

        Object result = handler.handleBadRequest(exception);

        Map<?, ?> body = (Map<?, ?>) result;
        assertEquals("CommonsHiddenException", body.get("type"));
        assertEquals("Commons is hidden", body.get("message"));
    }
}