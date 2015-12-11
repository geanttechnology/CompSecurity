// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ConditionalRequestBuilder
{

    ConditionalRequestBuilder()
    {
    }

    public HttpRequestWrapper buildConditionalRequest(HttpRequestWrapper httprequestwrapper, HttpCacheEntry httpcacheentry)
        throws ProtocolException
    {
        HttpRequestWrapper httprequestwrapper1 = HttpRequestWrapper.wrap(httprequestwrapper.getOriginal());
        httprequestwrapper1.setHeaders(httprequestwrapper.getAllHeaders());
        httprequestwrapper = httpcacheentry.getFirstHeader("ETag");
        if (httprequestwrapper != null)
        {
            httprequestwrapper1.setHeader("If-None-Match", httprequestwrapper.getValue());
        }
        httprequestwrapper = httpcacheentry.getFirstHeader("Last-Modified");
        if (httprequestwrapper != null)
        {
            httprequestwrapper1.setHeader("If-Modified-Since", httprequestwrapper.getValue());
        }
        boolean flag = false;
        httprequestwrapper = httpcacheentry.getHeaders("Cache-Control");
        int k = httprequestwrapper.length;
        int i = 0;
label0:
        do
        {
            if (i < k)
            {
                httpcacheentry = httprequestwrapper[i].getElements();
                int l = httpcacheentry.length;
                int j = 0;
                do
                {
label1:
                    {
                        boolean flag1 = flag;
                        if (j < l)
                        {
                            HeaderElement headerelement = httpcacheentry[j];
                            if (!"must-revalidate".equalsIgnoreCase(headerelement.getName()) && !"proxy-revalidate".equalsIgnoreCase(headerelement.getName()))
                            {
                                break label1;
                            }
                            flag1 = true;
                        }
                        i++;
                        flag = flag1;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            if (flag)
            {
                httprequestwrapper1.addHeader("Cache-Control", "max-age=0");
            }
            return httprequestwrapper1;
        } while (true);
    }

    public HttpRequestWrapper buildConditionalRequestFromVariants(HttpRequestWrapper httprequestwrapper, Map map)
    {
        HttpRequestWrapper httprequestwrapper1 = HttpRequestWrapper.wrap(httprequestwrapper.getOriginal());
        httprequestwrapper1.setHeaders(httprequestwrapper.getAllHeaders());
        httprequestwrapper = new StringBuilder();
        boolean flag = true;
        String s;
        for (map = map.keySet().iterator(); map.hasNext(); httprequestwrapper.append(s))
        {
            s = (String)map.next();
            if (!flag)
            {
                httprequestwrapper.append(",");
            }
            flag = false;
        }

        httprequestwrapper1.setHeader("If-None-Match", httprequestwrapper.toString());
        return httprequestwrapper1;
    }

    public HttpRequestWrapper buildUnconditionalRequest(HttpRequestWrapper httprequestwrapper, HttpCacheEntry httpcacheentry)
    {
        httpcacheentry = HttpRequestWrapper.wrap(httprequestwrapper.getOriginal());
        httpcacheentry.setHeaders(httprequestwrapper.getAllHeaders());
        httpcacheentry.addHeader("Cache-Control", "no-cache");
        httpcacheentry.addHeader("Pragma", "no-cache");
        httpcacheentry.removeHeaders("If-Range");
        httpcacheentry.removeHeaders("If-Match");
        httpcacheentry.removeHeaders("If-None-Match");
        httpcacheentry.removeHeaders("If-Unmodified-Since");
        httpcacheentry.removeHeaders("If-Modified-Since");
        return httpcacheentry;
    }
}
