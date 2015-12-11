// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            HttpUriRequest, Configurable, HttpRequestBase, HttpEntityEnclosingRequestBase

public class RequestBuilder
{
    static class InternalEntityEclosingRequest extends HttpEntityEnclosingRequestBase
    {

        private final String method;

        public String getMethod()
        {
            return method;
        }

        InternalEntityEclosingRequest(String s)
        {
            method = s;
        }
    }

    static class InternalRequest extends HttpRequestBase
    {

        private final String method;

        public String getMethod()
        {
            return method;
        }

        InternalRequest(String s)
        {
            method = s;
        }
    }


    private RequestConfig config;
    private HttpEntity entity;
    private HeaderGroup headergroup;
    private String method;
    private LinkedList parameters;
    private URI uri;
    private ProtocolVersion version;

    RequestBuilder()
    {
        this(null);
    }

    RequestBuilder(String s)
    {
        method = s;
    }

    public static RequestBuilder copy(HttpRequest httprequest)
    {
        Args.notNull(httprequest, "HTTP request");
        return (new RequestBuilder()).doCopy(httprequest);
    }

    public static RequestBuilder create(String s)
    {
        Args.notBlank(s, "HTTP method");
        return new RequestBuilder(s);
    }

    public static RequestBuilder delete()
    {
        return new RequestBuilder("DELETE");
    }

    private RequestBuilder doCopy(HttpRequest httprequest)
    {
        if (httprequest == null)
        {
            return this;
        }
        method = httprequest.getRequestLine().getMethod();
        version = httprequest.getRequestLine().getProtocolVersion();
        if (httprequest instanceof HttpUriRequest)
        {
            uri = ((HttpUriRequest)httprequest).getURI();
        } else
        {
            uri = URI.create(httprequest.getRequestLine().getUri());
        }
        if (headergroup == null)
        {
            headergroup = new HeaderGroup();
        }
        headergroup.clear();
        headergroup.setHeaders(httprequest.getAllHeaders());
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            entity = ((HttpEntityEnclosingRequest)httprequest).getEntity();
        } else
        {
            entity = null;
        }
        if (httprequest instanceof Configurable)
        {
            config = ((Configurable)httprequest).getConfig();
        } else
        {
            config = null;
        }
        parameters = null;
        return this;
    }

    public static RequestBuilder get()
    {
        return new RequestBuilder("GET");
    }

    public static RequestBuilder head()
    {
        return new RequestBuilder("HEAD");
    }

    public static RequestBuilder options()
    {
        return new RequestBuilder("OPTIONS");
    }

    public static RequestBuilder post()
    {
        return new RequestBuilder("POST");
    }

    public static RequestBuilder put()
    {
        return new RequestBuilder("PUT");
    }

    public static RequestBuilder trace()
    {
        return new RequestBuilder("TRACE");
    }

    public RequestBuilder addHeader(Header header)
    {
        if (headergroup == null)
        {
            headergroup = new HeaderGroup();
        }
        headergroup.addHeader(header);
        return this;
    }

    public RequestBuilder addHeader(String s, String s1)
    {
        if (headergroup == null)
        {
            headergroup = new HeaderGroup();
        }
        headergroup.addHeader(new BasicHeader(s, s1));
        return this;
    }

    public RequestBuilder addParameter(NameValuePair namevaluepair)
    {
        Args.notNull(namevaluepair, "Name value pair");
        if (parameters == null)
        {
            parameters = new LinkedList();
        }
        parameters.add(namevaluepair);
        return this;
    }

    public RequestBuilder addParameter(String s, String s1)
    {
        return addParameter(((NameValuePair) (new BasicNameValuePair(s, s1))));
    }

    public transient RequestBuilder addParameters(NameValuePair anamevaluepair[])
    {
        int j = anamevaluepair.length;
        for (int i = 0; i < j; i++)
        {
            addParameter(anamevaluepair[i]);
        }

        return this;
    }

    public HttpUriRequest build()
    {
        Object obj;
        Object obj1;
        Object obj2;
        HttpEntity httpentity;
        if (uri != null)
        {
            obj = uri;
        } else
        {
            obj = URI.create("/");
        }
        httpentity = entity;
        obj2 = httpentity;
        obj1 = obj;
        if (parameters == null) goto _L2; else goto _L1
_L1:
        obj2 = httpentity;
        obj1 = obj;
        if (parameters.isEmpty()) goto _L2; else goto _L3
_L3:
        if (httpentity != null || !"POST".equalsIgnoreCase(method) && !"PUT".equalsIgnoreCase(method)) goto _L5; else goto _L4
_L4:
        obj2 = new UrlEncodedFormEntity(parameters, HTTP.DEF_CONTENT_CHARSET);
        obj1 = obj;
_L2:
        if (obj2 == null)
        {
            obj = new InternalRequest(method);
        } else
        {
            obj = new InternalEntityEclosingRequest(method);
            ((InternalEntityEclosingRequest) (obj)).setEntity(((HttpEntity) (obj2)));
        }
        ((HttpRequestBase) (obj)).setProtocolVersion(version);
        ((HttpRequestBase) (obj)).setURI(((URI) (obj1)));
        if (headergroup != null)
        {
            ((HttpRequestBase) (obj)).setHeaders(headergroup.getAllHeaders());
        }
        ((HttpRequestBase) (obj)).setConfig(config);
        return ((HttpUriRequest) (obj));
_L5:
        obj1 = (new URIBuilder(((URI) (obj)))).addParameters(parameters).build();
        obj2 = httpentity;
        continue; /* Loop/switch isn't completed */
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        obj2 = httpentity;
        urisyntaxexception = ((URISyntaxException) (obj));
        if (true) goto _L2; else goto _L6
_L6:
    }

    public RequestConfig getConfig()
    {
        return config;
    }

    public HttpEntity getEntity()
    {
        return entity;
    }

    public Header getFirstHeader(String s)
    {
        if (headergroup != null)
        {
            return headergroup.getFirstHeader(s);
        } else
        {
            return null;
        }
    }

    public Header[] getHeaders(String s)
    {
        if (headergroup != null)
        {
            return headergroup.getHeaders(s);
        } else
        {
            return null;
        }
    }

    public Header getLastHeader(String s)
    {
        if (headergroup != null)
        {
            return headergroup.getLastHeader(s);
        } else
        {
            return null;
        }
    }

    public String getMethod()
    {
        return method;
    }

    public List getParameters()
    {
        if (parameters != null)
        {
            return new ArrayList(parameters);
        } else
        {
            return new ArrayList();
        }
    }

    public URI getUri()
    {
        return uri;
    }

    public ProtocolVersion getVersion()
    {
        return version;
    }

    public RequestBuilder removeHeader(Header header)
    {
        if (headergroup == null)
        {
            headergroup = new HeaderGroup();
        }
        headergroup.removeHeader(header);
        return this;
    }

    public RequestBuilder removeHeaders(String s)
    {
        if (s != null && headergroup != null)
        {
            HeaderIterator headeriterator = headergroup.iterator();
            while (headeriterator.hasNext()) 
            {
                if (s.equalsIgnoreCase(headeriterator.nextHeader().getName()))
                {
                    headeriterator.remove();
                }
            }
        }
        return this;
    }

    public RequestBuilder setConfig(RequestConfig requestconfig)
    {
        config = requestconfig;
        return this;
    }

    public RequestBuilder setEntity(HttpEntity httpentity)
    {
        entity = httpentity;
        return this;
    }

    public RequestBuilder setHeader(Header header)
    {
        if (headergroup == null)
        {
            headergroup = new HeaderGroup();
        }
        headergroup.updateHeader(header);
        return this;
    }

    public RequestBuilder setHeader(String s, String s1)
    {
        if (headergroup == null)
        {
            headergroup = new HeaderGroup();
        }
        headergroup.updateHeader(new BasicHeader(s, s1));
        return this;
    }

    public RequestBuilder setUri(String s)
    {
        if (s != null)
        {
            s = URI.create(s);
        } else
        {
            s = null;
        }
        uri = s;
        return this;
    }

    public RequestBuilder setUri(URI uri1)
    {
        uri = uri1;
        return this;
    }

    public RequestBuilder setVersion(ProtocolVersion protocolversion)
    {
        version = protocolversion;
        return this;
    }
}
