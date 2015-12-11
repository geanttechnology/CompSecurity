// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.a.e;
import com.google.android.gms.ads.internal.d;
import com.google.android.gms.ads.internal.k;
import com.google.android.gms.ads.internal.overlay.l;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.bj;
import com.google.android.gms.d.cc;
import com.google.android.gms.d.df;
import com.google.android.gms.d.er;
import com.google.android.gms.d.ev;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            j, f, t, e, 
//            m, AdSizeParcel, h, l, 
//            z, a

public final class ab
{

    private final df a;
    private final Context b;
    private final j c;
    private com.google.android.gms.ads.a d;
    private com.google.android.gms.ads.internal.client.a e;
    private t f;
    private String g;
    private String h;
    private com.google.android.gms.ads.a.a i;
    private com.google.android.gms.ads.purchase.b j;
    private com.google.android.gms.ads.purchase.a k;
    private e l;
    private com.google.android.gms.ads.a.b m;

    public ab(Context context)
    {
        this(context, com.google.android.gms.ads.internal.client.j.a(), null);
    }

    public ab(Context context, e e1)
    {
        this(context, com.google.android.gms.ads.internal.client.j.a(), e1);
    }

    private ab(Context context, j j1, e e1)
    {
        a = new df();
        b = context;
        c = j1;
        l = e1;
    }

    private void b(String s)
    {
        if (f == null)
        {
            throw new IllegalStateException((new StringBuilder("The ad unit ID must be set on InterstitialAd before ")).append(s).append(" is called.").toString());
        } else
        {
            return;
        }
    }

    public final void a(com.google.android.gms.ads.a a1)
    {
        d = a1;
        if (f == null) goto _L2; else goto _L1
_L1:
        t t1 = f;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        a1 = new f(a1);
_L3:
        t1.a(a1);
_L2:
        return;
        a1 = null;
          goto _L3
        a1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return;
    }

    public final void a(com.google.android.gms.ads.internal.client.a a1)
    {
        e = a1;
        if (f == null) goto _L2; else goto _L1
_L1:
        t t1 = f;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        a1 = new com.google.android.gms.ads.internal.client.e(a1);
_L3:
        t1.a(a1);
_L2:
        return;
        a1 = null;
          goto _L3
        a1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return;
    }

    public final void a(z z1)
    {
label0:
        {
            Object obj;
            t t1;
            Context context;
            AdSizeParcel adsizeparcel;
            String s;
            df df1;
            try
            {
                if (f != null)
                {
                    break MISSING_BLOCK_LABEL_303;
                }
                if (g == null)
                {
                    b("loadAd");
                }
                h h1 = com.google.android.gms.ads.internal.client.m.b();
                context = b;
                adsizeparcel = new AdSizeParcel();
                s = g;
                df1 = a;
                com.google.android.gms.ads.internal.client.m.a();
                if (!com.google.android.gms.ads.internal.util.client.a.b(context))
                {
                    break label0;
                }
                t1 = h1.a(context, adsizeparcel, s, df1, 2);
            }
            // Misplaced declaration of an exception variable
            catch (z z1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
            obj = t1;
            if (t1 != null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
        }
        com.google.android.gms.ads.internal.util.client.b.a(5);
        obj = new k(context, adsizeparcel, s, df1, new VersionInfoParcel(), new d(new cc(), new l()));
        f = ((t) (obj));
        if (d != null)
        {
            f.a(new f(d));
        }
        if (e != null)
        {
            f.a(new com.google.android.gms.ads.internal.client.e(e));
        }
        if (i != null)
        {
            f.a(new com.google.android.gms.ads.internal.client.l(i));
        }
        if (k != null)
        {
            f.a(new er(k));
        }
        if (j != null)
        {
            f.a(new ev(j), h);
        }
        if (m != null)
        {
            f.a(new bj(m));
        }
        if (f.a(com.google.android.gms.ads.internal.client.j.a(b, z1)))
        {
            a.a = z1.i;
        }
        return;
    }

    public final void a(String s)
    {
        if (g != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else
        {
            g = s;
            return;
        }
    }

    public final boolean a()
    {
        if (f == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = f.c();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        }
        return flag;
    }

    public final void b()
    {
        try
        {
            b("show");
            f.f();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }
}
