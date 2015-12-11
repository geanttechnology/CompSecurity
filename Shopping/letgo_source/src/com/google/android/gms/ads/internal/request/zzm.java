// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.mq;
import android.support.v7.mt;
import android.support.v7.ng;
import android.support.v7.nj;
import android.support.v7.nn;
import android.support.v7.ox;
import android.support.v7.oy;
import android.support.v7.pc;
import android.support.v7.pm;
import android.support.v7.sh;
import android.support.v7.sm;
import android.support.v7.tl;
import android.support.v7.tp;
import android.support.v7.ul;
import android.support.v7.vn;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            AdRequestInfoParcel, AdResponseParcel

public class zzm extends tl
{
    public static class zza
        implements android.support.v7.pm.b
    {

        public void zza(mq mq1)
        {
            zzm.zzd(mq1);
        }

        public void zzc(Object obj)
        {
            zza((mq)obj);
        }

        public zza()
        {
        }
    }

    public static class zzb
        implements android.support.v7.pm.b
    {

        public void zza(mq mq1)
        {
            zzm.zzc(mq1);
        }

        public void zzc(Object obj)
        {
            zza((mq)obj);
        }

        public zzb()
        {
        }
    }

    public static class zzc
        implements ox
    {

        public void zza(ul ul, Map map)
        {
            ul = (String)map.get("request_id");
            map = (String)map.get("errors");
            com.google.android.gms.ads.internal.util.client.zzb.zzaE((new StringBuilder()).append("Invalid request: ").append(map).toString());
            zzm.zzfD().b(ul);
        }

        public zzc()
        {
        }
    }


    static final long zzEu;
    private static boolean zzEv = false;
    private static pm zzEw = null;
    private static oy zzEx = null;
    private static pc zzEy = null;
    private static ox zzEz = null;
    private static final Object zzpm = new Object();
    private final Context mContext;
    private final Object zzCE;
    private final zza.zza zzDp;
    private final AdRequestInfoParcel.zza zzDq;
    private android.support.v7.pm.d zzEA;

    public zzm(Context context, AdRequestInfoParcel.zza zza1, zza.zza zza2)
    {
        zzCE = new Object();
        zzDp = zza2;
        mContext = context;
        zzDq = zza1;
        synchronized (zzpm)
        {
            if (!zzEv)
            {
                zzEy = new pc();
                zzEx = new oy(context.getApplicationContext(), zza1.zzqb);
                zzEz = new zzc();
                zzEw = new pm(mContext.getApplicationContext(), zzDq.zzqb, (String)nn.b.c(), new zzb(), new zza());
                zzEv = true;
            }
        }
        return;
        context;
        zza2;
        JVM INSTR monitorexit ;
        throw context;
    }

    static android.support.v7.pm.d zza(zzm zzm1, android.support.v7.pm.d d1)
    {
        zzm1.zzEA = d1;
        return d1;
    }

    static zza.zza zza(zzm zzm1)
    {
        return zzm1.zzDp;
    }

    private JSONObject zza(AdRequestInfoParcel adrequestinfoparcel, String s)
    {
        Bundle bundle;
        String s1;
        bundle = adrequestinfoparcel.zzDy.extras.getBundle("sdk_less_server_data");
        s1 = adrequestinfoparcel.zzDy.extras.getString("sdk_less_network_id");
        if (bundle != null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        return null;
_L2:
        if ((jsonobject = sh.a(mContext, adrequestinfoparcel, zzp.zzbD().a(mContext), null, null, new ng((String)nn.b.c()), null, null, new ArrayList())) == null) goto _L1; else goto _L3
_L3:
        adrequestinfoparcel = AdvertisingIdClient.getAdvertisingIdInfo(mContext);
_L4:
        HashMap hashmap = new HashMap();
        hashmap.put("request_id", s);
        hashmap.put("network_id", s1);
        hashmap.put("request_param", jsonobject);
        hashmap.put("data", bundle);
        if (adrequestinfoparcel != null)
        {
            hashmap.put("adid", adrequestinfoparcel.getId());
            int i;
            if (adrequestinfoparcel.isLimitAdTrackingEnabled())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            hashmap.put("lat", Integer.valueOf(i));
        }
        try
        {
            adrequestinfoparcel = zzp.zzbx().a(hashmap);
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            return null;
        }
        return adrequestinfoparcel;
        adrequestinfoparcel;
_L5:
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", adrequestinfoparcel);
        adrequestinfoparcel = null;
          goto _L4
        adrequestinfoparcel;
          goto _L5
        adrequestinfoparcel;
          goto _L5
        adrequestinfoparcel;
          goto _L5
    }

    static android.support.v7.pm.d zzb(zzm zzm1)
    {
        return zzm1.zzEA;
    }

    protected static void zzc(mq mq1)
    {
        mq1.a("/loadAd", zzEy);
        mq1.a("/fetchHttpRequest", zzEx);
        mq1.a("/invalidRequest", zzEz);
    }

    protected static void zzd(mq mq1)
    {
        mq1.b("/loadAd", zzEy);
        mq1.b("/fetchHttpRequest", zzEx);
        mq1.b("/invalidRequest", zzEz);
    }

    private AdResponseParcel zzf(AdRequestInfoParcel adrequestinfoparcel)
    {
        Object obj;
        Object obj1;
        obj = UUID.randomUUID().toString();
        obj1 = zza(adrequestinfoparcel, ((String) (obj)));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        adrequestinfoparcel = new AdResponseParcel(0);
_L4:
        return adrequestinfoparcel;
_L2:
        long l = zzp.zzbB().b();
        Future future = zzEy.a(((String) (obj)));
        com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new Runnable(((JSONObject) (obj1)), ((String) (obj))) {

            final zzm zzEB;
            final JSONObject zzEC;
            final String zzED;

            public void run()
            {
                com.google.android.gms.ads.internal.request.zzm.zza(zzEB, zzm.zzfE().b());
                com.google.android.gms.ads.internal.request.zzm.zzb(zzEB).a(new android.support.v7.uf.c(this) {

                    final _cls2 zzEE;

                    public void zzb(mt mt1)
                    {
                        try
                        {
                            mt1.a("AFMA_getAdapterLessMediationAd", zzEE.zzEC);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (mt mt1)
                        {
                            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", mt1);
                        }
                        zzm.zzfD().b(zzEE.zzED);
                    }

                    public void zzc(Object obj)
                    {
                        zzb((mt)obj);
                    }

            
            {
                zzEE = _pcls2;
                super();
            }
                }, new android.support.v7.uf.a(this) {

                    final _cls2 zzEE;

                    public void run()
                    {
                        zzm.zzfD().b(zzEE.zzED);
                    }

            
            {
                zzEE = _pcls2;
                super();
            }
                });
            }

            
            {
                zzEB = zzm.this;
                zzEC = jsonobject;
                zzED = s;
                super();
            }
        });
        long l1 = zzEu;
        long l2 = zzp.zzbB().b();
        try
        {
            obj = (JSONObject)future.get(l1 - (l2 - l), TimeUnit.MILLISECONDS);
            break MISSING_BLOCK_LABEL_102;
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel) { }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel) { }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            return new AdResponseParcel(2);
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            return new AdResponseParcel(0);
        }
        return new AdResponseParcel(-1);
        if (obj == null)
        {
            return new AdResponseParcel(-1);
        }
        obj1 = mContext;
        if (!(obj instanceof JSONObject))
        {
            obj = ((JSONObject) (obj)).toString();
        } else
        {
            obj = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        obj = sh.a(((Context) (obj1)), adrequestinfoparcel, ((String) (obj)));
        adrequestinfoparcel = ((AdRequestInfoParcel) (obj));
        if (((AdResponseParcel) (obj)).errorCode != -3)
        {
            adrequestinfoparcel = ((AdRequestInfoParcel) (obj));
            if (TextUtils.isEmpty(((AdResponseParcel) (obj)).body))
            {
                return new AdResponseParcel(3);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static pc zzfD()
    {
        return zzEy;
    }

    static pm zzfE()
    {
        return zzEw;
    }

    public void onStop()
    {
        synchronized (zzCE)
        {
            com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new Runnable() {

                final zzm zzEB;

                public void run()
                {
                    if (com.google.android.gms.ads.internal.request.zzm.zzb(zzEB) != null)
                    {
                        com.google.android.gms.ads.internal.request.zzm.zzb(zzEB).a();
                        com.google.android.gms.ads.internal.request.zzm.zza(zzEB, null);
                    }
                }

            
            {
                zzEB = zzm.this;
                super();
            }
            });
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzdG()
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("SdkLessAdLoaderBackgroundTask started.");
        Object obj = new AdRequestInfoParcel(zzDq, null, null, -1L);
        AdResponseParcel adresponseparcel = zzf(((AdRequestInfoParcel) (obj)));
        long l = zzp.zzbB().b();
        obj = new android.support.v7.te.a(((AdRequestInfoParcel) (obj)), adresponseparcel, null, null, adresponseparcel.errorCode, l, adresponseparcel.zzEb, null);
        com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new Runnable(((android.support.v7.te.a) (obj))) {

            final zzm zzEB;
            final android.support.v7.te.a zzoA;

            public void run()
            {
                com.google.android.gms.ads.internal.request.zzm.zza(zzEB).zza(zzoA);
                if (com.google.android.gms.ads.internal.request.zzm.zzb(zzEB) != null)
                {
                    com.google.android.gms.ads.internal.request.zzm.zzb(zzEB).a();
                    com.google.android.gms.ads.internal.request.zzm.zza(zzEB, null);
                }
            }

            
            {
                zzEB = zzm.this;
                zzoA = a;
                super();
            }
        });
    }

    static 
    {
        zzEu = TimeUnit.SECONDS.toMillis(10L);
    }
}
