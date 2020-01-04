package proxy.application;

        import com.fasterxml.jackson.annotation.JsonProperty;
        import io.dropwizard.Configuration;
        import org.hibernate.validator.constraints.NotEmpty;

        import java.util.List;

/**
 * Created by kumar.shashi on 04/01/20.
 */
public class ProxyConfiguration extends Configuration {

  private List<String> proxySellers;

  @JsonProperty
  public List<String> getProxySellers() {
    return proxySellers;
  }

}
