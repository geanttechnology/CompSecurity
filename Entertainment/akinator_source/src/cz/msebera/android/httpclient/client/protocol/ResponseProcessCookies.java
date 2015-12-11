// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            HttpClientContext

public class ResponseProcessCookies
    implements HttpResponseInterceptor
{

    public HttpClientAndroidLog log;

    public ResponseProcessCookies()
    {
        log = new HttpClientAndroidLog(getClass());
    }

    private static String formatCooke(Cookie cookie)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(cookie.getName());
        stringbuilder.append("=\"");
        String s1 = cookie.getValue();
        if (s1 != null)
        {
            String s = s1;
            if (s1.length() > 100)
            {
                s = (new StringBuilder()).append(s1.substring(0, 100)).append("...").toString();
            }
            stringbuilder.append(s);
        }
        stringbuilder.append("\"");
        stringbuilder.append(", version:");
        stringbuilder.append(Integer.toString(cookie.getVersion()));
        stringbuilder.append(", domain:");
        stringbuilder.append(cookie.getDomain());
        stringbuilder.append(", path:");
        stringbuilder.append(cookie.getPath());
        stringbuilder.append(", expiry:");
        stringbuilder.append(cookie.getExpiryDate());
        return stringbuilder.toString();
    }

    private void processCookies(HeaderIterator headeriterator, CookieSpec cookiespec, CookieOrigin cookieorigin, CookieStore cookiestore)
    {
_L4:
        cz.msebera.android.httpclient.Header header;
        if (!headeriterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        header = headeriterator.nextHeader();
        Iterator iterator = cookiespec.parse(header, cookieorigin).iterator();
_L1:
        Cookie cookie;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        cookie = (Cookie)iterator.next();
        cookiespec.validate(cookie, cookieorigin);
        cookiestore.addCookie(cookie);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Cookie accepted [").append(formatCooke(cookie)).append("]").toString());
        }
          goto _L1
        MalformedCookieException malformedcookieexception1;
        malformedcookieexception1;
        if (!log.isWarnEnabled()) goto _L1; else goto _L2
_L2:
        log.warn((new StringBuilder()).append("Cookie rejected [").append(formatCooke(cookie)).append("] ").append(malformedcookieexception1.getMessage()).toString());
          goto _L1
        MalformedCookieException malformedcookieexception;
        malformedcookieexception;
        if (log.isWarnEnabled())
        {
            log.warn((new StringBuilder()).append("Invalid cookie header: \"").append(header).append("\". ").append(malformedcookieexception.getMessage()).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP request");
        Args.notNull(httpcontext, "HTTP context");
        Object obj = HttpClientContext.adapt(httpcontext);
        httpcontext = ((HttpClientContext) (obj)).getCookieSpec();
        if (httpcontext == null)
        {
            log.debug("Cookie spec not specified in HTTP context");
        } else
        {
            CookieStore cookiestore = ((HttpClientContext) (obj)).getCookieStore();
            if (cookiestore == null)
            {
                log.debug("Cookie store not specified in HTTP context");
                return;
            }
            obj = ((HttpClientContext) (obj)).getCookieOrigin();
            if (obj == null)
            {
                log.debug("Cookie origin not specified in HTTP context");
                return;
            }
            processCookies(httpresponse.headerIterator("Set-Cookie"), httpcontext, ((CookieOrigin) (obj)), cookiestore);
            if (httpcontext.getVersion() > 0)
            {
                processCookies(httpresponse.headerIterator("Set-Cookie2"), httpcontext, ((CookieOrigin) (obj)), cookiestore);
                return;
            }
        }
    }
}
