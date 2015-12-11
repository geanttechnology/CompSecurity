// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;
import java.net.URISyntaxException;

public class RequestWrapper extends AbstractHttpMessage
    implements HttpUriRequest
{

    private int execCount;
    private String method;
    private final HttpRequest original;
    private URI uri;
    private ProtocolVersion version;

    public RequestWrapper(HttpRequest httprequest)
        throws ProtocolException
    {
        Args.notNull(httprequest, "HTTP request");
        original = httprequest;
        setParams(httprequest.getParams());
        setHeaders(httprequest.getAllHeaders());
        if (httprequest instanceof HttpUriRequest)
        {
            uri = ((HttpUriRequest)httprequest).getURI();
            method = ((HttpUriRequest)httprequest).getMethod();
            version = null;
        } else
        {
            RequestLine requestline = httprequest.getRequestLine();
            try
            {
                uri = new URI(requestline.getUri());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequest httprequest)
            {
                throw new ProtocolException((new StringBuilder()).append("Invalid request URI: ").append(requestline.getUri()).toString(), httprequest);
            }
            method = requestline.getMethod();
            version = httprequest.getProtocolVersion();
        }
        execCount = 0;
    }

    public void abort()
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    }

    public int getExecCount()
    {
        return execCount;
    }

    public String getMethod()
    {
        return method;
    }

    public HttpRequest getOriginal()
    {
        return original;
    }

    public ProtocolVersion getProtocolVersion()
    {
        if (version == null)
        {
            version = HttpProtocolParams.getVersion(getParams());
        }
        return version;
    }

    public RequestLine getRequestLine()
    {
        String s1;
        String s2;
        ProtocolVersion protocolversion;
label0:
        {
            s2 = getMethod();
            protocolversion = getProtocolVersion();
            String s = null;
            if (uri != null)
            {
                s = uri.toASCIIString();
            }
            if (s != null)
            {
                s1 = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            s1 = "/";
        }
        return new BasicRequestLine(s2, s1, protocolversion);
    }

    public URI getURI()
    {
        return uri;
    }

    public void incrementExecCount()
    {
        execCount = execCount + 1;
    }

    public boolean isAborted()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return true;
    }

    public void resetHeaders()
    {
        headergroup.clear();
        setHeaders(original.getAllHeaders());
    }

    public void setMethod(String s)
    {
        Args.notNull(s, "Method name");
        method = s;
    }

    public void setProtocolVersion(ProtocolVersion protocolversion)
    {
        version = protocolversion;
    }

    public void setURI(URI uri1)
    {
        uri = uri1;
    }
}
