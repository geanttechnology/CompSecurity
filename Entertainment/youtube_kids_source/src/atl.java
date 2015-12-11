// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class atl
{

    private static final Comparator a = new atm();
    private static final Comparator b = new atn();
    private final int c;
    private final ArrayList d = new ArrayList();
    private final ato e[] = new ato[5];
    private int f;
    private int g;
    private int h;
    private int i;

    public atl(int j)
    {
        c = j;
        f = -1;
    }

    public final float a(float f1)
    {
        if (f != 0)
        {
            Collections.sort(d, b);
            f = 0;
        }
        f1 = h;
        int j = 0;
        int k = 0;
        for (; j < d.size(); j++)
        {
            ato ato1 = (ato)d.get(j);
            k += ato1.b;
            if ((float)k >= 0.5F * f1)
            {
                return ato1.c;
            }
        }

        if (d.isEmpty())
        {
            return (0.0F / 0.0F);
        } else
        {
            return ((ato)d.get(d.size() - 1)).c;
        }
    }

    public final void a(int j, float f1)
    {
        if (f != 1)
        {
            Collections.sort(d, a);
            f = 1;
        }
        ato ato1;
        int l;
        if (i > 0)
        {
            ato aato[] = e;
            int k = i - 1;
            i = k;
            ato1 = aato[k];
        } else
        {
            ato1 = new ato();
        }
        l = g;
        g = l + 1;
        ato1.a = l;
        ato1.b = j;
        ato1.c = f1;
        d.add(ato1);
        h = h + j;
        do
        {
            if (h <= c)
            {
                break;
            }
            j = h - c;
            ato1 = (ato)d.get(0);
            if (ato1.b <= j)
            {
                h = h - ato1.b;
                d.remove(0);
                if (i < 5)
                {
                    ato aato1[] = e;
                    j = i;
                    i = j + 1;
                    aato1[j] = ato1;
                }
            } else
            {
                ato1.b = ato1.b - j;
                h = h - j;
            }
        } while (true);
    }

}
