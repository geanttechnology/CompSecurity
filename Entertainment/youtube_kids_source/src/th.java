// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class th extends Enum
{

    private static th a;
    private static th b;
    private static th c;
    private static th d;
    private static final th f[];
    private int e;

    private th(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static int a()
    {
        return a(values()[3].e);
    }

    private static int a(int i)
    {
        return (i * 255) / 100;
    }

    public static int b()
    {
        return a(values()[3].e);
    }

    public static int c()
    {
        return a(values()[3].e);
    }

    public static th valueOf(String s)
    {
        return (th)Enum.valueOf(th, s);
    }

    public static th[] values()
    {
        return (th[])f.clone();
    }

    static 
    {
        a = new th("PERCENT_25", 0, 25);
        b = new th("PERCENT_50", 1, 50);
        c = new th("PERCENT_75", 2, 75);
        d = new th("PERCENT_100", 3, 100);
        f = (new th[] {
            a, b, c, d
        });
    }
}
