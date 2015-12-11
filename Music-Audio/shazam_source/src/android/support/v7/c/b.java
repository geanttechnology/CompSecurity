// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.c;

import android.support.v4.b.a;
import java.util.Iterator;
import java.util.List;

final class b extends c.b
{

    private List a;
    private int b;
    private c.d c;
    private c.d d;
    private c.d e;
    private c.d f;
    private c.d g;
    private c.d h;

    b()
    {
    }

    private static float a(float f1, float f2)
    {
        return 1.0F - Math.abs(f1 - f2);
    }

    private c.d a(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        c.d d1 = null;
        float f7 = 0.0F;
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            c.d d2 = (c.d)iterator.next();
            float f8 = d2.a()[1];
            float f9 = d2.a()[2];
            if (f8 >= f5 && f8 <= f6 && f9 >= f2 && f9 <= f3)
            {
                int i;
                if (c == d2 || e == d2 || g == d2 || d == d2 || f == d2 || h == d2)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i == 0)
                {
                    i = d2.b;
                    int j = b;
                    float af[] = new float[6];
                    af[0] = a(f8, f4);
                    af[1] = 3F;
                    af[2] = a(f9, f1);
                    af[3] = 6F;
                    af[4] = (float)i / (float)j;
                    af[5] = 1.0F;
                    f9 = 0.0F;
                    f8 = 0.0F;
                    for (i = 0; i < 6; i += 2)
                    {
                        float f11 = af[i];
                        float f10 = af[i + 1];
                        f9 += f11 * f10;
                        f8 += f10;
                    }

                    f8 = f9 / f8;
                    if (d1 == null || f8 > f7)
                    {
                        d1 = d2;
                        f7 = f8;
                    }
                }
            }
        } while (true);
        return d1;
    }

    private static float[] a(c.d d1)
    {
        float af[] = new float[3];
        System.arraycopy(d1.a(), 0, af, 0, 3);
        return af;
    }

    public final c.d a()
    {
        return c;
    }

    public final void a(List list)
    {
        a = list;
        list = a.iterator();
        int i;
        for (i = 0; list.hasNext(); i = Math.max(i, ((c.d)list.next()).b)) { }
        b = i;
        c = a(0.5F, 0.3F, 0.7F, 1.0F, 0.35F, 1.0F);
        g = a(0.74F, 0.55F, 1.0F, 1.0F, 0.35F, 1.0F);
        e = a(0.26F, 0.0F, 0.45F, 1.0F, 0.35F, 1.0F);
        d = a(0.5F, 0.3F, 0.7F, 0.3F, 0.0F, 0.4F);
        h = a(0.74F, 0.55F, 1.0F, 0.3F, 0.0F, 0.4F);
        f = a(0.26F, 0.0F, 0.45F, 0.3F, 0.0F, 0.4F);
        if (c == null && e != null)
        {
            list = a(e);
            list[2] = 0.5F;
            c = new c.d(android.support.v4.b.a.a(list), 0);
        }
        if (e == null && c != null)
        {
            list = a(c);
            list[2] = 0.26F;
            e = new c.d(android.support.v4.b.a.a(list), 0);
        }
    }

    public final c.d b()
    {
        return e;
    }

    public final c.d c()
    {
        return d;
    }

    public final c.d d()
    {
        return f;
    }
}
