package proxy.util;

import java.util.List;

/**
 * Created by kumar.shashi on 04/01/20.
 */
public class ProxySeller {

  private static List<String> proxySellers;

  public ProxySeller(List<String> proxySellers) {
    this.proxySellers = proxySellers;
  }

  public static List<String> getProxySellers() {
    return proxySellers;
  }

}
