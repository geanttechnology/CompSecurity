// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpContext, BasicHttpContext

public class HttpCoreContext
    implements HttpContext
{

    public static final String HTTP_CONNECTION = "http.connection";
    public static final String HTTP_REQUEST = "http.request";
    public static final String HTTP_REQ_SENT = "http.request_sent";
    public static final String HTTP_RESPONSE = "http.response";
    public static final String HTTP_TARGET_HOST = "http.target_host";
    private final HttpContext context;

    public HttpCoreContext()
    {
        context = new BasicHttpContext();
    }

    public HttpCoreContext(HttpContext httpcontext)
    {
        context = httpcontext;
    }

    public static HttpCoreContext adapt(HttpContext httpcontext)
    {
        Args.notNull(httpcontext, "HTTP context");
        if (httpcontext instanceof HttpCoreContext)
        {
            return (HttpCoreContext)httpcontext;
        } else
        {
            return new HttpCoreContext(httpcontext);
        }
    }

    public static HttpCoreContext create()
    {
        return new HttpCoreContext(new BasicHttpContext());
    }

    public Object getAttribute(String s)
    {
        return context.getAttribute(s);
    }

    public Object getAttribute(String s, Class class1)
    {
        Args.notNull(class1, "Attribute class");
        s = ((String) (getAttribute(s)));
        if (s == null)
        {
            return null;
        } else
        {
            return class1.cast(s);
        }
    }

    public HttpConnection getConnection()
    {
        return (HttpConnection)getAttribute("http.connection", cz/msebera/android/httpclient/HttpConnection);
    }

    public HttpConnection getConnection(Class class1)
    {
        return (HttpConnection)getAttribute("http.connection", class1);
    }

    public HttpRequest getRequest()
    {
        return (HttpRequest)getAttribute("http.request", cz/msebera/android/httpclient/HttpRequest);
    }

    public HttpResponse getResponse()
    {
        return (HttpResponse)getAttribute("http.response", cz/msebera/android/httpclient/HttpResponse);
    }

    public HttpHost getTargetHost()
    {
        return (HttpHost)getAttribute("http.target_host", cz/msebera/android/httpclient/HttpHost);
    }

    public boolean isRequestSent()
    {
        Boolean boolean1 = (Boolean)getAttribute("http.request_sent", java/lang/Boolean);
        return boolean1 != null && boolean1.booleanValue();
    }

    public Object removeAttribute(String s)
    {
        return context.removeAttribute(s);
    }

    public void setAttribute(String s, Object obj)
    {
        context.setAttribute(s, obj);
    }

    public void setTargetHost(HttpHost httphost)
    {
        setAttribute("http.target_host", httphost);
    }
}
