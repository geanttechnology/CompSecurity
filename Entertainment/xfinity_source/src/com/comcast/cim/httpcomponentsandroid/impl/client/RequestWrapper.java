// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.message.AbstractHttpMessage;
import com.comcast.cim.httpcomponentsandroid.message.BasicRequestLine;
import com.comcast.cim.httpcomponentsandroid.message.HeaderGroup;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
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
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
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
        if (s == null)
        {
            throw new IllegalArgumentException("Method name may not be null");
        } else
        {
            method = s;
            return;
        }
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
