// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v4.view:
//            cq, co, cp, cm, 
//            ck, cr, cw

public final class cj
{

    static final cr a;
    private WeakReference b;
    private Runnable c;
    private Runnable d;
    private int e;

    cj(View view)
    {
        c = null;
        d = null;
        e = -1;
        b = new WeakReference(view);
    }

    static Runnable a(cj cj1)
    {
        return cj1.c;
    }

    static Runnable b(cj cj1)
    {
        return cj1.d;
    }

    static int c(cj cj1)
    {
        cj1.e = -1;
        return -1;
    }

    static int d(cj cj1)
    {
        return cj1.e;
    }

    public final cj a(float f)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view, f);
        }
        return this;
    }

    public final cj a(long l)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(view, l);
        }
        return this;
    }

    public final cj a(cw cw)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view, cw);
        }
        return this;
    }

    public final void a()
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view);
        }
    }

    public final cj b(float f)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.b(this, view, f);
        }
        return this;
    }

    public final void b()
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.b(this, view);
        }
    }

    public final cj c(float f)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.c(this, view, f);
        }
        return this;
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 19)
        {
            a = new cq();
        } else
        if (i >= 18)
        {
            a = new co();
        } else
        if (i >= 16)
        {
            a = new cp();
        } else
        if (i >= 14)
        {
            a = new cm();
        } else
        {
            a = new ck();
        }
    }
}
