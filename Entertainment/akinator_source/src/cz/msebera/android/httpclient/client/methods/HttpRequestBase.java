// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import java.net.URI;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            AbstractExecutionAwareRequest, HttpUriRequest, Configurable

public abstract class HttpRequestBase extends AbstractExecutionAwareRequest
    implements HttpUriRequest, Configurable
{

    private RequestConfig config;
    private URI uri;
    private ProtocolVersion version;

    public HttpRequestBase()
    {
    }

    public RequestConfig getConfig()
    {
        return config;
    }

    public abstract String getMethod();

    public ProtocolVersion getProtocolVersion()
    {
        if (version != null)
        {
            return version;
        } else
        {
            return HttpProtocolParams.getVersion(getParams());
        }
    }

    public RequestLine getRequestLine()
    {
        Object obj;
        String s1;
        ProtocolVersion protocolversion;
label0:
        {
            s1 = getMethod();
            protocolversion = getProtocolVersion();
            obj = getURI();
            String s = null;
            if (obj != null)
            {
                s = ((URI) (obj)).toASCIIString();
            }
            if (s != null)
            {
                obj = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            obj = "/";
        }
        return new BasicRequestLine(s1, ((String) (obj)), protocolversion);
    }

    public URI getURI()
    {
        return uri;
    }

    public void releaseConnection()
    {
        reset();
    }

    public void setConfig(RequestConfig requestconfig)
    {
        config = requestconfig;
    }

    public void setProtocolVersion(ProtocolVersion protocolversion)
    {
        version = protocolversion;
    }

    public void setURI(URI uri1)
    {
        uri = uri1;
    }

    public void started()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append(getMethod()).append(" ").append(getURI()).append(" ").append(getProtocolVersion()).toString();
    }
}
