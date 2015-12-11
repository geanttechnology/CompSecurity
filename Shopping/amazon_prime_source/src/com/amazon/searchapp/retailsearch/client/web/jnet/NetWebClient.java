// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.jnet;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.RequestContent;
import com.amazon.searchapp.retailsearch.client.web.WebClient;
import com.amazon.searchapp.retailsearch.client.web.WebConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web.jnet:
//            NetWebConnection

public class NetWebClient
    implements WebClient
{

    private final int connectTimeout;
    private final Proxy proxy;
    private final int readTimeout;

    public NetWebClient()
    {
        this(null, 30000, 30000);
    }

    public NetWebClient(Proxy proxy1, int i, int j)
    {
        proxy = proxy1;
        connectTimeout = i;
        readTimeout = j;
    }

    public WebConnection createConnection(String s, String s1, CollectionMap collectionmap, RequestContent requestcontent)
        throws IOException
    {
        if (requestcontent != null && requestcontent.getLength() > 0L && !HttpMethod.POST.getName().equals(s) && !HttpMethod.PUT.getName().equals(s))
        {
            throw new IOException("Content not supported by request method");
        }
        s1 = new URL(s1);
        if (proxy != null)
        {
            s1 = s1.openConnection(proxy);
        } else
        {
            s1 = s1.openConnection();
        }
        s1 = (HttpURLConnection)(HttpURLConnection)s1;
        if (connectTimeout >= 0)
        {
            s1.setConnectTimeout(connectTimeout);
        }
        if (readTimeout >= 0)
        {
            s1.setReadTimeout(readTimeout);
        }
        s1.setRequestMethod(s);
        if (collectionmap != null)
        {
            for (s = collectionmap.entrySet().iterator(); s.hasNext();)
            {
                collectionmap = (java.util.Map.Entry)s.next();
                Iterator iterator = ((List)collectionmap.getValue()).iterator();
                while (iterator.hasNext()) 
                {
                    String s2 = (String)iterator.next();
                    s1.setRequestProperty((String)collectionmap.getKey(), s2);
                }
            }

        }
        if (requestcontent != null)
        {
            s = requestcontent.getType();
            collectionmap = requestcontent.getEncoding();
            long l = requestcontent.getLength();
            if (s != null)
            {
                s1.setRequestProperty("Content-Type", s);
            }
            if (collectionmap != null)
            {
                s1.setRequestProperty("Content-Encoding", collectionmap);
            }
            if (l >= 0L)
            {
                s1.setRequestProperty("Content-Length", Long.toString(l));
            }
            s1.setDoOutput(true);
            if (l >= 0L && l <= 0x7fffffffL)
            {
                s1.setFixedLengthStreamingMode((int)l);
            } else
            {
                s1.setChunkedStreamingMode(0);
            }
        }
        return new NetWebConnection(s1, requestcontent);
    }
}
