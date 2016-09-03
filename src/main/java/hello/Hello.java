package hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


/**
 * This route returns a simple plain text response. However in order
 * to do so, we had to set the Content-Type header and also define a
 * custom mapping template specifically in the
 * serverless.yml file to allow plaintext.
 */
public class Hello implements RequestHandler<Request, String> {

    @Override
    public String handleRequest(Request input, Context context) {

        return new String("Hello world!");
    }
}
