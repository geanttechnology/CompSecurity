// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.k;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            ct, ar, ay, be, 
//            ax, ft, fs, fp, 
//            fo, fm, at, ga, 
//            gm, fr, fq, ii, 
//            gd, bd, ae, hg, 
//            he, hf, cd, ab

public final class fn extends com.google.android.gms.ads.internal.request.j.a
{

    private static final Object a = new Object();
    private static fn b;
    private final Context c;
    private final fm d;
    private final ar e;
    private final ct f;

    private fn(Context context, ar ar1, fm fm1)
    {
        c = context;
        d = fm1;
        e = ar1;
        if (context.getApplicationContext() != null)
        {
            context = context.getApplicationContext();
        }
        f = new ct(context, new VersionInfoParcel(), ar1.a, new ct.b() {

            final fn a;

            public final void a(Object obj)
            {
                ((ab)obj).a("/log", cd.h);
            }

            
            {
                a = fn.this;
                super();
            }
        }, new ct.c());
    }

    private static AdResponseParcel a(Context context, ct ct1, ar ar1, fm fm1, AdRequestInfoParcel adrequestinfoparcel)
    {
        com.google.android.gms.ads.internal.util.client.b.a(3);
        ay.a(context);
        Object obj = ay.G;
        be be1 = new be(((Boolean)p.n().a(((au) (obj)))).booleanValue(), "load_ad", adrequestinfoparcel.d.b);
        if (adrequestinfoparcel.a > 10 && adrequestinfoparcel.E != -1L)
        {
            be1.a(be1.a(adrequestinfoparcel.E), new String[] {
                "cts"
            });
        }
        bd bd = be1.a();
        Object obj1 = p.k().a(context);
        if (((fs) (obj1)).m == -1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            return new AdResponseParcel(2);
        }
        fp fp1;
        if (adrequestinfoparcel.a >= 7)
        {
            obj = adrequestinfoparcel.z;
        } else
        {
            obj = UUID.randomUUID().toString();
        }
        fp1 = new fp(((String) (obj)), adrequestinfoparcel.f.packageName);
        if (adrequestinfoparcel.c.c != null)
        {
            String s = adrequestinfoparcel.c.c.getString("_ad");
            if (s != null)
            {
                return fo.a(context, adrequestinfoparcel, s);
            }
        }
        Object obj2 = adrequestinfoparcel.g.packageName;
        obj2 = fm1.b.a(adrequestinfoparcel);
        fm1 = fo.a(context, adrequestinfoparcel, ((fs) (obj1)), ar1, fm1.e.a(adrequestinfoparcel.h), ((List) (obj2)));
        if (adrequestinfoparcel.a < 7)
        {
            try
            {
                fm1.put("request_id", obj);
            }
            catch (JSONException jsonexception) { }
        }
        if (fm1 == null)
        {
            return new AdResponseParcel(0);
        }
        fm1 = fm1.toString();
        be1.a(bd, new String[] {
            "arc"
        });
        obj = be1.a();
        obj1 = ay.c;
        if (((Boolean)p.n().a(((au) (obj1)))).booleanValue())
        {
            gm.a.post(new Runnable(ct1, fp1, be1, ((bd) (obj)), fm1) {

                final ct a;
                final fp b;
                final be c;
                final bd d;
                final String e;

                public final void run()
                {
                    ct.d d1 = a.b();
                    b.f = d1;
                    c.a(d, new String[] {
                        "rwc"
                    });
                    d1.a(new hc.c(this, c.a()) {

                        final bd a;
                        final _cls1 b;

                        public final void a(Object obj)
                        {
                            obj = (ae)obj;
                            b.c.a(a, new String[] {
                                "jsf"
                            });
                            b.c.b();
                            ((ae) (obj)).a("/invalidRequest", b.b.g);
                            ((ae) (obj)).a("/loadAdURL", b.b.h);
                            try
                            {
                                ((ae) (obj)).a("AFMA_buildAdURL", b.e);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (Object obj)
                            {
                                com.google.android.gms.ads.internal.util.client.b.a("Error requesting an ad url", ((Throwable) (obj)));
                            }
                        }

            
            {
                b = _pcls1;
                a = bd;
                super();
            }
                    }, new hc.a(this) {

                        final _cls1 a;

                        public final void a()
                        {
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

            
            {
                a = ct1;
                b = fp1;
                c = be1;
                d = bd;
                e = s;
                super();
            }
            });
        } else
        {
            gm.a.post(new Runnable(context, adrequestinfoparcel, fp1, be1, ((bd) (obj)), fm1, ar1) {

                final Context a;
                final AdRequestInfoParcel b;
                final fp c;
                final be d;
                final bd e;
                final String f;
                final ar g;

                public final void run()
                {
                    p.f();
                    he he1 = hg.a(a, new AdSizeParcel(), false, false, null, b.k);
                    if (p.h().h())
                    {
                        he1.getWebView().clearCache(true);
                    }
                    he1.setWillNotDraw(true);
                    c.e = he1;
                    d.a(e, new String[] {
                        "rwc"
                    });
                    Object obj3 = d.a();
                    obj3 = fn.a(f, d, ((bd) (obj3)));
                    hf hf1 = he1.i();
                    hf1.a("/invalidRequest", c.g);
                    hf1.a("/loadAdURL", c.h);
                    hf1.a("/log", cd.h);
                    hf1.d = ((hf.a) (obj3));
                    com.google.android.gms.ads.internal.util.client.b.a(3);
                    he1.loadUrl(g.a);
                }

            
            {
                a = context;
                b = adrequestinfoparcel;
                c = fp1;
                d = be1;
                e = bd;
                f = s;
                g = ar1;
                super();
            }
            });
        }
        ct1 = (fr)fp1.d.get(10L, TimeUnit.SECONDS);
        if (ct1 != null)
        {
            break MISSING_BLOCK_LABEL_482;
        }
        context = new AdResponseParcel(0);
        gm.a.post(new Runnable(fp1) {

            final fp a;

            public final void run()
            {
                fp fp2 = a;
                if (fp2.e != null)
                {
                    fp2.e.destroy();
                    fp2.e = null;
                }
                if (a.f != null)
                {
                    a.f.a();
                }
            }

            
            {
                a = fp1;
                super();
            }
        });
        return context;
        context;
        context = new AdResponseParcel(0);
        gm.a.post(new _cls3(fp1));
        return context;
        if (((fr) (ct1)).g == -2)
        {
            break MISSING_BLOCK_LABEL_521;
        }
        context = new AdResponseParcel(((fr) (ct1)).g);
        gm.a.post(new _cls3(fp1));
        return context;
        if (be1.e() != null)
        {
            be1.a(be1.e(), new String[] {
                "rur"
            });
        }
        if (((fr) (ct1)).d)
        {
            ar1 = adrequestinfoparcel.g.packageName;
        }
        context = a(adrequestinfoparcel, context, adrequestinfoparcel.k.b, ((fr) (ct1)).f, ((fr) (ct1)), be1);
        if (((AdResponseParcel) (context)).x == 1)
        {
            ct1 = adrequestinfoparcel.g.packageName;
        }
        be1.a(bd, new String[] {
            "tts"
        });
        context.z = be1.c();
        gm.a.post(new _cls3(fp1));
        return context;
        context;
        gm.a.post(new _cls3(fp1));
        throw context;
    }

    public static AdResponseParcel a(AdRequestInfoParcel adrequestinfoparcel, Context context, String s, String s1, fr fr1, be be1)
    {
        fq fq1;
        Map map;
        int i;
        bd bd;
        byte abyte0[];
        BufferedOutputStream bufferedoutputstream;
        int j;
        long l;
        if (be1 != null)
        {
            bd = be1.a();
        } else
        {
            bd = null;
        }
        try
        {
            fq1 = new fq(adrequestinfoparcel);
            com.google.android.gms.ads.internal.util.client.b.a(3);
            adrequestinfoparcel = new URL(s1);
            l = p.i().b();
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            (new StringBuilder("Error while connecting to ad server: ")).append(adrequestinfoparcel.getMessage());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return new AdResponseParcel(2);
        }
        i = 0;
_L1:
        s1 = (HttpURLConnection)adrequestinfoparcel.openConnection();
        p.e().a(context, s, false, s1);
        if (!TextUtils.isEmpty(null))
        {
            s1.addRequestProperty("x-afma-drt-cookie", null);
        }
        if (!TextUtils.isEmpty(null))
        {
            s1.addRequestProperty("Authorization", (new StringBuilder("Bearer ")).append(null).toString());
        }
        if (fr1 == null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (!TextUtils.isEmpty(fr1.b))
        {
            s1.setDoOutput(true);
            abyte0 = fr1.b.getBytes();
            s1.setFixedLengthStreamingMode(abyte0.length);
            bufferedoutputstream = new BufferedOutputStream(s1.getOutputStream());
            bufferedoutputstream.write(abyte0);
            bufferedoutputstream.close();
        }
        j = s1.getResponseCode();
        map = s1.getHeaderFields();
        if (j < 200 || j >= 300)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        adrequestinfoparcel = adrequestinfoparcel.toString();
        p.e();
        context = gm.a(new InputStreamReader(s1.getInputStream()));
        a(((String) (adrequestinfoparcel)), map, ((String) (context)), j);
        fq1.b = adrequestinfoparcel;
        fq1.c = context;
        fq1.a(map);
        if (be1 == null)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        be1.a(bd, new String[] {
            "ufe"
        });
        adrequestinfoparcel = new AdResponseParcel(fq1.r, fq1.b, fq1.c, fq1.d, fq1.g, fq1.h, fq1.i, fq1.j, fq1.k, fq1.l, fq1.a, l, fq1.e, fq1.f, fq1.m, fq1.n, fq1.o, fq1.p, fq1.q);
        s1.disconnect();
        return adrequestinfoparcel;
        a(adrequestinfoparcel.toString(), map, null, j);
        if (j < 300 || j >= 400)
        {
            break MISSING_BLOCK_LABEL_528;
        }
        adrequestinfoparcel = s1.getHeaderField("Location");
        if (!TextUtils.isEmpty(adrequestinfoparcel))
        {
            break MISSING_BLOCK_LABEL_487;
        }
        com.google.android.gms.ads.internal.util.client.b.a(5);
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        adrequestinfoparcel = new URL(adrequestinfoparcel);
        i++;
        if (i <= 5)
        {
            break MISSING_BLOCK_LABEL_548;
        }
        com.google.android.gms.ads.internal.util.client.b.a(5);
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        fq1.a(map);
        s1.disconnect();
          goto _L1
        adrequestinfoparcel;
        s1.disconnect();
        throw adrequestinfoparcel;
    }

    public static fn a(Context context, ar ar1, fm fm1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Context context1 = context;
        if (context.getApplicationContext() != null)
        {
            context1 = context.getApplicationContext();
        }
        b = new fn(context1, ar1, fm1);
        context = b;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static hf.a a(String s, be be1, bd bd)
    {
        return new hf.a(be1, bd, s) {

            final be a;
            final bd b;
            final String c;

            public final void a(he he1, boolean flag)
            {
                a.a(b, new String[] {
                    "jsf"
                });
                a.b();
                he1.a("AFMA_buildAdURL", c);
            }

            
            {
                a = be1;
                b = bd;
                c = s;
                super();
            }
        };
    }

    private static void a(String s, Map map, String s1, int i)
    {
        if (com.google.android.gms.ads.internal.util.client.b.a(2))
        {
            (new StringBuilder("Http Response: {\n  URL:\n    ")).append(s).append("\n  Headers:");
            com.google.android.gms.ads.internal.util.client.b.a(2);
            if (map != null)
            {
                for (s = map.keySet().iterator(); s.hasNext();)
                {
                    Object obj = (String)s.next();
                    (new StringBuilder("    ")).append(((String) (obj))).append(":");
                    com.google.android.gms.ads.internal.util.client.b.a(2);
                    obj = ((List)map.get(obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        ((Iterator) (obj)).next();
                        com.google.android.gms.ads.internal.util.client.b.a(2);
                    }
                }

            }
            com.google.android.gms.ads.internal.util.client.b.a(2);
            if (s1 != null)
            {
                for (int j = 0; j < Math.min(s1.length(), 0x186a0); j += 1000)
                {
                    s1.substring(j, Math.min(s1.length(), j + 1000));
                    com.google.android.gms.ads.internal.util.client.b.a(2);
                }

            } else
            {
                com.google.android.gms.ads.internal.util.client.b.a(2);
            }
            (new StringBuilder("  Response Code:\n    ")).append(i).append("\n}");
            com.google.android.gms.ads.internal.util.client.b.a(2);
        }
    }

    public final AdResponseParcel a(AdRequestInfoParcel adrequestinfoparcel)
    {
        return a(c, f, e, d, adrequestinfoparcel);
    }

    public final void a(AdRequestInfoParcel adrequestinfoparcel, k k)
    {
        p.h().a(c, adrequestinfoparcel.k);
        com.google.android.gms.d.gm.b(new Runnable(adrequestinfoparcel, k) {

            final AdRequestInfoParcel a;
            final k b;
            final fn c;

            public final void run()
            {
                AdResponseParcel adresponseparcel;
                AdResponseParcel adresponseparcel1;
                try
                {
                    adresponseparcel = c.a(a);
                }
                catch (Exception exception)
                {
                    p.h().a(exception, true);
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                    exception = null;
                }
                adresponseparcel1 = adresponseparcel;
                if (adresponseparcel == null)
                {
                    adresponseparcel1 = new AdResponseParcel(0);
                }
                try
                {
                    b.a(adresponseparcel1);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                }
            }

            
            {
                c = fn.this;
                a = adrequestinfoparcel;
                b = k1;
                super();
            }
        });
    }

}
