// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpConnection, MultiThreadedHttpConnectionManager, HttpConnectionManager

private static class wrappedConnection extends HttpConnection
{

    private HttpConnection wrappedConnection;

    public void close()
    {
        if (hasConnection())
        {
            wrappedConnection.close();
        }
    }

    public boolean closeIfStale()
        throws IOException
    {
        if (hasConnection())
        {
            return wrappedConnection.closeIfStale();
        } else
        {
            return false;
        }
    }

    public void flushRequestOutputStream()
        throws IOException
    {
        if (hasConnection())
        {
            wrappedConnection.flushRequestOutputStream();
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public String getHost()
    {
        if (hasConnection())
        {
            return wrappedConnection.getHost();
        } else
        {
            return null;
        }
    }

    public HttpConnectionManager getHttpConnectionManager()
    {
        if (hasConnection())
        {
            return wrappedConnection.getHttpConnectionManager();
        } else
        {
            return null;
        }
    }

    public InputStream getLastResponseInputStream()
    {
        if (hasConnection())
        {
            return wrappedConnection.getLastResponseInputStream();
        } else
        {
            return null;
        }
    }

    public InetAddress getLocalAddress()
    {
        if (hasConnection())
        {
            return wrappedConnection.getLocalAddress();
        } else
        {
            return null;
        }
    }

    public HttpConnectionParams getParams()
    {
        if (hasConnection())
        {
            return wrappedConnection.getParams();
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public int getPort()
    {
        if (hasConnection())
        {
            return wrappedConnection.getPort();
        } else
        {
            return -1;
        }
    }

    public Protocol getProtocol()
    {
        if (hasConnection())
        {
            return wrappedConnection.getProtocol();
        } else
        {
            return null;
        }
    }

    public String getProxyHost()
    {
        if (hasConnection())
        {
            return wrappedConnection.getProxyHost();
        } else
        {
            return null;
        }
    }

    public int getProxyPort()
    {
        if (hasConnection())
        {
            return wrappedConnection.getProxyPort();
        } else
        {
            return -1;
        }
    }

    public OutputStream getRequestOutputStream()
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            return wrappedConnection.getRequestOutputStream();
        } else
        {
            return null;
        }
    }

    public InputStream getResponseInputStream()
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            return wrappedConnection.getResponseInputStream();
        } else
        {
            return null;
        }
    }

    public int getSendBufferSize()
        throws SocketException
    {
        if (hasConnection())
        {
            return wrappedConnection.getSendBufferSize();
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public int getSoTimeout()
        throws SocketException
    {
        if (hasConnection())
        {
            return wrappedConnection.getSoTimeout();
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public String getVirtualHost()
    {
        if (hasConnection())
        {
            return wrappedConnection.getVirtualHost();
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    HttpConnection getWrappedConnection()
    {
        return wrappedConnection;
    }

    protected boolean hasConnection()
    {
        return wrappedConnection != null;
    }

    public boolean isOpen()
    {
        if (hasConnection())
        {
            return wrappedConnection.isOpen();
        } else
        {
            return false;
        }
    }

    public boolean isProxied()
    {
        if (hasConnection())
        {
            return wrappedConnection.isProxied();
        } else
        {
            return false;
        }
    }

    public boolean isResponseAvailable()
        throws IOException
    {
        if (hasConnection())
        {
            return wrappedConnection.isResponseAvailable();
        } else
        {
            return false;
        }
    }

    public boolean isResponseAvailable(int i)
        throws IOException
    {
        if (hasConnection())
        {
            return wrappedConnection.isResponseAvailable(i);
        } else
        {
            return false;
        }
    }

    public boolean isSecure()
    {
        if (hasConnection())
        {
            return wrappedConnection.isSecure();
        } else
        {
            return false;
        }
    }

    public boolean isStaleCheckingEnabled()
    {
        if (hasConnection())
        {
            return wrappedConnection.isStaleCheckingEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isTransparent()
    {
        if (hasConnection())
        {
            return wrappedConnection.isTransparent();
        } else
        {
            return false;
        }
    }

    public void open()
        throws IOException
    {
        if (hasConnection())
        {
            wrappedConnection.open();
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void print(String s)
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.print(s);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void print(String s, String s1)
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.print(s, s1);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void printLine()
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.printLine();
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void printLine(String s)
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.printLine(s);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void printLine(String s, String s1)
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.printLine(s, s1);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public String readLine()
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            return wrappedConnection.readLine();
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public String readLine(String s)
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            return wrappedConnection.readLine(s);
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void releaseConnection()
    {
        if (!isLocked() && hasConnection())
        {
            HttpConnection httpconnection = wrappedConnection;
            wrappedConnection = null;
            httpconnection.releaseConnection();
        }
    }

    public void setConnectionTimeout(int i)
    {
        if (hasConnection())
        {
            wrappedConnection.setConnectionTimeout(i);
        }
    }

    public void setHost(String s)
        throws IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.setHost(s);
        }
    }

    public void setHttpConnectionManager(HttpConnectionManager httpconnectionmanager)
    {
        if (hasConnection())
        {
            wrappedConnection.setHttpConnectionManager(httpconnectionmanager);
        }
    }

    public void setLastResponseInputStream(InputStream inputstream)
    {
        if (hasConnection())
        {
            wrappedConnection.setLastResponseInputStream(inputstream);
        }
    }

    public void setLocalAddress(InetAddress inetaddress)
    {
        if (hasConnection())
        {
            wrappedConnection.setLocalAddress(inetaddress);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void setParams(HttpConnectionParams httpconnectionparams)
    {
        if (hasConnection())
        {
            wrappedConnection.setParams(httpconnectionparams);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void setPort(int i)
        throws IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.setPort(i);
        }
    }

    public void setProtocol(Protocol protocol)
    {
        if (hasConnection())
        {
            wrappedConnection.setProtocol(protocol);
        }
    }

    public void setProxyHost(String s)
        throws IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.setProxyHost(s);
        }
    }

    public void setProxyPort(int i)
        throws IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.setProxyPort(i);
        }
    }

    public void setSendBufferSize(int i)
        throws SocketException
    {
        if (hasConnection())
        {
            wrappedConnection.setSendBufferSize(i);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void setSoTimeout(int i)
        throws SocketException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.setSoTimeout(i);
        }
    }

    public void setSocketTimeout(int i)
        throws SocketException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.setSocketTimeout(i);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void setStaleCheckingEnabled(boolean flag)
    {
        if (hasConnection())
        {
            wrappedConnection.setStaleCheckingEnabled(flag);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void setVirtualHost(String s)
        throws IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.setVirtualHost(s);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void shutdownOutput()
    {
        if (hasConnection())
        {
            wrappedConnection.shutdownOutput();
        }
    }

    public void tunnelCreated()
        throws IllegalStateException, IOException
    {
        if (hasConnection())
        {
            wrappedConnection.tunnelCreated();
        }
    }

    public void write(byte abyte0[])
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.write(abyte0);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.write(abyte0, i, j);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void writeLine()
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.writeLine();
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public void writeLine(byte abyte0[])
        throws IOException, IllegalStateException
    {
        if (hasConnection())
        {
            wrappedConnection.writeLine(abyte0);
            return;
        } else
        {
            throw new IllegalStateException("Connection has been released");
        }
    }

    public (HttpConnection httpconnection)
    {
        super(httpconnection.getHost(), httpconnection.getPort(), httpconnection.getProtocol());
        wrappedConnection = httpconnection;
    }
}
