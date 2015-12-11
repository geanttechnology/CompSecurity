// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bws extends Enum
{

    public static final bws a;
    public static final bws b;
    public static final bws c;
    public static final bws d;
    private static final bws e[];

    private bws(String s, int i)
    {
        super(s, i);
    }

    public static bws valueOf(String s)
    {
        return (bws)Enum.valueOf(bws, s);
    }

    public static bws[] values()
    {
        return (bws[])e.clone();
    }

    static 
    {
        a = new bws("OFF", 0);
        b = new bws("NON_ADAPTIVE", 1);
        c = new bws("ADAPTIVE", 2);
        d = new bws("SERVER_EXPERIMENT", 3);
        e = (new bws[] {
            a, b, c, d
        });
    }
}
