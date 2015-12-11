// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.doubleclick.AppEventListener;

// Referenced classes of package com.google.android.gms.internal:
//            bl, b, x, er, 
//            f, et, kv, kw, 
//            kz, v, o

public final class q
{

    public AdListener a;
    public f b;
    public AdSize c[];
    public String d;
    public AppEventListener e;
    private final bl f;
    private ViewGroup g;

    public q(ViewGroup viewgroup)
    {
        f = new bl();
        g = viewgroup;
    }

    public q(ViewGroup viewgroup, AttributeSet attributeset, boolean flag)
    {
        android.content.Context context;
        f = new bl();
        g = viewgroup;
        context = viewgroup.getContext();
        attributeset = new b(context, attributeset);
        if (flag) goto _L2; else goto _L1
_L1:
        if (((b) (attributeset)).a.length != 1)
        {
            throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        }
          goto _L2
        attributeset;
        com.google.android.gms.internal.er.a(viewgroup, new x(context, AdSize.BANNER), attributeset.getMessage(), attributeset.getMessage());
_L4:
        return;
_L2:
        c = ((b) (attributeset)).a;
        d = ((b) (attributeset)).b;
        if (viewgroup.isInEditMode())
        {
            com.google.android.gms.internal.er.a(viewgroup, new x(context, c[0]), "Ads by Google");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
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
            com.google.android.gms.internal.et.a("Failed to destroy AdView.", remoteexception);
        }
    }

    public final void a(AdListener adlistener)
    {
        a = adlistener;
        if (b == null) goto _L2; else goto _L1
_L1:
        f f1 = b;
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        adlistener = new kv(adlistener);
_L3:
        f1.a(adlistener);
_L2:
        return;
        adlistener = null;
          goto _L3
        adlistener;
        com.google.android.gms.internal.et.a("Failed to set the AdListener.", adlistener);
        return;
    }

    public final void a(o o1)
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
        android.content.Context context = g.getContext();
        b = com.google.android.gms.internal.kw.a(context, new x(context, c), d, f);
        if (a != null)
        {
            b.a(new kv(a));
        }
        if (e != null)
        {
            b.a(new kz(e));
        }
        com.google.android.gms.a.a a1 = b.a();
        if (a1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        try
        {
            if (b.a(new v(g.getContext(), o1)))
            {
                f.a = o1.g;
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            com.google.android.gms.internal.et.a("Failed to load ad.", o1);
        }
        if (true) goto _L5; else goto _L4
_L4:
        g.addView((View)com.google.android.gms.a.d.a(a1));
          goto _L2
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.et.a("Failed to get an ad frame.", remoteexception);
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

    public final transient void a(AdSize aadsize[])
    {
        if (c != null)
        {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        } else
        {
            b(aadsize);
            return;
        }
    }

    public final AdSize b()
    {
        Object obj;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        obj = b.i();
        obj = com.google.android.gms.ads.a.a(((x) (obj)).f, ((x) (obj)).c, ((x) (obj)).b);
        return ((AdSize) (obj));
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.et.a("Failed to get the current AdSize.", remoteexception);
        if (c != null)
        {
            return c[0];
        } else
        {
            return null;
        }
    }

    public final transient void b(AdSize aadsize[])
    {
        c = aadsize;
        try
        {
            if (b != null)
            {
                b.a(new x(g.getContext(), c));
            }
        }
        // Misplaced declaration of an exception variable
        catch (AdSize aadsize[])
        {
            com.google.android.gms.internal.et.a("Failed to set the ad size.", aadsize);
        }
        g.requestLayout();
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
            com.google.android.gms.internal.et.a("Failed to call pause.", remoteexception);
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
            com.google.android.gms.internal.et.a("Failed to call resume.", remoteexception);
        }
    }
}
