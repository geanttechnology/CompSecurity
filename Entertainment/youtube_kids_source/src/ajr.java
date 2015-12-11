// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ajr extends Enum
{

    public static final ajr a;
    public static final ajr b;
    public static final ajr c;
    private static final ajr d[];

    private ajr(String s, int i)
    {
        super(s, i);
    }

    public static ajr valueOf(String s)
    {
        return (ajr)Enum.valueOf(ajr, s);
    }

    public static ajr[] values()
    {
        return (ajr[])d.clone();
    }

    static 
    {
        a = new ajr("PLAYING_VIDEO", 0);
        b = new ajr("SHOWING_TV_QUEUE", 1);
        c = new ajr("CONNECTED_ONLY", 2);
        d = (new ajr[] {
            a, b, c
        });
    }
}
