// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ExceptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HostConfiguration, Wire, WireLogOutputStream, HttpParser, 
//            HttpConnectionManager

public class HttpConnection
{

    private static final byte CRLF[] = {
        13, 10
    };
    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$HttpConnection;
    private String hostName;
    private HttpConnectionManager httpConnectionManager;
    private InputStream inputStream;
    protected boolean isOpen;
    private InputStream lastResponseInputStream;
    private InetAddress localAddress;
    private boolean locked;
    private OutputStream outputStream;
    private HttpConnectionParams params;
    private int portNumber;
    private Protocol protocolInUse;
    private String proxyHostName;
    private int proxyPortNumber;
    private Socket socket;
    private boolean tunnelEstablished;
    private boolean usingSecureSocket;

    public HttpConnection(String s, int i)
    {
        this(null, -1, s, null, i, Protocol.getProtocol("http"));
    }

    public HttpConnection(String s, int i, String s1, int j)
    {
        this(s, i, s1, null, j, Protocol.getProtocol("http"));
    }

    public HttpConnection(String s, int i, String s1, int j, Protocol protocol)
    {
        hostName = null;
        portNumber = -1;
        proxyHostName = null;
        proxyPortNumber = -1;
        socket = null;
        inputStream = null;
        outputStream = null;
        lastResponseInputStream = null;
        isOpen = false;
        params = new HttpConnectionParams();
        locked = false;
        usingSecureSocket = false;
        tunnelEstablished = false;
        if (s1 == null)
        {
            throw new IllegalArgumentException("host parameter is null");
        }
        if (protocol == null)
        {
            throw new IllegalArgumentException("protocol is null");
        } else
        {
            proxyHostName = s;
            proxyPortNumber = i;
            hostName = s1;
            portNumber = protocol.resolvePort(j);
            protocolInUse = protocol;
            return;
        }
    }

    public HttpConnection(String s, int i, String s1, String s2, int j, Protocol protocol)
    {
        this(s, i, s1, j, protocol);
    }

    public HttpConnection(String s, int i, Protocol protocol)
    {
        this(null, -1, s, null, i, protocol);
    }

    public HttpConnection(String s, String s1, int i, Protocol protocol)
    {
        this(null, -1, s, s1, i, protocol);
    }

    public HttpConnection(HostConfiguration hostconfiguration)
    {
        this(hostconfiguration.getProxyHost(), hostconfiguration.getProxyPort(), hostconfiguration.getHost(), hostconfiguration.getPort(), hostconfiguration.getProtocol());
        localAddress = hostconfiguration.getLocalAddress();
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    protected void assertNotOpen()
        throws IllegalStateException
    {
        if (isOpen)
        {
            throw new IllegalStateException("Connection is open");
        } else
        {
            return;
        }
    }

    protected void assertOpen()
        throws IllegalStateException
    {
        if (!isOpen)
        {
            throw new IllegalStateException("Connection is not open");
        } else
        {
            return;
        }
    }

    public void close()
    {
        LOG.trace("enter HttpConnection.close()");
        closeSocketAndStreams();
    }

    public boolean closeIfStale()
        throws IOException
    {
        if (isOpen && isStale())
        {
            LOG.debug("Connection is stale, closing...");
            close();
            return true;
        } else
        {
            return false;
        }
    }

    protected void closeSocketAndStreams()
    {
        LOG.trace("enter HttpConnection.closeSockedAndStreams()");
        isOpen = false;
        lastResponseInputStream = null;
        if (outputStream != null)
        {
            Object obj = outputStream;
            outputStream = null;
            try
            {
                ((OutputStream) (obj)).close();
            }
            catch (Exception exception)
            {
                LOG.debug("Exception caught when closing output", exception);
            }
        }
        if (inputStream != null)
        {
            obj = inputStream;
            inputStream = null;
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (Exception exception1)
            {
                LOG.debug("Exception caught when closing input", exception1);
            }
        }
        if (socket != null)
        {
            obj = socket;
            socket = null;
            try
            {
                ((Socket) (obj)).close();
            }
            catch (Exception exception2)
            {
                LOG.debug("Exception caught when closing socket", exception2);
            }
        }
        tunnelEstablished = false;
        usingSecureSocket = false;
    }

    public void flushRequestOutputStream()
        throws IOException
    {
        LOG.trace("enter HttpConnection.flushRequestOutputStream()");
        assertOpen();
        outputStream.flush();
    }

    public String getHost()
    {
        return hostName;
    }

    public HttpConnectionManager getHttpConnectionManager()
    {
        return httpConnectionManager;
    }

    public InputStream getLastResponseInputStream()
    {
        return lastResponseInputStream;
    }

    public InetAddress getLocalAddress()
    {
        return localAddress;
    }

    public HttpConnectionParams getParams()
    {
        return params;
    }

    public int getPort()
    {
        if (portNumber < 0)
        {
            return !isSecure() ? 80 : 443;
        } else
        {
            return portNumber;
        }
    }

    public Protocol getProtocol()
    {
        return protocolInUse;
    }

    public String getProxyHost()
    {
        return proxyHostName;
    }

    public int getProxyPort()
    {
        return proxyPortNumber;
    }

    public OutputStream getRequestOutputStream()
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.getRequestOutputStream()");
        assertOpen();
        OutputStream outputstream = outputStream;
        Object obj = outputstream;
        if (Wire.CONTENT_WIRE.enabled())
        {
            obj = new WireLogOutputStream(outputstream, Wire.CONTENT_WIRE);
        }
        return ((OutputStream) (obj));
    }

    public InputStream getResponseInputStream()
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.getResponseInputStream()");
        assertOpen();
        return inputStream;
    }

    public int getSendBufferSize()
        throws SocketException
    {
        if (socket == null)
        {
            return -1;
        } else
        {
            return socket.getSendBufferSize();
        }
    }

    public int getSoTimeout()
        throws SocketException
    {
        return params.getSoTimeout();
    }

    protected Socket getSocket()
    {
        return socket;
    }

    public String getVirtualHost()
    {
        return hostName;
    }

    protected boolean isLocked()
    {
        return locked;
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    public boolean isProxied()
    {
        return proxyHostName != null && proxyPortNumber > 0;
    }

    public boolean isResponseAvailable()
        throws IOException
    {
        boolean flag1 = false;
        LOG.trace("enter HttpConnection.isResponseAvailable()");
        boolean flag = flag1;
        if (isOpen)
        {
            flag = flag1;
            if (inputStream.available() > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isResponseAvailable(int i)
        throws IOException
    {
        boolean flag;
        LOG.trace("enter HttpConnection.isResponseAvailable(int)");
        assertOpen();
        flag = false;
        if (inputStream.available() > 0)
        {
            return true;
        }
        socket.setSoTimeout(i);
        inputStream.mark(1);
        if (inputStream.read() == -1) goto _L2; else goto _L1
_L1:
        inputStream.reset();
        LOG.debug("Input data available");
        flag = true;
_L4:
        try
        {
            socket.setSoTimeout(params.getSoTimeout());
        }
        catch (IOException ioexception)
        {
            LOG.debug("An error ocurred while resetting soTimeout, we will assume that no response is available.", ioexception);
            return false;
        }
        return flag;
_L2:
        LOG.debug("Input data not available");
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        if (!ExceptionUtil.isSocketTimeoutException(((InterruptedIOException) (obj))))
        {
            throw obj;
        }
        break MISSING_BLOCK_LABEL_151;
        obj;
        try
        {
            socket.setSoTimeout(params.getSoTimeout());
        }
        catch (IOException ioexception1)
        {
            LOG.debug("An error ocurred while resetting soTimeout, we will assume that no response is available.", ioexception1);
        }
        throw obj;
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Input data not available after " + i + " ms");
        }
        try
        {
            socket.setSoTimeout(params.getSoTimeout());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LOG.debug("An error ocurred while resetting soTimeout, we will assume that no response is available.", ((Throwable) (obj)));
            return false;
        }
        return false;
    }

    public boolean isSecure()
    {
        return protocolInUse.isSecure();
    }

    protected boolean isStale()
        throws IOException
    {
        boolean flag = true;
        if (!isOpen) goto _L2; else goto _L1
_L1:
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag = false;
        flag3 = false;
        flag2 = false;
        flag1 = flag3;
        int i = inputStream.available();
        if (i > 0) goto _L2; else goto _L3
_L3:
        socket.setSoTimeout(1);
        inputStream.mark(1);
        i = inputStream.read();
        if (i != -1) goto _L5; else goto _L4
_L4:
        flag = true;
_L7:
        flag1 = flag;
        socket.setSoTimeout(params.getSoTimeout());
_L2:
        return flag;
_L5:
        inputStream.reset();
        flag = flag2;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        flag1 = flag3;
        socket.setSoTimeout(params.getSoTimeout());
        flag1 = flag3;
        throw obj;
        obj;
        flag = flag1;
        if (!ExceptionUtil.isSocketTimeoutException(((InterruptedIOException) (obj))))
        {
            throw obj;
        }
          goto _L2
        obj;
        LOG.debug("An error occurred while reading from the socket, is appears to be stale", ((Throwable) (obj)));
        return true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean isStaleCheckingEnabled()
    {
        return params.isStaleCheckingEnabled();
    }

    public boolean isTransparent()
    {
        return !isProxied() || tunnelEstablished;
    }

    public void open()
        throws IOException
    {
        ProtocolSocketFactory protocolsocketfactory;
        int i;
        int j;
        boolean flag;
        LOG.trace("enter HttpConnection.open()");
        Object obj;
        int k;
        if (proxyHostName == null)
        {
            obj = hostName;
        } else
        {
            obj = proxyHostName;
        }
        if (proxyHostName == null)
        {
            i = portNumber;
        } else
        {
            i = proxyPortNumber;
        }
        assertNotOpen();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Open connection to " + obj + ":" + i);
        }
        if (socket != null) goto _L2; else goto _L1
_L1:
        if (isSecure() && !isProxied())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        usingSecureSocket = flag;
        if (!isSecure() || !isProxied()) goto _L4; else goto _L3
_L3:
        protocolsocketfactory = Protocol.getProtocol("http").getSocketFactory();
_L8:
        socket = protocolsocketfactory.createSocket(((String) (obj)), i, localAddress, 0, params);
_L2:
        socket.setTcpNoDelay(params.getTcpNoDelay());
        socket.setSoTimeout(params.getSoTimeout());
        i = params.getLinger();
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        try
        {
            obj = socket;
        }
        catch (IOException ioexception)
        {
            closeSocketAndStreams();
            throw ioexception;
        }
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Socket) (obj)).setSoLinger(flag, i);
        i = params.getSendBufferSize();
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        socket.setSendBufferSize(i);
        i = params.getReceiveBufferSize();
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        socket.setReceiveBufferSize(i);
        j = socket.getSendBufferSize();
        if (j > 2048) goto _L6; else goto _L5
_L5:
        i = j;
        if (j > 0) goto _L7; else goto _L6
_L7:
        k = socket.getReceiveBufferSize();
        if (k > 2048)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        j = k;
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_416;
        }
_L9:
        inputStream = new BufferedInputStream(socket.getInputStream(), j);
        outputStream = new BufferedOutputStream(socket.getOutputStream(), i);
        isOpen = true;
        return;
_L4:
        protocolsocketfactory = protocolInUse.getSocketFactory();
          goto _L8
_L6:
        i = 2048;
          goto _L7
        j = 2048;
          goto _L9
    }

    public void print(String s)
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.print(String)");
        write(EncodingUtil.getBytes(s, "ISO-8859-1"));
    }

    public void print(String s, String s1)
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.print(String)");
        write(EncodingUtil.getBytes(s, s1));
    }

    public void printLine()
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.printLine()");
        writeLine();
    }

    public void printLine(String s)
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.printLine(String)");
        writeLine(EncodingUtil.getBytes(s, "ISO-8859-1"));
    }

    public void printLine(String s, String s1)
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.printLine(String)");
        writeLine(EncodingUtil.getBytes(s, s1));
    }

    public String readLine()
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.readLine()");
        assertOpen();
        return HttpParser.readLine(inputStream);
    }

    public String readLine(String s)
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.readLine()");
        assertOpen();
        return HttpParser.readLine(inputStream, s);
    }

    public void releaseConnection()
    {
        LOG.trace("enter HttpConnection.releaseConnection()");
        if (locked)
        {
            LOG.debug("Connection is locked.  Call to releaseConnection() ignored.");
            return;
        }
        if (httpConnectionManager != null)
        {
            LOG.debug("Releasing connection back to connection manager.");
            httpConnectionManager.releaseConnection(this);
            return;
        } else
        {
            LOG.warn("HttpConnectionManager is null.  Connection cannot be released.");
            return;
        }
    }

    public void setConnectionTimeout(int i)
    {
        params.setConnectionTimeout(i);
    }

    public void setHost(String s)
        throws IllegalStateException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("host parameter is null");
        } else
        {
            assertNotOpen();
            hostName = s;
            return;
        }
    }

    public void setHttpConnectionManager(HttpConnectionManager httpconnectionmanager)
    {
        httpConnectionManager = httpconnectionmanager;
    }

    public void setLastResponseInputStream(InputStream inputstream)
    {
        lastResponseInputStream = inputstream;
    }

    public void setLocalAddress(InetAddress inetaddress)
    {
        assertNotOpen();
        localAddress = inetaddress;
    }

    protected void setLocked(boolean flag)
    {
        locked = flag;
    }

    public void setParams(HttpConnectionParams httpconnectionparams)
    {
        if (httpconnectionparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        } else
        {
            params = httpconnectionparams;
            return;
        }
    }

    public void setPort(int i)
        throws IllegalStateException
    {
        assertNotOpen();
        portNumber = i;
    }

    public void setProtocol(Protocol protocol)
    {
        assertNotOpen();
        if (protocol == null)
        {
            throw new IllegalArgumentException("protocol is null");
        } else
        {
            protocolInUse = protocol;
            return;
        }
    }

    public void setProxyHost(String s)
        throws IllegalStateException
    {
        assertNotOpen();
        proxyHostName = s;
    }

    public void setProxyPort(int i)
        throws IllegalStateException
    {
        assertNotOpen();
        proxyPortNumber = i;
    }

    public void setSendBufferSize(int i)
        throws SocketException
    {
        params.setSendBufferSize(i);
    }

    public void setSoTimeout(int i)
        throws SocketException, IllegalStateException
    {
        params.setSoTimeout(i);
        if (socket != null)
        {
            socket.setSoTimeout(i);
        }
    }

    public void setSocketTimeout(int i)
        throws SocketException, IllegalStateException
    {
        assertOpen();
        if (socket != null)
        {
            socket.setSoTimeout(i);
        }
    }

    public void setStaleCheckingEnabled(boolean flag)
    {
        params.setStaleCheckingEnabled(flag);
    }

    public void setVirtualHost(String s)
        throws IllegalStateException
    {
        assertNotOpen();
    }

    public void shutdownOutput()
    {
        LOG.trace("enter HttpConnection.shutdownOutput()");
        try
        {
            socket.getClass().getMethod("shutdownOutput", new Class[0]).invoke(socket, new Object[0]);
            return;
        }
        catch (Exception exception)
        {
            LOG.debug("Unexpected Exception caught", exception);
        }
    }

    public void tunnelCreated()
        throws IllegalStateException, IOException
    {
        LOG.trace("enter HttpConnection.tunnelCreated()");
        if (!isSecure() || !isProxied())
        {
            throw new IllegalStateException("Connection must be secure and proxied to use this feature");
        }
        if (usingSecureSocket)
        {
            throw new IllegalStateException("Already using a secure socket");
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Secure tunnel to " + hostName + ":" + portNumber);
        }
        socket = ((SecureProtocolSocketFactory)protocolInUse.getSocketFactory()).createSocket(socket, hostName, portNumber, true);
        int i = params.getSendBufferSize();
        if (i >= 0)
        {
            socket.setSendBufferSize(i);
        }
        i = params.getReceiveBufferSize();
        if (i >= 0)
        {
            socket.setReceiveBufferSize(i);
        }
        int j = socket.getSendBufferSize();
        i = j;
        if (j > 2048)
        {
            i = 2048;
        }
        int k = socket.getReceiveBufferSize();
        j = k;
        if (k > 2048)
        {
            j = 2048;
        }
        inputStream = new BufferedInputStream(socket.getInputStream(), j);
        outputStream = new BufferedOutputStream(socket.getOutputStream(), i);
        usingSecureSocket = true;
        tunnelEstablished = true;
    }

    public void write(byte abyte0[])
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.write(byte[])");
        write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.write(byte[], int, int)");
        if (i < 0)
        {
            throw new IllegalArgumentException("Array offset may not be negative");
        }
        if (j < 0)
        {
            throw new IllegalArgumentException("Array length may not be negative");
        }
        if (i + j > abyte0.length)
        {
            throw new IllegalArgumentException("Given offset and length exceed the array length");
        } else
        {
            assertOpen();
            outputStream.write(abyte0, i, j);
            return;
        }
    }

    public void writeLine()
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.writeLine()");
        write(CRLF);
    }

    public void writeLine(byte abyte0[])
        throws IOException, IllegalStateException
    {
        LOG.trace("enter HttpConnection.writeLine(byte[])");
        write(abyte0);
        writeLine();
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$HttpConnection == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.HttpConnection");
            class$org$apache$commons$httpclient$HttpConnection = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$HttpConnection;
        }
        LOG = LogFactory.getLog(class1);
    }
}
