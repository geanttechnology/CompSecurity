// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class aav extends aao
{

    private static final Object a = new Object();
    private static aav b;
    private final Context c;
    private final abb d;
    private final vr e;
    private final uf f;

    aav(Context context, uf uf1, vr vr1, abb abb1)
    {
        c = context;
        d = abb1;
        e = vr1;
        f = uf1;
    }

    public static aav a(Context context, uf uf1, vr vr1, abb abb1)
    {
        synchronized (a)
        {
            if (b == null)
            {
                b = new aav(context.getApplicationContext(), uf1, vr1, abb1);
            }
            context = b;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static acf a(String s)
    {
        return new acf(s) {

            final String a;

            public void a(gu gu1)
            {
                String s1 = String.format("javascript:%s(%s);", new Object[] {
                    "AFMA_buildAdURL", a
                });
                acb.d((new StringBuilder()).append("About to execute: ").append(s1).toString());
                gu1.loadUrl(s1);
            }

            
            {
                a = s;
                super();
            }
        };
    }

    public static fj a(Context context, String s, String s1, String s2, aaz aaz1)
    {
        aay aay1;
        long l;
        aay1 = new aay();
        acb.a((new StringBuilder()).append("AdRequestServiceImpl: Sending request: ").append(s1).toString());
        s1 = new URL(s1);
        l = SystemClock.elapsedRealtime();
        int i = 0;
_L1:
        HttpURLConnection httpurlconnection = (HttpURLConnection)s1.openConnection();
        abq.a(context, s, false, httpurlconnection);
        if (!TextUtils.isEmpty(s2))
        {
            httpurlconnection.addRequestProperty("x-afma-drt-cookie", s2);
        }
        if (aaz1 == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        byte abyte0[];
        if (TextUtils.isEmpty(aaz1.c()))
        {
            break MISSING_BLOCK_LABEL_160;
        }
        httpurlconnection.setDoOutput(true);
        abyte0 = aaz1.c().getBytes();
        httpurlconnection.setFixedLengthStreamingMode(abyte0.length);
        p.a(httpurlconnection);
        Object obj;
        obj = httpurlconnection.getOutputStream();
        p.b(httpurlconnection);
        obj = new BufferedOutputStream(((java.io.OutputStream) (obj)));
        ((BufferedOutputStream) (obj)).write(abyte0);
        ((BufferedOutputStream) (obj)).close();
        p.a(httpurlconnection);
        int j;
        j = httpurlconnection.getResponseCode();
        p.b(httpurlconnection);
        Map map;
        p.c(httpurlconnection);
        p.a(httpurlconnection);
        map = httpurlconnection.getHeaderFields();
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        if (j < 200 || j >= 300)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        context = s1.toString();
        s = abq.a(new InputStreamReader(p.d(httpurlconnection)));
        a(((String) (context)), map, s, j);
        aay1.a(context, map, s);
        context = aay1.a(l);
        httpurlconnection.disconnect();
        return context;
        context;
        p.a(httpurlconnection, context);
        throw context;
        context;
        try
        {
            httpurlconnection.disconnect();
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            acb.e((new StringBuilder()).append("Error while connecting to ad server: ").append(context.getMessage()).toString());
        }
        return new fj(2);
        context;
        p.a(httpurlconnection, context);
        throw context;
        a(s1.toString(), map, ((String) (null)), j);
        if (j < 300 || j >= 400)
        {
            break MISSING_BLOCK_LABEL_456;
        }
        p.a(httpurlconnection);
        s1 = httpurlconnection.getHeaderField("Location");
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        if (!TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_414;
        }
        acb.e("No location header to follow redirect.");
        context = new fj(0);
        httpurlconnection.disconnect();
        return context;
        s1 = new URL(s1);
        i++;
        if (i <= 5)
        {
            break MISSING_BLOCK_LABEL_495;
        }
        acb.e("Too many redirects.");
        context = new fj(0);
        httpurlconnection.disconnect();
        return context;
        acb.e((new StringBuilder()).append("Received error HTTP response code: ").append(j).toString());
        context = new fj(0);
        httpurlconnection.disconnect();
        return context;
        aay1.a(map);
        httpurlconnection.disconnect();
          goto _L1
    }

    private static fj a(Context context, uf uf1, vr vr1, abb abb1, fh fh1)
    {
        aax aax1;
        acb.a("Starting ad request from service.");
        vr1.a();
        aba aba1 = new aba(context);
        if (aba1.l == -1)
        {
            acb.a("Device is offline.");
            return new fj(2);
        }
        aax1 = new aax(fh1.f.packageName);
        if (fh1.c.c != null)
        {
            String s = fh1.c.c.getString("_ad");
            if (s != null)
            {
                return aaw.a(context, fh1, s);
            }
        }
        android.location.Location location = vr1.a(250L);
        vr1 = uf1.a();
        uf1 = aaw.a(fh1, aba1, location, uf1.b(), uf1.c(), uf1.d());
        if (uf1 == null)
        {
            return new fj(0);
        }
        uf1 = a(((String) (uf1)));
        aca.a.post(new Runnable(context, fh1, aax1, uf1, vr1) {

            final Context a;
            final fh b;
            final aax c;
            final acf d;
            final String e;

            public void run()
            {
                gu gu1 = gu.a(a, new ay(), false, false, null, b.k);
                gu1.setWillNotDraw(true);
                c.a(gu1);
                ace ace1 = gu1.f();
                ace1.a("/invalidRequest", c.b);
                ace1.a("/loadAdURL", c.c);
                ace1.a("/log", vc.h);
                ace1.a(d);
                acb.a("Loading the JS library.");
                gu1.loadUrl(e);
            }

            
            {
                a = context;
                b = fh1;
                c = aax1;
                d = acf;
                e = s;
                super();
            }
        });
        vr1 = (aaz)aax1.a().get(10L, TimeUnit.SECONDS);
        if (vr1 != null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        context = new fj(0);
        aca.a.post(new Runnable(aax1) {

            final aax a;

            public void run()
            {
                a.b();
            }

            
            {
                a = aax1;
                super();
            }
        });
        return context;
        context;
        context = new fj(0);
        aca.a.post(new _cls2(aax1));
        return context;
        if (vr1.a() == -2)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        context = new fj(vr1.a());
        aca.a.post(new _cls2(aax1));
        return context;
        uf1 = null;
        if (vr1.f())
        {
            uf1 = abb1.a(fh1.g.packageName);
        }
        context = a(context, fh1.k.b, vr1.d(), ((String) (uf1)), ((aaz) (vr1)));
        aca.a.post(new _cls2(aax1));
        return context;
        context;
        aca.a.post(new _cls2(aax1));
        throw context;
    }

    private static void a(String s, Map map, String s1, int i)
    {
        if (acb.a(2))
        {
            acb.d((new StringBuilder()).append("Http Response: {\n  URL:\n    ").append(s).append("\n  Headers:").toString());
            if (map != null)
            {
                for (s = map.keySet().iterator(); s.hasNext();)
                {
                    Object obj = (String)s.next();
                    acb.d((new StringBuilder()).append("    ").append(((String) (obj))).append(":").toString());
                    obj = ((List)map.get(obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s2 = (String)((Iterator) (obj)).next();
                        acb.d((new StringBuilder()).append("      ").append(s2).toString());
                    }
                }

            }
            acb.d("  Body:");
            if (s1 != null)
            {
                for (int j = 0; j < Math.min(s1.length(), 0x186a0); j += 1000)
                {
                    acb.d(s1.substring(j, Math.min(s1.length(), j + 1000)));
                }

            } else
            {
                acb.d("    null");
            }
            acb.d((new StringBuilder()).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    public fj a(fh fh1)
    {
        return a(c, f, e, d, fh1);
    }

}
