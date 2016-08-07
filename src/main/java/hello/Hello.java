package hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


/**
 * Allocated an available unique name to a requesting application
 */
public class Hello implements RequestHandler<Request, Response> {

    @Override
    public Response handleRequest(Request input, Context context) {

        return new Response("Example Message", input);
    }
}
