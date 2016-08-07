package hello;

/**
 * Unlike the request object, the response object (as of Serverless 1.0.0) lacks any customised Velocity response
 * data, which basically makes it impossible to customise the response codes :-(
 *
 * Currently this "works" by defaulting to the Error data model, which results in us being able to return only a JSON
 * response with the key of message and value of string and an HTTP response code of 200... regardless.
 *
 * This has to change if the Serverless framework is to be taken seriously, issues/PRs to watch:
 * https://github.com/serverless/serverless/issues/1593
 */

public class Response {

	private String message;
	private Request request;

	public Response(String message, Request request) {
		this.message = message;
		this.request = request;
	}

	public Response() {
	}

	public String getMessage() {
		return this.message;
	}

	public Request getRequest() {
		return this.request;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
