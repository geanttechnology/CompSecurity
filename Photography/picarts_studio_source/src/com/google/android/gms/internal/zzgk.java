// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzgf, zzec, zzei, zzhs, 
//            zzek, zzby, zzbu, zzee, 
//            zzcg, zzem

public class zzgk extends zzgf
{

    protected zzei zzDA;
    private zzec zzDz;
    private final zzcg zzoo;
    private zzem zzox;
    private zzee zzzA;

    zzgk(Context context, zzhs.zza zza, zzem zzem, zzgg.zza zza1, zzcg zzcg)
    {
        super(context, zza, zza1);
        zzox = zzem;
        zzzA = zza.zzHx;
        zzoo = zzcg;
    }

    public void onStop()
    {
        synchronized (zzDh)
        {
            super.onStop();
            if (zzDz != null)
            {
                zzDz.cancel();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected zzhs zzA(int i)
    {
        Object obj = zzDe.zzHC;
        com.google.android.gms.ads.internal.client.AdRequestParcel adrequestparcel = ((AdRequestInfoParcel) (obj)).zzEn;
        java.util.List list = zzDf.zzyY;
        java.util.List list1 = zzDf.zzyZ;
        java.util.List list2 = zzDf.zzEM;
        int j = zzDf.orientation;
        long l = zzDf.zzzc;
        String s1 = ((AdRequestInfoParcel) (obj)).zzEq;
        boolean flag = zzDf.zzEK;
        zzen zzen;
        String s;
        zzeg zzeg;
        zzee zzee1;
        if (zzDA != null)
        {
            obj = zzDA.zzzu;
        } else
        {
            obj = null;
        }
        if (zzDA != null)
        {
            zzen = zzDA.zzzv;
        } else
        {
            zzen = null;
        }
        if (zzDA != null)
        {
            s = zzDA.zzzw;
        } else
        {
            s = com/google/ads/mediation/admob/AdMobAdapter.getName();
        }
        zzee1 = zzzA;
        if (zzDA != null)
        {
            zzeg = zzDA.zzzx;
        } else
        {
            zzeg = null;
        }
        return new zzhs(adrequestparcel, null, list, i, list1, list2, j, l, s1, flag, ((zzed) (obj)), zzen, s, zzee1, zzeg, zzDf.zzEL, zzDe.zzqn, zzDf.zzEJ, zzDe.zzHz, zzDf.zzEO, zzDf.zzEP, zzDe.zzHw, null);
    }

    protected void zzh(long l)
    {
        synchronized (zzDh)
        {
            zzDz = new zzek(mContext, zzDe.zzHC, zzox, zzzA, zzDf.zzth, l, ((Long)zzby.zzvw.get()).longValue(), zzoo);
        }
        zzDA = zzDz.zzc(zzzA.zzyW);
        switch (zzDA.zzzt)
        {
        default:
            throw new zzgf.zza((new StringBuilder("Unexpected mediation result: ")).append(zzDA.zzzt).toString(), 0);

        case 1: // '\001'
            throw new zzgf.zza("No fill from any mediation ad networks.", 3);

        case 0: // '\0'
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
