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

// Referenced classes of package com.google.android.gms.internal:
//            ct, cs, bd, bg

public final class bf
    implements MediationBannerListener, MediationInterstitialListener
{

    private final bd gi;

    public bf(bd bd1)
    {
        gi = bd1;
    }

    static bd a(bf bf1)
    {
        return bf1.gi;
    }

    public void onClick(MediationBannerAdapter mediationbanneradapter)
    {
        ct.r("Adapter called onClick.");
        if (!cs.ay())
        {
            ct.v("onClick must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).w();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdClicked.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.w();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            ct.b("Could not call onAdClicked.", mediationbanneradapter);
        }
    }

    public void onDismissScreen(MediationBannerAdapter mediationbanneradapter)
    {
        ct.r("Adapter called onDismissScreen.");
        if (!cs.ay())
        {
            ct.v("onDismissScreen must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdClosed.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            ct.b("Could not call onAdClosed.", mediationbanneradapter);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        ct.r("Adapter called onDismissScreen.");
        if (!cs.ay())
        {
            ct.v("onDismissScreen must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdClosed.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            ct.b("Could not call onAdClosed.", mediationinterstitialadapter);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter mediationbanneradapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        ct.r((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error. ").append(errorcode).toString());
        if (!cs.ay())
        {
            ct.v("onFailedToReceiveAd must be called on the main UI thread.");
            cs.iI.post(new Runnable(errorcode) {

                final bf gj;
                final com.google.ads.AdRequest.ErrorCode gk;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdFailedToLoad(bg.a(gk));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdFailedToLoad.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                gk = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdFailedToLoad(bg.a(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            ct.b("Could not call onAdFailedToLoad.", mediationbanneradapter);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter mediationinterstitialadapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        ct.r((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error ").append(errorcode).append(".").toString());
        if (!cs.ay())
        {
            ct.v("onFailedToReceiveAd must be called on the main UI thread.");
            cs.iI.post(new Runnable(errorcode) {

                final bf gj;
                final com.google.ads.AdRequest.ErrorCode gk;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdFailedToLoad(bg.a(gk));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdFailedToLoad.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                gk = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdFailedToLoad(bg.a(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            ct.b("Could not call onAdFailedToLoad.", mediationinterstitialadapter);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter mediationbanneradapter)
    {
        ct.r("Adapter called onLeaveApplication.");
        if (!cs.ay())
        {
            ct.v("onLeaveApplication must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdLeftApplication.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            ct.b("Could not call onAdLeftApplication.", mediationbanneradapter);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        ct.r("Adapter called onLeaveApplication.");
        if (!cs.ay())
        {
            ct.v("onLeaveApplication must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdLeftApplication.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            ct.b("Could not call onAdLeftApplication.", mediationinterstitialadapter);
        }
    }

    public void onPresentScreen(MediationBannerAdapter mediationbanneradapter)
    {
        ct.r("Adapter called onPresentScreen.");
        if (!cs.ay())
        {
            ct.v("onPresentScreen must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdOpened.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            ct.b("Could not call onAdOpened.", mediationbanneradapter);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        ct.r("Adapter called onPresentScreen.");
        if (!cs.ay())
        {
            ct.v("onPresentScreen must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdOpened.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            ct.b("Could not call onAdOpened.", mediationinterstitialadapter);
        }
    }

    public void onReceivedAd(MediationBannerAdapter mediationbanneradapter)
    {
        ct.r("Adapter called onReceivedAd.");
        if (!cs.ay())
        {
            ct.v("onReceivedAd must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdLoaded.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            ct.b("Could not call onAdLoaded.", mediationbanneradapter);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        ct.r("Adapter called onReceivedAd.");
        if (!cs.ay())
        {
            ct.v("onReceivedAd must be called on the main UI thread.");
            cs.iI.post(new Runnable() {

                final bf gj;

                public void run()
                {
                    try
                    {
                        bf.a(gj).onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not call onAdLoaded.", remoteexception);
                    }
                }

            
            {
                gj = bf.this;
                super();
            }
            });
            return;
        }
        try
        {
            gi.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            ct.b("Could not call onAdLoaded.", mediationinterstitialadapter);
        }
    }
}
