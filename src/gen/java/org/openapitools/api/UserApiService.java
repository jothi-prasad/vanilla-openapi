package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import org.openapitools.model.User;
import org.openapitools.model.UserList;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2020-08-14T17:07:38.296-07:00[America/Los_Angeles]")
public abstract class UserApiService {
    public abstract Response userGet(String type,SecurityContext securityContext) throws NotFoundException;
    public abstract Response userNameGet(String name,SecurityContext securityContext) throws NotFoundException;
}
