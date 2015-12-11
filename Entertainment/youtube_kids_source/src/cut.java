// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cut extends Enum
{

    public static final cut a;
    public static final cut b;
    public static final cut c;
    public static final cut d;
    public static final cut e;
    public static final cut f;
    private static final cut g[];

    private cut(String s, int i)
    {
        super(s, i);
    }

    public static cut valueOf(String s)
    {
        return (cut)Enum.valueOf(cut, s);
    }

    public static cut[] values()
    {
        return (cut[])g.clone();
    }

    static 
    {
        a = new cut("BUFFERING", 0);
        b = new cut("PAUSED", 1);
        c = new cut("PLAYING", 2);
        d = new cut("STOPPED", 3);
        e = new cut("ENDED", 4);
        f = new cut("ERROR", 5);
        g = (new cut[] {
            a, b, c, d, e, f
        });
    }
}
