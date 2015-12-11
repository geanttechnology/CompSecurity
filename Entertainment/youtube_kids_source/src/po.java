// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class po extends Enum
{

    public static final po a;
    public static final po b;
    public static final po c;
    public static final po d;
    public static final po e;
    public static final po f;
    public static final po g;
    public static final po h;
    private static po i;
    private static final po k[];
    private final String j;

    private po(String s, int l, String s1)
    {
        super(s, l);
        j = s1;
    }

    public static po valueOf(String s)
    {
        return (po)Enum.valueOf(po, s);
    }

    public static po[] values()
    {
        return (po[])k.clone();
    }

    public final String toString()
    {
        return j;
    }

    static 
    {
        a = new po("BUFFERING", 0, "B");
        b = new po("ERROR", 1, "ER");
        c = new po("ENDED", 2, "EN");
        d = new po("NOT_PLAYING", 3, "N");
        e = new po("PAUSED", 4, "PA");
        f = new po("PLAYING", 5, "PL");
        g = new po("SEEKING", 6, "S");
        i = new po("NOT_VALID", 7, "X");
        h = new po("PAUSED_BUFFERING", 8, "PB");
        k = (new po[] {
            a, b, c, d, e, f, g, i, h
        });
    }
}
