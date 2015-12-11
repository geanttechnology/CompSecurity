// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzh;
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

// Referenced classes of package com.google.android.gms.internal:
//            zzcf, zzal, zzat, zzay, 
//            zzep, zzcg, zzev, zzes, 
//            zzer, zzdm, zzao, zzez, 
//            zzap, zzfl, zzeu, zzew, 
//            zzfg, zzav, zzet, zzfc, 
//            zzax, zzfx, zzy, zzgf, 
//            zzgd, zzge, zzbr, zzfh

public final class zzeq extends com.google.android.gms.ads.internal.request.zzi.zza
{

    private static zzeq zzAe;
    private static final Object zznu = new Object();
    private final Context mContext;
    private final zzep zzAf;
    private final zzal zzAg;
    private final zzcf zzoo;

    zzeq(Context context, zzal zzal1, zzep zzep1)
    {
        mContext = context;
        zzAf = zzep1;
        zzAg = zzal1;
        if (context.getApplicationContext() != null)
        {
            context = context.getApplicationContext();
        }
        zzoo = new zzcf(context, new VersionInfoParcel(0x6fcd18, 0x6fcd18, true), zzal1.zzcb(), new zzfx.zzd() {

            final zzeq zzAr;

            public void zza(Object obj)
            {
                zzc((zzy)obj);
            }

            public void zzc(zzy zzy1)
            {
                zzy1.zza("/log", zzbr.zztp);
            }

            
            {
                zzAr = zzeq.this;
                super();
            }
        }, new zzfx.zzc());
    }

    private static AdResponseParcel zza(Context context, zzcf zzcf1, zzal zzal1, zzep zzep1, AdRequestInfoParcel adrequestinfoparcel)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaj("Starting ad request from service.");
        zzat.zzo(context);
        zzay zzay1 = new zzay("load_ad");
        zzax zzax = zzay1.zzct();
        zzep1.zzAb.init();
        Object obj1 = new zzev(context);
        if (((zzev) (obj1)).zzBj == -1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaj("Device is offline.");
            return new AdResponseParcel(2);
        }
        Object obj;
        zzes zzes1;
        if (adrequestinfoparcel.versionCode >= 7)
        {
            obj = adrequestinfoparcel.zzzo;
        } else
        {
            obj = UUID.randomUUID().toString();
        }
        zzes1 = new zzes(((String) (obj)), adrequestinfoparcel.applicationInfo.packageName);
        if (adrequestinfoparcel.zzyW.extras != null)
        {
            String s = adrequestinfoparcel.zzyW.extras.getString("_ad");
            if (s != null)
            {
                return zzer.zza(context, adrequestinfoparcel, s);
            }
        }
        android.location.Location location = zzep1.zzAb.zzb(250L);
        String s1 = zzep1.zzAc.zzc(context, adrequestinfoparcel.zzyX.packageName);
        List list = zzep1.zzAa.zza(adrequestinfoparcel);
        obj1 = zzer.zza(adrequestinfoparcel, ((zzev) (obj1)), location, zzal1, s1, zzep1.zzAd.zzab(adrequestinfoparcel.zzyY), list);
        if (adrequestinfoparcel.versionCode < 7)
        {
            try
            {
                ((JSONObject) (obj1)).put("request_id", obj);
            }
            catch (JSONException jsonexception) { }
        }
        if (obj1 == null)
        {
            return new AdResponseParcel(0);
        }
        obj = ((JSONObject) (obj1)).toString();
        zzay1.zza(zzax, new String[] {
            "arc"
        });
        obj1 = zzay1.zzct();
        if (((Boolean)zzat.zzri.get()).booleanValue())
        {
            zzfl.zzCr.post(new Runnable(zzcf1, zzes1, zzay1, ((zzax) (obj1)), ((String) (obj))) {

                final zzcf zzAh;
                final zzes zzAi;
                final zzay zzAj;
                final zzax zzAk;
                final String zzAl;

                public void run()
                {
                    zzfx zzfx1 = zzAh.zzda();
                    zzAi.zze(zzfx1);
                    zzAj.zza(zzAk, new String[] {
                        "rwc"
                    });
                    zzfx1.zza(new zzfx.zzd(this, zzAj.zzct()) {

                        final zzax zzAm;
                        final _cls1 zzAn;

                        public void zza(Object obj)
                        {
                            zzc((zzy)obj);
                        }

                        public void zzc(zzy zzy1)
                        {
                            zzAn.zzAj.zza(zzAm, new String[] {
                                "jsf"
                            });
                            zzAn.zzAj.zzcu();
                            zzy1.zza("/invalidRequest", zzAn.zzAi.zzAy);
                            zzy1.zza("/loadAdURL", zzAn.zzAi.zzAz);
                            try
                            {
                                zzy1.zzb("AFMA_buildAdURL", zzAn.zzAl);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (zzy zzy1)
                            {
                                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", zzy1);
                            }
                        }

            
            {
                zzAn = _pcls1;
                zzAm = zzax;
                super();
            }
                    }, new zzfx.zza(this) {

                        final _cls1 zzAn;

                        public void run()
                        {
                        }

            
            {
                zzAn = _pcls1;
                super();
            }
                    });
                }

            
            {
                zzAh = zzcf1;
                zzAi = zzes1;
                zzAj = zzay1;
                zzAk = zzax;
                zzAl = s;
                super();
            }
            });
        } else
        {
            zzfl.zzCr.post(new Runnable(context, adrequestinfoparcel, zzes1, zzay1, ((zzax) (obj1)), ((String) (obj)), zzal1) {

                final zzes zzAi;
                final zzay zzAj;
                final zzax zzAk;
                final String zzAl;
                final AdRequestInfoParcel zzAo;
                final zzal zzAp;
                final Context zzoH;

                public void run()
                {
                    zzgd zzgd1 = zzh.zzaR().zza(zzoH, new AdSizeParcel(), false, false, null, zzAo.zzmJ);
                    if (zzh.zzaT().zzeS())
                    {
                        zzgd1.getWebView().clearCache(true);
                    }
                    zzgd1.setWillNotDraw(true);
                    zzAi.zzd(zzgd1);
                    zzAj.zza(zzAk, new String[] {
                        "rwc"
                    });
                    Object obj2 = zzAj.zzct();
                    obj2 = com.google.android.gms.internal.zzeq.zzb(zzAl, zzAj, ((zzax) (obj2)));
                    zzge zzge1 = zzgd1.zzft();
                    zzge1.zza("/invalidRequest", zzAi.zzAy);
                    zzge1.zza("/loadAdURL", zzAi.zzAz);
                    zzge1.zza("/log", zzbr.zztp);
                    zzge1.zza(((zzge.zza) (obj2)));
                    com.google.android.gms.ads.internal.util.client.zzb.zzaj("Loading the JS library.");
                    zzgd1.loadUrl(zzAp.zzcb());
                }

            
            {
                zzoH = context;
                zzAo = adrequestinfoparcel;
                zzAi = zzes1;
                zzAj = zzay1;
                zzAk = zzax;
                zzAl = s;
                zzAp = zzal1;
                super();
            }
            });
        }
        obj = (zzeu)zzes1.zzey().get(10L, TimeUnit.SECONDS);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        context = new AdResponseParcel(0);
        zzfl.zzCr.post(new Runnable(zzes1, zzcf1) {

            final zzcf zzAh;
            final zzes zzAi;

            public void run()
            {
                zzAi.zzez();
                if (zzAi.zzex() != null)
                {
                    zzAi.zzex().zza(new zzfx.zzd(this) {

                        final _cls3 zzAq;

                        public void zza(Object obj)
                        {
                            zzc((zzy)obj);
                        }

                        public void zzc(zzy zzy1)
                        {
                            zzy1.zzb("/invalidRequest", zzAq.zzAi.zzAy);
                            zzy1.zzb("/loadAdURL", zzAq.zzAi.zzAz);
                        }

            
            {
                zzAq = _pcls3;
                super();
            }
                    }, new zzfx.zzb());
                    zzAh.zzb(zzAi.zzex());
                }
            }

            
            {
                zzAi = zzes1;
                zzAh = zzcf1;
                super();
            }
        });
        return context;
        context;
        context = new AdResponseParcel(0);
        zzfl.zzCr.post(new _cls3(zzes1, zzcf1));
        return context;
        if (((zzeu) (obj)).getErrorCode() == -2)
        {
            break MISSING_BLOCK_LABEL_490;
        }
        context = new AdResponseParcel(((zzeu) (obj)).getErrorCode());
        zzfl.zzCr.post(new _cls3(zzes1, zzcf1));
        return context;
        if (zzay1.zzcx() != null)
        {
            zzay1.zza(zzay1.zzcx(), new String[] {
                "rur"
            });
        }
        zzal1 = null;
        if (((zzeu) (obj)).zzeC())
        {
            zzal1 = zzep1.zzzZ.zzaa(adrequestinfoparcel.zzyX.packageName);
        }
        obj1 = zzay1.zzct();
        zzal1 = zza(adrequestinfoparcel, context, adrequestinfoparcel.zzmJ.zzCI, ((zzeu) (obj)).getUrl(), ((String) (zzal1)), s1, ((zzeu) (obj)));
        if (((AdResponseParcel) (zzal1)).zzzF == 1)
        {
            zzep1.zzAc.clearToken(context, adrequestinfoparcel.zzyX.packageName);
        }
        zzay1.zza(((zzax) (obj1)), new String[] {
            "ufe"
        });
        zzay1.zza(zzax, new String[] {
            "tts"
        });
        if (zzfg.zzeM() != null)
        {
            zzfg.zzeM().zza(zzay1);
        }
        zzfl.zzCr.post(new _cls3(zzes1, zzcf1));
        return zzal1;
        context;
        zzfl.zzCr.post(new _cls3(zzes1, zzcf1));
        throw context;
    }

    public static AdResponseParcel zza(AdRequestInfoParcel adrequestinfoparcel, Context context, String s, String s1, String s2, String s3, zzeu zzeu1)
    {
        zzet zzet1;
        byte abyte0[];
        Map map;
        BufferedOutputStream bufferedoutputstream;
        int i;
        int j;
        long l;
        try
        {
            zzet1 = new zzet(adrequestinfoparcel);
            com.google.android.gms.ads.internal.util.client.zzb.zzaj((new StringBuilder()).append("AdRequestServiceImpl: Sending request: ").append(s1).toString());
            adrequestinfoparcel = new URL(s1);
            l = SystemClock.elapsedRealtime();
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzan((new StringBuilder()).append("Error while connecting to ad server: ").append(adrequestinfoparcel.getMessage()).toString());
            return new AdResponseParcel(2);
        }
        i = 0;
        s1 = (HttpURLConnection)adrequestinfoparcel.openConnection();
        zzh.zzaQ().zza(context, s, false, s1);
        if (!TextUtils.isEmpty(s2))
        {
            s1.addRequestProperty("x-afma-drt-cookie", s2);
        }
        if (!TextUtils.isEmpty(s3))
        {
            s1.addRequestProperty("Authorization", (new StringBuilder()).append("Bearer ").append(s3).toString());
        }
        if (zzeu1 == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (!TextUtils.isEmpty(zzeu1.zzeB()))
        {
            s1.setDoOutput(true);
            abyte0 = zzeu1.zzeB().getBytes();
            s1.setFixedLengthStreamingMode(abyte0.length);
            bufferedoutputstream = new BufferedOutputStream(s1.getOutputStream());
            bufferedoutputstream.write(abyte0);
            bufferedoutputstream.close();
        }
        j = s1.getResponseCode();
        map = s1.getHeaderFields();
        if (j < 200 || j >= 300)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        adrequestinfoparcel = adrequestinfoparcel.toString();
        context = zzh.zzaQ().zza(new InputStreamReader(s1.getInputStream()));
        zza(((String) (adrequestinfoparcel)), map, ((String) (context)), j);
        zzet1.zza(adrequestinfoparcel, map, context);
        adrequestinfoparcel = zzet1.zzi(l);
        s1.disconnect();
        return adrequestinfoparcel;
        zza(adrequestinfoparcel.toString(), map, null, j);
        if (j < 300 || j >= 400)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        adrequestinfoparcel = s1.getHeaderField("Location");
        if (!TextUtils.isEmpty(adrequestinfoparcel))
        {
            break MISSING_BLOCK_LABEL_331;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzan("No location header to follow redirect.");
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        adrequestinfoparcel = new URL(adrequestinfoparcel);
        i++;
        if (i <= 5)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzan("Too many redirects.");
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        com.google.android.gms.ads.internal.util.client.zzb.zzan((new StringBuilder()).append("Received error HTTP response code: ").append(j).toString());
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        zzet1.zzh(map);
        s1.disconnect();
        break MISSING_BLOCK_LABEL_50;
        adrequestinfoparcel;
        s1.disconnect();
        throw adrequestinfoparcel;
    }

    public static zzeq zza(Context context, zzal zzal1, zzep zzep1)
    {
        Object obj = zznu;
        obj;
        JVM INSTR monitorenter ;
        if (zzAe != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Context context1 = context;
        if (context.getApplicationContext() != null)
        {
            context1 = context.getApplicationContext();
        }
        zzAe = new zzeq(context1, zzal1, zzep1);
        context = zzAe;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static zzge.zza zza(String s, zzay zzay1, zzax zzax)
    {
        return new zzge.zza(zzay1, zzax, s) {

            final zzay zzAj;
            final String zzAl;
            final zzax zzAm;

            public void zza(zzgd zzgd1, boolean flag)
            {
                zzAj.zza(zzAm, new String[] {
                    "jsf"
                });
                zzAj.zzcu();
                zzgd1.zzb("AFMA_buildAdURL", zzAl);
            }

            
            {
                zzAj = zzay1;
                zzAm = zzax;
                zzAl = s;
                super();
            }
        };
    }

    private static void zza(String s, Map map, String s1, int i)
    {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzC(2))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzam((new StringBuilder()).append("Http Response: {\n  URL:\n    ").append(s).append("\n  Headers:").toString());
            if (map != null)
            {
                for (s = map.keySet().iterator(); s.hasNext();)
                {
                    Object obj = (String)s.next();
                    com.google.android.gms.ads.internal.util.client.zzb.zzam((new StringBuilder()).append("    ").append(((String) (obj))).append(":").toString());
                    obj = ((List)map.get(obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s2 = (String)((Iterator) (obj)).next();
                        com.google.android.gms.ads.internal.util.client.zzb.zzam((new StringBuilder()).append("      ").append(s2).toString());
                    }
                }

            }
            com.google.android.gms.ads.internal.util.client.zzb.zzam("  Body:");
            if (s1 != null)
            {
                for (int j = 0; j < Math.min(s1.length(), 0x186a0); j += 1000)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzam(s1.substring(j, Math.min(s1.length(), j + 1000)));
                }

            } else
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzam("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzam((new StringBuilder()).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    static zzge.zza zzb(String s, zzay zzay1, zzax zzax)
    {
        return zza(s, zzay1, zzax);
    }

    public void zza(AdRequestInfoParcel adrequestinfoparcel, zzj zzj)
    {
        zzh.zzaT().zzb(mContext, adrequestinfoparcel.zzmJ);
        (new zzfh(adrequestinfoparcel, zzj) {

            final AdRequestInfoParcel zzAo;
            final zzeq zzAr;
            final zzj zzAs;

            public void onStop()
            {
                try
                {
                    zzAs.zzb(new AdResponseParcel(-1));
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", remoteexception);
                }
            }

            public void zzcX()
            {
                AdResponseParcel adresponseparcel;
                AdResponseParcel adresponseparcel1;
                try
                {
                    adresponseparcel = zzAr.zze(zzAo);
                }
                catch (Exception exception)
                {
                    zzh.zzaT().zzc(exception, true);
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response due to an Exception.", exception);
                    exception = null;
                }
                adresponseparcel1 = adresponseparcel;
                if (adresponseparcel == null)
                {
                    adresponseparcel1 = new AdResponseParcel(0);
                }
                try
                {
                    zzAs.zzb(adresponseparcel1);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", remoteexception);
                }
            }

            
            {
                zzAr = zzeq.this;
                zzAo = adrequestinfoparcel;
                zzAs = zzj1;
                super();
            }
        }).zzeW();
    }

    public AdResponseParcel zze(AdRequestInfoParcel adrequestinfoparcel)
    {
        zzfg.zze(mContext, adrequestinfoparcel.zzmJ.zzCI);
        return zza(mContext, zzoo, zzAg, zzAf, adrequestinfoparcel);
    }

}
