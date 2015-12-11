// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.URI;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            HttpUriRequest

public class HttpRequestWrapper extends AbstractHttpMessage
    implements HttpUriRequest
{
    static class HttpEntityEnclosingRequestWrapper extends HttpRequestWrapper
        implements HttpEntityEnclosingRequest
    {

        private HttpEntity entity;

        public boolean expectContinue()
        {
            Header header = getFirstHeader("Expect");
            return header != null && "100-continue".equalsIgnoreCase(header.getValue());
        }

        public HttpEntity getEntity()
        {
            return entity;
        }

        public void setEntity(HttpEntity httpentity)
        {
            entity = httpentity;
        }

        public HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpentityenclosingrequest)
        {
            super(httpentityenclosingrequest, null);
            entity = httpentityenclosingrequest.getEntity();
        }
    }


    private final String method;
    private final HttpRequest original;
    private URI uri;
    private ProtocolVersion version;

    private HttpRequestWrapper(HttpRequest httprequest)
    {
        original = httprequest;
        version = original.getRequestLine().getProtocolVersion();
        method = original.getRequestLine().getMethod();
        if (httprequest instanceof HttpUriRequest)
        {
            uri = ((HttpUriRequest)httprequest).getURI();
        } else
        {
            uri = null;
        }
        setHeaders(httprequest.getAllHeaders());
    }


    public static HttpRequestWrapper wrap(HttpRequest httprequest)
    {
        if (httprequest == null)
        {
            return null;
        }
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            return new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)httprequest);
        } else
        {
            return new HttpRequestWrapper(httprequest);
        }
    }

    public void abort()
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    }

    public String getMethod()
    {
        return method;
    }

    public HttpRequest getOriginal()
    {
        return original;
    }

    public HttpParams getParams()
    {
        if (params == null)
        {
            params = original.getParams().copy();
        }
        return params;
    }

    public ProtocolVersion getProtocolVersion()
    {
        if (version != null)
        {
            return version;
        } else
        {
            return original.getProtocolVersion();
        }
    }

    public RequestLine getRequestLine()
    {
label0:
        {
            String s;
            String s1;
            if (uri != null)
            {
                s = uri.toASCIIString();
            } else
            {
                s = original.getRequestLine().getUri();
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
        return new BasicRequestLine(method, s1, getProtocolVersion());
    }

    public URI getURI()
    {
        return uri;
    }

    public boolean isAborted()
    {
        return false;
    }

    public void setProtocolVersion(ProtocolVersion protocolversion)
    {
        version = protocolversion;
    }

    public void setURI(URI uri1)
    {
        uri = uri1;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getRequestLine()).append(" ").append(headergroup).toString();
    }
}
