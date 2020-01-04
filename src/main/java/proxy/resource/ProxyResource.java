package proxy.resource;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kumar.shashi on 04/01/20.
 */
@Path("/dashboard/payments/v1")
public class ProxyResource {


  @GET
  @Path("/{seller_id}/history")
  @ExceptionMetered
  @Produces(MediaType.APPLICATION_JSON)
  @Timed
  public Response getDetails(@PathParam("seller_id") String sellerId) {

    return Response.ok("This seller is not in proxy list\nRedirecting to [OLD] es : " +
            "Successfully continued the flow!!").build();
  }

}






