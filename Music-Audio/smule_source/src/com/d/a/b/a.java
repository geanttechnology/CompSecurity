// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a.b;

import android.view.animation.Interpolator;
import com.d.a.b;

// Referenced classes of package com.d.a.b:
//            b

public class a
    implements com.d.a.b.b
{

    private int a;
    private int b;
    private long c;
    private long d;
    private float e;
    private float f;
    private Interpolator g;

    public a(int i, int j, long l, long l1, Interpolator interpolator)
    {
        a = i;
        b = j;
        c = l;
        d = l1;
        e = d - c;
        f = b - a;
        g = interpolator;
    }

    public void a(b b1, long l)
    {
        if (l < c)
        {
            b1.e = a;
            return;
        }
        if (l > d)
        {
            b1.e = b;
            return;
        } else
        {
            float f1 = g.getInterpolation(((float)(l - c) * 1.0F) / e);
            float f2 = a;
            b1.e = (int)(f1 * f + f2);
            return;
        }
    }
}
