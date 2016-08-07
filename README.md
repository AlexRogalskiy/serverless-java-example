# serverless-java-example

An example AWS Lambda application written in Java and using the Serverless
framework to provide an example of how the request/response mapping works.

Once launched, you can do an example query with:

    curl -i https://ENDPOINTNAME.execute-api.ap-southeast-2.amazonaws.com/dev/test
    curl -s https://ENDPOINTNAME.execute-api.ap-southeast-2.amazonaws.com/dev/test | jq

This example returns a test message and also echos back the object of the request
showing all the different values available.


# Requirements

* Java 8
* An AWS account with Lambda enabled
* Serverless framework version 1.0.0+


# Technology

We make use of the serverless framework for deployment and management of the
AWS Lambda. Gradle is used to perform the builds of the application and package
the completed Java application into a zip artifact for upload.


# Deployment

To build & deploy the serverless application:

    gradle buildZip
    serverless deploy

Optionally you can specify the `--stage` parameter to deploy specific instances
of the application (eg dev vs staging vs production).

If you've made changes to specific functions, you'll have to build and upload
to AWS (where NAME == your function name):

    gradle buildZip
    serverless deploy function --function NAME

