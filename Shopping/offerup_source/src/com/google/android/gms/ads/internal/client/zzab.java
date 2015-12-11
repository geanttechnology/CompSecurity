// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzel;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzl, zzad, zzw, zzac

public class zzab
{

    private static final Object zzpy = new Object();
    private static zzab zztM;
    private zzw zztN;
    private RewardedVideoAd zztO;

    private zzab()
    {
    }

    public static zzab zzcV()
    {
        zzab zzab1;
        synchronized (zzpy)
        {
            if (zztM == null)
            {
                zztM = new zzab();
            }
            zzab1 = zztM;
        }
        return zzab1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context)
    {
label0:
        {
            synchronized (zzpy)
            {
                if (zztO == null)
                {
                    break label0;
                }
                context = zztO;
            }
            return context;
        }
        zzel zzel1 = new zzel();
        zztO = new zzi(context, zzl.zzcK().zza(context, zzel1));
        context = zztO;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void initialize(Context context)
    {
label0:
        {
            synchronized (zzpy)
            {
                if (zztN == null)
                {
                    break label0;
                }
            }
            return;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        throw new IllegalArgumentException("Context cannot be null.");
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        zztN = zzl.zzcI().zzt(context);
        zztN.zza();
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        context;
        zzb.zzaH("Fail to initialize mobile ads setting manager");
          goto _L1
    }

    public void zza(Context context, String s, zzac zzac)
    {
        initialize(context);
    }

}
