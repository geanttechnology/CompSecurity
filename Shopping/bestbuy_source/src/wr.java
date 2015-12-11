// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class wr extends wh
{

    private final nz a;
    private final oh b;

    public wr(nz nz1, oh oh)
    {
        a = nz1;
        b = oh;
    }

    private oe a(String s, int i, String s1)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        try
        {
            obj = new JSONObject(s);
            s1 = new HashMap(((JSONObject) (obj)).length());
            iterator = ((JSONObject) (obj)).keys();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            acb.d("Could not get MediationServerParameters.", s);
            throw new RemoteException();
        }
        s = s1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        s1.put(s, ((JSONObject) (obj)).getString(s));
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_34;
_L2:
        s = new HashMap(0);
_L3:
        obj = a.c();
        s1 = null;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s1 = (oe)((Class) (obj)).newInstance();
        s1.a(s);
        return s1;
    }

    public ry a()
    {
        if (!(a instanceof oa))
        {
            acb.e((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        ry ry;
        try
        {
            ry = sb.a(((oa)a).d());
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
        if (!(a instanceof oc))
        {
            acb.e((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        acb.a("Requesting interstitial ad from adapter.");
        try
        {
            ((oc)a).a(new ws(wl), (Activity)sb.a(ry), a(s, av1.g, s1), wt.a(av1), b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ry ry)
        {
            acb.d("Could not request interstitial ad from adapter.", ry);
        }
        throw new RemoteException();
    }

    public void a(ry ry, av av1, String s, wl wl)
    {
        a(ry, av1, s, null, wl);
    }

    public void a(ry ry, ay ay, av av1, String s, String s1, wl wl)
    {
        if (!(a instanceof oa))
        {
            acb.e((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        acb.a("Requesting banner ad from adapter.");
        try
        {
            ((oa)a).a(new ws(wl), (Activity)sb.a(ry), a(s, av1.g, s1), wt.a(ay), wt.a(av1), b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ry ry)
        {
            acb.d("Could not request banner ad from adapter.", ry);
        }
        throw new RemoteException();
    }

    public void a(ry ry, ay ay, av av1, String s, wl wl)
    {
        a(ry, ay, av1, s, null, wl);
    }

    public void b()
    {
        if (!(a instanceof oc))
        {
            acb.e((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        acb.a("Showing interstitial from adapter.");
        try
        {
            ((oc)a).d();
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
        throw new RemoteException();
    }

    public void e()
    {
        throw new RemoteException();
    }
}
