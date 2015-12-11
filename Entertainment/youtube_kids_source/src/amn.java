// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class amn extends Enum
{

    public static final amn a;
    public static final amn b;
    public static final amn c;
    public static final amn d;
    private static final amn e[];

    private amn(String s, int i)
    {
        super(s, i);
    }

    public static amn valueOf(String s)
    {
        return (amn)Enum.valueOf(amn, s);
    }

    public static amn[] values()
    {
        return (amn[])e.clone();
    }

    public final boolean a()
    {
        return this == b;
    }

    static 
    {
        a = new amn("NEW", 0);
        b = new amn("MEDIA_PLAYING_AD", 1);
        c = new amn("MEDIA_PLAYING_VIDEO", 2);
        d = new amn("ENDED", 3);
        e = (new amn[] {
            a, b, c, d
        });
    }
}
