// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.cookie.SetCookie2;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            HttpClientContext

public class RequestAddCookies
    implements HttpRequestInterceptor
{

    public HttpClientAndroidLog log;

    public RequestAddCookies()
    {
        log = new HttpClientAndroidLog(getClass());
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Object obj;
        Object obj1;
        Object obj3;
        Object obj4;
        Lookup lookup;
        RouteInfo routeinfo;
        HttpHost httphost;
label0:
        {
            Args.notNull(httprequest, "HTTP request");
            Args.notNull(httpcontext, "HTTP context");
            if (httprequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT"))
            {
                return;
            }
            obj4 = HttpClientContext.adapt(httpcontext);
            obj3 = ((HttpClientContext) (obj4)).getCookieStore();
            if (obj3 == null)
            {
                log.debug("Cookie store not specified in HTTP context");
                return;
            }
            lookup = ((HttpClientContext) (obj4)).getCookieSpecRegistry();
            if (lookup == null)
            {
                log.debug("CookieSpec registry not specified in HTTP context");
                return;
            }
            httphost = ((HttpClientContext) (obj4)).getTargetHost();
            if (httphost == null)
            {
                log.debug("Target host not set in the context");
                return;
            }
            routeinfo = ((HttpClientContext) (obj4)).getHttpRoute();
            if (routeinfo == null)
            {
                log.debug("Connection route not set in the context");
                return;
            }
            obj = ((HttpClientContext) (obj4)).getRequestConfig().getCookieSpec();
            obj1 = obj;
            if (obj == null)
            {
                obj1 = "best-match";
            }
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("CookieSpec selected: ").append(((String) (obj1))).toString());
            }
            obj = null;
            if (httprequest instanceof HttpUriRequest)
            {
                obj = ((HttpUriRequest)httprequest).getURI();
                break label0;
            }
        }
        obj2 = new URI(httprequest.getRequestLine().getUri());
        obj = obj2;
        continue; /* Loop/switch isn't completed */
_L2:
        Object obj2;
        int i;
        int j;
        if (obj != null)
        {
            obj = ((URI) (obj)).getPath();
        } else
        {
            obj = null;
        }
        obj2 = httphost.getHostName();
        j = httphost.getPort();
        i = j;
        if (j < 0)
        {
            i = routeinfo.getTargetHost().getPort();
        }
        if (i < 0)
        {
            i = 0;
        }
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = "/";
        }
        obj = new CookieOrigin(((String) (obj2)), i, ((String) (obj)), routeinfo.isSecure());
        obj2 = (CookieSpecProvider)lookup.lookup(((String) (obj1)));
        if (obj2 == null)
        {
            throw new HttpException((new StringBuilder()).append("Unsupported cookie policy: ").append(((String) (obj1))).toString());
        }
        obj1 = ((CookieSpecProvider) (obj2)).create(((HttpContext) (obj4)));
        obj4 = new ArrayList(((CookieStore) (obj3)).getCookies());
        obj2 = new ArrayList();
        obj3 = new Date();
        obj4 = ((List) (obj4)).iterator();
        do
        {
            if (!((Iterator) (obj4)).hasNext())
            {
                break;
            }
            Cookie cookie1 = (Cookie)((Iterator) (obj4)).next();
            if (!cookie1.isExpired(((Date) (obj3))))
            {
                if (((CookieSpec) (obj1)).match(cookie1, ((CookieOrigin) (obj))))
                {
                    if (log.isDebugEnabled())
                    {
                        log.debug((new StringBuilder()).append("Cookie ").append(cookie1).append(" match ").append(obj).toString());
                    }
                    ((List) (obj2)).add(cookie1);
                }
            } else
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Cookie ").append(cookie1).append(" expired").toString());
            }
        } while (true);
        if (!((List) (obj2)).isEmpty())
        {
            for (Iterator iterator = ((CookieSpec) (obj1)).formatCookies(((List) (obj2))).iterator(); iterator.hasNext(); httprequest.addHeader((Header)iterator.next())) { }
        }
        j = ((CookieSpec) (obj1)).getVersion();
        if (j > 0)
        {
            boolean flag = false;
            obj2 = ((List) (obj2)).iterator();
            do
            {
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                Cookie cookie = (Cookie)((Iterator) (obj2)).next();
                if (j != cookie.getVersion() || !(cookie instanceof SetCookie2))
                {
                    flag = true;
                }
            } while (true);
            if (flag)
            {
                Header header = ((CookieSpec) (obj1)).getVersionHeader();
                if (header != null)
                {
                    httprequest.addHeader(header);
                }
            }
        }
        httpcontext.setAttribute("http.cookie-spec", obj1);
        httpcontext.setAttribute("http.cookie-origin", obj);
        return;
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
