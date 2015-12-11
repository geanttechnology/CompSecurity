// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;


class bf
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/android/gms/e/bf$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("NONE", 0);
            b = new a("CONTAINER", 1);
            c = new a("CONTAINER_DEBUG", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static bf d;
    volatile a a;
    volatile String b;
    volatile String c;
    private volatile String e;

    bf()
    {
        a = a.a;
        c = null;
        b = null;
        e = null;
    }

    static bf a()
    {
        com/google/android/gms/e/bf;
        JVM INSTR monitorenter ;
        bf bf1;
        if (d == null)
        {
            d = new bf();
        }
        bf1 = d;
        com/google/android/gms/e/bf;
        JVM INSTR monitorexit ;
        return bf1;
        Exception exception;
        exception;
        com/google/android/gms/e/bf;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
