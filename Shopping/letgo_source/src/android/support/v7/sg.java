// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
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

// Referenced classes of package android.support.v7:
//            pm, ng, nn, nt, 
//            nj, sf, pn, sm, 
//            sl, si, sh, ra, 
//            ni, td, sn, tp, 
//            sk, ta, sj, vn, 
//            tg, ns, mt, un, 
//            ul, um, ow, mq

public final class sg extends com.google.android.gms.ads.internal.request.zzj.zza
{

    private static final Object a = new Object();
    private static sg b;
    private final Context c;
    private final sf d;
    private final ng e;
    private final pm f;

    sg(Context context, ng ng1, sf sf1)
    {
        c = context;
        d = sf1;
        e = ng1;
        if (context.getApplicationContext() != null)
        {
            context = context.getApplicationContext();
        }
        f = new pm(context, new VersionInfoParcel(0x7877d8, 0x7877d8, true), ng1.a(), new pm.b() {

            final sg a;

            public void a(mq mq1)
            {
                mq1.a("/log", ow.h);
            }

            public void zzc(Object obj)
            {
                a((mq)obj);
            }

            
            {
                a = sg.this;
                super();
            }
        }, new pm.c());
    }

    public static sg a(Context context, ng ng1, sf sf1)
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
        b = new sg(context1, ng1, sf1);
        context = b;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static um.a a(String s, nt nt1, ns ns)
    {
        return b(s, nt1, ns);
    }

    private static AdResponseParcel a(Context context, pm pm1, ng ng1, sf sf1, AdRequestInfoParcel adrequestinfoparcel)
    {
        zzb.zzaC("Starting ad request from service.");
        nn.a(context);
        nt nt1 = new nt(((Boolean)nn.G.c()).booleanValue(), "load_ad", adrequestinfoparcel.zzqf.zzsG);
        if (adrequestinfoparcel.versionCode > 10 && adrequestinfoparcel.zzDT != -1L)
        {
            nt1.a(nt1.a(adrequestinfoparcel.zzDT), new String[] {
                "cts"
            });
        }
        ns ns = nt1.a();
        sf1.c.a();
        Object obj = zzp.zzbD().a(context);
        if (((sl) (obj)).m == -1)
        {
            zzb.zzaC("Device is offline.");
            return new AdResponseParcel(2);
        }
        String s;
        si si1;
        if (adrequestinfoparcel.versionCode >= 7)
        {
            s = adrequestinfoparcel.zzDQ;
        } else
        {
            s = UUID.randomUUID().toString();
        }
        si1 = new si(s, adrequestinfoparcel.applicationInfo.packageName);
        if (adrequestinfoparcel.zzDy.extras != null)
        {
            String s1 = adrequestinfoparcel.zzDy.extras.getString("_ad");
            if (s1 != null)
            {
                return sh.a(context, adrequestinfoparcel, s1);
            }
        }
        android.location.Location location = sf1.c.a(250L);
        String s2 = sf1.d.a(context, adrequestinfoparcel.zzDz.packageName);
        List list = sf1.b.a(adrequestinfoparcel);
        String s3 = sf1.e.a(adrequestinfoparcel.zzDA);
        obj = sh.a(context, adrequestinfoparcel, ((sl) (obj)), sf1.f.a(context), location, ng1, s2, s3, list);
        if (adrequestinfoparcel.versionCode < 7)
        {
            try
            {
                ((JSONObject) (obj)).put("request_id", s);
            }
            catch (JSONException jsonexception) { }
        }
        if (obj == null)
        {
            return new AdResponseParcel(0);
        }
        s = ((JSONObject) (obj)).toString();
        nt1.a(ns, new String[] {
            "arc"
        });
        obj = nt1.a();
        if (((Boolean)nn.c.c()).booleanValue())
        {
            tp.a.post(new Runnable(pm1, si1, nt1, ((ns) (obj)), s) {

                final pm a;
                final si b;
                final nt c;
                final ns d;
                final String e;

                public void run()
                {
                    pm.d d1 = a.b();
                    b.a(d1);
                    c.a(d, new String[] {
                        "rwc"
                    });
                    d1.a(new uf.c(this, c.a()) {

                        final ns a;
                        final _cls1 b;

                        public void a(mt mt1)
                        {
                            b.c.a(a, new String[] {
                                "jsf"
                            });
                            b.c.b();
                            mt1.a("/invalidRequest", b.b.c);
                            mt1.a("/loadAdURL", b.b.d);
                            try
                            {
                                mt1.a("AFMA_buildAdURL", b.e);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (mt mt1)
                            {
                                zzb.zzb("Error requesting an ad url", mt1);
                            }
                        }

                        public void zzc(Object obj)
                        {
                            a((mt)obj);
                        }

            
            {
                b = _pcls1;
                a = ns;
                super();
            }
                    }, new uf.a(this) {

                        final _cls1 a;

                        public void run()
                        {
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

            
            {
                a = pm1;
                b = si1;
                c = nt1;
                d = ns;
                e = s;
                super();
            }
            });
        } else
        {
            tp.a.post(new Runnable(context, adrequestinfoparcel, si1, nt1, ((ns) (obj)), s, ng1) {

                final Context a;
                final AdRequestInfoParcel b;
                final si c;
                final nt d;
                final ns e;
                final String f;
                final ng g;

                public void run()
                {
                    ul ul1 = zzp.zzby().a(a, new AdSizeParcel(), false, false, null, b.zzqb);
                    if (zzp.zzbA().k())
                    {
                        ul1.getWebView().clearCache(true);
                    }
                    ul1.setWillNotDraw(true);
                    c.a(ul1);
                    d.a(e, new String[] {
                        "rwc"
                    });
                    Object obj1 = d.a();
                    obj1 = sg.a(f, d, ((ns) (obj1)));
                    um um1 = ul1.i();
                    um1.a("/invalidRequest", c.c);
                    um1.a("/loadAdURL", c.d);
                    um1.a("/log", ow.h);
                    um1.a(((um.a) (obj1)));
                    zzb.zzaC("Loading the JS library.");
                    ul1.loadUrl(g.a());
                }

            
            {
                a = context;
                b = adrequestinfoparcel;
                c = si1;
                d = nt1;
                e = ns;
                f = s;
                g = ng1;
                super();
            }
            });
        }
        ng1 = (sk)si1.b().get(10L, TimeUnit.SECONDS);
        if (ng1 != null)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        context = new AdResponseParcel(0);
        tp.a.post(new Runnable(si1) {

            final si a;

            public void run()
            {
                a.c();
                if (a.a() != null)
                {
                    a.a().a();
                }
            }

            
            {
                a = si1;
                super();
            }
        });
        return context;
        context;
        context = new AdResponseParcel(0);
        tp.a.post(new _cls3(si1));
        return context;
        if (ng1.a() == -2)
        {
            break MISSING_BLOCK_LABEL_566;
        }
        context = new AdResponseParcel(ng1.a());
        tp.a.post(new _cls3(si1));
        return context;
        if (nt1.e() != null)
        {
            nt1.a(nt1.e(), new String[] {
                "rur"
            });
        }
        pm1 = null;
        if (ng1.f())
        {
            pm1 = sf1.a.a(adrequestinfoparcel.zzDz.packageName);
        }
        pm1 = a(adrequestinfoparcel, context, adrequestinfoparcel.zzqb.zzIz, ng1.d(), ((String) (pm1)), s2, ((sk) (ng1)), nt1);
        if (((AdResponseParcel) (pm1)).zzEj == 1)
        {
            sf1.d.b(context, adrequestinfoparcel.zzDz.packageName);
        }
        nt1.a(ns, new String[] {
            "tts"
        });
        pm1.zzEl = nt1.c();
        tp.a.post(new _cls3(si1));
        return pm1;
        context;
        tp.a.post(new _cls3(si1));
        throw context;
    }

    public static AdResponseParcel a(AdRequestInfoParcel adrequestinfoparcel, Context context, String s, String s1, String s2, String s3, sk sk1, nt nt1)
    {
        ns ns;
        sj sj1;
        byte abyte0[];
        Map map;
        BufferedOutputStream bufferedoutputstream;
        int i;
        int j;
        long l;
        if (nt1 != null)
        {
            ns = nt1.a();
        } else
        {
            ns = null;
        }
        try
        {
            sj1 = new sj(adrequestinfoparcel);
            zzb.zzaC((new StringBuilder()).append("AdRequestServiceImpl: Sending request: ").append(s1).toString());
            adrequestinfoparcel = new URL(s1);
            l = zzp.zzbB().b();
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            zzb.zzaE((new StringBuilder()).append("Error while connecting to ad server: ").append(adrequestinfoparcel.getMessage()).toString());
            return new AdResponseParcel(2);
        }
        i = 0;
        s1 = (HttpURLConnection)adrequestinfoparcel.openConnection();
        zzp.zzbx().a(context, s, false, s1);
        if (!TextUtils.isEmpty(s2))
        {
            s1.addRequestProperty("x-afma-drt-cookie", s2);
        }
        if (!TextUtils.isEmpty(s3))
        {
            s1.addRequestProperty("Authorization", (new StringBuilder()).append("Bearer ").append(s3).toString());
        }
        if (sk1 == null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        if (!TextUtils.isEmpty(sk1.c()))
        {
            s1.setDoOutput(true);
            abyte0 = sk1.c().getBytes();
            s1.setFixedLengthStreamingMode(abyte0.length);
            bufferedoutputstream = new BufferedOutputStream(s1.getOutputStream());
            bufferedoutputstream.write(abyte0);
            bufferedoutputstream.close();
        }
        j = s1.getResponseCode();
        map = s1.getHeaderFields();
        if (j < 200 || j >= 300)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        adrequestinfoparcel = adrequestinfoparcel.toString();
        context = zzp.zzbx().a(new InputStreamReader(s1.getInputStream()));
        a(((String) (adrequestinfoparcel)), map, ((String) (context)), j);
        sj1.a(adrequestinfoparcel, map, context);
        if (nt1 == null)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        nt1.a(ns, new String[] {
            "ufe"
        });
        adrequestinfoparcel = sj1.a(l);
        s1.disconnect();
        return adrequestinfoparcel;
        a(adrequestinfoparcel.toString(), map, null, j);
        if (j < 300 || j >= 400)
        {
            break MISSING_BLOCK_LABEL_419;
        }
        adrequestinfoparcel = s1.getHeaderField("Location");
        if (!TextUtils.isEmpty(adrequestinfoparcel))
        {
            break MISSING_BLOCK_LABEL_377;
        }
        zzb.zzaE("No location header to follow redirect.");
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        adrequestinfoparcel = new URL(adrequestinfoparcel);
        i++;
        if (i <= 5)
        {
            break MISSING_BLOCK_LABEL_458;
        }
        zzb.zzaE("Too many redirects.");
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        zzb.zzaE((new StringBuilder()).append("Received error HTTP response code: ").append(j).toString());
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        sj1.a(map);
        s1.disconnect();
        break MISSING_BLOCK_LABEL_67;
        adrequestinfoparcel;
        s1.disconnect();
        throw adrequestinfoparcel;
    }

    private static void a(String s, Map map, String s1, int i)
    {
        if (zzb.zzM(2))
        {
            zzb.v((new StringBuilder()).append("Http Response: {\n  URL:\n    ").append(s).append("\n  Headers:").toString());
            if (map != null)
            {
                for (s = map.keySet().iterator(); s.hasNext();)
                {
                    Object obj = (String)s.next();
                    zzb.v((new StringBuilder()).append("    ").append(((String) (obj))).append(":").toString());
                    obj = ((List)map.get(obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s2 = (String)((Iterator) (obj)).next();
                        zzb.v((new StringBuilder()).append("      ").append(s2).toString());
                    }
                }

            }
            zzb.v("  Body:");
            if (s1 != null)
            {
                for (int j = 0; j < Math.min(s1.length(), 0x186a0); j += 1000)
                {
                    zzb.v(s1.substring(j, Math.min(s1.length(), j + 1000)));
                }

            } else
            {
                zzb.v("    null");
            }
            zzb.v((new StringBuilder()).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    private static um.a b(String s, nt nt1, ns ns)
    {
        return new um.a(nt1, ns, s) {

            final nt a;
            final ns b;
            final String c;

            public void zza(ul ul1, boolean flag)
            {
                a.a(b, new String[] {
                    "jsf"
                });
                a.b();
                ul1.a("AFMA_buildAdURL", c);
            }

            
            {
                a = nt1;
                b = ns;
                c = s;
                super();
            }
        };
    }

    public void zza(AdRequestInfoParcel adrequestinfoparcel, zzk zzk)
    {
        zzp.zzbA().a(c, adrequestinfoparcel.zzqb);
        tp.b(new Runnable(adrequestinfoparcel, zzk) {

            final AdRequestInfoParcel a;
            final zzk b;
            final sg c;

            public void run()
            {
                AdResponseParcel adresponseparcel;
                AdResponseParcel adresponseparcel1;
                try
                {
                    adresponseparcel = c.zze(a);
                }
                catch (Exception exception)
                {
                    zzp.zzbA().a(exception, true);
                    zzb.zzd("Could not fetch ad response due to an Exception.", exception);
                    exception = null;
                }
                adresponseparcel1 = adresponseparcel;
                if (adresponseparcel == null)
                {
                    adresponseparcel1 = new AdResponseParcel(0);
                }
                try
                {
                    b.zzb(adresponseparcel1);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    zzb.zzd("Fail to forward ad response.", remoteexception);
                }
            }

            
            {
                c = sg.this;
                a = adrequestinfoparcel;
                b = zzk1;
                super();
            }
        });
    }

    public AdResponseParcel zze(AdRequestInfoParcel adrequestinfoparcel)
    {
        return a(c, f, e, d, adrequestinfoparcel);
    }

}
