// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


class ack
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(android/support/v7/ack$a, s);
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


    private static ack a;
    private volatile a b;
    private volatile String c;
    private volatile String d;
    private volatile String e;

    ack()
    {
        e();
    }

    static ack a()
    {
        android/support/v7/ack;
        JVM INSTR monitorenter ;
        ack ack1;
        if (a == null)
        {
            a = new ack();
        }
        ack1 = a;
        android/support/v7/ack;
        JVM INSTR monitorexit ;
        return ack1;
        Exception exception;
        exception;
        android/support/v7/ack;
        JVM INSTR monitorexit ;
        throw exception;
    }

    a b()
    {
        return b;
    }

    String c()
    {
        return d;
    }

    String d()
    {
        return c;
    }

    void e()
    {
        b = a.a;
        d = null;
        c = null;
        e = null;
    }
}
