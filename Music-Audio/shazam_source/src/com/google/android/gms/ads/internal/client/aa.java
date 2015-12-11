// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.d;
import com.google.android.gms.d.bj;
import com.google.android.gms.d.df;
import com.google.android.gms.d.er;
import com.google.android.gms.d.ev;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            j, t, f, e, 
//            m, AdSizeParcel, h, l, 
//            z, a

public final class aa
{

    public com.google.android.gms.ads.a a;
    public t b;
    public com.google.android.gms.ads.d c[];
    public String d;
    public com.google.android.gms.ads.a.a e;
    public com.google.android.gms.ads.purchase.a f;
    public com.google.android.gms.ads.purchase.b g;
    public com.google.android.gms.ads.a.b h;
    public boolean i;
    private final df j;
    private final j k;
    private final AtomicBoolean l;
    private com.google.android.gms.ads.internal.client.a m;
    private String n;
    private ViewGroup o;

    public aa(ViewGroup viewgroup)
    {
        this(viewgroup, com.google.android.gms.ads.internal.client.j.a(), (byte)0);
    }

    private aa(ViewGroup viewgroup, j j1)
    {
        j = new df();
        o = viewgroup;
        k = j1;
        b = null;
        l = new AtomicBoolean(false);
    }

    private aa(ViewGroup viewgroup, j j1, byte byte0)
    {
        this(viewgroup, j1);
    }

    public final void a()
    {
        try
        {
            if (b != null)
            {
                b.b();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void a(com.google.android.gms.ads.a a1)
    {
        a = a1;
        if (b == null) goto _L2; else goto _L1
_L1:
        t t1 = b;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        a1 = new com.google.android.gms.ads.internal.client.f(a1);
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
        m = a1;
        if (b == null) goto _L2; else goto _L1
_L1:
        t t1 = b;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        a1 = new e(a1);
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
        if (b != null) goto _L2; else goto _L1
_L1:
        if ((c == null || d == null) && b == null)
        {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
          goto _L3
_L5:
        return;
_L3:
        t t1;
        android.content.Context context;
        AdSizeParcel adsizeparcel;
        String s;
        df df1;
        context = o.getContext();
        h h1 = com.google.android.gms.ads.internal.client.m.b();
        adsizeparcel = new AdSizeParcel(context, c);
        s = d;
        df1 = j;
        com.google.android.gms.ads.internal.client.m.a();
        if (!com.google.android.gms.ads.internal.util.client.a.b(context))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        t1 = h1.a(context, adsizeparcel, s, df1, 1);
        Object obj;
        obj = t1;
        if (t1 != null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
        obj = new f(context, adsizeparcel, s, df1, new VersionInfoParcel());
        b = ((t) (obj));
        if (a != null)
        {
            b.a(new com.google.android.gms.ads.internal.client.f(a));
        }
        if (m != null)
        {
            b.a(new e(m));
        }
        if (e != null)
        {
            b.a(new l(e));
        }
        if (f != null)
        {
            b.a(new er(f));
        }
        if (g != null)
        {
            b.a(new ev(g), n);
        }
        if (h != null)
        {
            b.a(new bj(h));
        }
        b.a(com.google.android.gms.ads.internal.client.m.c());
        b.a(i);
        obj = b.a();
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        try
        {
            if (b.a(com.google.android.gms.ads.internal.client.j.a(o.getContext(), z1)))
            {
                j.a = z1.i;
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (z z1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        if (true) goto _L5; else goto _L4
_L4:
        o.addView((View)com.google.android.gms.b.d.a(((com.google.android.gms.b.c) (obj))));
          goto _L2
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L2
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final void a(String s)
    {
        if (d != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        } else
        {
            d = s;
            return;
        }
    }

    public final transient void a(com.google.android.gms.ads.d ad[])
    {
        if (c != null)
        {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        } else
        {
            b(ad);
            return;
        }
    }

    public final com.google.android.gms.ads.d b()
    {
        Object obj;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj = b.i();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj = com.google.android.gms.ads.g.a(((AdSizeParcel) (obj)).f, ((AdSizeParcel) (obj)).c, ((AdSizeParcel) (obj)).b);
        return ((com.google.android.gms.ads.d) (obj));
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (c != null)
        {
            return c[0];
        } else
        {
            return null;
        }
    }

    public final transient void b(com.google.android.gms.ads.d ad[])
    {
        c = ad;
        try
        {
            if (b != null)
            {
                b.a(new AdSizeParcel(o.getContext(), c));
            }
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.ads.d ad[])
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        o.requestLayout();
    }

    public final void c()
    {
        try
        {
            if (b != null)
            {
                b.d();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void d()
    {
        try
        {
            if (b != null)
            {
                b.e();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final String e()
    {
        String s;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        s = b.j();
        return s;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return null;
    }
}
