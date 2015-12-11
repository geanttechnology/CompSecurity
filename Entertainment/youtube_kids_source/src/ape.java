// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ape
    implements Runnable
{

    private String a;
    private int b;
    private boolean c;
    private long d;
    private long e;
    private long f;
    private apd g;

    ape(apd apd1, String s, int i, boolean flag, long l, long l1, long l2)
    {
        g = apd1;
        a = s;
        b = i;
        c = flag;
        d = l;
        e = l1;
        f = l2;
        super();
    }

    public final void run()
    {
        Object obj = g.b;
        int i = g.a;
        obj = a;
        i = b;
        boolean flag = c;
        obj = g;
        long l = d;
        obj = g;
        l = e;
        l = f;
    }
}
