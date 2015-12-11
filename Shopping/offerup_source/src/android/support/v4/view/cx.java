// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v4.view:
//            df, de, dc, dd, 
//            da, cy, dg, dk, 
//            dm

public final class cx
{

    private static dg e;
    private WeakReference a;
    private Runnable b;
    private Runnable c;
    private int d;

    cx(View view)
    {
        b = null;
        c = null;
        d = -1;
        a = new WeakReference(view);
    }

    static int a(cx cx1, int i)
    {
        cx1.d = -1;
        return -1;
    }

    static Runnable a(cx cx1)
    {
        return null;
    }

    static Runnable b(cx cx1)
    {
        return null;
    }

    static int c(cx cx1)
    {
        return cx1.d;
    }

    public final long a()
    {
        View view = (View)a.get();
        if (view != null)
        {
            return e.a(view);
        } else
        {
            return 0L;
        }
    }

    public final cx a(float f)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.a(this, view, f);
        }
        return this;
    }

    public final cx a(long l)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.a(view, l);
        }
        return this;
    }

    public final cx a(dk dk)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.a(this, view, dk);
        }
        return this;
    }

    public final cx a(dm dm)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.a(view, dm);
        }
        return this;
    }

    public final cx a(Interpolator interpolator)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.a(view, interpolator);
        }
        return this;
    }

    public final cx b(float f)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.b(this, view, f);
        }
        return this;
    }

    public final cx b(long l)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.b(view, l);
        }
        return this;
    }

    public final void b()
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.a(this, view);
        }
    }

    public final cx c(float f)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.c(this, view, f);
        }
        return this;
    }

    public final void c()
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.b(this, view);
        }
    }

    public final cx d(float f)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.d(this, view, 1.0F);
        }
        return this;
    }

    public final cx e(float f)
    {
        View view = (View)a.get();
        if (view != null)
        {
            e.e(this, view, 1.0F);
        }
        return this;
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            e = new df();
        } else
        if (i >= 19)
        {
            e = new de();
        } else
        if (i >= 18)
        {
            e = new dc();
        } else
        if (i >= 16)
        {
            e = new dd();
        } else
        if (i >= 14)
        {
            e = new da();
        } else
        {
            e = new cy();
        }
    }
}
