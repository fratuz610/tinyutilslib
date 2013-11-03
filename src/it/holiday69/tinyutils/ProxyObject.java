package it.holiday69.tinyutils;

import java.io.Serializable;

public class ProxyObject implements Serializable
{
  private String _host;
  private Integer _port;
  private String _username;
  private String _password;

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
      _username = null;
      _password = null;
      _host = proxyInfo.substring(0, proxyInfo.indexOf(":"));
      _port = Integer.valueOf(proxyInfo.substring(proxyInfo.indexOf(":") + 1));
    }
    else
    {
      if (proxyInfo.indexOf("@") == -1) {
        throw new IllegalArgumentException("The proxyInfo string can be either: 'username:password@host:port' or 'host:port'");
      }
      _username = proxyInfo.substring(0, proxyInfo.indexOf(":"));
      _password = proxyInfo.substring(proxyInfo.indexOf(":") + 1, proxyInfo.indexOf("@"));
      _host = proxyInfo.substring(proxyInfo.indexOf("@") + 1, proxyInfo.lastIndexOf(":"));
      _port = Integer.valueOf(proxyInfo.substring(proxyInfo.lastIndexOf(":") + 1));

      if ((StringUtils.isEmpty(_username)) || (StringUtils.isEmpty(_password))) {
        throw new IllegalArgumentException("The proxyInfo string can be either: 'username:password@host:port' or 'host:port'");
      }
    }
    if (StringUtils.isEmpty(_host)) {
      throw new IllegalArgumentException("No valid host name retrievable from '" + proxyInfo + "'");
    }
    if ((_port == null) || (_port.intValue() <= 0))
      throw new IllegalArgumentException("No valid port number retrievable from '" + proxyInfo + "'"); 
  }
  
  public boolean isValid() { return _validationError == null; }
  public String getValidationError() { return _validationError; }
  
  public String getHost() { return _host; } 
  public int getPort() { return _port.intValue(); } 
  public String getUsername() { return _username; } 
  public String getPassword() { return _password; }

  @Override
  public String toString() {
    return "ProxyObject{" + "host=" + _host + ", port=" + _port + ", username=" + _username + ", password=" + _password + ", validationError=" + _validationError + '}';
  }

  public String toProxyString()
  {
    if(!isValid())
      return "Invalid Proxy settings";
    
    if ((StringUtils.isEmpty(_username)) || (StringUtils.isEmpty(_password)))
      return _host + ":" + _port;
    
    return _username + ":" + _password + "@" + _host + ":" + _port;
  }
}