package it.holiday69.tinyutils;

import java.io.Serializable;

public class ProxyObject implements Serializable
{
  private String host;
  private Integer port;
  private String username;
  private String password;

  private String _validationError = null;
  
  public ProxyObject(String proxyInfo)
  {
    try {
      parseProxyString(proxyInfo);
    } catch(IllegalArgumentException ex) {
      _validationError = ex.getMessage();
    }
  }
  
  private void parseProxyString(String proxyInfo) {
    
    if (proxyInfo.indexOf(":") == -1) {
      throw new IllegalArgumentException("The proxyInfo string can be either: 'username:password@host:port' or 'host:port'");
    }
    if (proxyInfo.indexOf(":") == proxyInfo.lastIndexOf(":"))
    {
      username = null;
      password = null;
      host = proxyInfo.substring(0, proxyInfo.indexOf(":"));
      port = Integer.valueOf(proxyInfo.substring(proxyInfo.indexOf(":") + 1));
    }
    else
    {
      if (proxyInfo.indexOf("@") == -1) {
        throw new IllegalArgumentException("The proxyInfo string can be either: 'username:password@host:port' or 'host:port'");
      }
      username = proxyInfo.substring(0, proxyInfo.indexOf(":"));
      password = proxyInfo.substring(proxyInfo.indexOf(":") + 1, proxyInfo.indexOf("@"));
      host = proxyInfo.substring(proxyInfo.indexOf("@") + 1, proxyInfo.lastIndexOf(":"));
      port = Integer.valueOf(proxyInfo.substring(proxyInfo.lastIndexOf(":") + 1));

      if ((StringUtils.isEmpty(username)) || (StringUtils.isEmpty(password))) {
        throw new IllegalArgumentException("The proxyInfo string can be either: 'username:password@host:port' or 'host:port'");
      }
    }
    if (StringUtils.isEmpty(host)) {
      throw new IllegalArgumentException("No valid host name retrievable from '" + proxyInfo + "'");
    }
    if ((port == null) || (port.intValue() <= 0))
      throw new IllegalArgumentException("No valid port number retrievable from '" + proxyInfo + "'"); 
  }
  
  public boolean isValid() { return _validationError == null; }
  public String getValidationError() { return _validationError; }
  
  public String getHost() { return host; } 
  public int getPort() { return port.intValue(); } 
  public String getUsername() { return username; } 
  public String getPassword() { return password; }

  @Override
  public String toString()
  {
    if(!isValid())
      return "Invalid Proxy settings";
    
    if ((StringUtils.isEmpty(username)) || (StringUtils.isEmpty(password)))
      return host + ":" + port;
    
    return username + ":" + password + "@" + host + ":" + port;
  }
}