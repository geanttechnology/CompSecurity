// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.a.a.f;
import com.google.a.a.g;
import com.google.a.a.h;
import com.google.a.a.i;
import com.google.a.b;
import com.google.android.gms.ads.internal.client.zzj;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzct, zzcz

public final class zzcy
    implements g, i
{

    private final zzct zzvb;

    public zzcy(zzct zzct1)
    {
        zzvb = zzct1;
    }

    static zzct zza(zzcy zzcy1)
    {
        return zzcy1.zzvb;
    }

    public void onClick(f f)
    {
        zzb.zzaj("Adapter called onClick.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onClick must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdClicked();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdClicked.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f)
        {
            zzb.zzd("Could not call onAdClicked.", f);
        }
    }

    public void onDismissScreen(f f)
    {
        zzb.zzaj("Adapter called onDismissScreen.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onDismissScreen must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdClosed.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f)
        {
            zzb.zzd("Could not call onAdClosed.", f);
        }
    }

    public void onDismissScreen(h h)
    {
        zzb.zzaj("Adapter called onDismissScreen.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onDismissScreen must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdClosed.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            zzb.zzd("Could not call onAdClosed.", h);
        }
    }

    public void onFailedToReceiveAd(f f, b b)
    {
        zzb.zzaj((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error. ").append(b).toString());
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzCH.post(new Runnable(b) {

                final zzcy zzve;
                final b zzvf;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdFailedToLoad(com.google.android.gms.internal.zzcz.zza(zzvf));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdFailedToLoad.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                zzvf = b;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdFailedToLoad(com.google.android.gms.internal.zzcz.zza(b));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", f);
        }
    }

    public void onFailedToReceiveAd(h h, b b)
    {
        zzb.zzaj((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error ").append(b).append(".").toString());
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzCH.post(new Runnable(b) {

                final zzcy zzve;
                final b zzvf;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdFailedToLoad(com.google.android.gms.internal.zzcz.zza(zzvf));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdFailedToLoad.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                zzvf = b;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdFailedToLoad(com.google.android.gms.internal.zzcz.zza(b));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", h);
        }
    }

    public void onLeaveApplication(f f)
    {
        zzb.zzaj("Adapter called onLeaveApplication.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onLeaveApplication must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdLeftApplication.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f)
        {
            zzb.zzd("Could not call onAdLeftApplication.", f);
        }
    }

    public void onLeaveApplication(h h)
    {
        zzb.zzaj("Adapter called onLeaveApplication.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onLeaveApplication must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdLeftApplication.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            zzb.zzd("Could not call onAdLeftApplication.", h);
        }
    }

    public void onPresentScreen(f f)
    {
        zzb.zzaj("Adapter called onPresentScreen.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onPresentScreen must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdOpened.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f)
        {
            zzb.zzd("Could not call onAdOpened.", f);
        }
    }

    public void onPresentScreen(h h)
    {
        zzb.zzaj("Adapter called onPresentScreen.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onPresentScreen must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdOpened.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            zzb.zzd("Could not call onAdOpened.", h);
        }
    }

    public void onReceivedAd(f f)
    {
        zzb.zzaj("Adapter called onReceivedAd.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onReceivedAd must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdLoaded.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f)
        {
            zzb.zzd("Could not call onAdLoaded.", f);
        }
    }

    public void onReceivedAd(h h)
    {
        zzb.zzaj("Adapter called onReceivedAd.");
        if (!zzj.zzbJ().zzfk())
        {
            zzb.zzan("onReceivedAd must be called on the main UI thread.");
            zza.zzCH.post(new Runnable() {

                final zzcy zzve;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzcy.zza(zzve).onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdLoaded.", remoteexception);
                    }
                }

            
            {
                zzve = zzcy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzvb.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            zzb.zzd("Could not call onAdLoaded.", h);
        }
    }
}
