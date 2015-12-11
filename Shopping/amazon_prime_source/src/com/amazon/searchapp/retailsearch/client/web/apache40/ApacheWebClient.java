// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.RequestContent;
import com.amazon.searchapp.retailsearch.client.web.WebClient;
import com.amazon.searchapp.retailsearch.client.web.WebConnection;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web.apache40:
//            ConnectionManager, CustomHttpMethod, StreamableEntity, ApacheWebConnection

public class ApacheWebClient
    implements WebClient
{

    private static ConnectionManager defaultConnectionManager;
    private final HttpClient client;

    public ApacheWebClient()
    {
        this(getDefaultConnectionManager().createHttpClient());
    }

    public ApacheWebClient(HttpClient httpclient)
    {
        client = httpclient;
    }

    public static ConnectionManager getDefaultConnectionManager()
    {
        com/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;
        JVM INSTR monitorenter ;
        ConnectionManager connectionmanager;
        if (defaultConnectionManager == null)
        {
            defaultConnectionManager = new ConnectionManager(10);
        }
        connectionmanager = defaultConnectionManager;
        com/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;
        JVM INSTR monitorexit ;
        return connectionmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public WebConnection createConnection(String s, String s1, CollectionMap collectionmap, RequestContent requestcontent)
        throws IOException
    {
        if (HttpMethod.DELETE.getName().equals(s))
        {
            s = new HttpDelete(s1);
        } else
        if (HttpMethod.GET.getName().equals(s))
        {
            s = new HttpGet(s1);
        } else
        if (HttpMethod.HEAD.getName().equals(s))
        {
            s = new HttpHead(s1);
        } else
        if (HttpMethod.OPTIONS.getName().equals(s))
        {
            s = new HttpOptions(s1);
        } else
        if (HttpMethod.POST.getName().equals(s))
        {
            s = new HttpPost(s1);
        } else
        if (HttpMethod.PUT.getName().equals(s))
        {
            s = new HttpPut(s1);
        } else
        if (HttpMethod.TRACE.getName().equals(s))
        {
            s = new HttpTrace(s1);
        } else
        {
            s = new CustomHttpMethod(s, s1);
        }
        for (s1 = collectionmap.entrySet().iterator(); s1.hasNext();)
        {
            collectionmap = (java.util.Map.Entry)s1.next();
            s.removeHeaders((String)collectionmap.getKey());
            Iterator iterator = ((List)collectionmap.getValue()).iterator();
            while (iterator.hasNext()) 
            {
                String s2 = (String)iterator.next();
                s.setHeader((String)collectionmap.getKey(), s2);
            }
        }

        if (requestcontent != null)
        {
            if (!(s instanceof HttpEntityEnclosingRequest))
            {
                throw new IOException("Content not supported by request method");
            }
            s1 = new StreamableEntity(requestcontent);
            ((HttpEntityEnclosingRequest)s).setEntity(s1);
        }
        return new ApacheWebConnection(client, s);
    }
}
