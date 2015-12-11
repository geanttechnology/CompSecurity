// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bct extends Enum
{

    public static final bct a;
    public static final bct b;
    public static final bct c;
    public static final bct d;
    public static final bct e;
    public static final bct f;
    public static final bct g;
    public static final bct h;
    public static final bct i;
    public static final bct j;
    private static final bct l[];
    public final int k;

    private bct(String s, int i1, int j1)
    {
        super(s, i1);
        k = j1;
    }

    public static bct valueOf(String s)
    {
        return (bct)Enum.valueOf(bct, s);
    }

    public static bct[] values()
    {
        return (bct[])l.clone();
    }

    static 
    {
        a = new bct("START", 0, 0);
        b = new bct("FIRST_QUARTILE", 1, 1);
        c = new bct("MIDPOINT", 2, 2);
        d = new bct("THIRD_QUARTILE", 3, 3);
        e = new bct("COMPLETE", 4, 4);
        f = new bct("RESUME", 5, -1);
        g = new bct("PAUSE", 6, -1);
        h = new bct("SKIP", 7, -1);
        i = new bct("MUTE", 8, -1);
        j = new bct("UNMUTE", 9, -1);
        l = (new bct[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
