// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import aze;
import azf;
import azg;
import azh;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzeh, zzen

public final class zzem
    implements azf, azh
{

    private final zzeh zzyg;

    public zzem(zzeh zzeh1)
    {
        zzyg = zzeh1;
    }

    static zzeh zza(zzem zzem1)
    {
        return zzem1.zzyg;
    }

    public void onClick(aze aze)
    {
        zzb.zzay("Adapter called onClick.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onClick must be called on the main UI thread.");
            zza.zzGF.post(new _cls1());
            return;
        }
        try
        {
            zzyg.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aze aze)
        {
            zzb.zzd("Could not call onAdClicked.", aze);
        }
    }

    public void onDismissScreen(aze aze)
    {
        zzb.zzay("Adapter called onDismissScreen.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onDismissScreen must be called on the main UI thread.");
            zza.zzGF.post(new _cls4());
            return;
        }
        try
        {
            zzyg.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aze aze)
        {
            zzb.zzd("Could not call onAdClosed.", aze);
        }
    }

    public void onDismissScreen(azg azg)
    {
        zzb.zzay("Adapter called onDismissScreen.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onDismissScreen must be called on the main UI thread.");
            zza.zzGF.post(new _cls9());
            return;
        }
        try
        {
            zzyg.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (azg azg)
        {
            zzb.zzd("Could not call onAdClosed.", azg);
        }
    }

    public void onFailedToReceiveAd(aze aze, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzb.zzay((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error. ").append(errorcode).toString());
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzGF.post(new _cls5(errorcode));
            return;
        }
        try
        {
            zzyg.onAdFailedToLoad(com.google.android.gms.internal.zzen.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aze aze)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", aze);
        }
    }

    public void onFailedToReceiveAd(azg azg, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzb.zzay((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error ").append(errorcode).append(".").toString());
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzGF.post(new _cls10(errorcode));
            return;
        }
        try
        {
            zzyg.onAdFailedToLoad(com.google.android.gms.internal.zzen.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (azg azg)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", azg);
        }
    }

    public void onLeaveApplication(aze aze)
    {
        zzb.zzay("Adapter called onLeaveApplication.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onLeaveApplication must be called on the main UI thread.");
            zza.zzGF.post(new _cls6());
            return;
        }
        try
        {
            zzyg.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aze aze)
        {
            zzb.zzd("Could not call onAdLeftApplication.", aze);
        }
    }

    public void onLeaveApplication(azg azg)
    {
        zzb.zzay("Adapter called onLeaveApplication.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onLeaveApplication must be called on the main UI thread.");
            zza.zzGF.post(new _cls11());
            return;
        }
        try
        {
            zzyg.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (azg azg)
        {
            zzb.zzd("Could not call onAdLeftApplication.", azg);
        }
    }

    public void onPresentScreen(aze aze)
    {
        zzb.zzay("Adapter called onPresentScreen.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onPresentScreen must be called on the main UI thread.");
            zza.zzGF.post(new _cls7());
            return;
        }
        try
        {
            zzyg.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aze aze)
        {
            zzb.zzd("Could not call onAdOpened.", aze);
        }
    }

    public void onPresentScreen(azg azg)
    {
        zzb.zzay("Adapter called onPresentScreen.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onPresentScreen must be called on the main UI thread.");
            zza.zzGF.post(new _cls2());
            return;
        }
        try
        {
            zzyg.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (azg azg)
        {
            zzb.zzd("Could not call onAdOpened.", azg);
        }
    }

    public void onReceivedAd(aze aze)
    {
        zzb.zzay("Adapter called onReceivedAd.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onReceivedAd must be called on the main UI thread.");
            zza.zzGF.post(new _cls8());
            return;
        }
        try
        {
            zzyg.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aze aze)
        {
            zzb.zzd("Could not call onAdLoaded.", aze);
        }
    }

    public void onReceivedAd(azg azg)
    {
        zzb.zzay("Adapter called onReceivedAd.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onReceivedAd must be called on the main UI thread.");
            zza.zzGF.post(new _cls3());
            return;
        }
        try
        {
            zzyg.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (azg azg)
        {
            zzb.zzd("Could not call onAdLoaded.", azg);
        }
    }

    private class _cls1
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdClicked();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdClicked.", remoteexception);
            }
        }

        _cls1()
        {
            zzyj = zzem.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdClosed();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdClosed.", remoteexception);
            }
        }

        _cls4()
        {
            zzyj = zzem.this;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdClosed();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdClosed.", remoteexception);
            }
        }

        _cls9()
        {
            zzyj = zzem.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final zzem zzyj;
        final com.google.ads.AdRequest.ErrorCode zzyk;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdFailedToLoad(com.google.android.gms.internal.zzen.zza(zzyk));
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdFailedToLoad.", remoteexception);
            }
        }

        _cls5(com.google.ads.AdRequest.ErrorCode errorcode)
        {
            zzyj = zzem.this;
            zzyk = errorcode;
            super();
        }
    }


    private class _cls10
        implements Runnable
    {

        final zzem zzyj;
        final com.google.ads.AdRequest.ErrorCode zzyk;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdFailedToLoad(com.google.android.gms.internal.zzen.zza(zzyk));
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdFailedToLoad.", remoteexception);
            }
        }

        _cls10(com.google.ads.AdRequest.ErrorCode errorcode)
        {
            zzyj = zzem.this;
            zzyk = errorcode;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdLeftApplication();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdLeftApplication.", remoteexception);
            }
        }

        _cls6()
        {
            zzyj = zzem.this;
            super();
        }
    }


    private class _cls11
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdLeftApplication();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdLeftApplication.", remoteexception);
            }
        }

        _cls11()
        {
            zzyj = zzem.this;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdOpened();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdOpened.", remoteexception);
            }
        }

        _cls7()
        {
            zzyj = zzem.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdOpened();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdOpened.", remoteexception);
            }
        }

        _cls2()
        {
            zzyj = zzem.this;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdLoaded();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdLoaded.", remoteexception);
            }
        }

        _cls8()
        {
            zzyj = zzem.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final zzem zzyj;

        public void run()
        {
            try
            {
                com.google.android.gms.internal.zzem.zza(zzyj).onAdLoaded();
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call onAdLoaded.", remoteexception);
            }
        }

        _cls3()
        {
            zzyj = zzem.this;
            super();
        }
    }

}
