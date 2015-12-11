// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.a.b:
//            s, ba, u, t

public final class az
    implements s
{

    static volatile Object a;
    private static final Object b = new Object();
    private final Context c;

    public az(Context context)
    {
        c = context.getApplicationContext();
    }

    public final t a(Uri uri, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 14) goto _L2; else goto _L1
_L1:
        Object obj = c;
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
        file = ba.b(((Context) (obj)));
        httpresponsecache = HttpResponseCache.getInstalled();
        obj = httpresponsecache;
        if (httpresponsecache != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = HttpResponseCache.install(file, ba.a(file));
        a = obj;
        obj2;
        JVM INSTR monitorexit ;
_L2:
        uri = (HttpURLConnection)(new URL(uri.toString())).openConnection();
        uri.setConnectTimeout(15000);
        uri.setReadTimeout(20000);
        uri.setUseCaches(true);
        if (flag)
        {
            uri.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int i = uri.getResponseCode();
        Object obj1;
        if (i >= 300)
        {
            uri.disconnect();
            throw new u((new StringBuilder()).append(i).append(" ").append(uri.getResponseMessage()).toString());
        } else
        {
            flag = ba.a(uri.getHeaderField("X-Android-Response-Source"));
            return new t(uri.getInputStream(), flag);
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
