// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;


public final class m
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a g[];
        private final int e = -1;
        private final int f;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/facebook/ads/m$a, s);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        public final int a()
        {
            switch (f)
            {
            default:
                return -1;

            case 100: // 'd'
                return 1;

            case 120: // 'x'
                return 2;

            case 300: 
                return 3;

            case 400: 
                return 4;
            }
        }

        static 
        {
            a = new a("HEIGHT_100", 0, 100);
            b = new a("HEIGHT_120", 1, 120);
            c = new a("HEIGHT_300", 2, 300);
            d = new a("HEIGHT_400", 3, 400);
            g = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i, int j)
        {
            super(s, i);
            f = j;
        }
    }

}
