// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobServerParameters;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            ct, bf, v, bg, 
//            bd, x

public final class be extends bc.a
{

    private final MediationAdapter gg;
    private final NetworkExtras gh;

    public be(MediationAdapter mediationadapter, NetworkExtras networkextras)
    {
        gg = mediationadapter;
        gh = networkextras;
    }

    private MediationServerParameters a(String s, int i, String s1)
        throws RemoteException
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            s = new HashMap(jsonobject.length());
            String s2;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); s.put(s2, jsonobject.getString(s2)))
            {
                s2 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.internal.ct.b("Could not get MediationServerParameters.", s);
            throw new RemoteException();
        }
_L4:
        Class class1 = gg.getServerParametersType();
        MediationServerParameters mediationserverparameters;
        mediationserverparameters = null;
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        mediationserverparameters = (MediationServerParameters)class1.newInstance();
        mediationserverparameters.load(s);
        if (!(mediationserverparameters instanceof AdMobServerParameters))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (AdMobServerParameters)mediationserverparameters;
        s.adJson = s1;
        s.tagForChildDirectedTreatment = i;
        return mediationserverparameters;
_L2:
        s = new HashMap(0);
        if (true) goto _L4; else goto _L3
_L3:
        return mediationserverparameters;
    }

    public void a(b b, v v1, String s, bd bd)
        throws RemoteException
    {
        a(b, v1, s, null, bd);
    }

    public void a(b b, v v1, String s, String s1, bd bd)
        throws RemoteException
    {
        if (!(gg instanceof MediationInterstitialAdapter))
        {
            ct.v((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(gg.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        ct.r("Requesting interstitial ad from adapter.");
        try
        {
            ((MediationInterstitialAdapter)gg).requestInterstitialAd(new bf(bd), (Activity)c.b(b), a(s, v1.tagForChildDirectedTreatment, s1), bg.e(v1), gh);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (b b)
        {
            com.google.android.gms.internal.ct.b("Could not request interstitial ad from adapter.", b);
        }
        throw new RemoteException();
    }

    public void a(b b, x x, v v1, String s, bd bd)
        throws RemoteException
    {
        a(b, x, v1, s, null, bd);
    }

    public void a(b b, x x, v v1, String s, String s1, bd bd)
        throws RemoteException
    {
        if (!(gg instanceof MediationBannerAdapter))
        {
            ct.v((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(gg.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        ct.r("Requesting banner ad from adapter.");
        try
        {
            ((MediationBannerAdapter)gg).requestBannerAd(new bf(bd), (Activity)c.b(b), a(s, v1.tagForChildDirectedTreatment, s1), com.google.android.gms.internal.bg.b(x), bg.e(v1), gh);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (b b)
        {
            com.google.android.gms.internal.ct.b("Could not request banner ad from adapter.", b);
        }
        throw new RemoteException();
    }

    public void destroy()
        throws RemoteException
    {
        try
        {
            gg.destroy();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.ct.b("Could not destroy adapter.", throwable);
        }
        throw new RemoteException();
    }

    public b getView()
        throws RemoteException
    {
        if (!(gg instanceof MediationBannerAdapter))
        {
            ct.v((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(gg.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        b b;
        try
        {
            b = c.h(((MediationBannerAdapter)gg).getBannerView());
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.ct.b("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return b;
    }

    public void showInterstitial()
        throws RemoteException
    {
        if (!(gg instanceof MediationInterstitialAdapter))
        {
            ct.v((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(gg.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        ct.r("Showing interstitial from adapter.");
        try
        {
            ((MediationInterstitialAdapter)gg).showInterstitial();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.ct.b("Could not show interstitial from adapter.", throwable);
        }
        throw new RemoteException();
    }
}
