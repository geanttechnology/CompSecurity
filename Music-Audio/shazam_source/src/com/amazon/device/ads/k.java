// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


public final class k
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/k$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("NETWORK_ERROR", 0);
            b = new a("NETWORK_TIMEOUT", 1);
            c = new a("NO_FILL", 2);
            d = new a("INTERNAL_ERROR", 3);
            e = new a("REQUEST_ERROR", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final a a;
    public final String b;

    k(a a1, String s)
    {
        a = a1;
        b = s;
    }
}
