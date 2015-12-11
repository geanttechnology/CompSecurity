// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class cr extends Enum
{

    public static final cr a;
    public static final cr b;
    public static final cr c;
    public static final cr d;
    public static final cr e;
    private static final cr f[];

    private cr(String s, int i)
    {
        super(s, i);
    }

    public static cr valueOf(String s)
    {
        return (cr)Enum.valueOf(a/a/cr, s);
    }

    public static cr[] values()
    {
        return (cr[])f.clone();
    }

    static 
    {
        a = new cr("INTERNET_UP", 0);
        b = new cr("INTERNET_DOWN", 1);
        c = new cr("CONN_TYPE_GAINED", 2);
        d = new cr("CONN_TYPE_LOST", 3);
        e = new cr("CONN_TYPE_SWITCHED", 4);
        f = (new cr[] {
            a, b, c, d, e
        });
    }
}
