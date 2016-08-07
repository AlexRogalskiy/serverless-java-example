package hello;

/**
 * When API Gateway is used with the Serverless framework, the framework provisions a very specific data mapping in
 * API gateway which passes through almost all the event data for you, so that you don't have to tailor the mappings
 * yourself.
 *
 * The Serverless docs are confusing as heck, but the key part is:
 *
 *      Note: Serverless supports a built in, universal velocity request template which makes the following parameters
 *      available in the event object:
 *      body
 *      method
 *      principalId
 *      headers
 *      query
 *      path
 *      identity
 *      stageVariables
 *
 * Basically what they're saying is that they've created a bunch of mappings in API Gateway for you that package pretty
 * much anything you'd ever want into a JSON object and pass it through to your application, rather than you needing to
 * define a custom mapping for each value/query/header you want.
 *
 * This is easy to use on dynamic languages like Node/Python, but a bit trickier with Java's strict typecasting since we
 * have to define a Plain Old Java Object (POJO) and if we get any of the types wrong, you get nothing but cryptic
 * Jackson parsing errors which nobody wants :-(
 *
 * API gateway docs on this subject:
 * http://docs.aws.amazon.com/apigateway/latest/developerguide/models-mappings.html
 * http://docs.aws.amazon.com/lambda/latest/dg/java-handler-io-type-pojo.html
 */

import java.util.Map;

public class Request {

    /**
     * TODO: Haven't figured out a way to handle body without blowing up, this is mostly due to body being optional
     * and if unset, trying to de-seralize a null object really upsets Jackson. Given you only need body for POSTs, I
     * recommend instead just extending this class and adding the body field specifically to suit the nature of the data
     * you are sending.
     */

    private String method;
    private String principalId;
    private Map<String,String> headers;
    private Map<String,String> query;
    private Map<String,String> path;
    private Map<String,String> identity;
    private Map<String,String> stageVariables;

    public Request() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public Map<String, String> getPath() {
        return path;
    }

    public void setPath(Map<String, String> path) {
        this.path = path;
    }

    public Map<String, String> getIdentity() {
        return identity;
    }

    public void setIdentity(Map<String, String> identity) {
        this.identity = identity;
    }

    public Map<String, String> getStageVariables() {
        return stageVariables;
    }

    public void setStageVariables(Map<String, String> stageVariables) {
        this.stageVariables = stageVariables;
    }

}
