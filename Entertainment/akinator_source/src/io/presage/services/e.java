// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services;


public final class e
{
    private static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(io/presage/services/e$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("ONCE", 0);
            b = new a("PERIODIC", 1);
            c = new a("GREATER", 2);
            d = new a("EVENT", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a a;
    private boolean b;
    private boolean c;
    private long d;
    private long e;
    private long f;

    private e()
    {
        b = false;
        c = false;
        d = 0L;
        e = -1L;
        f = 0L;
    }

    public static e a()
    {
        e e1 = new e();
        e1.a = a.a;
        return e1;
    }

    public static e a(long l)
    {
        e e1 = new e();
        e1.d = l;
        e1.a = a.b;
        return e1;
    }

    public static e b()
    {
        e e1 = new e();
        e1.d = 1L;
        e1.a = a.b;
        return e1;
    }

    public static e b(long l)
    {
        e e1 = new e();
        e1.d = l;
        e1.a = a.c;
        return e1;
    }

    public static e c()
    {
        e e1 = new e();
        e1.a = a.d;
        return e1;
    }

    public final void a(boolean flag)
    {
        c = flag;
    }

    public final boolean c(long l)
    {
        boolean flag = true;
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[a.values().length];
                try
                {
                    a[a.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[a.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[a.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[a.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 44
    //                   2 61
    //                   3 97;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L6:
        return flag;
_L2:
        if (l % (f / 1000L) == 0L) goto _L6; else goto _L5
_L5:
        return false;
_L3:
        if (e == -1L)
        {
            e = f;
        }
        if (l / (e / 1000L) >= 1L) goto _L6; else goto _L7
_L7:
        return false;
_L4:
        if (b)
        {
            return true;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public final void d(long l)
    {
        if (c) goto _L2; else goto _L1
_L1:
        _cls1.a[a.ordinal()];
        JVM INSTR tableswitch 2 3: default 40
    //                   2 47
    //                   3 41;
           goto _L2 _L3 _L4
_L2:
        return;
_L4:
        b = false;
        return;
_L3:
        while (l >= e / 1000L) 
        {
            e = e + f;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final boolean d()
    {
        return a == a.a;
    }

    public final e e()
    {
        f = d * 1000L;
        return this;
    }

    public final boolean equals(Object obj)
    {
        obj = (e)obj;
        return ((e) (obj)).a == a && ((e) (obj)).d == d;
    }

    public final e f()
    {
        f = d * 1000L * 60L * 60L;
        return this;
    }

    public final void g()
    {
        if (a == a.d)
        {
            b = true;
        }
    }
}
