// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class wp extends wh
{

    private final oz a;

    public wp(oz oz1)
    {
        a = oz1;
    }

    private Bundle a(String s, int i, String s1)
    {
        Bundle bundle;
        acb.e((new StringBuilder()).append("Server parameters: ").append(s).toString());
        Iterator iterator;
        String s2;
        try
        {
            bundle = new Bundle();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            acb.d("Could not get Server Parameters Bundle.", s);
            throw new RemoteException();
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        s = new JSONObject(s);
        bundle = new Bundle();
        for (iterator = s.keys(); iterator.hasNext(); bundle.putString(s2, s.getString(s2)))
        {
            s2 = (String)iterator.next();
        }

        if (a instanceof oi)
        {
            bundle.putString("adJson", s1);
            bundle.putInt("tagForChildDirectedTreatment", i);
        }
        return bundle;
    }

    public ry a()
    {
        if (!(a instanceof pa))
        {
            acb.e((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        ry ry;
        try
        {
            ry = sb.a(((pa)a).d());
        }
        catch (Throwable throwable)
        {
            acb.d("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return ry;
    }

    public void a(ry ry, av av1, String s, String s1, wl wl)
    {
        if (!(a instanceof pc))
        {
            acb.e((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        acb.a("Requesting interstitial ad from adapter.");
        pc pc1 = (pc)a;
        if (av1.e == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(av1.e);
_L5:
        wo wo1 = new wo(new Date(av1.b), av1.d, ((java.util.Set) (obj)), av1.k, av1.f, av1.g);
        if (av1.m == null) goto _L4; else goto _L3
_L3:
        obj = av1.m.getBundle(pc1.getClass().getName());
_L6:
        pc1.a((Context)sb.a(ry), new wq(wl), a(s, av1.g, s1), wo1, ((Bundle) (obj)));
        return;
_L2:
        obj = null;
          goto _L5
_L4:
        obj = null;
          goto _L6
        ry;
        acb.d("Could not request interstitial ad from adapter.", ry);
        throw new RemoteException();
          goto _L5
    }

    public void a(ry ry, av av1, String s, wl wl)
    {
        a(ry, av1, s, null, wl);
    }

    public void a(ry ry, ay ay1, av av1, String s, String s1, wl wl)
    {
        Object obj1;
        obj1 = null;
        if (!(a instanceof pa))
        {
            acb.e((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        acb.a("Requesting banner ad from adapter.");
        Object obj;
        pa pa1;
        pa1 = (pa)a;
        if (av1.e == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj = new HashSet(av1.e);
_L1:
        wo wo1 = new wo(new Date(av1.b), av1.d, ((java.util.Set) (obj)), av1.k, av1.f, av1.g);
        obj = obj1;
        try
        {
            if (av1.m != null)
            {
                obj = av1.m.getBundle(pa1.getClass().getName());
            }
            pa1.a((Context)sb.a(ry), new wq(wl), a(s, av1.g, s1), oq.a(ay1.f, ay1.c, ay1.b), wo1, ((Bundle) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ry ry)
        {
            acb.d("Could not request banner ad from adapter.", ry);
        }
        break MISSING_BLOCK_LABEL_220;
        obj = null;
          goto _L1
        throw new RemoteException();
    }

    public void a(ry ry, ay ay1, av av1, String s, wl wl)
    {
        a(ry, ay1, av1, s, null, wl);
    }

    public void b()
    {
        if (!(a instanceof pc))
        {
            acb.e((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        acb.a("Showing interstitial from adapter.");
        try
        {
            ((pc)a).e();
            return;
        }
        catch (Throwable throwable)
        {
            acb.d("Could not show interstitial from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void c()
    {
        try
        {
            a.a();
            return;
        }
        catch (Throwable throwable)
        {
            acb.d("Could not destroy adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void d()
    {
        try
        {
            a.b();
            return;
        }
        catch (Throwable throwable)
        {
            acb.d("Could not pause adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void e()
    {
        try
        {
            a.c();
            return;
        }
        catch (Throwable throwable)
        {
            acb.d("Could not resume adapter.", throwable);
        }
        throw new RemoteException();
    }
}
