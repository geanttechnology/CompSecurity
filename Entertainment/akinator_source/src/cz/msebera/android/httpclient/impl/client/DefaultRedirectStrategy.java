// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.CircularRedirectException;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.methods.RequestBuilder;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            RedirectLocations

public class DefaultRedirectStrategy
    implements RedirectStrategy
{

    public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private static final String REDIRECT_METHODS[] = {
        "GET", "HEAD"
    };
    public HttpClientAndroidLog log;

    public DefaultRedirectStrategy()
    {
        log = new HttpClientAndroidLog(getClass());
    }

    protected URI createLocationURI(String s)
        throws ProtocolException
    {
        Object obj;
        String s1;
        try
        {
            obj = new URIBuilder((new URI(s)).normalize());
            s1 = ((URIBuilder) (obj)).getHost();
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid redirect URI: ").append(s).toString(), urisyntaxexception);
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        ((URIBuilder) (obj)).setHost(s1.toLowerCase(Locale.ENGLISH));
        if (TextUtils.isEmpty(((URIBuilder) (obj)).getPath()))
        {
            ((URIBuilder) (obj)).setPath("/");
        }
        obj = ((URIBuilder) (obj)).build();
        return ((URI) (obj));
    }

    public URI getLocationURI(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException
    {
        Object obj;
        RequestConfig requestconfig;
        HttpClientContext httpclientcontext;
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpresponse, "HTTP response");
        Args.notNull(httpcontext, "HTTP context");
        httpclientcontext = HttpClientContext.adapt(httpcontext);
        obj = httpresponse.getFirstHeader("location");
        if (obj == null)
        {
            throw new ProtocolException((new StringBuilder()).append("Received redirect response ").append(httpresponse.getStatusLine()).append(" but no location header").toString());
        }
        httpresponse = ((Header) (obj)).getValue();
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Redirect requested to location '").append(httpresponse).append("'").toString());
        }
        requestconfig = httpclientcontext.getRequestConfig();
        obj = createLocationURI(httpresponse);
        httpresponse = ((HttpResponse) (obj));
        if (((URI) (obj)).isAbsolute())
        {
            break MISSING_BLOCK_LABEL_249;
        }
        if (!requestconfig.isRelativeRedirectsAllowed())
        {
            throw new ProtocolException((new StringBuilder()).append("Relative redirect location '").append(obj).append("' not allowed").toString());
        }
        try
        {
            httpresponse = httpclientcontext.getTargetHost();
            Asserts.notNull(httpresponse, "Target host");
            httpresponse = URIUtils.resolve(URIUtils.rewriteURI(new URI(httprequest.getRequestLine().getUri()), httpresponse, false), ((URI) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            throw new ProtocolException(httprequest.getMessage(), httprequest);
        }
        RedirectLocations redirectlocations = (RedirectLocations)httpclientcontext.getAttribute("http.protocol.redirect-locations");
        httprequest = redirectlocations;
        if (redirectlocations == null)
        {
            httprequest = new RedirectLocations();
            httpcontext.setAttribute("http.protocol.redirect-locations", httprequest);
        }
        if (!requestconfig.isCircularRedirectsAllowed() && httprequest.contains(httpresponse))
        {
            throw new CircularRedirectException((new StringBuilder()).append("Circular redirect to '").append(httpresponse).append("'").toString());
        } else
        {
            httprequest.add(httpresponse);
            return httpresponse;
        }
    }

    public HttpUriRequest getRedirect(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException
    {
        httpcontext = getLocationURI(httprequest, httpresponse, httpcontext);
        String s = httprequest.getRequestLine().getMethod();
        if (s.equalsIgnoreCase("HEAD"))
        {
            return new HttpHead(httpcontext);
        }
        if (s.equalsIgnoreCase("GET"))
        {
            return new HttpGet(httpcontext);
        }
        if (httpresponse.getStatusLine().getStatusCode() == 307)
        {
            return RequestBuilder.copy(httprequest).setUri(httpcontext).build();
        } else
        {
            return new HttpGet(httpcontext);
        }
    }

    protected boolean isRedirectable(String s)
    {
        boolean flag1 = false;
        String as[] = REDIRECT_METHODS;
        int j = as.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!as[i].equalsIgnoreCase(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public boolean isRedirected(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException
    {
        int i;
        boolean flag;
        boolean flag1;
        flag1 = true;
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpresponse, "HTTP response");
        i = httpresponse.getStatusLine().getStatusCode();
        httprequest = httprequest.getRequestLine().getMethod();
        httpresponse = httpresponse.getFirstHeader("location");
        flag = flag1;
        i;
        JVM INSTR tableswitch 301 307: default 100
    //                   301 124
    //                   302 106
    //                   303 103
    //                   304 100
    //                   305 100
    //                   306 100
    //                   307 124;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L2
_L1:
        flag = false;
_L4:
        return flag;
_L3:
        if (!isRedirectable(httprequest))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (httpresponse != null) goto _L4; else goto _L5
_L5:
        return false;
_L2:
        return isRedirectable(httprequest);
    }

}
