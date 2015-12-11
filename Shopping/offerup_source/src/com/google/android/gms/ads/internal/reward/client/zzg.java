// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

// Referenced classes of package com.google.android.gms.ads.internal.reward.client:
//            zze, zza

public class zzg extends zzd.zza
{

    private final RewardedVideoAdListener zzHd;

    public zzg(RewardedVideoAdListener rewardedvideoadlistener)
    {
        zzHd = rewardedvideoadlistener;
    }

    public void onRewardedVideoAdClosed()
    {
        if (zzHd != null)
        {
            zzHd.onRewardedVideoAdClosed();
        }
    }

    public void onRewardedVideoAdFailedToLoad(int i)
    {
        if (zzHd != null)
        {
            zzHd.onRewardedVideoAdFailedToLoad(i);
        }
    }

    public void onRewardedVideoAdLeftApplication()
    {
        if (zzHd != null)
        {
            zzHd.onRewardedVideoAdLeftApplication();
        }
    }

    public void onRewardedVideoAdLoaded()
    {
        if (zzHd != null)
        {
            zzHd.onRewardedVideoAdLoaded();
        }
    }

    public void onRewardedVideoAdOpened()
    {
        if (zzHd != null)
        {
            zzHd.onRewardedVideoAdOpened();
        }
    }

    public void onRewardedVideoStarted()
    {
        if (zzHd != null)
        {
            zzHd.onRewardedVideoStarted();
        }
    }

    public void zza(zza zza1)
    {
        if (zzHd != null)
        {
            zzHd.onRewarded(new zze(zza1));
        }
    }
}
