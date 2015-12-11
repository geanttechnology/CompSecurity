// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmn;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            AdResponseParcel, zzc, AdRequestInfoParcel

public class zzb extends zzhz
    implements zzc.zza
{
    static final class zza extends Exception
    {

        private final int zzDv;

        public int getErrorCode()
        {
            return zzDv;
        }

        public zza(String s, int i)
        {
            super(s);
            zzDv = i;
        }
    }


    private final Context mContext;
    AdResponseParcel zzDf;
    private Runnable zzDg;
    private final Object zzDh = new Object();
    private final zza.zza zzEe;
    private final AdRequestInfoParcel.zza zzEf;
    zzhz zzEg;
    private final zzan zzwL;
    zzee zzzA;
    private AdRequestInfoParcel zzzz;

    public zzb(Context context, AdRequestInfoParcel.zza zza1, zzan zzan1, zza.zza zza2)
    {
        zzEe = zza2;
        mContext = context;
        zzEf = zza1;
        zzwL = zzan1;
    }

    static Object zza(zzb zzb1)
    {
        return zzb1.zzDh;
    }

    static void zza(zzb zzb1, int i, String s)
    {
        zzb1.zzc(i, s);
    }

    private void zzc(int i, String s)
    {
        if (i == 3 || i == -1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaG(s);
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(s);
        }
        if (zzDf == null)
        {
            zzDf = new AdResponseParcel(i);
        } else
        {
            zzDf = new AdResponseParcel(i, zzDf.zzzc);
        }
        s = new com.google.android.gms.internal.zzhs.zza(zzzz, zzDf, zzzA, null, i, -1L, zzDf.zzEO, null);
        zzEe.zza(s);
    }

    public void onStop()
    {
        synchronized (zzDh)
        {
            if (zzEg != null)
            {
                zzEg.cancel();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    zzhz zzb(AdRequestInfoParcel adrequestinfoparcel)
    {
        return com.google.android.gms.ads.internal.request.zzc.zza(mContext, adrequestinfoparcel, this);
    }

    public void zzb(AdResponseParcel adresponseparcel)
    {
        long l;
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Received ad response.");
        zzDf = adresponseparcel;
        l = zzp.zzbz().elapsedRealtime();
        synchronized (zzDh)
        {
            zzEg = null;
        }
        try
        {
            if (zzDf.errorCode != -2 && zzDf.errorCode != -3)
            {
                throw new zza((new StringBuilder()).append("There was a problem getting an ad response. ErrorCode: ").append(zzDf.errorCode).toString(), zzDf.errorCode);
            }
        }
        // Misplaced declaration of an exception variable
        catch (AdResponseParcel adresponseparcel)
        {
            zzc(adresponseparcel.getErrorCode(), adresponseparcel.getMessage());
            zzid.zzIE.removeCallbacks(zzDg);
            return;
        }
        break MISSING_BLOCK_LABEL_126;
        exception;
        adresponseparcel;
        JVM INSTR monitorexit ;
        throw exception;
        zzfG();
        if (zzzz.zzqn.zztg == null) goto _L2; else goto _L1
_L1:
        adresponseparcel = zzc(zzzz);
_L7:
        zzw(zzDf.zzEU);
        if (TextUtils.isEmpty(zzDf.zzES)) goto _L4; else goto _L3
_L3:
        Object obj = new JSONObject(zzDf.zzES);
_L5:
        adresponseparcel = new com.google.android.gms.internal.zzhs.zza(zzzz, zzDf, zzzA, adresponseparcel, -2, l, zzDf.zzEO, ((JSONObject) (obj)));
        zzEe.zza(adresponseparcel);
        zzid.zzIE.removeCallbacks(zzDg);
        return;
        obj;
        com.google.android.gms.ads.internal.util.client.zzb.zzb("Error parsing the JSON for Active View.", ((Throwable) (obj)));
_L4:
        obj = null;
        if (true) goto _L5; else goto _L2
_L2:
        adresponseparcel = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void zzbn()
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdLoaderBackgroundTask started.");
        String s = zzwL.zzab().zzb(mContext);
        zzDg = new _cls1();
        zzid.zzIE.postDelayed(zzDg, ((Long)zzby.zzvv.get()).longValue());
        long l = zzp.zzbz().elapsedRealtime();
        zzzz = new AdRequestInfoParcel(zzEf, s, l);
        synchronized (zzDh)
        {
            zzEg = zzb(zzzz);
            if (zzEg == null)
            {
                zzc(0, "Could not start the ad request service.");
                zzid.zzIE.removeCallbacks(zzDg);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected AdSizeParcel zzc(AdRequestInfoParcel adrequestinfoparcel)
        throws zza
    {
        if (zzDf.zzEN == null)
        {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        Object aobj[] = zzDf.zzEN.split("x");
        if (aobj.length != 2)
        {
            throw new zza((new StringBuilder()).append("Invalid ad size format from the ad response: ").append(zzDf.zzEN).toString(), 0);
        }
        int l;
        int i1;
        int j1;
        try
        {
            l = Integer.parseInt(aobj[0]);
            i1 = Integer.parseInt(aobj[1]);
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            throw new zza((new StringBuilder()).append("Invalid ad size number from the ad response: ").append(zzDf.zzEN).toString(), 0);
        }
        aobj = adrequestinfoparcel.zzqn.zztg;
        j1 = aobj.length;
        AdSizeParcel adsizeparcel;
        int j;
        int k;
        for (int i = 0; i < j1; i++)
        {
            adsizeparcel = aobj[i];
            float f = mContext.getResources().getDisplayMetrics().density;
            if (adsizeparcel.width == -1)
            {
                j = (int)((float)adsizeparcel.widthPixels / f);
            } else
            {
                j = adsizeparcel.width;
            }
            if (adsizeparcel.height == -2)
            {
                k = (int)((float)adsizeparcel.heightPixels / f);
            } else
            {
                k = adsizeparcel.height;
            }
            if (l == j && i1 == k)
            {
                return new AdSizeParcel(adsizeparcel, adrequestinfoparcel.zzqn.zztg);
            }
        }

        throw new zza((new StringBuilder()).append("The ad size from the ad response was not one of the requested sizes: ").append(zzDf.zzEN).toString(), 0);
    }

    protected void zzfG()
        throws zza
    {
        if (zzDf.errorCode != -3)
        {
            if (TextUtils.isEmpty(zzDf.body))
            {
                throw new zza("No fill from ad server.", 3);
            }
            zzp.zzby().zza(mContext, zzDf.zzEv);
            if (zzDf.zzEK)
            {
                try
                {
                    zzzA = new zzee(zzDf.body);
                    return;
                }
                catch (JSONException jsonexception)
                {
                    throw new zza((new StringBuilder()).append("Could not parse mediation config: ").append(zzDf.body).toString(), 0);
                }
            }
        }
    }

    protected void zzw(boolean flag)
    {
        zzp.zzby().zzA(flag);
        zzbk zzbk1 = zzp.zzby().zzE(mContext);
        if (zzbk1 != null && !zzbk1.isAlive())
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("start fetching content...");
            zzbk1.zzct();
        }
    }

    /* member class not found */
    class _cls1 {}

}
