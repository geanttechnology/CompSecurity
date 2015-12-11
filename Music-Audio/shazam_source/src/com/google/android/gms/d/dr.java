// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.c;
import com.google.android.gms.b.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            ds, dt, di, dj, 
//            dk

public final class dr extends dh.a
{

    private final MediationAdapter a;
    private final NetworkExtras b;

    public dr(MediationAdapter mediationadapter, NetworkExtras networkextras)
    {
        a = mediationadapter;
        b = networkextras;
    }

    private MediationServerParameters a(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Iterator iterator;
        try
        {
            obj1 = new JSONObject(s);
            obj = new HashMap(((JSONObject) (obj1)).length());
            iterator = ((JSONObject) (obj1)).keys();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        s = ((String) (obj));
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        ((Map) (obj)).put(s, ((JSONObject) (obj1)).getString(s));
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_31;
_L2:
        s = new HashMap(0);
_L3:
        obj1 = a.getServerParametersType();
        obj = null;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj = (MediationServerParameters)((Class) (obj1)).newInstance();
        ((MediationServerParameters) (obj)).load(s);
        return ((MediationServerParameters) (obj));
    }

    public final c a()
    {
        if (!(a instanceof MediationBannerAdapter))
        {
            (new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        c c1;
        try
        {
            c1 = com.google.android.gms.b.d.a(((MediationBannerAdapter)a).getBannerView());
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        return c1;
    }

    public final void a(AdRequestParcel adrequestparcel, String s)
    {
    }

    public final void a(c c1, AdRequestParcel adrequestparcel, String s, a a1, String s1)
    {
    }

    public final void a(c c1, AdRequestParcel adrequestparcel, String s, di di)
    {
        a(c1, adrequestparcel, s, ((String) (null)), di);
    }

    public final void a(c c1, AdRequestParcel adrequestparcel, String s, String s1, di di)
    {
        if (!(a instanceof MediationInterstitialAdapter))
        {
            (new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            s1 = (MediationInterstitialAdapter)a;
            di = new ds(di);
            c1 = (Activity)com.google.android.gms.b.d.a(c1);
            int j = adrequestparcel.g;
            s1.requestInterstitialAd(di, c1, a(s), com.google.android.gms.d.dt.a(adrequestparcel), b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        throw new RemoteException();
    }

    public final void a(c c1, AdRequestParcel adrequestparcel, String s, String s1, di di, NativeAdOptionsParcel nativeadoptionsparcel, List list)
    {
    }

    public final void a(c c1, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, di di)
    {
        a(c1, adsizeparcel, adrequestparcel, s, null, di);
    }

    public final void a(c c1, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, di di)
    {
        if (!(a instanceof MediationBannerAdapter))
        {
            (new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            s1 = (MediationBannerAdapter)a;
            di = new ds(di);
            c1 = (Activity)com.google.android.gms.b.d.a(c1);
            int j = adrequestparcel.g;
            s1.requestBannerAd(di, c1, a(s), com.google.android.gms.d.dt.a(adsizeparcel), com.google.android.gms.d.dt.a(adrequestparcel), b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        throw new RemoteException();
    }

    public final void b()
    {
        if (!(a instanceof MediationInterstitialAdapter))
        {
            (new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            ((MediationInterstitialAdapter)a).showInterstitial();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        throw new RemoteException();
    }

    public final void c()
    {
        try
        {
            a.destroy();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        throw new RemoteException();
    }

    public final void d()
    {
        throw new RemoteException();
    }

    public final void e()
    {
        throw new RemoteException();
    }

    public final void f()
    {
    }

    public final boolean g()
    {
        return true;
    }

    public final dj h()
    {
        return null;
    }

    public final dk i()
    {
        return null;
    }
}
