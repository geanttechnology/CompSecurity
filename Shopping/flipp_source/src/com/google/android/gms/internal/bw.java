// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.a.a.a.a;
import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.h;
import com.google.android.gms.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            br, et, bx, v, 
//            by, x, bt

public final class bw extends br
{

    private final b a;
    private final h b;

    public bw(b b1, h h)
    {
        a = b1;
        b = h;
    }

    private e a(String s, int i, String s1)
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
            com.google.android.gms.internal.et.a("Could not get MediationServerParameters.", s);
            throw new RemoteException();
        }
_L4:
        Class class1 = a.b();
        e e1;
        e1 = null;
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        e1 = (e)class1.newInstance();
        e1.a(s);
        if (!(e1 instanceof a))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (a)e1;
        s.b = s1;
        s.c = i;
        return e1;
_L2:
        s = new HashMap(0);
        if (true) goto _L4; else goto _L3
_L3:
        return e1;
    }

    public final com.google.android.gms.a.a a()
    {
        if (!(a instanceof c))
        {
            com.google.android.gms.internal.et.d((new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.a.a a1;
        try
        {
            a1 = d.a(((c)a).c());
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.et.a("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return a1;
    }

    public final void a(com.google.android.gms.a.a a1, v v1, String s, bt bt)
    {
        a(a1, v1, s, null, bt);
    }

    public final void a(com.google.android.gms.a.a a1, v v1, String s, String s1, bt bt)
    {
        if (!(a instanceof com.google.a.a.d))
        {
            com.google.android.gms.internal.et.d((new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.internal.et.a("Requesting interstitial ad from adapter.");
        try
        {
            new bx(bt);
            d.a(a1);
            a(s, v1.g, s1);
            com.google.android.gms.internal.by.a(v1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.a.a a1)
        {
            com.google.android.gms.internal.et.a("Could not request interstitial ad from adapter.", a1);
        }
        throw new RemoteException();
    }

    public final void a(com.google.android.gms.a.a a1, x x1, v v1, String s, bt bt)
    {
        a(a1, x1, v1, s, null, bt);
    }

    public final void a(com.google.android.gms.a.a a1, x x1, v v1, String s, String s1, bt bt)
    {
        if (!(a instanceof c))
        {
            com.google.android.gms.internal.et.d((new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.internal.et.a("Requesting banner ad from adapter.");
        try
        {
            new bx(bt);
            d.a(a1);
            a(s, v1.g, s1);
            new com.google.a.c(com.google.android.gms.ads.a.a(x1.f, x1.c, x1.b));
            com.google.android.gms.internal.by.a(v1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.a.a a1)
        {
            com.google.android.gms.internal.et.a("Could not request banner ad from adapter.", a1);
        }
        throw new RemoteException();
    }

    public final void b()
    {
        if (!(a instanceof com.google.a.a.d))
        {
            com.google.android.gms.internal.et.d((new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        } else
        {
            com.google.android.gms.internal.et.a("Showing interstitial from adapter.");
            return;
        }
    }

    public final void c()
    {
    }
}
