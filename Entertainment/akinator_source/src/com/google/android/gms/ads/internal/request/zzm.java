// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzgu;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

public class zzm extends zzhz
{

    static final long zzFi;
    private static boolean zzFj = false;
    private static zzdz zzFk = null;
    private static zzdl zzFl = null;
    private static zzdp zzFm = null;
    private static zzdk zzFn = null;
    private static final Object zzpy = new Object();
    private final Context mContext;
    private final Object zzDh;
    private final zza.zza zzEe;
    private final AdRequestInfoParcel.zza zzEf;
    private com.google.android.gms.internal.zzdz.zzd zzFo;

    public zzm(Context context, AdRequestInfoParcel.zza zza1, zza.zza zza2)
    {
        super(true);
        zzDh = new Object();
        zzEe = zza2;
        mContext = context;
        zzEf = zza1;
        synchronized (zzpy)
        {
            if (!zzFj)
            {
                zzFm = new zzdp();
                zzFl = new zzdl(context.getApplicationContext(), zza1.zzqj);
    /* block-local class not found */
    class zzc {}

                zzFn = new zzc();
    /* block-local class not found */
    class zza {}

    /* block-local class not found */
    class zzb {}

                zzFk = new zzdz(mContext.getApplicationContext(), zzEf.zzqj, (String)zzby.zzul.get(), new zzb(), new zza());
                zzFj = true;
            }
        }
        return;
        context;
        zza2;
        JVM INSTR monitorexit ;
        throw context;
    }

    static zza.zza zza(zzm zzm1)
    {
        return zzm1.zzEe;
    }

    static com.google.android.gms.internal.zzdz.zzd zza(zzm zzm1, com.google.android.gms.internal.zzdz.zzd zzd1)
    {
        zzm1.zzFo = zzd1;
        return zzd1;
    }

    private JSONObject zza(AdRequestInfoParcel adrequestinfoparcel, String s)
    {
        Bundle bundle;
        String s1;
        bundle = adrequestinfoparcel.zzEn.extras.getBundle("sdk_less_server_data");
        s1 = adrequestinfoparcel.zzEn.extras.getString("sdk_less_network_id");
        if (bundle != null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        return null;
_L2:
        if ((jsonobject = zzgu.zza(mContext, adrequestinfoparcel, zzp.zzbB().zzC(mContext), null, null, new zzbr((String)zzby.zzul.get()), null, null, new ArrayList())) == null) goto _L1; else goto _L3
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
            adrequestinfoparcel = zzp.zzbv().zzz(hashmap);
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

    static com.google.android.gms.internal.zzdz.zzd zzb(zzm zzm1)
    {
        return zzm1.zzFo;
    }

    protected static void zzc(zzbb zzbb1)
    {
        zzbb1.zza("/loadAd", zzFm);
        zzbb1.zza("/fetchHttpRequest", zzFl);
        zzbb1.zza("/invalidRequest", zzFn);
    }

    protected static void zzd(zzbb zzbb1)
    {
        zzbb1.zzb("/loadAd", zzFm);
        zzbb1.zzb("/fetchHttpRequest", zzFl);
        zzbb1.zzb("/invalidRequest", zzFn);
    }

    private AdResponseParcel zzf(AdRequestInfoParcel adrequestinfoparcel)
    {
        Object obj;
        JSONObject jsonobject;
        obj = UUID.randomUUID().toString();
        jsonobject = zza(adrequestinfoparcel, ((String) (obj)));
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        adrequestinfoparcel = new AdResponseParcel(0);
_L4:
        return adrequestinfoparcel;
_L2:
        long l = zzp.zzbz().elapsedRealtime();
        Future future = zzFm.zzY(((String) (obj)));
        zza.zzJt.post(new _cls2(jsonobject, ((String) (obj))));
        long l1 = zzFi;
        long l2 = zzp.zzbz().elapsedRealtime();
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
        obj = zzgu.zza(mContext, adrequestinfoparcel, ((JSONObject) (obj)).toString());
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

    static zzdp zzfN()
    {
        return zzFm;
    }

    static zzdz zzfO()
    {
        return zzFk;
    }

    public void onStop()
    {
        synchronized (zzDh)
        {
            zza.zzJt.post(new _cls3());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzbn()
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("SdkLessAdLoaderBackgroundTask started.");
        Object obj = new AdRequestInfoParcel(zzEf, null, -1L);
        AdResponseParcel adresponseparcel = zzf(((AdRequestInfoParcel) (obj)));
        long l = zzp.zzbz().elapsedRealtime();
        obj = new com.google.android.gms.internal.zzhs.zza(((AdRequestInfoParcel) (obj)), adresponseparcel, null, null, adresponseparcel.errorCode, l, adresponseparcel.zzEO, null);
        zza.zzJt.post(new _cls1(((com.google.android.gms.internal.zzhs.zza) (obj))));
    }

    static 
    {
        zzFi = TimeUnit.SECONDS.toMillis(10L);
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}

}
