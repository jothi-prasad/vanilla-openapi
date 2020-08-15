package org.openapitools.api.impl;

import io.swagger.annotations.ApiParam;
import org.openapitools.api.NotFoundException;
import org.openapitools.api.UnixgroupApiService;
import org.openapitools.api.UserApiService;
import org.openapitools.api.factories.UnixgroupApiServiceFactory;
import org.openapitools.api.factories.UserApiServiceFactory;
import org.openapitools.model.*;

import javax.servlet.ServletConfig;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

//import org.openapitools.model.*;
//import org.openapitools.api.UserApiService;
//import org.openapitools.api.factories.UserApiServiceFactory;
//
//import io.swagger.annotations.ApiParam;
//import io.swagger.jaxrs.*;
//
//import org.openapitools.model.User;
//import org.openapitools.model.UserList;
//
//import java.util.Map;
//import java.util.List;
//import org.openapitools.api.NotFoundException;
//
//import java.io.InputStream;
//
//import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
//import org.glassfish.jersey.media.multipart.FormDataParam;
//
//import javax.servlet.ServletConfig;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.SecurityContext;
//import javax.ws.rs.*;
//import javax.validation.constraints.*;
//import javax.validation.Valid;


@Path("/yanis")

@io.swagger.annotations.Api(description = "the user API")
//@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2020-08-14T17:07:38.296-07:00[America/Los_Angeles]")
public class YanisResources {

    private final UserApiService delegate;
    private final UnixgroupApiService delegate1;

    public YanisResources(@Context ServletConfig servletContext) {
        UserApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("UserApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (UserApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = UserApiServiceFactory.getUserApi();

        }

        UnixgroupApiService delegate1 = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("UnixgroupApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate1 = (UnixgroupApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate1 == null) {
            delegate1 = UnixgroupApiServiceFactory.getUnixgroupApi();
        }

        this.delegate1 = delegate1;


        this.delegate = delegate;
    }

    @GET
    @Path("/user")


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get users by Type", notes = "API to retrieve list of users like headless users, human users and all users. Note: you will need special privileges to access certain types of users", response = UserList.class, responseContainer = "List", tags = {"Get-Unix-Users-By-Type"})
        @io.swagger.annotations.ApiResponses(value = {
                @io.swagger.annotations.ApiResponse(code = 200, message = "list of all users", response = UserList.class, responseContainer = "List") })
    public Response userGet(@ApiParam(value = "flag include headless only", allowableValues = "headless, human, all", defaultValue = "headless") @DefaultValue("headless") @QueryParam("type") String type)
            throws org.openapitools.api.NotFoundException {
        return delegate.userGet(type, null);
    }

//    @GET
//    @Path("/{name}")
//
//    @Produces({"application/json", "application/xml"})
//    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = User.class, tags = {})//
////        @io.swagger.annotations.ApiResponses(value = {
////                @io.swagger.annotations.ApiResponse(code = 200, message = "user details for the name provided", response = User.class) })
//    public Response userNameGet(@ApiParam(value = "user's login name", required = true) @PathParam("name") @NotNull String name
//    )
//            throws NotFoundException {
//        return delegate.userNameGet(name, null);
//    }

//    @GET
//    @Path("/unixgroup")


//    @Produces({ "application/json" })
//    @io.swagger.annotations.ApiOperation(value = "", notes = "list of all unix groups", response = Group.class, responseContainer = "List", tags={  })
//    @io.swagger.annotations.ApiResponses(value = {
//            @io.swagger.annotations.ApiResponse(code = 200, message = "list of all unix groups", response = Group.class, responseContainer = "List") })
//    public Response unixgroupGet(@Context SecurityContext securityContext)
//            throws NotFoundException {
//        return delegate1.unixgroupGet(securityContext);
//    }
    @GET
    @Path("/unixgroup/{name}")

    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Use this api to get Unix group by providing grup name as input (Note: make sure it follows the following format Ex: GROUPNAME:NAME ) ", tags={ "GET-UNIXGROUP-BY-NAME"})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "unixgroup details for the name provided", response = Group.class) })
    public Response unixgroupNameGet(@ApiParam(value = "unixgroup name", required = true) @PathParam("name") @NotNull  String name
            ,@Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate1.unixgroupNameGet(name, securityContext);
    }

//    @DELETE
//    @Path("/{name}/member/{membername}")


//    @io.swagger.annotations.ApiOperation(value = "", notes = "disable a unix headless user", response = Void.class, tags={  })
////    @io.swagger.annotations.ApiResponses(value = {
////            @io.swagger.annotations.ApiResponse(code = 204, message = "No Content", response = Void.class) })
//    public Response unixgroupNameMemberMembernameDelete(@ApiParam(value = "unixgroup name", required = true) @PathParam("name") @NotNull  String name
//            ,@ApiParam(value = "membername", required = true) @PathParam("membername") @NotNull  String membername
//            ,@Context SecurityContext securityContext)
//            throws NotFoundException {
//        return delegate1.unixgroupNameMemberMembernameDelete(name, membername, securityContext);
//    }
//    @PUT
//    @Path("/{name}/member/{membername}")
//
//
//    @io.swagger.annotations.ApiOperation(value = "", notes = "disable/enable a unix headless user", response = Void.class, tags={  })
////    @io.swagger.annotations.ApiResponses(value = {
////            @io.swagger.annotations.ApiResponse(code = 204, message = "No Content", response = Void.class) })
//    public Response unixgroupNameMemberMembernamePut(@ApiParam(value = "unixgroup name", required = true) @PathParam("name") @NotNull  String name
//            ,@ApiParam(value = "membername", required = true) @PathParam("membername") @NotNull  String membername
//            ,@Context SecurityContext securityContext)
//            throws NotFoundException {
//        return delegate1.unixgroupNameMemberMembernamePut(name, membername, securityContext);
//    }
//    @PUT
//    @Path("/{name}")
//    @Consumes({ "application/json" })
//
//    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Void.class, tags={  })
////    @io.swagger.annotations.ApiResponses(value = {
////            @io.swagger.annotations.ApiResponse(code = 204, message = "No Content", response = Void.class) })
//    public Response unixgroupNamePut(@ApiParam(value = "unixgroup name", required = true) @PathParam("name") @NotNull  String name
//            ,@ApiParam(value = "") @Valid  GroupStub groupStub
//            ,@Context SecurityContext securityContext)
//            throws NotFoundException {
//        return delegate1.unixgroupNamePut(name, groupStub, securityContext);
//    }
//    @POST
//
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @io.swagger.annotations.ApiOperation(value = "", notes = "create a unix group", response = Group.class, tags={  })
////    @io.swagger.annotations.ApiResponses(value = {
////            @io.swagger.annotations.ApiResponse(code = 201, message = "unixgroup created", response = Group.class) })
//    public Response unixgroupPost(@ApiParam(value = "") @Valid GroupStub groupStub
//            ,@Context SecurityContext securityContext)
//            throws NotFoundException {
//        return delegate1.unixgroupPost(groupStub, securityContext);
//    }

//    @GET
//    @Path("/unixgroupname/{name}")
//
//    @Produces({ "application/json" })
//    @io.swagger.annotations.ApiOperation(value = "", notes = "PNAME:NAME ) ", tags={ "GET-UNIXGROUP-BY-NAME-NAME"})
//    @io.swagger.annotations.ApiResponses(value = {
//            @io.swagger.annotations.ApiResponse(code = 200, message = "unixgroup details for the name nameprovided", response = UnixGroup.class) })
//    public Response unixgroupNameNameGet(@ApiParam(value = "unixgroup name", required = true) @PathParam("name") @NotNull  String name
//            ,@Context SecurityContext securityContext)
//            throws NotFoundException {
//        return delegate1.unixgroupNameNameGet(name, securityContext);
//    }

}