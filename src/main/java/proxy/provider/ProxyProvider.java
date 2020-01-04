package proxy.provider;

import proxy.util.Constant;
import proxy.util.ProxySeller;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

/**
 * Created by kumar.shashi on 04/01/20.
 */
@Provider
public class ProxyProvider implements ContainerRequestFilter {

  private final String SELLER_ID = "seller_id";
  @Context
  private ResourceInfo resourceInfo;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {

    MultivaluedMap<String, String> pathParameters = requestContext.getUriInfo().getPathParameters();

    List<String> proxySellers = ProxySeller.getProxySellers();
    if (!proxySellers.contains(pathParameters.getFirst(SELLER_ID))) {

      System.out.println("This seller is not in proxy list, so continuing with old es flow");
      return;
    } else {
      System.out.println("This is not in proxy list, so redirecting to new es");
      String url = Constant.BASE_URL + requestContext.getUriInfo().getRequestUri().getPath() + "?" + requestContext
              .getUriInfo().getRequestUri().getQuery();
      System.out.println("Redirecting to [NEW]: " + url);
      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();
      con.setRequestMethod("GET");
      if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();

        requestContext.abortWith(Response.status(Response.Status.TEMPORARY_REDIRECT)
                .entity("This is not in proxy list, so redirecting to new es\n[NEW URL]: " + url + "\n" +
                        response.toString()).build());
      } else {
        System.out.println("GET request not worked");
      }

      return;
    }

  }


}
