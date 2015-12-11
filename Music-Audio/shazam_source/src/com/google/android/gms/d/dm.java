// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.c.c;
import com.google.android.gms.ads.c.e;
import com.google.android.gms.ads.c.h;
import com.google.android.gms.ads.c.i;
import com.google.android.gms.ads.c.l;
import com.google.android.gms.ads.d.a.a;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.d;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            dl, dn, dq, do, 
//            dp, di, dj, dk

public final class dm extends dh.a
{

    private final com.google.android.gms.ads.c.b a;
    private dn b;

    public dm(com.google.android.gms.ads.c.b b1)
    {
        a = b1;
    }

    private Bundle a(String s, int j, String s1)
    {
        Bundle bundle;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        Iterator iterator;
        String s2;
        try
        {
            bundle = new Bundle();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = new JSONObject(s);
        bundle = new Bundle();
        for (iterator = s.keys(); iterator.hasNext(); bundle.putString(s2, s.getString(s2)))
        {
            s2 = (String)iterator.next();
        }

        if (a instanceof AdMobAdapter)
        {
            bundle.putString("adJson", s1);
            bundle.putInt("tagForChildDirectedTreatment", j);
        }
        return bundle;
    }

    public final com.google.android.gms.b.c a()
    {
        if (!(a instanceof c))
        {
            (new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.b.c c1;
        try
        {
            c1 = com.google.android.gms.b.d.a(((c)a).getBannerView());
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
        Date date;
        date = null;
        if (!(a instanceof a))
        {
            (new StringBuilder("MediationAdapter is not a MediationRewardedVideoAdAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        a a1 = (a)a;
        if (adrequestparcel.e == null) goto _L2; else goto _L1
_L1:
        HashSet hashset = new HashSet(adrequestparcel.e);
_L4:
        if (adrequestparcel.b != -1L)
        {
            try
            {
                date = new Date(adrequestparcel.b);
            }
            // Misplaced declaration of an exception variable
            catch (AdRequestParcel adrequestparcel)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                throw new RemoteException();
            }
        }
        new dl(date, adrequestparcel.d, hashset, adrequestparcel.k, adrequestparcel.f, adrequestparcel.g);
        if (adrequestparcel.m != null)
        {
            adrequestparcel.m.getBundle(a1.getClass().getName());
        }
        a(s, adrequestparcel.g, null);
        return;
_L2:
        hashset = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(com.google.android.gms.b.c c1, AdRequestParcel adrequestparcel, String s, com.google.android.gms.ads.internal.reward.mediation.client.a a1, String s1)
    {
        if (!(a instanceof a))
        {
            (new StringBuilder("MediationAdapter is not a MediationRewardedVideoAdAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        a a2;
        a2 = (a)a;
        if (adrequestparcel.e == null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        Date date;
        for (s = new HashSet(adrequestparcel.e); adrequestparcel.b == -1L; s = null)
        {
            date = null;
            break MISSING_BLOCK_LABEL_93;
        }

        date = new Date(adrequestparcel.b);
        try
        {
            new dl(date, adrequestparcel.d, s, adrequestparcel.k, adrequestparcel.f, adrequestparcel.g);
            if (adrequestparcel.m != null)
            {
                adrequestparcel.m.getBundle(a2.getClass().getName());
            }
            com.google.android.gms.b.d.a(c1);
            new com.google.android.gms.ads.internal.reward.mediation.client.b(a1);
            a(s1, adrequestparcel.g, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.b.c c1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        throw new RemoteException();
    }

    public final void a(com.google.android.gms.b.c c1, AdRequestParcel adrequestparcel, String s, di di)
    {
        a(c1, adrequestparcel, s, ((String) (null)), di);
    }

    public final void a(com.google.android.gms.b.c c1, AdRequestParcel adrequestparcel, String s, String s1, di di)
    {
        if (!(a instanceof e))
        {
            (new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        e e1 = (e)a;
        if (adrequestparcel.e == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.e);
_L5:
        Object obj1;
        if (adrequestparcel.b == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.b);
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.b.c c1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                throw new RemoteException();
            }
        }
        obj1 = new dl(((Date) (obj1)), adrequestparcel.d, ((java.util.Set) (obj)), adrequestparcel.k, adrequestparcel.f, adrequestparcel.g);
        if (adrequestparcel.m == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        obj = adrequestparcel.m.getBundle(e1.getClass().getName());
_L3:
        e1.requestInterstitialAd((Context)com.google.android.gms.b.d.a(c1), new dn(di), a(s, adrequestparcel.g, s1), ((com.google.android.gms.ads.c.a) (obj1)), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a(com.google.android.gms.b.c c1, AdRequestParcel adrequestparcel, String s, String s1, di di, NativeAdOptionsParcel nativeadoptionsparcel, List list)
    {
        if (!(a instanceof l))
        {
            (new StringBuilder("MediationAdapter is not a MediationNativeAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        l l1 = (l)a;
        if (adrequestparcel.e == null) goto _L2; else goto _L1
_L1:
        HashSet hashset = new HashSet(adrequestparcel.e);
_L5:
        Date date;
        if (adrequestparcel.b == -1L)
        {
            date = null;
        } else
        {
            try
            {
                date = new Date(adrequestparcel.b);
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.b.c c1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                throw new RemoteException();
            }
        }
        list = new dq(date, adrequestparcel.d, hashset, adrequestparcel.k, adrequestparcel.f, adrequestparcel.g, nativeadoptionsparcel, list);
        if (adrequestparcel.m == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        nativeadoptionsparcel = adrequestparcel.m.getBundle(l1.getClass().getName());
_L3:
        b = new dn(di);
        l1.requestNativeAd((Context)com.google.android.gms.b.d.a(c1), b, a(s, adrequestparcel.g, s1), list, nativeadoptionsparcel);
        return;
        nativeadoptionsparcel = null;
          goto _L3
_L2:
        hashset = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a(com.google.android.gms.b.c c1, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, di di)
    {
        a(c1, adsizeparcel, adrequestparcel, s, null, di);
    }

    public final void a(com.google.android.gms.b.c c1, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, di di)
    {
        if (!(a instanceof c))
        {
            (new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        c c2 = (c)a;
        if (adrequestparcel.e == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.e);
_L5:
        Object obj1;
        if (adrequestparcel.b == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.b);
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.b.c c1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                throw new RemoteException();
            }
        }
        obj1 = new dl(((Date) (obj1)), adrequestparcel.d, ((java.util.Set) (obj)), adrequestparcel.k, adrequestparcel.f, adrequestparcel.g);
        if (adrequestparcel.m == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        obj = adrequestparcel.m.getBundle(c2.getClass().getName());
_L3:
        c2.requestBannerAd((Context)com.google.android.gms.b.d.a(c1), new dn(di), a(s, adrequestparcel.g, s1), com.google.android.gms.ads.g.a(adsizeparcel.f, adsizeparcel.c, adsizeparcel.b), ((com.google.android.gms.ads.c.a) (obj1)), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void b()
    {
        if (!(a instanceof e))
        {
            (new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            ((e)a).showInterstitial();
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
            a.onDestroy();
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
        try
        {
            a.onPause();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        throw new RemoteException();
    }

    public final void e()
    {
        try
        {
            a.onResume();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        throw new RemoteException();
    }

    public final void f()
    {
        if (!(a instanceof a))
        {
            (new StringBuilder("MediationAdapter is not a MediationRewardedVideoAdAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            return;
        }
    }

    public final boolean g()
    {
        if (!(a instanceof a))
        {
            (new StringBuilder("MediationAdapter is not a MediationRewardedVideoAdAdapter: ")).append(a.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        boolean flag;
        try
        {
            flag = ((a)a).a();
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            throw new RemoteException();
        }
        return flag;
    }

    public final dj h()
    {
        com.google.android.gms.ads.c.g g1 = b.a;
        if (g1 instanceof h)
        {
            return new do((h)g1);
        } else
        {
            return null;
        }
    }

    public final dk i()
    {
        com.google.android.gms.ads.c.g g1 = b.a;
        if (g1 instanceof i)
        {
            return new dp((i)g1);
        } else
        {
            return null;
        }
    }
}
