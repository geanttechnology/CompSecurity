// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;

// Referenced classes of package com.google.android.gms.ads.internal.reward.mediation.client:
//            zza, RewardItemParcel

public class zzb
    implements MediationRewardedVideoAdListener
{

    private final zza zzHu;

    public zzb(zza zza1)
    {
        zzHu = zza1;
    }

    public void onAdClicked(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
    {
        zzx.zzci("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdClicked.");
        try
        {
            zzHu.zzl(zze.zzy(mediationrewardedvideoadadapter));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", mediationrewardedvideoadadapter);
        }
    }

    public void onAdClosed(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
    {
        zzx.zzci("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdClosed.");
        try
        {
            zzHu.zzk(zze.zzy(mediationrewardedvideoadadapter));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", mediationrewardedvideoadadapter);
        }
    }

    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter, int i)
    {
        zzx.zzci("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdFailedToLoad.");
        try
        {
            zzHu.zzc(zze.zzy(mediationrewardedvideoadadapter), i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", mediationrewardedvideoadadapter);
        }
    }

    public void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
    {
        zzx.zzci("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdLeftApplication.");
        try
        {
            zzHu.zzm(zze.zzy(mediationrewardedvideoadadapter));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", mediationrewardedvideoadadapter);
        }
    }

    public void onAdLoaded(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
    {
        zzx.zzci("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdLoaded.");
        try
        {
            zzHu.zzh(zze.zzy(mediationrewardedvideoadadapter));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", mediationrewardedvideoadadapter);
        }
    }

    public void onAdOpened(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
    {
        zzx.zzci("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdOpened.");
        try
        {
            zzHu.zzi(zze.zzy(mediationrewardedvideoadadapter));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", mediationrewardedvideoadadapter);
        }
    }

    public void onInitializationFailed(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter, int i)
    {
        zzx.zzci("onInitializationFailed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onInitializationFailed.");
        try
        {
            zzHu.zzb(zze.zzy(mediationrewardedvideoadadapter), i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationFailed.", mediationrewardedvideoadadapter);
        }
    }

    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
    {
        zzx.zzci("onInitializationSucceeded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onInitializationSucceeded.");
        try
        {
            zzHu.zzg(zze.zzy(mediationrewardedvideoadadapter));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationSucceeded.", mediationrewardedvideoadadapter);
        }
    }

    public void onRewarded(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter, RewardItem rewarditem)
    {
        zzx.zzci("onRewarded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onRewarded.");
        if (rewarditem != null)
        {
            try
            {
                zzHu.zza(zze.zzy(mediationrewardedvideoadadapter), new RewardItemParcel(rewarditem));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onRewarded.", mediationrewardedvideoadadapter);
            }
            break MISSING_BLOCK_LABEL_72;
        }
        zzHu.zza(zze.zzy(mediationrewardedvideoadadapter), new RewardItemParcel(mediationrewardedvideoadadapter.getClass().getName(), 1));
        return;
    }

    public void onVideoStarted(MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
    {
        zzx.zzci("onVideoStarted must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onVideoStarted.");
        try
        {
            zzHu.zzj(zze.zzy(mediationrewardedvideoadadapter));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onVideoStarted.", mediationrewardedvideoadadapter);
        }
    }
}
