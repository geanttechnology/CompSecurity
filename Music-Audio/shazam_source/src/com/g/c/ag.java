// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.g.c:
//            j, ah, r

public final class ag
    implements j
{

    static volatile Object a;
    private static final Object b = new Object();
    private static final ThreadLocal c = new ThreadLocal() {

        protected final Object initialValue()
        {
            return new StringBuilder();
        }

    };
    private final Context d;

    public ag(Context context)
    {
        d = context.getApplicationContext();
    }

    public final j.a a(Uri uri, int i)
    {
        if (android.os.Build.VERSION.SDK_INT < 14) goto _L2; else goto _L1
_L1:
        Object obj = d;
        if (a != null) goto _L2; else goto _L3
_L3:
        Object obj2 = b;
        obj2;
        JVM INSTR monitorenter ;
        HttpResponseCache httpresponsecache;
        java.io.File file;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        file = ah.b(((Context) (obj)));
        httpresponsecache = HttpResponseCache.getInstalled();
        obj = httpresponsecache;
        if (httpresponsecache != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = HttpResponseCache.install(file, ah.a(file));
        a = obj;
        obj2;
        JVM INSTR monitorexit ;
_L2:
        Object obj1 = (HttpURLConnection)(new URL(uri.toString())).openConnection();
        ((HttpURLConnection) (obj1)).setConnectTimeout(15000);
        ((HttpURLConnection) (obj1)).setReadTimeout(20000);
        ((HttpURLConnection) (obj1)).setUseCaches(true);
        if (i != 0)
        {
            int k;
            if (r.c(i))
            {
                uri = "only-if-cached,max-age=2147483647";
            } else
            {
                uri = (StringBuilder)c.get();
                uri.setLength(0);
                if (!r.a(i))
                {
                    uri.append("no-cache");
                }
                if (!r.b(i))
                {
                    if (uri.length() > 0)
                    {
                        uri.append(',');
                    }
                    uri.append("no-store");
                }
                uri = uri.toString();
            }
            ((HttpURLConnection) (obj1)).setRequestProperty("Cache-Control", uri);
        }
        k = ((HttpURLConnection) (obj1)).getResponseCode();
        if (k >= 300)
        {
            ((HttpURLConnection) (obj1)).disconnect();
            throw new j.b((new StringBuilder()).append(k).append(" ").append(((HttpURLConnection) (obj1)).getResponseMessage()).toString(), i, k);
        } else
        {
            long l = ((HttpURLConnection) (obj1)).getHeaderFieldInt("Content-Length", -1);
            boolean flag = ah.a(((HttpURLConnection) (obj1)).getHeaderField("X-Android-Response-Source"));
            return new j.a(((HttpURLConnection) (obj1)).getInputStream(), flag, l);
        }
        obj1;
        obj2;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
          goto _L2
    }

}
