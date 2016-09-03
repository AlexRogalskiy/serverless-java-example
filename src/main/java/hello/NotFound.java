package hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


/**
 * This route returns an example 404 response. This is implemented in a somewhat dubious manner, the Serverless
 * Framework requires that you throw an exception which then gets regexed over for various specifically configured
 * response codes.
 *
 * But there's some issues with this - firstly you only get a vastly cut down subset of the full list of HTTP status
 * codes and secondly, in the case of Java, you end up with a full Java stack trace being returned to the user! For
 * example:
 *
 *  {
 *      "errorMessage": "[404] This is a simulated custom response from Lambda",
 *      "errorType": "java.lang.RuntimeException",
 *      "stackTrace": [
 *      "hello.NotFound.handleRequest(NotFound.java:19)",
 *      "hello.NotFound.handleRequest(NotFound.java:11)"
 *      ]
 *  }
 *
 *  Further reading:
 *  https://github.com/serverless/serverless/blob/master/lib/plugins/aws/deploy/compile/events/apiGateway/README.md
 *  http://docs.aws.amazon.com/lambda/latest/dg/java-exceptions.html
 *
 */
public class NotFound implements RequestHandler<Request, String> {


    @Override
    public String handleRequest(Request input, Context context) {
        throw new RuntimeException("[404] This is a simulated custom response from Lambda");
    }
}

