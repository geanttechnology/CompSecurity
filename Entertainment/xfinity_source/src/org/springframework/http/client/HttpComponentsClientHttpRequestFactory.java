// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.net.URI;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpRequestFactory, HttpComponentsClientHttpRequest, ClientHttpRequest

public class HttpComponentsClientHttpRequestFactory
    implements ClientHttpRequestFactory
{

    private HttpClient httpClient;

    public HttpComponentsClientHttpRequestFactory()
    {
        Object obj = new SchemeRegistry();
        ((SchemeRegistry) (obj)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry) (obj)).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        BasicHttpParams basichttpparams = new BasicHttpParams();
        obj = new ThreadSafeClientConnManager(basichttpparams, ((SchemeRegistry) (obj)));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 100);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(5));
        httpClient = new DefaultHttpClient(((org.apache.http.conn.ClientConnectionManager) (obj)), null);
        setReadTimeout(60000);
    }

    protected HttpContext createHttpContext(HttpMethod httpmethod, URI uri)
    {
        return null;
    }

    protected HttpUriRequest createHttpRequest(HttpMethod httpmethod, URI uri)
    {
        static class _cls1
        {

            static final int $SwitchMap$org$springframework$http$HttpMethod[];

            static 
            {
                $SwitchMap$org$springframework$http$HttpMethod = new int[HttpMethod.values().length];
                try
                {
                    $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.DELETE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.HEAD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.OPTIONS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.POST.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.PUT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.TRACE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.org.springframework.http.HttpMethod[httpmethod.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid HTTP method: ").append(httpmethod).toString());

        case 1: // '\001'
            return new HttpGet(uri);

        case 2: // '\002'
            return new HttpDelete(uri);

        case 3: // '\003'
            return new HttpHead(uri);

        case 4: // '\004'
            return new HttpOptions(uri);

        case 5: // '\005'
            return new HttpPost(uri);

        case 6: // '\006'
            return new HttpPut(uri);

        case 7: // '\007'
            return new HttpTrace(uri);
        }
    }

    public ClientHttpRequest createRequest(URI uri, HttpMethod httpmethod)
        throws IOException
    {
        HttpUriRequest httpurirequest = createHttpRequest(httpmethod, uri);
        postProcessHttpRequest(httpurirequest);
        return new HttpComponentsClientHttpRequest(getHttpClient(), httpurirequest, createHttpContext(httpmethod, uri));
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    protected void postProcessHttpRequest(HttpUriRequest httpurirequest)
    {
        HttpProtocolParams.setUseExpectContinue(httpurirequest.getParams(), false);
    }

    public void setReadTimeout(int i)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.isTrue(flag, "Timeout must be a non-negative value");
        getHttpClient().getParams().setIntParameter("http.socket.timeout", i);
    }
}
