package proxy.application;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import proxy.provider.ProxyProvider;
import proxy.resource.ProxyResource;
import proxy.util.ProxySeller;

/**
 * Created by kumar.shashi on 04/01/20.
 */
public class ProxyApplication extends Application<ProxyConfiguration> {

  private GuiceBundle<ProxyConfiguration> guiceBundle;

  public static void main(String[] args) throws Exception {

    new ProxyApplication().run(args);
  }

  @Override
  public String getName() {
    return "proxy-poc";
  }

  @Override
  public void initialize(Bootstrap<ProxyConfiguration> bootstrap) {

  }

  @Override
  public void run(ProxyConfiguration proxyConfiguration, Environment environment) throws Exception {

    environment.jersey().register(new ProxyResource());
    environment.jersey().register(new ProxyProvider());
    environment.jersey().register(new ProxySeller(proxyConfiguration.getProxySellers()));



  }
}
