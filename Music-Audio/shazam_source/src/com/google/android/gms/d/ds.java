// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            di, dt

public final class ds
    implements MediationBannerListener, MediationInterstitialListener
{

    private final di a;

    public ds(di di1)
    {
        a = di1;
    }

    static di a(ds ds1)
    {
        return ds1.a;
    }

    public final void onClick(MediationBannerAdapter mediationbanneradapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).a();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            b.a(5);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter mediationbanneradapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).b();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.b();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            b.a(5);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).b();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.b();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            b.a(5);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter mediationbanneradapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        (new StringBuilder("Adapter called onFailedToReceiveAd with error. ")).append(errorcode);
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable(errorcode) {

                final com.google.ads.AdRequest.ErrorCode a;
                final ds b;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(b).a(com.google.android.gms.d.dt.a(a));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(5);
                    }
                }

            
            {
                b = ds.this;
                a = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            a.a(com.google.android.gms.d.dt.a(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            b.a(5);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter mediationinterstitialadapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        (new StringBuilder("Adapter called onFailedToReceiveAd with error ")).append(errorcode).append(".");
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable(errorcode) {

                final com.google.ads.AdRequest.ErrorCode a;
                final ds b;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(b).a(com.google.android.gms.d.dt.a(a));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(5);
                    }
                }

            
            {
                b = ds.this;
                a = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            a.a(com.google.android.gms.d.dt.a(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            b.a(5);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter mediationbanneradapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).c();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            b.a(5);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).c();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            b.a(5);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter mediationbanneradapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).d();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            b.a(5);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).d();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            b.a(5);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter mediationbanneradapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).e();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.e();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            b.a(5);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        b.a(3);
        m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b())
        {
            b.a(5);
            a.a.post(new Runnable() {

                final ds a;

                public final void run()
                {
                    try
                    {
                        com.google.android.gms.d.ds.a(a).e();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        b.a(5);
                    }
                }

            
            {
                a = ds.this;
                super();
            }
            });
            return;
        }
        try
        {
            a.e();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            b.a(5);
        }
    }
}
