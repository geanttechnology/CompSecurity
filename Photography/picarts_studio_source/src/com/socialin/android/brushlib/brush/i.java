// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            g, h, Brush

public final class i extends g
{

    public i()
    {
    }

    private i(i l)
    {
        super(l);
    }

    public static Brush.Params j()
    {
        return (new Brush.Params()).setThickness(80F);
    }

    protected final void a(float af[], int l)
    {
        int i1 = e.getColor();
        int l1 = Color.red(i1);
        int k1 = Color.green(i1);
        i1 = Color.blue(i1);
        for (int j1 = 0; j1 < l; j1++)
        {
            c[j1] = new h();
            l1 -= l1 / (l * 2);
            k1 -= k1 / (l * 2);
            i1 -= i1 / (l * 2);
            c[j1].a.moveTo(af[0], af[1]);
            c[j1].c = af[0];
            c[j1].d = af[1];
            c[j1].h = af[0];
            c[j1].i = af[1];
            c[j1].b.moveTo(af[0], af[1]);
            c[j1].g = (float)((double)((float)j1 * 0.006F) * Math.random() + 0.5D);
            c[j1].j = Color.rgb(l1, k1, i1);
        }

    }

    public final int c()
    {
        return 6;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        i l = new i(this);
        l.a(b);
        return l;
    }

    public final g i()
    {
        return k();
    }

    public final i k()
    {
        i l = new i();
        l.f = true;
        l.d.set(d);
        l.e.set(e);
        int j1 = b(e.getThickness());
        for (int i1 = 0; i1 < j1; i1++)
        {
            l.c[i1] = new h();
            l.c[i1].a.set(c[i1].a);
            l.c[i1].j = c[i1].j;
        }

        return l;
    }

    public final String toString()
    {
        return "Smoke2";
    }
}
