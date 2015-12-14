// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpMethodBase, HttpException, HostConfiguration, URIException, 
//            URI, HttpConnection, Header, StatusLine, 
//            Wire, HttpMethod, HttpState

public class ConnectMethod extends HttpMethodBase
{

    private static final Log LOG;
    public static final String NAME = "CONNECT";
    static Class class$org$apache$commons$httpclient$ConnectMethod;
    private final HostConfiguration targethost;

    public ConnectMethod()
    {
        targethost = null;
    }

    public ConnectMethod(HostConfiguration hostconfiguration)
    {
        if (hostconfiguration == null)
        {
            throw new IllegalArgumentException("Target host may not be null");
        } else
        {
            targethost = hostconfiguration;
            return;
        }
    }

    public ConnectMethod(HttpMethod httpmethod)
    {
        targethost = null;
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

    protected void addCookieRequestHeader(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
    }

    protected void addRequestHeaders(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter ConnectMethod.addRequestHeaders(HttpState, HttpConnection)");
        addUserAgentRequestHeader(httpstate, httpconnection);
        addHostRequestHeader(httpstate, httpconnection);
        addProxyConnectionHeader(httpstate, httpconnection);
    }

    public int execute(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter ConnectMethod.execute(HttpState, HttpConnection)");
        int i = super.execute(httpstate, httpconnection);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("CONNECT status code " + i);
        }
        return i;
    }

    public String getName()
    {
        return "CONNECT";
    }

    public String getPath()
    {
        if (targethost != null)
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append(targethost.getHost());
            int j = targethost.getPort();
            int i = j;
            if (j == -1)
            {
                i = targethost.getProtocol().getDefaultPort();
            }
            stringbuffer.append(':');
            stringbuffer.append(i);
            return stringbuffer.toString();
        } else
        {
            return "/";
        }
    }

    public URI getURI()
        throws URIException
    {
        String s = getParams().getUriCharset();
        return new URI(getPath(), true, s);
    }

    protected boolean shouldCloseConnection(HttpConnection httpconnection)
    {
        if (getStatusCode() == 200)
        {
            Header header = null;
            if (!httpconnection.isTransparent())
            {
                header = getResponseHeader("proxy-connection");
            }
            httpconnection = header;
            if (header == null)
            {
                httpconnection = getResponseHeader("connection");
            }
            if (httpconnection != null && httpconnection.getValue().equalsIgnoreCase("close") && LOG.isWarnEnabled())
            {
                LOG.warn("Invalid header encountered '" + httpconnection.toExternalForm() + "' in response " + getStatusLine().toString());
            }
            return false;
        } else
        {
            return super.shouldCloseConnection(httpconnection);
        }
    }

    protected void writeRequestLine(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        httpstate = new StringBuffer();
        httpstate.append(getName());
        httpstate.append(' ');
        if (targethost != null)
        {
            httpstate.append(getPath());
        } else
        {
            int j = httpconnection.getPort();
            int i = j;
            if (j == -1)
            {
                i = httpconnection.getProtocol().getDefaultPort();
            }
            httpstate.append(httpconnection.getHost());
            httpstate.append(':');
            httpstate.append(i);
        }
        httpstate.append(" ");
        httpstate.append(getEffectiveVersion());
        httpstate = httpstate.toString();
        httpconnection.printLine(httpstate, getParams().getHttpElementCharset());
        if (Wire.HEADER_WIRE.enabled())
        {
            Wire.HEADER_WIRE.output(httpstate);
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$ConnectMethod == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.ConnectMethod");
            class$org$apache$commons$httpclient$ConnectMethod = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$ConnectMethod;
        }
        LOG = LogFactory.getLog(class1);
    }
}
