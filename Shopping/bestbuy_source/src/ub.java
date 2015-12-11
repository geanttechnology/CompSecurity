// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bb;

public final class ub
{

    private final wc a;
    private final tj b;
    private ol c;
    private tq d;
    private oo e[];
    private String f;
    private String g;
    private ViewGroup h;
    private or i;
    private pg j;
    private pi k;
    private ou l;

    public ub(ViewGroup viewgroup)
    {
        this(viewgroup, null, false, tj.a());
    }

    public ub(ViewGroup viewgroup, AttributeSet attributeset, boolean flag)
    {
        this(viewgroup, attributeset, flag, tj.a());
    }

    ub(ViewGroup viewgroup, AttributeSet attributeset, boolean flag, tj tj1)
    {
        this(viewgroup, attributeset, flag, tj1, null);
    }

    ub(ViewGroup viewgroup, AttributeSet attributeset, boolean flag, tj tj1, tq tq1)
    {
        a = new wc();
        h = viewgroup;
        b = tj1;
        if (attributeset != null)
        {
            tj1 = viewgroup.getContext();
            try
            {
                attributeset = new bb(tj1, attributeset);
                e = attributeset.a(flag);
                f = attributeset.a();
            }
            // Misplaced declaration of an exception variable
            catch (AttributeSet attributeset)
            {
                aca.a(viewgroup, new ay(tj1, oo.a), attributeset.getMessage(), attributeset.getMessage());
                return;
            }
            if (viewgroup.isInEditMode())
            {
                aca.a(viewgroup, new ay(tj1, e[0]), "Ads by Google");
                return;
            }
        }
        d = tq1;
    }

    private void e()
    {
        ry ry = d.a();
        if (ry == null)
        {
            return;
        }
        try
        {
            h.addView((View)sb.a(ry));
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Failed to get an ad frame.", remoteexception);
        }
        return;
    }

    private void f()
    {
        if ((e == null || f == null) && d == null)
        {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        android.content.Context context = h.getContext();
        d = th.a(context, new ay(context, e), f, a);
        if (c != null)
        {
            d.a(new tg(c));
        }
        if (i != null)
        {
            d.a(new tm(i));
        }
        if (j != null)
        {
            d.a(new yy(j));
        }
        if (k != null)
        {
            d.a(new zd(k), g);
        }
        if (l != null)
        {
            d.a(new up(l));
        }
        e();
    }

    public void a()
    {
        try
        {
            if (d != null)
            {
                d.b();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Failed to destroy AdView.", remoteexception);
        }
    }

    public void a(String s)
    {
        if (f != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        } else
        {
            f = s;
            return;
        }
    }

    public void a(ol ol)
    {
        c = ol;
        if (d == null) goto _L2; else goto _L1
_L1:
        tq tq1 = d;
        if (ol == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        ol = new tg(ol);
_L3:
        tq1.a(ol);
_L2:
        return;
        ol = null;
          goto _L3
        ol;
        acb.d("Failed to set the AdListener.", ol);
        return;
    }

    public void a(or or)
    {
        i = or;
        if (d == null) goto _L2; else goto _L1
_L1:
        tq tq1 = d;
        if (or == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        or = new tm(or);
_L3:
        tq1.a(or);
_L2:
        return;
        or = null;
          goto _L3
        or;
        acb.d("Failed to set the AppEventListener.", or);
        return;
    }

    public void a(pg pg)
    {
        if (k != null)
        {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        j = pg;
        if (d == null) goto _L2; else goto _L1
_L1:
        tq tq1 = d;
        if (pg == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        pg = new yy(pg);
_L3:
        tq1.a(pg);
_L2:
        return;
        pg = null;
          goto _L3
        pg;
        acb.d("Failed to set the InAppPurchaseListener.", pg);
        return;
    }

    public void a(pi pi, String s)
    {
        if (j != null)
        {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        k = pi;
        g = s;
        if (d == null) goto _L2; else goto _L1
_L1:
        tq tq1 = d;
        if (pi == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        pi = new zd(pi);
_L3:
        tq1.a(pi, s);
_L2:
        return;
        pi = null;
          goto _L3
        pi;
        acb.d("Failed to set the play store purchase parameter.", pi);
        return;
    }

    public void a(tz tz1)
    {
        try
        {
            if (d == null)
            {
                f();
            }
            if (d.a(b.a(h.getContext(), tz1)))
            {
                a.a(tz1.i());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (tz tz1)
        {
            acb.d("Failed to load ad.", tz1);
        }
    }

    public transient void a(oo aoo[])
    {
        if (e != null)
        {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        } else
        {
            b(aoo);
            return;
        }
    }

    public oo b()
    {
        oo oo1;
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        oo1 = d.i().a();
        return oo1;
        RemoteException remoteexception;
        remoteexception;
        acb.d("Failed to get the current AdSize.", remoteexception);
        if (e != null)
        {
            return e[0];
        } else
        {
            return null;
        }
    }

    public transient void b(oo aoo[])
    {
        e = aoo;
        try
        {
            if (d != null)
            {
                d.a(new ay(h.getContext(), e));
            }
        }
        // Misplaced declaration of an exception variable
        catch (oo aoo[])
        {
            acb.d("Failed to set the ad size.", aoo);
        }
        h.requestLayout();
    }

    public void c()
    {
        try
        {
            if (d != null)
            {
                d.d();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Failed to call pause.", remoteexception);
        }
    }

    public void d()
    {
        try
        {
            if (d != null)
            {
                d.e();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Failed to call resume.", remoteexception);
        }
    }
}
