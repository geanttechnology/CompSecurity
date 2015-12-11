// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;


class g
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a d[];
        private int c;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/moodmedia/moodpresence/g$a, s);
        }

        public static a[] values()
        {
            a aa[] = d;
            int i = aa.length;
            a aa1[] = new a[i];
            System.arraycopy(aa, 0, aa1, 0, i);
            return aa1;
        }

        final int a()
        {
            return c;
        }

        static 
        {
            a = new a("SONIC", 0, 0);
            b = new a("ULTRASONIC", 1, 1);
            d = (new a[] {
                a, b
            });
        }

        private a(String s, int i, int j)
        {
            super(s, i);
            c = j;
        }
    }


    private long a;
    private a b;
    private int c;
    private int d;

    g(long l, a a1, int i)
    {
        b = a1;
        a = l;
        c = i;
    }

    long a()
    {
        return a;
    }

    public void a(int i)
    {
        d = i;
    }

    boolean a(g g1)
    {
        while (g1 == null || g1.b().a() != b.a() || g1.a() != a) 
        {
            return false;
        }
        return true;
    }

    a b()
    {
        return b;
    }

    int c()
    {
        return c;
    }

    public int d()
    {
        return d;
    }
}
