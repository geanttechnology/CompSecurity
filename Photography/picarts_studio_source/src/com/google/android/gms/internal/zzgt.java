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

// Referenced classes of package com.google.android.gms.internal:
//            zzdz, zzbr, zzby, zzcg, 
//            zzbu, zzgs, zzea, zzgz, 
//            zzgy, zzgv, zzgu, zzfn, 
//            zzbt, zzhr, zzhb, zzid, 
//            zzgx, zzho, zzgw, zzmn, 
//            zzha, zzmt, zzhu, zzce, 
//            zzbe, zzjb, zziz, zzja, 
//            zzdj, zzbb

public final class zzgt extends com.google.android.gms.ads.internal.request.zzj.zza
{

    private static zzgt zzFA;
    private static final Object zzpy = new Object();
    private final Context mContext;
    private final zzgs zzFB;
    private final zzbr zzFC;
    private final zzdz zzrf;

    zzgt(Context context, zzbr zzbr1, zzgs zzgs1)
    {
        mContext = context;
        zzFB = zzgs1;
        zzFC = zzbr1;
        if (context.getApplicationContext() != null)
        {
            context = context.getApplicationContext();
        }
        zzrf = new zzdz(context, new VersionInfoParcel(0x7bd338, 0x7bd338, true), zzbr1.zzdc(), new zzdz.zzb() {

            final zzgt zzFL;

            public void zza(zzbb zzbb1)
            {
                zzbb1.zza("/log", zzdj.zzxv);
            }

            public void zzc(Object obj)
            {
                zza((zzbb)obj);
            }

            
            {
                zzFL = zzgt.this;
                super();
            }
        }, new zzdz.zzc());
    }

    private static AdResponseParcel zza(Context context, zzdz zzdz1, zzbr zzbr1, zzgs zzgs1, AdRequestInfoParcel adrequestinfoparcel)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Starting ad request from service.");
        zzby.initialize(context);
        zzcg zzcg1 = new zzcg(((Boolean)zzby.zzuQ.get()).booleanValue(), "load_ad", adrequestinfoparcel.zzqn.zzte);
        if (adrequestinfoparcel.versionCode > 10 && adrequestinfoparcel.zzEF != -1L)
        {
            zzcg1.zza(zzcg1.zzb(adrequestinfoparcel.zzEF), new String[] {
                "cts"
            });
        }
        zzce zzce = zzcg1.zzdn();
        zzgs1.zzFv.init();
        Object obj = zzp.zzbB().zzC(context);
        if (((zzgy) (obj)).zzGE == -1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Device is offline.");
            return new AdResponseParcel(2);
        }
        String s;
        zzgv zzgv1;
        if (adrequestinfoparcel.versionCode >= 7)
        {
            s = adrequestinfoparcel.zzEC;
        } else
        {
            s = UUID.randomUUID().toString();
        }
        zzgv1 = new zzgv(s, adrequestinfoparcel.applicationInfo.packageName);
        if (adrequestinfoparcel.zzEn.extras != null)
        {
            String s1 = adrequestinfoparcel.zzEn.extras.getString("_ad");
            if (s1 != null)
            {
                return zzgu.zza(context, adrequestinfoparcel, s1);
            }
        }
        android.location.Location location = zzgs1.zzFv.zzd(250L);
        String s2 = zzgs1.zzFw.zzc(context, adrequestinfoparcel.zzEo.packageName);
        List list = zzgs1.zzFu.zza(adrequestinfoparcel);
        String s3 = zzgs1.zzFx.zzax(adrequestinfoparcel.zzEp);
        obj = zzgu.zza(context, adrequestinfoparcel, ((zzgy) (obj)), zzgs1.zzFy.zzD(context), location, zzbr1, s2, s3, list);
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
        zzcg1.zza(zzce, new String[] {
            "arc"
        });
        obj = zzcg1.zzdn();
        if (((Boolean)zzby.zzum.get()).booleanValue())
        {
            zzid.zzIE.post(new Runnable(zzdz1, zzgv1, zzcg1, ((zzce) (obj)), s) {

                final zzdz zzFD;
                final zzgv zzFE;
                final zzce zzFF;
                final String zzFG;
                final zzcg zzoD;

                public final void run()
                {
                    zzdz.zzd zzd = zzFD.zzdO();
                    zzFE.zzb(zzd);
                    zzoD.zza(zzFF, new String[] {
                        "rwc"
                    });
                    zzd.zza(new zzis.zzc(this, zzoD.zzdn()) {

                        final zzce zzFH;
                        final _cls1 zzFI;

                        public void zzb(zzbe zzbe1)
                        {
                            zzFI.zzoD.zza(zzFH, new String[] {
                                "jsf"
                            });
                            zzFI.zzoD.zzdo();
                            zzbe1.zza("/invalidRequest", zzFI.zzFE.zzFR);
                            zzbe1.zza("/loadAdURL", zzFI.zzFE.zzFS);
                            try
                            {
                                zzbe1.zza("AFMA_buildAdURL", zzFI.zzFG);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (zzbe zzbe1)
                            {
                                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", zzbe1);
                            }
                        }

                        public void zzc(Object obj)
                        {
                            zzb((zzbe)obj);
                        }

            
            {
                zzFI = _pcls1;
                zzFH = zzce;
                super();
            }
                    }, new zzis.zza(this) {

                        final _cls1 zzFI;

                        public void run()
                        {
                        }

            
            {
                zzFI = _pcls1;
                super();
            }
                    });
                }

            
            {
                zzFD = zzdz1;
                zzFE = zzgv1;
                zzoD = zzcg1;
                zzFF = zzce;
                zzFG = s;
                super();
            }
            });
        } else
        {
            zzid.zzIE.post(new Runnable(context, adrequestinfoparcel, zzgv1, zzcg1, ((zzce) (obj)), s, zzbr1) {

                final zzgv zzFE;
                final zzce zzFF;
                final String zzFG;
                final AdRequestInfoParcel zzFJ;
                final zzbr zzFK;
                final zzcg zzoD;
                final Context zzry;

                public final void run()
                {
                    zziz zziz1 = zzp.zzbw().zza(zzry, new AdSizeParcel(), false, false, null, zzFJ.zzqj);
                    if (zzp.zzby().zzgu())
                    {
                        zziz1.clearCache(true);
                    }
                    zziz1.getWebView().setWillNotDraw(true);
                    zzFE.zze(zziz1);
                    zzoD.zza(zzFF, new String[] {
                        "rwc"
                    });
                    Object obj1 = zzoD.zzdn();
                    obj1 = com.google.android.gms.internal.zzgt.zzb(zzFG, zzoD, ((zzce) (obj1)));
                    zzja zzja1 = zziz1.zzhe();
                    zzja1.zza("/invalidRequest", zzFE.zzFR);
                    zzja1.zza("/loadAdURL", zzFE.zzFS);
                    zzja1.zza("/log", zzdj.zzxv);
                    zzja1.zza(((zzja.zza) (obj1)));
                    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Loading the JS library.");
                    zziz1.loadUrl(zzFK.zzdc());
                }

            
            {
                zzry = context;
                zzFJ = adrequestinfoparcel;
                zzFE = zzgv1;
                zzoD = zzcg1;
                zzFF = zzce;
                zzFG = s;
                zzFK = zzbr1;
                super();
            }
            });
        }
        zzbr1 = (zzgx)zzgv1.zzfS().get(10L, TimeUnit.SECONDS);
        if (zzbr1 != null)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        context = new AdResponseParcel(0);
        zzid.zzIE.post(new Runnable(zzgv1) {

            final zzgv zzFE;

            public final void run()
            {
                zzFE.zzfT();
                if (zzFE.zzfR() != null)
                {
                    zzFE.zzfR().release();
                }
            }

            
            {
                zzFE = zzgv1;
                super();
            }
        });
        return context;
        context;
        context = new AdResponseParcel(0);
        zzid.zzIE.post(new _cls3(zzgv1));
        return context;
        if (zzbr1.getErrorCode() == -2)
        {
            break MISSING_BLOCK_LABEL_566;
        }
        context = new AdResponseParcel(zzbr1.getErrorCode());
        zzid.zzIE.post(new _cls3(zzgv1));
        return context;
        if (zzcg1.zzdq() != null)
        {
            zzcg1.zza(zzcg1.zzdq(), new String[] {
                "rur"
            });
        }
        zzdz1 = null;
        if (zzbr1.zzfW())
        {
            zzdz1 = zzgs1.zzFt.zzaw(adrequestinfoparcel.zzEo.packageName);
        }
        zzdz1 = zza(adrequestinfoparcel, context, adrequestinfoparcel.zzqj.zzJu, zzbr1.getUrl(), ((String) (zzdz1)), s2, ((zzgx) (zzbr1)), zzcg1, zzgs1);
        if (((AdResponseParcel) (zzdz1)).zzEW == 1)
        {
            zzgs1.zzFw.clearToken(context, adrequestinfoparcel.zzEo.packageName);
        }
        zzcg1.zza(zzce, new String[] {
            "tts"
        });
        zzdz1.zzEY = zzcg1.zzdp();
        zzid.zzIE.post(new _cls3(zzgv1));
        return zzdz1;
        context;
        zzid.zzIE.post(new _cls3(zzgv1));
        throw context;
    }

    public static AdResponseParcel zza(AdRequestInfoParcel adrequestinfoparcel, Context context, String s, String s1, String s2, String s3, zzgx zzgx1, zzcg zzcg1, 
            zzgs zzgs1)
    {
        HttpURLConnection httpurlconnection;
        zzgw zzgw1;
        int i;
        int j;
        zzce zzce;
        byte abyte0[];
        long l;
        if (zzcg1 != null)
        {
            zzce = zzcg1.zzdn();
        } else
        {
            zzce = null;
        }
        try
        {
            zzgw1 = new zzgw(adrequestinfoparcel);
            com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder("AdRequestServiceImpl: Sending request: ")).append(s1).toString());
            adrequestinfoparcel = new URL(s1);
            l = zzp.zzbz().elapsedRealtime();
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Error while connecting to ad server: ")).append(adrequestinfoparcel.getMessage()).toString());
            return new AdResponseParcel(2);
        }
        i = 0;
_L4:
        if (zzgs1 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        zzgs1.zzFz.zzfY();
        httpurlconnection = (HttpURLConnection)adrequestinfoparcel.openConnection();
        zzp.zzbv().zza(context, s, false, httpurlconnection);
        if (!TextUtils.isEmpty(s2))
        {
            httpurlconnection.addRequestProperty("x-afma-drt-cookie", s2);
        }
        if (!TextUtils.isEmpty(s3))
        {
            httpurlconnection.addRequestProperty("Authorization", (new StringBuilder("Bearer ")).append(s3).toString());
        }
        if (zzgx1 == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        if (TextUtils.isEmpty(zzgx1.zzfV()))
        {
            break MISSING_BLOCK_LABEL_214;
        }
        httpurlconnection.setDoOutput(true);
        abyte0 = zzgx1.zzfV().getBytes();
        httpurlconnection.setFixedLengthStreamingMode(abyte0.length);
        s1 = new BufferedOutputStream(httpurlconnection.getOutputStream());
        s1.write(abyte0);
        com.google.android.gms.internal.zzmt.zzb(s1);
        j = httpurlconnection.getResponseCode();
        s1 = httpurlconnection.getHeaderFields();
        if (j < 200 || j >= 300) goto _L2; else goto _L1
_L1:
        adrequestinfoparcel = adrequestinfoparcel.toString();
        context = new InputStreamReader(httpurlconnection.getInputStream());
        s = zzp.zzbv().zza(context);
        com.google.android.gms.internal.zzmt.zzb(context);
        zza(((String) (adrequestinfoparcel)), ((Map) (s1)), s, j);
        zzgw1.zzb(adrequestinfoparcel, s1, s);
        if (zzcg1 == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        zzcg1.zza(zzce, new String[] {
            "ufe"
        });
        adrequestinfoparcel = zzgw1.zzj(l);
        httpurlconnection.disconnect();
        if (zzgs1 == null)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        zzgs1.zzFz.zzfZ();
        return adrequestinfoparcel;
        adrequestinfoparcel;
        context = null;
_L6:
        com.google.android.gms.internal.zzmt.zzb(context);
        throw adrequestinfoparcel;
        adrequestinfoparcel;
        httpurlconnection.disconnect();
        if (zzgs1 == null)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        zzgs1.zzFz.zzfZ();
        throw adrequestinfoparcel;
        adrequestinfoparcel;
        context = null;
_L5:
        com.google.android.gms.internal.zzmt.zzb(context);
        throw adrequestinfoparcel;
_L2:
        zza(adrequestinfoparcel.toString(), ((Map) (s1)), null, j);
        if (j < 300 || j >= 400)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        adrequestinfoparcel = httpurlconnection.getHeaderField("Location");
        if (!TextUtils.isEmpty(adrequestinfoparcel))
        {
            break MISSING_BLOCK_LABEL_502;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("No location header to follow redirect.");
        adrequestinfoparcel = new AdResponseParcel(0);
        httpurlconnection.disconnect();
        if (zzgs1 == null)
        {
            break MISSING_BLOCK_LABEL_500;
        }
        zzgs1.zzFz.zzfZ();
        return adrequestinfoparcel;
        adrequestinfoparcel = new URL(adrequestinfoparcel);
        i++;
        if (i <= 5)
        {
            break MISSING_BLOCK_LABEL_612;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Too many redirects.");
        adrequestinfoparcel = new AdResponseParcel(0);
        httpurlconnection.disconnect();
        if (zzgs1 == null)
        {
            break MISSING_BLOCK_LABEL_558;
        }
        zzgs1.zzFz.zzfZ();
        return adrequestinfoparcel;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Received error HTTP response code: ")).append(j).toString());
        adrequestinfoparcel = new AdResponseParcel(0);
        httpurlconnection.disconnect();
        if (zzgs1 == null)
        {
            break MISSING_BLOCK_LABEL_610;
        }
        zzgs1.zzFz.zzfZ();
        return adrequestinfoparcel;
        zzgw1.zzh(s1);
        httpurlconnection.disconnect();
        if (zzgs1 == null) goto _L4; else goto _L3
_L3:
        zzgs1.zzFz.zzfZ();
          goto _L4
        adrequestinfoparcel;
          goto _L5
        adrequestinfoparcel;
        context = s1;
          goto _L6
    }

    public static zzgt zza(Context context, zzbr zzbr1, zzgs zzgs1)
    {
        Object obj = zzpy;
        obj;
        JVM INSTR monitorenter ;
        if (zzFA != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Context context1 = context;
        if (context.getApplicationContext() != null)
        {
            context1 = context.getApplicationContext();
        }
        zzFA = new zzgt(context1, zzbr1, zzgs1);
        context = zzFA;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static zzja.zza zza(String s, zzcg zzcg1, zzce zzce)
    {
        return new zzja.zza(zzcg1, zzce, s) {

            final String zzFG;
            final zzce zzFH;
            final zzcg zzoD;

            public final void zza(zziz zziz1, boolean flag)
            {
                zzoD.zza(zzFH, new String[] {
                    "jsf"
                });
                zzoD.zzdo();
                zziz1.zza("AFMA_buildAdURL", zzFG);
            }

            
            {
                zzoD = zzcg1;
                zzFH = zzce;
                zzFG = s;
                super();
            }
        };
    }

    private static void zza(String s, Map map, String s1, int i)
    {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzN(2))
        {
            com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("Http Response: {\n  URL:\n    ")).append(s).append("\n  Headers:").toString());
            if (map != null)
            {
                for (s = map.keySet().iterator(); s.hasNext();)
                {
                    Object obj = (String)s.next();
                    com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("    ")).append(((String) (obj))).append(":").toString());
                    obj = ((List)map.get(obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s2 = (String)((Iterator) (obj)).next();
                        com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("      ")).append(s2).toString());
                    }
                }

            }
            com.google.android.gms.ads.internal.util.client.zzb.v("  Body:");
            if (s1 != null)
            {
                for (int j = 0; j < Math.min(s1.length(), 0x186a0); j += 1000)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.v(s1.substring(j, Math.min(s1.length(), j + 1000)));
                }

            } else
            {
                com.google.android.gms.ads.internal.util.client.zzb.v("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("  Response Code:\n    ")).append(i).append("\n}").toString());
        }
    }

    static zzja.zza zzb(String s, zzcg zzcg1, zzce zzce)
    {
        return zza(s, zzcg1, zzce);
    }

    public final void zza(AdRequestInfoParcel adrequestinfoparcel, zzk zzk)
    {
        zzp.zzby().zzb(mContext, adrequestinfoparcel.zzqj);
        com.google.android.gms.internal.zzid.zzb(new Runnable(adrequestinfoparcel, zzk) {

            final AdRequestInfoParcel zzFJ;
            final zzgt zzFL;
            final zzk zzFM;

            public void run()
            {
                AdResponseParcel adresponseparcel;
                AdResponseParcel adresponseparcel1;
                try
                {
                    adresponseparcel = zzFL.zze(zzFJ);
                }
                catch (Exception exception)
                {
                    zzp.zzby().zzc(exception, true);
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
                    zzFM.zzb(adresponseparcel1);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", remoteexception);
                }
            }

            
            {
                zzFL = zzgt.this;
                zzFJ = adrequestinfoparcel;
                zzFM = zzk1;
                super();
            }
        });
    }

    public final AdResponseParcel zze(AdRequestInfoParcel adrequestinfoparcel)
    {
        return zza(mContext, zzrf, zzFC, zzFB, adrequestinfoparcel);
    }

}
