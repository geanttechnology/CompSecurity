// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.net.URI;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.apache.commons.httpclient.methods.OptionsMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.TraceMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpRequestFactory, d, ClientHttpRequest

public class CommonsClientHttpRequestFactory
    implements DisposableBean, ClientHttpRequestFactory
{

    private HttpClient a;

    public CommonsClientHttpRequestFactory()
    {
        a = new HttpClient(new MultiThreadedHttpConnectionManager());
        setReadTimeout(60000);
    }

    public CommonsClientHttpRequestFactory(HttpClient httpclient)
    {
        Assert.notNull(httpclient, "httpClient must not be null");
        a = httpclient;
    }

    protected HttpMethodBase createCommonsHttpMethod(HttpMethod httpmethod, String s)
    {
    /* anonymous class not found */
    class _anm1 {}

        switch (_cls1.a[httpmethod.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Invalid HTTP method: ")).append(httpmethod).toString());

        case 1: // '\001'
            return new GetMethod(s);

        case 2: // '\002'
            return new DeleteMethod(s);

        case 3: // '\003'
            return new HeadMethod(s);

        case 4: // '\004'
            return new OptionsMethod(s);

        case 5: // '\005'
            return new PostMethod(s);

        case 6: // '\006'
            return new PutMethod(s);

        case 7: // '\007'
            return new TraceMethod(s);
        }
    }

    public ClientHttpRequest createRequest(URI uri, HttpMethod httpmethod)
    {
        uri = createCommonsHttpMethod(httpmethod, uri.toString());
        postProcessCommonsHttpMethod(uri);
        return new d(getHttpClient(), uri);
    }

    public void destroy()
    {
        HttpConnectionManager httpconnectionmanager = getHttpClient().getHttpConnectionManager();
        if (httpconnectionmanager instanceof MultiThreadedHttpConnectionManager)
        {
            ((MultiThreadedHttpConnectionManager)httpconnectionmanager).shutdown();
        }
    }

    public HttpClient getHttpClient()
    {
        return a;
    }

    protected void postProcessCommonsHttpMethod(HttpMethodBase httpmethodbase)
    {
    }

    public void setConnectTimeout(int i)
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
        a.getHttpConnectionManager().getParams().setConnectionTimeout(i);
    }

    public void setHttpClient(HttpClient httpclient)
    {
        a = httpclient;
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
        getHttpClient().getHttpConnectionManager().getParams().setSoTimeout(i);
    }
}
