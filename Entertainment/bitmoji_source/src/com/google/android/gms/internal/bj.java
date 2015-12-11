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
//            da, cz, bh, bk

public final class bj
    implements MediationBannerListener, MediationInterstitialListener
{

    private final bh mT;

    public bj(bh bh1)
    {
        mT = bh1;
    }

    static bh a(bj bj1)
    {
        return bj1.mT;
    }

    public void onClick(MediationBannerAdapter mediationbanneradapter)
    {
        da.s("Adapter called onClick.");
        if (!cz.aX())
        {
            da.w("onClick must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).O();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdClicked.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.O();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            da.b("Could not call onAdClicked.", mediationbanneradapter);
        }
    }

    public void onDismissScreen(MediationBannerAdapter mediationbanneradapter)
    {
        da.s("Adapter called onDismissScreen.");
        if (!cz.aX())
        {
            da.w("onDismissScreen must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdClosed.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            da.b("Could not call onAdClosed.", mediationbanneradapter);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        da.s("Adapter called onDismissScreen.");
        if (!cz.aX())
        {
            da.w("onDismissScreen must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdClosed.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            da.b("Could not call onAdClosed.", mediationinterstitialadapter);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter mediationbanneradapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        da.s((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error. ").append(errorcode).toString());
        if (!cz.aX())
        {
            da.w("onFailedToReceiveAd must be called on the main UI thread.");
            cz.pT.post(new Runnable(errorcode) {

                final bj mU;
                final com.google.ads.AdRequest.ErrorCode mV;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdFailedToLoad(bk.a(mV));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdFailedToLoad.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                mV = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdFailedToLoad(bk.a(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            da.b("Could not call onAdFailedToLoad.", mediationbanneradapter);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter mediationinterstitialadapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        da.s((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error ").append(errorcode).append(".").toString());
        if (!cz.aX())
        {
            da.w("onFailedToReceiveAd must be called on the main UI thread.");
            cz.pT.post(new Runnable(errorcode) {

                final bj mU;
                final com.google.ads.AdRequest.ErrorCode mV;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdFailedToLoad(bk.a(mV));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdFailedToLoad.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                mV = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdFailedToLoad(bk.a(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            da.b("Could not call onAdFailedToLoad.", mediationinterstitialadapter);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter mediationbanneradapter)
    {
        da.s("Adapter called onLeaveApplication.");
        if (!cz.aX())
        {
            da.w("onLeaveApplication must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdLeftApplication.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            da.b("Could not call onAdLeftApplication.", mediationbanneradapter);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        da.s("Adapter called onLeaveApplication.");
        if (!cz.aX())
        {
            da.w("onLeaveApplication must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdLeftApplication.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            da.b("Could not call onAdLeftApplication.", mediationinterstitialadapter);
        }
    }

    public void onPresentScreen(MediationBannerAdapter mediationbanneradapter)
    {
        da.s("Adapter called onPresentScreen.");
        if (!cz.aX())
        {
            da.w("onPresentScreen must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdOpened.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            da.b("Could not call onAdOpened.", mediationbanneradapter);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        da.s("Adapter called onPresentScreen.");
        if (!cz.aX())
        {
            da.w("onPresentScreen must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdOpened.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            da.b("Could not call onAdOpened.", mediationinterstitialadapter);
        }
    }

    public void onReceivedAd(MediationBannerAdapter mediationbanneradapter)
    {
        da.s("Adapter called onReceivedAd.");
        if (!cz.aX())
        {
            da.w("onReceivedAd must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdLoaded.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            da.b("Could not call onAdLoaded.", mediationbanneradapter);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        da.s("Adapter called onReceivedAd.");
        if (!cz.aX())
        {
            da.w("onReceivedAd must be called on the main UI thread.");
            cz.pT.post(new Runnable() {

                final bj mU;

                public void run()
                {
                    try
                    {
                        bj.a(mU).onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        da.b("Could not call onAdLoaded.", remoteexception);
                    }
                }

            
            {
                mU = bj.this;
                super();
            }
            });
            return;
        }
        try
        {
            mT.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            da.b("Could not call onAdLoaded.", mediationinterstitialadapter);
        }
    }
}
