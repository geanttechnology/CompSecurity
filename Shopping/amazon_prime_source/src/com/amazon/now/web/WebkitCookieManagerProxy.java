// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebkitCookieManagerProxy extends CookieManager
{

    private android.webkit.CookieManager webkitCookieManager;

    public WebkitCookieManagerProxy()
    {
        this(null, null);
    }

    public WebkitCookieManagerProxy(CookieStore cookiestore, CookiePolicy cookiepolicy)
    {
        super(null, cookiepolicy);
        webkitCookieManager = android.webkit.CookieManager.getInstance();
    }

    public Map get(URI uri, Map map)
        throws IOException
    {
        if (uri == null || map == null)
        {
            throw new IllegalArgumentException("Argument is null");
        }
        map = uri.toString();
        uri = new HashMap();
        map = webkitCookieManager.getCookie(map);
        if (map != null)
        {
            uri.put("Cookie", Arrays.asList(new String[] {
                map
            }));
        }
        return uri;
    }

    public CookieStore getCookieStore()
    {
        throw new UnsupportedOperationException();
    }

    public void put(URI uri, Map map)
        throws IOException
    {
        if (uri != null && map != null)
        {
            uri = uri.toString();
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                Object obj = (java.util.Map.Entry)map.next();
                String s = (String)((java.util.Map.Entry) (obj)).getKey();
                if (s != null && (s.equalsIgnoreCase("Set-Cookie2") || s.equalsIgnoreCase("Set-Cookie")))
                {
                    obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s1 = (String)((Iterator) (obj)).next();
                        webkitCookieManager.setCookie(uri, s1);
                    }
                }
            }
        }
    }
}
