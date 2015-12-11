// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class agc extends Enum
{

    public static final agc a;
    public static final agc b;
    public static final agc c;
    public static final agc d;
    private static agc e;
    private static final agc f[];

    private agc(String s, int i)
    {
        super(s, i);
    }

    public static agc valueOf(String s)
    {
        return (agc)Enum.valueOf(agc, s);
    }

    public static agc[] values()
    {
        return (agc[])f.clone();
    }

    static 
    {
        a = new agc("COMPACT_VIDEO", 0);
        b = new agc("COMPACT_CHANNEL", 1);
        c = new agc("COMPACT_PLAYLIST", 2);
        d = new agc("PLAYLIST_PANEL_VIDEO", 3);
        e = new agc("LOADING_SPINNER", 4);
        f = (new agc[] {
            a, b, c, d, e
        });
    }
}
