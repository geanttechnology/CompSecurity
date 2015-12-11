// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzhk, zzhj, zzhm

public class zzhl extends com.google.android.gms.ads.internal.reward.mediation.client.zza.zza
{

    private zzhm zzHh;
    private zzhj zzHn;
    private zzhk zzHo;

    public zzhl(zzhk zzhk1)
    {
        zzHo = zzhk1;
    }

    public void zza(zzd zzd, RewardItemParcel rewarditemparcel)
    {
        if (zzHo != null)
        {
            zzHo.zza(rewarditemparcel);
        }
    }

    public void zza(zzhj zzhj1)
    {
        zzHn = zzhj1;
    }

    public void zza(zzhm zzhm1)
    {
        zzHh = zzhm1;
    }

    public void zzb(zzd zzd, int i)
    {
        if (zzHn != null)
        {
            zzHn.zzK(i);
        }
    }

    public void zzc(zzd zzd, int i)
    {
        if (zzHh != null)
        {
            zzHh.zzb(zze.zzp(zzd).getClass().getName(), i);
        }
    }

    public void zzg(zzd zzd)
    {
        if (zzHn != null)
        {
            zzHn.zzge();
        }
    }

    public void zzh(zzd zzd)
    {
        if (zzHh != null)
        {
            zzHh.zzav(zze.zzp(zzd).getClass().getName());
        }
    }

    public void zzi(zzd zzd)
    {
        if (zzHo != null)
        {
            zzHo.onRewardedVideoAdOpened();
        }
    }

    public void zzj(zzd zzd)
    {
        if (zzHo != null)
        {
            zzHo.onRewardedVideoStarted();
        }
    }

    public void zzk(zzd zzd)
    {
        if (zzHo != null)
        {
            zzHo.onRewardedVideoAdClosed();
        }
    }

    public void zzl(zzd zzd)
    {
        if (zzHo != null)
        {
            zzHo.zzgb();
        }
    }

    public void zzm(zzd zzd)
    {
        if (zzHo != null)
        {
            zzHo.onRewardedVideoAdLeftApplication();
        }
    }
}
