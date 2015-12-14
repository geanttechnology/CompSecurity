// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.millennialmedia.android:
//            MMConversionTracker, HttpGetRequest, MMLog

final class d
    implements Runnable
{

    private String a;
    private boolean b;
    private long c;
    private TreeMap d;

    public final void run()
    {
        Object obj;
        int i;
        i = 1;
        obj = new HttpGetRequest();
        String s;
        Object obj2;
        long l;
        boolean flag;
        s = a;
        flag = b;
        l = c;
        obj2 = d;
        Object obj1;
        if (!flag)
        {
            i = 0;
        }
        obj1 = new StringBuilder((new StringBuilder("http://cvt.mydas.mobi/handleConversion?firstlaunch=")).append(i).toString());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        ((StringBuilder) (obj1)).append((new StringBuilder("&goalId=")).append(s).toString());
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        ((StringBuilder) (obj1)).append((new StringBuilder("&installtime=")).append(l / 1000L).toString());
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        for (Iterator iterator = ((TreeMap) (obj2)).entrySet().iterator(); iterator.hasNext(); ((StringBuilder) (obj1)).append(String.format("&%s=%s", new Object[] {
    ((java.util.) (obj2)).(), URLEncoder.encode((String)((java.util.) (obj2)).(), "UTF-8")
})))
        {
            obj2 = (java.util.)iterator.next();
        }

        break MISSING_BLOCK_LABEL_219;
        obj;
        try
        {
            MMLog.a("HttpGetRequest", "Conversion tracking error: ", ((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.a("MMConversionTracker", "Problem doing conversion tracking.", ((Throwable) (obj)));
        }
        break MISSING_BLOCK_LABEL_329;
        obj1 = ((StringBuilder) (obj1)).toString();
        MMLog.b("HttpGetRequest", String.format("Sending conversion tracker report: %s", new Object[] {
            obj1
        }));
        ((HttpGetRequest) (obj)).b.setURI(new URI(((String) (obj1))));
        obj = ((HttpGetRequest) (obj)).a.execute(((HttpGetRequest) (obj)).b);
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() == 200)
        {
            MMLog.a("HttpGetRequest", String.format("Successful conversion tracking event: %d", new Object[] {
                Integer.valueOf(((HttpResponse) (obj)).getStatusLine().getStatusCode())
            }));
            return;
        }
        break MISSING_BLOCK_LABEL_330;
        return;
        MMLog.e("HttpGetRequest", String.format("Conversion tracking error: %d", new Object[] {
            Integer.valueOf(((HttpResponse) (obj)).getStatusLine().getStatusCode())
        }));
        return;
    }

    (String s, boolean flag, long l, TreeMap treemap)
    {
        a = s;
        b = flag;
        c = l;
        d = treemap;
        super();
    }
}
