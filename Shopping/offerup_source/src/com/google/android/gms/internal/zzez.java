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
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzeo, zzfa

public final class zzez
    implements MediationBannerListener, MediationInterstitialListener
{

    private final zzeo zzzL;

    public zzez(zzeo zzeo1)
    {
        zzzL = zzeo1;
    }

    static zzeo zza(zzez zzez1)
    {
        return zzez1.zzzL;
    }

    public final void onClick(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaF("Adapter called onClick.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onClick must be called on the main UI thread.");
            zza.zzJt.post(new _cls1());
            return;
        }
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

    public final void onDismissScreen(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaF("Adapter called onDismissScreen.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onDismissScreen must be called on the main UI thread.");
            zza.zzJt.post(new _cls4());
            return;
        }
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

    public final void onDismissScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzb.zzaF("Adapter called onDismissScreen.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onDismissScreen must be called on the main UI thread.");
            zza.zzJt.post(new _cls9());
            return;
        }
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

    public final void onFailedToReceiveAd(MediationBannerAdapter mediationbanneradapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzb.zzaF((new StringBuilder("Adapter called onFailedToReceiveAd with error. ")).append(errorcode).toString());
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzJt.post(new _cls5(errorcode));
            return;
        }
        try
        {
            zzzL.onAdFailedToLoad(com.google.android.gms.internal.zzfa.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", mediationbanneradapter);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter mediationinterstitialadapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzb.zzaF((new StringBuilder("Adapter called onFailedToReceiveAd with error ")).append(errorcode).append(".").toString());
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzJt.post(new _cls10(errorcode));
            return;
        }
        try
        {
            zzzL.onAdFailedToLoad(com.google.android.gms.internal.zzfa.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", mediationinterstitialadapter);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaF("Adapter called onLeaveApplication.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onLeaveApplication must be called on the main UI thread.");
            zza.zzJt.post(new _cls6());
            return;
        }
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

    public final void onLeaveApplication(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzb.zzaF("Adapter called onLeaveApplication.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onLeaveApplication must be called on the main UI thread.");
            zza.zzJt.post(new _cls11());
            return;
        }
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

    public final void onPresentScreen(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaF("Adapter called onPresentScreen.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onPresentScreen must be called on the main UI thread.");
            zza.zzJt.post(new _cls7());
            return;
        }
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

    public final void onPresentScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzb.zzaF("Adapter called onPresentScreen.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onPresentScreen must be called on the main UI thread.");
            zza.zzJt.post(new _cls2());
            return;
        }
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

    public final void onReceivedAd(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzaF("Adapter called onReceivedAd.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onReceivedAd must be called on the main UI thread.");
            zza.zzJt.post(new _cls8());
            return;
        }
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

    public final void onReceivedAd(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzb.zzaF("Adapter called onReceivedAd.");
        if (!zzl.zzcF().zzgT())
        {
            zzb.zzaH("onReceivedAd must be called on the main UI thread.");
            zza.zzJt.post(new _cls3());
            return;
        }
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

    private class _cls1
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdClicked();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdClicked.", remoteexception);
            }
        }

        _cls1()
        {
            zzzR = zzez.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdClosed();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdClosed.", remoteexception);
            }
        }

        _cls4()
        {
            zzzR = zzez.this;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdClosed();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdClosed.", remoteexception);
            }
        }

        _cls9()
        {
            zzzR = zzez.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final zzez zzzR;
        final com.google.ads.AdRequest.ErrorCode zzzS;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdFailedToLoad(com.google.android.gms.internal.zzfa.zza(zzzS));
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdFailedToLoad.", remoteexception);
            }
        }

        _cls5(com.google.ads.AdRequest.ErrorCode errorcode)
        {
            zzzR = zzez.this;
            zzzS = errorcode;
            super();
        }
    }


    private class _cls10
        implements Runnable
    {

        final zzez zzzR;
        final com.google.ads.AdRequest.ErrorCode zzzS;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdFailedToLoad(com.google.android.gms.internal.zzfa.zza(zzzS));
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdFailedToLoad.", remoteexception);
            }
        }

        _cls10(com.google.ads.AdRequest.ErrorCode errorcode)
        {
            zzzR = zzez.this;
            zzzS = errorcode;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdLeftApplication();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdLeftApplication.", remoteexception);
            }
        }

        _cls6()
        {
            zzzR = zzez.this;
            super();
        }
    }


    private class _cls11
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdLeftApplication();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdLeftApplication.", remoteexception);
            }
        }

        _cls11()
        {
            zzzR = zzez.this;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdOpened();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdOpened.", remoteexception);
            }
        }

        _cls7()
        {
            zzzR = zzez.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdOpened();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdOpened.", remoteexception);
            }
        }

        _cls2()
        {
            zzzR = zzez.this;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdLoaded();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdLoaded.", remoteexception);
            }
        }

        _cls8()
        {
            zzzR = zzez.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final zzez zzzR;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzez.zza(zzzR).onAdLoaded();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdLoaded.", remoteexception);
            }
        }

        _cls3()
        {
            zzzR = zzez.this;
            super();
        }
    }

}
