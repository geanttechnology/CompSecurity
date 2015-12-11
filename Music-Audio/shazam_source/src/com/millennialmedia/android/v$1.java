// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.millennialmedia.android:
//            v, an, al, w

final class a
    implements Runnable
{

    final boolean a;
    final v b;

    public final void run()
    {
        Context context;
        context = (Context)v.a(b).get();
        if (context == null)
        {
            context = (Context)v.b(b).get();
        }
        if (context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        StringBuilder stringbuilder;
        boolean flag;
        stringbuilder = new StringBuilder();
        obj = new TreeMap();
        ((Map) (obj)).put("ua", (new StringBuilder("Android:")).append(Build.MODEL).toString());
        flag = v.d(context);
        boolean flag1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        flag1 = flag;
        ((Map) (obj)).put("firstlaunch", "1");
        flag1 = flag;
        if (!a)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        flag1 = flag;
        ((Map) (obj)).put("init", "1");
        flag1 = flag;
        an.a(context, ((Map) (obj)));
        flag1 = flag;
        obj = ((Map) (obj)).entrySet().iterator();
_L4:
        flag1 = flag;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        Object obj1 = (java.util.Entry)((Iterator) (obj)).next();
        flag1 = flag;
        stringbuilder.append(String.format("&%s=%s", new Object[] {
            ((java.util.Entry) (obj1)).getKey(), URLEncoder.encode((String)((java.util.Entry) (obj1)).getValue(), "UTF-8")
        }));
        if (true) goto _L4; else goto _L3
        obj;
_L17:
        flag1 = flag;
        al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj)));
        return;
        obj;
_L15:
        if (flag1)
        {
            v.e(context);
        }
        throw obj;
_L3:
        flag1 = flag;
        obj1 = (new StringBuilder()).append(v.b()).append(v.a).append(stringbuilder.toString()).toString();
        flag1 = flag;
        String.format("Performing handshake: %s", new Object[] {
            obj1
        });
        flag1 = flag;
        al.a();
        obj = null;
        flag1 = flag;
        obj1 = (new w((byte)0)).a(((String) (obj1)));
        obj = obj1;
_L11:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_371;
        }
        flag1 = flag;
        int i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        obj1 = obj;
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_465;
        }
        flag1 = flag;
        v.e(v.b().replaceFirst("https://", "http://"));
        flag1 = flag;
        obj1 = (new StringBuilder()).append(v.b()).append(v.a).append(stringbuilder.toString()).toString();
        flag1 = flag;
        String.format("Performing handshake (HTTP Fallback): %s", new Object[] {
            obj1
        });
        flag1 = flag;
        al.a();
        flag1 = flag;
        obj1 = (new w()).a(((String) (obj1)));
_L12:
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        flag1 = flag;
        i = ((HttpResponse) (obj1)).getStatusLine().getStatusCode();
        if (i == 200) goto _L7; else goto _L6
_L6:
        flag1 = flag;
        obj = (new StringBuilder("http://ads.mp.mydas.mobi/appConfigServlet?apid=")).append(v.a).append(stringbuilder.toString()).toString();
        flag1 = flag;
        al.a();
        flag1 = flag;
        obj = (new w()).a(((String) (obj)));
_L13:
        if (obj == null) goto _L9; else goto _L8
_L8:
        flag1 = flag;
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() != 200) goto _L9; else goto _L10
_L10:
        flag1 = flag;
        v.a(b, v.f(w.a(((HttpResponse) (obj)).getEntity().getContent())));
        flag1 = flag;
        v.a(b, context);
        flag1 = flag;
        v.e(b).postDelayed(v.c(b), v.d(b));
        flag1 = flag;
        al.a();
_L14:
        if (flag)
        {
            v.e(context);
            return;
        }
          goto _L1
        obj1;
        flag1 = flag;
        al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj1)));
          goto _L11
        obj;
_L16:
        flag1 = flag;
        al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj)));
        return;
        obj1;
        flag1 = flag;
        al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj1)));
        obj1 = obj;
          goto _L12
        obj;
        flag1 = flag;
        al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj)));
_L7:
        obj = obj1;
          goto _L13
_L9:
        flag = false;
          goto _L14
        obj;
        flag1 = false;
          goto _L15
        obj;
        flag = false;
          goto _L16
        obj;
        flag = false;
          goto _L17
    }

    (v v1, boolean flag)
    {
        b = v1;
        a = flag;
        super();
    }
}
