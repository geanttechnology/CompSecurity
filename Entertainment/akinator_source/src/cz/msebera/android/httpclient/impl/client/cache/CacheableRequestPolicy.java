// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

class CacheableRequestPolicy
{

    public HttpClientAndroidLog log;

    CacheableRequestPolicy()
    {
        log = new HttpClientAndroidLog(getClass());
    }

    public boolean isServableFromCache(HttpRequest httprequest)
    {
        String s = httprequest.getRequestLine().getMethod();
        cz.msebera.android.httpclient.ProtocolVersion protocolversion = httprequest.getRequestLine().getProtocolVersion();
        if (HttpVersion.HTTP_1_1.compareToVersion(protocolversion) != 0)
        {
            log.trace("non-HTTP/1.1 request was not serveable from cache");
            return false;
        }
        if (!s.equals("GET"))
        {
            log.trace("non-GET request was not serveable from cache");
            return false;
        }
        if (httprequest.getHeaders("Pragma").length > 0)
        {
            log.trace("request with Pragma header was not serveable from cache");
            return false;
        }
        httprequest = httprequest.getHeaders("Cache-Control");
        int k = httprequest.length;
        for (int i = 0; i < k; i++)
        {
            HeaderElement aheaderelement[] = httprequest[i].getElements();
            int l = aheaderelement.length;
            for (int j = 0; j < l; j++)
            {
                HeaderElement headerelement = aheaderelement[j];
                if ("no-store".equalsIgnoreCase(headerelement.getName()))
                {
                    log.trace("Request with no-store was not serveable from cache");
                    return false;
                }
                if ("no-cache".equalsIgnoreCase(headerelement.getName()))
                {
                    log.trace("Request with no-cache was not serveable from cache");
                    return false;
                }
            }

        }

        log.trace("Request was serveable from cache");
        return true;
    }
}
