// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import pw;
import px;
import py;
import pz;

// Referenced classes of package com.google.android.gms.internal:
//            zzeh, zzen

public final class zzem
    implements px, pz
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

    public void onClick(pw pw)
    {
        zzb.zzay("Adapter called onClick.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onClick must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pw pw)
        {
            zzb.zzd("Could not call onAdClicked.", pw);
        }
    }

    public void onDismissScreen(pw pw)
    {
        zzb.zzay("Adapter called onDismissScreen.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onDismissScreen must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pw pw)
        {
            zzb.zzd("Could not call onAdClosed.", pw);
        }
    }

    public void onDismissScreen(py py)
    {
        zzb.zzay("Adapter called onDismissScreen.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onDismissScreen must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (py py)
        {
            zzb.zzd("Could not call onAdClosed.", py);
        }
    }

    public void onFailedToReceiveAd(pw pw, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzb.zzay((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error. ").append(errorcode).toString());
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzGF.post(new Runnable(errorcode) {

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

            
            {
                zzyj = zzem.this;
                zzyk = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdFailedToLoad(com.google.android.gms.internal.zzen.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pw pw)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", pw);
        }
    }

    public void onFailedToReceiveAd(py py, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzb.zzay((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error ").append(errorcode).append(".").toString());
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzGF.post(new Runnable(errorcode) {

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

            
            {
                zzyj = zzem.this;
                zzyk = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdFailedToLoad(com.google.android.gms.internal.zzen.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (py py)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", py);
        }
    }

    public void onLeaveApplication(pw pw)
    {
        zzb.zzay("Adapter called onLeaveApplication.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onLeaveApplication must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pw pw)
        {
            zzb.zzd("Could not call onAdLeftApplication.", pw);
        }
    }

    public void onLeaveApplication(py py)
    {
        zzb.zzay("Adapter called onLeaveApplication.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onLeaveApplication must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (py py)
        {
            zzb.zzd("Could not call onAdLeftApplication.", py);
        }
    }

    public void onPresentScreen(pw pw)
    {
        zzb.zzay("Adapter called onPresentScreen.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onPresentScreen must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pw pw)
        {
            zzb.zzd("Could not call onAdOpened.", pw);
        }
    }

    public void onPresentScreen(py py)
    {
        zzb.zzay("Adapter called onPresentScreen.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onPresentScreen must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (py py)
        {
            zzb.zzd("Could not call onAdOpened.", py);
        }
    }

    public void onReceivedAd(pw pw)
    {
        zzb.zzay("Adapter called onReceivedAd.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onReceivedAd must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pw pw)
        {
            zzb.zzd("Could not call onAdLoaded.", pw);
        }
    }

    public void onReceivedAd(py py)
    {
        zzb.zzay("Adapter called onReceivedAd.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onReceivedAd must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

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

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (py py)
        {
            zzb.zzd("Could not call onAdLoaded.", py);
        }
    }
}
