// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ts

public static class 
{

    private final List a = new ArrayList();
    private final List b = new ArrayList();
    private final List c = new ArrayList();

    static List a( )
    {
        return .b;
    }

    static List b(b b1)
    {
        return b1.a;
    }

    static List c(a a1)
    {
        return a1.c;
    }

    public c a(String s, double d, double d1)
    {
        int i = 0;
        do
        {
            double d2;
            double d3;
            if (i < a.size())
            {
                d2 = ((Double)c.get(i)).doubleValue();
                d3 = ((Double)b.get(i)).doubleValue();
                break MISSING_BLOCK_LABEL_55;
            }
            do
            {
                a.add(i, s);
                c.add(i, Double.valueOf(d));
                b.add(i, Double.valueOf(d1));
                return this;
            } while (d < d2 || d2 == d && d1 < d3);
            i++;
        } while (true);
    }

    public ts a()
    {
        return new ts(this, null);
    }

    public ()
    {
    }
}
