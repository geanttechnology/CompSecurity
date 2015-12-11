// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            dp, dz, ej, cb, 
//            et, ea, dw, bz, 
//            v, du, er, ds, 
//            cu, aj

public final class dr extends dp
{

    private static final Object a = new Object();
    private static dr b;
    private final Context c;
    private final aj d;

    private dr(Context context, aj aj)
    {
        c = context;
        d = aj;
    }

    public static cb a(Context context, String s, String s1)
    {
        HttpURLConnection httpurlconnection;
        dz dz1;
        Map map;
        int i;
        int j;
        try
        {
            dz1 = new dz();
            s1 = new URL(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            et.d((new StringBuilder("Error while connecting to ad server: ")).append(context.getMessage()).toString());
            return new cb(2);
        }
        i = 0;
_L1:
        httpurlconnection = (HttpURLConnection)s1.openConnection();
        ej.a(context, s, false, httpurlconnection);
        j = httpurlconnection.getResponseCode();
        map = httpurlconnection.getHeaderFields();
        if (j < 200 || j >= 300)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        context = s1.toString();
        s = ej.a(new InputStreamReader(httpurlconnection.getInputStream()));
        a(((String) (context)), map, s, j);
        dz1.b = context;
        dz1.c = s;
        dz1.a(map);
        context = new cb(dz1.b, dz1.c, dz1.d, dz1.e, dz1.f, dz1.g, dz1.h, dz1.i, dz1.j, dz1.a);
        httpurlconnection.disconnect();
        return context;
        a(s1.toString(), map, null, j);
        if (j < 300 || j >= 400)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        s1 = httpurlconnection.getHeaderField("Location");
        if (!TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_270;
        }
        et.d("No location header to follow redirect.");
        context = new cb(0);
        httpurlconnection.disconnect();
        return context;
        s1 = new URL(s1);
        i++;
        if (i <= 5)
        {
            break MISSING_BLOCK_LABEL_346;
        }
        et.d("Too many redirects.");
        context = new cb(0);
        httpurlconnection.disconnect();
        return context;
        et.d((new StringBuilder("Received error HTTP response code: ")).append(j).toString());
        context = new cb(0);
        httpurlconnection.disconnect();
        return context;
        dz1.a(map);
        httpurlconnection.disconnect();
          goto _L1
        context;
        httpurlconnection.disconnect();
        throw context;
    }

    public static dr a(Context context, aj aj)
    {
        synchronized (a)
        {
            if (b == null)
            {
                b = new dr(context.getApplicationContext(), aj);
            }
            context = b;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static void a(String s, Map map, String s1, int i)
    {
        if (et.a(2))
        {
            et.c((new StringBuilder("Http Response: {\n  URL:\n    ")).append(s).append("\n  Headers:").toString());
            if (map != null)
            {
                for (s = map.keySet().iterator(); s.hasNext();)
                {
                    Object obj = (String)s.next();
                    et.c((new StringBuilder("    ")).append(((String) (obj))).append(":").toString());
                    obj = ((List)map.get(obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s2 = (String)((Iterator) (obj)).next();
                        et.c((new StringBuilder("      ")).append(s2).toString());
                    }
                }

            }
            et.c("  Body:");
            if (s1 != null)
            {
                for (int j = 0; j < Math.min(s1.length(), 0x186a0); j += 1000)
                {
                    et.c(s1.substring(j, Math.min(s1.length(), j + 1000)));
                }

            } else
            {
                et.c("    null");
            }
            et.c((new StringBuilder("  Response Code:\n    ")).append(i).append("\n}").toString());
        }
    }

    public final cb a(bz bz1)
    {
        Context context = c;
        et.a("Starting ad request from service.");
        Object obj = new ea(context);
        if (((ea) (obj)).l == -1)
        {
            et.a("Device is offline.");
            return new cb(2);
        }
        dw dw1 = new dw(bz1.f.packageName);
        if (bz1.c.c != null)
        {
            String s = bz1.c.c.getString("_ad");
            if (s != null)
            {
                return du.a(context, bz1, s);
            }
        }
        obj = du.a(bz1, ((ea) (obj)));
        if (obj == null)
        {
            return new cb(0);
        }
        er.a.post(new ds(context, bz1, dw1, ((String) (obj))));
        obj = dw1.b();
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return new cb(dw1.a());
        } else
        {
            return a(context, bz1.k.b, ((String) (obj)));
        }
    }

}
