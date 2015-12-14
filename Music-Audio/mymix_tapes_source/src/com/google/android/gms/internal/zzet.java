// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzej, zzeu

public final class zzet
    implements MediationBannerListener, MediationInterstitialListener
{

    private final zzej zzyY;

    public zzet(zzej zzej1)
    {
        zzyY = zzej1;
    }

    static zzej zza(zzet zzet1)
    {
        return zzet1.zzyY;
    }

    public void onClick(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaC("Adapter called onClick.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onClick must be called on the main UI thread.");
            zza.zzIy.post(new _cls1());
            return;
        }
        try
        {
            zzyY.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdClicked.", mediationbanneradapter);
        }
    }

    public void onDismissScreen(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaC("Adapter called onDismissScreen.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onDismissScreen must be called on the main UI thread.");
            zza.zzIy.post(new _cls4());
            return;
        }
        try
        {
            zzyY.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdClosed.", mediationbanneradapter);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzb.zzaC("Adapter called onDismissScreen.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onDismissScreen must be called on the main UI thread.");
            zza.zzIy.post(new _cls9());
            return;
        }
        try
        {
            zzyY.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdClosed.", mediationinterstitialadapter);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter mediationbanneradapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzb.zzaC((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error. ").append(errorcode).toString());
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzIy.post(new _cls5(errorcode));
            return;
        }
        try
        {
            zzyY.onAdFailedToLoad(com.google.android.gms.internal.zzeu.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", mediationbanneradapter);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter mediationinterstitialadapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzb.zzaC((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error ").append(errorcode).append(".").toString());
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzIy.post(new _cls10(errorcode));
            return;
        }
        try
        {
            zzyY.onAdFailedToLoad(com.google.android.gms.internal.zzeu.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", mediationinterstitialadapter);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaC("Adapter called onLeaveApplication.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onLeaveApplication must be called on the main UI thread.");
            zza.zzIy.post(new _cls6());
            return;
        }
        try
        {
            zzyY.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdLeftApplication.", mediationbanneradapter);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzb.zzaC("Adapter called onLeaveApplication.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onLeaveApplication must be called on the main UI thread.");
            zza.zzIy.post(new _cls11());
            return;
        }
        try
        {
            zzyY.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdLeftApplication.", mediationinterstitialadapter);
        }
    }

    public void onPresentScreen(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaC("Adapter called onPresentScreen.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onPresentScreen must be called on the main UI thread.");
            zza.zzIy.post(new _cls7());
            return;
        }
        try
        {
            zzyY.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdOpened.", mediationbanneradapter);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzb.zzaC("Adapter called onPresentScreen.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onPresentScreen must be called on the main UI thread.");
            zza.zzIy.post(new _cls2());
            return;
        }
        try
        {
            zzyY.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdOpened.", mediationinterstitialadapter);
        }
    }

    public void onReceivedAd(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaC("Adapter called onReceivedAd.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onReceivedAd must be called on the main UI thread.");
            zza.zzIy.post(new _cls8());
            return;
        }
        try
        {
            zzyY.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdLoaded.", mediationbanneradapter);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzb.zzaC("Adapter called onReceivedAd.");
        if (!zzk.zzcE().zzgI())
        {
            zzb.zzaE("onReceivedAd must be called on the main UI thread.");
            zza.zzIy.post(new _cls3());
            return;
        }
        try
        {
            zzyY.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdLoaded.", mediationinterstitialadapter);
        }
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls3 {}

}
