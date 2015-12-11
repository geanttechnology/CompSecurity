// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzeo

public final class zzeu
    implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener
{

    private final zzeo zzzL;
    private NativeAdMapper zzzM;

    public zzeu(zzeo zzeo1)
    {
        zzzL = zzeo1;
    }

    public void onAdClicked(MediationBannerAdapter mediationbanneradapter)
    {
        zzx.zzci("onAdClicked must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClicked.");
        try
        {
            zzzL.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdClicked.", mediationbanneradapter);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzx.zzci("onAdClicked must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClicked.");
        try
        {
            zzzL.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdClicked.", mediationinterstitialadapter);
        }
    }

    public void onAdClicked(MediationNativeAdapter mediationnativeadapter)
    {
        zzx.zzci("onAdClicked must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClicked.");
        try
        {
            zzzL.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationNativeAdapter mediationnativeadapter)
        {
            zzb.zzd("Could not call onAdClicked.", mediationnativeadapter);
        }
    }

    public void onAdClosed(MediationBannerAdapter mediationbanneradapter)
    {
        zzx.zzci("onAdClosed must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClosed.");
        try
        {
            zzzL.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdClosed.", mediationbanneradapter);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzx.zzci("onAdClosed must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClosed.");
        try
        {
            zzzL.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdClosed.", mediationinterstitialadapter);
        }
    }

    public void onAdClosed(MediationNativeAdapter mediationnativeadapter)
    {
        zzx.zzci("onAdClosed must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClosed.");
        try
        {
            zzzL.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationNativeAdapter mediationnativeadapter)
        {
            zzb.zzd("Could not call onAdClosed.", mediationnativeadapter);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter mediationbanneradapter, int i)
    {
        zzx.zzci("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaF((new StringBuilder()).append("Adapter called onAdFailedToLoad with error. ").append(i).toString());
        try
        {
            zzzL.onAdFailedToLoad(i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", mediationbanneradapter);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter mediationinterstitialadapter, int i)
    {
        zzx.zzci("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaF((new StringBuilder()).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try
        {
            zzzL.onAdFailedToLoad(i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", mediationinterstitialadapter);
        }
    }

    public void onAdFailedToLoad(MediationNativeAdapter mediationnativeadapter, int i)
    {
        zzx.zzci("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaF((new StringBuilder()).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try
        {
            zzzL.onAdFailedToLoad(i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationNativeAdapter mediationnativeadapter)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", mediationnativeadapter);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter mediationbanneradapter)
    {
        zzx.zzci("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLeftApplication.");
        try
        {
            zzzL.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdLeftApplication.", mediationbanneradapter);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzx.zzci("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLeftApplication.");
        try
        {
            zzzL.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdLeftApplication.", mediationinterstitialadapter);
        }
    }

    public void onAdLeftApplication(MediationNativeAdapter mediationnativeadapter)
    {
        zzx.zzci("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLeftApplication.");
        try
        {
            zzzL.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationNativeAdapter mediationnativeadapter)
        {
            zzb.zzd("Could not call onAdLeftApplication.", mediationnativeadapter);
        }
    }

    public void onAdLoaded(MediationBannerAdapter mediationbanneradapter)
    {
        zzx.zzci("onAdLoaded must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLoaded.");
        try
        {
            zzzL.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdLoaded.", mediationbanneradapter);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzx.zzci("onAdLoaded must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLoaded.");
        try
        {
            zzzL.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdLoaded.", mediationinterstitialadapter);
        }
    }

    public void onAdLoaded(MediationNativeAdapter mediationnativeadapter, NativeAdMapper nativeadmapper)
    {
        zzx.zzci("onAdLoaded must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLoaded.");
        zzzM = nativeadmapper;
        try
        {
            zzzL.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationNativeAdapter mediationnativeadapter)
        {
            zzb.zzd("Could not call onAdLoaded.", mediationnativeadapter);
        }
    }

    public void onAdOpened(MediationBannerAdapter mediationbanneradapter)
    {
        zzx.zzci("onAdOpened must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdOpened.");
        try
        {
            zzzL.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdOpened.", mediationbanneradapter);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzx.zzci("onAdOpened must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdOpened.");
        try
        {
            zzzL.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdOpened.", mediationinterstitialadapter);
        }
    }

    public void onAdOpened(MediationNativeAdapter mediationnativeadapter)
    {
        zzx.zzci("onAdOpened must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdOpened.");
        try
        {
            zzzL.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationNativeAdapter mediationnativeadapter)
        {
            zzb.zzd("Could not call onAdOpened.", mediationnativeadapter);
        }
    }

    public NativeAdMapper zzeb()
    {
        return zzzM;
    }
}
