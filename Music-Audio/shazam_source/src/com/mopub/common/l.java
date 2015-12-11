// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


public final class l
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/mopub/common/l$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("NORMAL", 0);
            b = new a("TRUNCATED", 1);
            c = new a("DISABLED", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static volatile a a;
    private static volatile int b = 6;

    public static a a()
    {
        return a;
    }

    public static void a(int i)
    {
        b = Math.min(Math.max(0, i), 6);
    }

    public static void a(a a1)
    {
        a = a1;
    }

    public static int b()
    {
        return b;
    }

    static 
    {
        a = a.a;
    }
}
