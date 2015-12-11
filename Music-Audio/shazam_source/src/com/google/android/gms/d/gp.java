// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.internal.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class gp
{
    public static final class a
    {

        public final String a;
        public final double b;
        public final double c;
        public final double d;
        public final int e;

        public final boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                if (v.a(a, ((a) (obj = (a)obj)).a) && b == ((a) (obj)).b && c == ((a) (obj)).c && e == ((a) (obj)).e && Double.compare(d, ((a) (obj)).d) == 0)
                {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode()
        {
            return Arrays.hashCode(new Object[] {
                a, Double.valueOf(b), Double.valueOf(c), Double.valueOf(d), Integer.valueOf(e)
            });
        }

        public final String toString()
        {
            return v.a(this).a("name", a).a("minBound", Double.valueOf(c)).a("maxBound", Double.valueOf(b)).a("percent", Double.valueOf(d)).a("count", Integer.valueOf(e)).toString();
        }

        public a(String s, double d1, double d2, double d3, 
                int i)
        {
            a = s;
            c = d1;
            b = d2;
            d = d3;
            e = i;
        }
    }

    public static final class b
    {

        final List a = new ArrayList();
        final List b = new ArrayList();
        final List c = new ArrayList();

        public final b a(String s, double d1, double d2)
        {
            int i = 0;
            do
            {
                if (i >= a.size())
                {
                    break;
                }
                double d3 = ((Double)c.get(i)).doubleValue();
                double d4 = ((Double)b.get(i)).doubleValue();
                if (d1 < d3 || d3 == d1 && d2 < d4)
                {
                    break;
                }
                i++;
            } while (true);
            a.add(i, s);
            c.add(i, Double.valueOf(d1));
            b.add(i, Double.valueOf(d2));
            return this;
        }

        public b()
        {
        }
    }


    public final double a[];
    public final double b[];
    public final int c[];
    public int d;
    private final String e[];

    private gp(b b1)
    {
        int i = b1.b.size();
        e = (String[])b1.a.toArray(new String[i]);
        a = a(b1.b);
        b = a(b1.c);
        c = new int[i];
        d = 0;
    }

    public gp(b b1, byte byte0)
    {
        this(b1);
    }

    private static double[] a(List list)
    {
        double ad[] = new double[list.size()];
        for (int i = 0; i < ad.length; i++)
        {
            ad[i] = ((Double)list.get(i)).doubleValue();
        }

        return ad;
    }

    public final List a()
    {
        ArrayList arraylist = new ArrayList(e.length);
        for (int i = 0; i < e.length; i++)
        {
            arraylist.add(new a(e[i], b[i], a[i], (double)c[i] / (double)d, c[i]));
        }

        return arraylist;
    }
}
