package org.openapitools.api.factories;

import org.openapitools.api.UnixheadlessApiService;
import org.openapitools.api.impl.UnixheadlessApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2020-08-14T17:07:38.296-07:00[America/Los_Angeles]")
public class UnixheadlessApiServiceFactory {
    private final static UnixheadlessApiService service = new UnixheadlessApiServiceImpl();

    public static UnixheadlessApiService getUnixheadlessApi() {
        return service;
    }
}
