// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

abstract class ay
{

    protected final HttpClient a;
    protected HttpResponse b;
    private IOException c;
    private URL d;
    private long e;
    private ax f;

    ay(ax ax1, HttpClient httpclient, HttpUriRequest httpurirequest)
    {
        f = ax1;
        super();
        a = httpclient;
        ax1 = null;
        httpclient = httpurirequest.getURI().toURL();
        ax1 = httpclient;
_L2:
        d = ax1;
        a(httpurirequest);
        return;
        httpclient;
        p.a((new StringBuilder("Error constructing URL from URI (")).append(httpurirequest.getURI().toString()).append(")").toString(), httpclient);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void a(HttpRequest httprequest)
    {
        for (Iterator iterator = q.a().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Iterator iterator1 = ((List)entry.getValue()).iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                httprequest.addHeader((String)entry.getKey(), s);
            }
        }

        bc.a("Agent added server correlation header to request.");
    }

    protected abstract Object a();

    final Object b()
    {
        e = System.currentTimeMillis();
        ax.a(f).a(ad.a);
        Object obj1;
        Object obj2;
        int j;
        long l;
        obj1 = a();
        l = System.currentTimeMillis();
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        obj2 = b.getStatusLine();
        j = b.getStatusLine().getStatusCode();
        Object obj;
        obj = null;
        if (j < 400)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        obj = ((StatusLine) (obj2)).getReasonPhrase();
        Header aheader[];
        obj2 = new v();
        aheader = b.getAllHeaders();
        if (aheader == null) goto _L2; else goto _L1
_L1:
        Header header;
        int i;
        int k;
        try
        {
            k = aheader.length;
        }
        catch (IOException ioexception)
        {
            c = ioexception;
            if (d != null)
            {
                org.json.JSONObject jsonobject = ax.b(f).a(d, c, e, System.currentTimeMillis());
                if (jsonobject != null)
                {
                    ax.c(f).b(jsonobject);
                }
            }
            ax.a(f).a(ad.c);
            throw ioexception;
        }
        i = 0;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        header = aheader[i];
        ((v) (obj2)).a(header.getName(), Collections.singletonList(header.getValue()));
        i++;
        if (true) goto _L3; else goto _L2
_L3:
        break MISSING_BLOCK_LABEL_112;
_L2:
        obj = ax.b(f).a(d, e, l, j, ((String) (obj)), ((v) (obj2)).a());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        ax.c(f).b(((org.json.JSONObject) (obj)));
        ax.a(f).a(ad.b);
        return obj1;
    }
}
