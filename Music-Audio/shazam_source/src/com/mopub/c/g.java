// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import com.mopub.d.s;

public final class g extends s
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        private static final a g[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/mopub/c/g$a, s1);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("WARMING_UP", 0);
            b = new a("NO_FILL", 1);
            c = new a("BAD_HEADER_DATA", 2);
            d = new a("BAD_BODY", 3);
            e = new a("TRACKING_FAILURE", 4);
            f = new a("UNSPECIFIED", 5);
            g = (new a[] {
                a, b, c, d, e, f
            });
        }

        private a(String s1, int i)
        {
            super(s1, i);
        }
    }


    public final a a;
    public final Integer b;

    public g(String s1, a a1)
    {
        this(s1, a1, ((Integer) (null)));
    }

    public g(String s1, a a1, Integer integer)
    {
        super(s1);
        a = a1;
        b = integer;
    }

    public g(String s1, Throwable throwable, a a1)
    {
        super(s1, throwable);
        a = a1;
        b = null;
    }
}
