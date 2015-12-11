// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.resttemplate;

import java.net.URI;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class CookieEnabledHttpRequestFactory extends HttpComponentsClientHttpRequestFactory
{

    private static CookieStore cookieStore = new BasicCookieStore();
    private static HttpContext httpContext = null;

    public CookieEnabledHttpRequestFactory()
    {
    }

    public static String getSWID()
    {
        for (Iterator iterator = cookieStore.getCookies().iterator(); iterator.hasNext();)
        {
            Cookie cookie = (Cookie)iterator.next();
            if ("SWID".equals(cookie.getName()))
            {
                return cookie.getValue();
            }
        }

        return null;
    }

    protected HttpContext createHttpContext(HttpMethod httpmethod, URI uri)
    {
        if (httpContext == null)
        {
            httpContext = new BasicHttpContext();
            httpContext.setAttribute("http.cookie-store", cookieStore);
        }
        return httpContext;
    }

}
