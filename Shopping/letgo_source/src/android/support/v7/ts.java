// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.List;

public class ts
{
    public static class a
    {

        public final String a;
        public final double b;
        public final double c;
        public final double d;
        public final int e;

        public boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                if (w.a(a, ((a) (obj = (a)obj)).a) && b == ((a) (obj)).b && c == ((a) (obj)).c && e == ((a) (obj)).e && Double.compare(d, ((a) (obj)).d) == 0)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return w.a(new Object[] {
                a, Double.valueOf(b), Double.valueOf(c), Double.valueOf(d), Integer.valueOf(e)
            });
        }

        public String toString()
        {
            return w.a(this).a("name", a).a("minBound", Double.valueOf(c)).a("maxBound", Double.valueOf(b)).a("percent", Double.valueOf(d)).a("count", Integer.valueOf(e)).toString();
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

    public static class b
    {

        private final List a = new ArrayList();
        private final List b = new ArrayList();
        private final List c = new ArrayList();

        static List a(b b1)
        {
            return b1.b;
        }

        static List b(b b1)
        {
            return b1.a;
        }

        static List c(b b1)
        {
            return b1.c;
        }

        public b a(String s, double d1, double d2)
        {
            int i = 0;
            do
            {
                double d3;
                double d4;
                if (i < a.size())
                {
                    d3 = ((Double)c.get(i)).doubleValue();
                    d4 = ((Double)b.get(i)).doubleValue();
                    break MISSING_BLOCK_LABEL_55;
                }
                do
                {
                    a.add(i, s);
                    c.add(i, Double.valueOf(d1));
                    b.add(i, Double.valueOf(d2));
                    return this;
                } while (d1 < d3 || d3 == d1 && d2 < d4);
                i++;
            } while (true);
        }

        public ts a()
        {
            return new ts(this);
        }

        public b()
        {
        }
    }


    private final String a[];
    private final double b[];
    private final double c[];
    private final int d[];
    private int e;

    private ts(b b1)
    {
        int i = b.a(b1).size();
        a = (String[])b.b(b1).toArray(new String[i]);
        b = a(b.a(b1));
        c = a(b.c(b1));
        d = new int[i];
        e = 0;
    }


    private double[] a(List list)
    {
        double ad[] = new double[list.size()];
        for (int i = 0; i < ad.length; i++)
        {
            ad[i] = ((Double)list.get(i)).doubleValue();
        }

        return ad;
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList(a.length);
        for (int i = 0; i < a.length; i++)
        {
            arraylist.add(new a(a[i], c[i], b[i], (double)d[i] / (double)e, d[i]));
        }

        return arraylist;
    }

    public void a(double d1)
    {
        e = e + 1;
        int i = 0;
        do
        {
label0:
            {
                if (i < c.length)
                {
                    if (c[i] <= d1 && d1 < b[i])
                    {
                        int ai[] = d;
                        ai[i] = ai[i] + 1;
                    }
                    if (d1 >= c[i])
                    {
                        break label0;
                    }
                }
                return;
            }
            i++;
        } while (true);
    }
}
