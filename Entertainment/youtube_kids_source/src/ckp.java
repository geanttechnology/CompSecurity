// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

public final class ckp extends ckh
    implements cke
{

    private cke a;
    private View b;
    private boolean c;
    private boolean d;
    private ckg e;

    public ckp(Context context)
    {
        super(context);
    }

    private void e()
    {
        if (!f())
        {
            throw new IllegalStateException("MediaView method called before surface created");
        } else
        {
            return;
        }
    }

    private boolean f()
    {
        return a != null;
    }

    public final int a()
    {
        e();
        return a.a();
    }

    public final void a(int i1)
    {
        if (f())
        {
            d = false;
            a.a(i1);
            return;
        } else
        {
            d = true;
            return;
        }
    }

    public final void a(int i1, int j1)
    {
        e();
        a.a(i1, j1);
    }

    public final void a(ckg ckg)
    {
        e = ckg;
        if (a != null)
        {
            c = false;
            a.a(ckg);
            return;
        } else
        {
            c = true;
            return;
        }
    }

    public final void a(boolean flag)
    {
    }

    public final int b()
    {
        e();
        return a.b();
    }

    public final void b(int i1)
    {
        if (f())
        {
            a.b(i1);
            return;
        } else
        {
            throw new IllegalStateException("SafeTextureMediaView not initialized.");
        }
    }

    public final View c()
    {
        return this;
    }

    public final SurfaceHolder d()
    {
        if (a != null)
        {
            return a.d();
        } else
        {
            return null;
        }
    }

    public final void g()
    {
        if (f())
        {
            a.g();
        }
        d = false;
    }

    public final ckf h()
    {
        return null;
    }

    public final Surface i()
    {
        if (a != null)
        {
            return a.i();
        } else
        {
            return null;
        }
    }

    public final boolean j()
    {
        if (a == null)
        {
            return false;
        } else
        {
            return a.j();
        }
    }

    public final void k()
    {
        if (f())
        {
            a.k();
        }
    }

    public final void l()
    {
        if (f())
        {
            a.l();
        }
    }

    public final int m()
    {
        return a.m();
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (b != null)
        {
            removeView(b);
            b = null;
        }
        if (isHardwareAccelerated())
        {
            clg clg1 = new clg(getContext());
            a = clg1;
            b = clg1;
        } else
        {
            ckx ckx1 = new ckx(getContext());
            a = ckx1;
            b = ckx1;
        }
        addView(b);
        if (c)
        {
            c = false;
            a.a(e);
            if (d)
            {
                a(0);
            }
        }
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (getChildCount() > 0)
        {
            getChildAt(0).layout(0, 0, k1 - i1, l1 - j1);
        }
    }

    protected final void onMeasure(int i1, int j1)
    {
        if (getChildCount() > 0)
        {
            View view = getChildAt(0);
            view.measure(i1, j1);
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
            return;
        } else
        {
            setMeasuredDimension(0, 0);
            return;
        }
    }
}
