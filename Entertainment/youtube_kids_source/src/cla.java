// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

public final class cla extends ckh
    implements cke
{

    private cke a;
    private boolean b;
    private boolean c;
    private ckg d;
    private int e;
    private final View f;
    private final bmi g;

    public cla(Context context, View view, int i1, bmi bmi)
    {
        super(context);
        f = (View)b.a(view);
        e = i1;
        g = bmi;
    }

    private cke c(int i1)
    {
        switch (i1)
        {
        case 1: // '\001'
        default:
            throw new UnsupportedOperationException("Requested view is not supported.");

        case 0: // '\0'
        case 2: // '\002'
            return new ckp(getContext());

        case 4: // '\004'
            return new ckq(getContext());

        case 3: // '\003'
            return new ckx(getContext());

        case 5: // '\005'
            return new cjs(getContext(), f, g);
        }
    }

    private boolean e()
    {
        return a != null;
    }

    public final int a()
    {
        b.b(e(), "MediaView method called before surface created");
        return a.a();
    }

    public final void a(int i1)
    {
        if (e())
        {
            c = false;
            a.a(i1);
            return;
        } else
        {
            c = true;
            return;
        }
    }

    public final void a(int i1, int j1)
    {
        b.b(e(), "MediaView method called before surface created");
        a.a(i1, j1);
    }

    public final void a(ckg ckg)
    {
        d = ckg;
        if (e())
        {
            b = false;
            a.a(ckg);
            return;
        } else
        {
            b = true;
            return;
        }
    }

    public final void a(boolean flag)
    {
        if (a != null)
        {
            a.a(flag);
        }
    }

    public final int b()
    {
        b.b(e(), "MediaView method called before surface created");
        return a.b();
    }

    public final void b(int i1)
    {
        b.a(d);
        if (i1 != e)
        {
            int j1 = i1;
            if (i1 == 2)
            {
                j1 = i1;
                if (e != 0)
                {
                    j1 = i1;
                    if (e != 1)
                    {
                        bmo.e("Sticking to SurfaceView for subsequent playbacks");
                        j1 = 3;
                    }
                }
            }
            e = j1;
            bmo.e((new StringBuilder(25)).append("setMediaView: ").append(j1).toString());
            cke cke1 = a;
            a = c(j1);
            a.a(d);
            addView(a.c());
            if (cke1 != null)
            {
                cke1.a(null);
                removeView(cke1.c());
                cke1.l();
                return;
            }
        }
    }

    public final View c()
    {
        if (a != null)
        {
            return a.c();
        } else
        {
            return null;
        }
    }

    public final SurfaceHolder d()
    {
        if (e())
        {
            return a.d();
        } else
        {
            return null;
        }
    }

    public final void g()
    {
        if (e())
        {
            a.g();
        }
        c = false;
    }

    public final ckf h()
    {
        return a.h();
    }

    public final Surface i()
    {
        if (e())
        {
            return a.i();
        } else
        {
            return null;
        }
    }

    public final boolean j()
    {
        return e() && a.j();
    }

    public final void k()
    {
        if (e())
        {
            a.k();
        }
    }

    public final void l()
    {
        if (e())
        {
            a.l();
            a = null;
        }
    }

    public final int m()
    {
        if (a != null)
        {
            return a.m();
        } else
        {
            return 0;
        }
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (a != null)
        {
            removeView(a.c());
            a = null;
        }
        a = c(e);
        addView(a.c());
        if (b)
        {
            b = false;
            a.a(d);
            if (c)
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
