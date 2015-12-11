// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;

abstract class cja extends ckh
    implements cke
{

    final Runnable a = new cjb(this);
    public ckg b;
    private final Runnable c = new cjc(this);
    private int d;
    private int e;
    private int f;
    private int g;

    public cja(Context context)
    {
        super(context);
    }

    public final int a()
    {
        return f;
    }

    public final void a(int i)
    {
        a(c, a, i);
    }

    public final void a(int i, int j)
    {
        d = i;
        e = j;
        requestLayout();
    }

    protected final void a(View view, int i, int j)
    {
        i = (i - f) / 2;
        j = (j - g) / 2;
        view.layout(i, j, f + i, g + j);
    }

    public final void a(ckg ckg)
    {
        b = ckg;
    }

    public void a(boolean flag)
    {
    }

    public final int b()
    {
        return g;
    }

    public final void b(int i)
    {
        if (i != m())
        {
            throw new UnsupportedOperationException("MediaView does not support requested type.");
        } else
        {
            return;
        }
    }

    public final View c()
    {
        return this;
    }

    public SurfaceHolder d()
    {
        return null;
    }

    protected abstract void e();

    protected abstract void f();

    public final void g()
    {
        a(a, c, 0);
    }

    public ckf h()
    {
        return null;
    }

    protected final void onMeasure(int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        i1 = getDefaultSize(d, i);
        j1 = getDefaultSize(e, j);
        k = j1;
        l = i1;
        if (d <= 0) goto _L2; else goto _L1
_L1:
        k = j1;
        l = i1;
        if (e <= 0) goto _L2; else goto _L3
_L3:
        float f1 = (float)(d * j1) / (float)(e * i1) - 1.0F;
        if (f1 <= 0.01F) goto _L5; else goto _L4
_L4:
        k = (e * i1) / d;
        l = i1;
_L2:
        f = resolveSize(l, i);
        g = resolveSize(k, j);
        setMeasuredDimension(f, g);
        return;
_L5:
        k = j1;
        l = i1;
        if (f1 < -0.01F)
        {
            l = (d * j1) / e;
            k = j1;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }
}
