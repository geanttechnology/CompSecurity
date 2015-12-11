// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class amb extends Enum
{

    public static final amb a;
    public static final amb b;
    public static final amb c;
    public static final amb d;
    public static final amb e;
    public static final amb f;
    public static final amb g;
    public static final amb h;
    public static final amb i;
    public static final amb j;
    public static final amb k;
    private static final amb n[];
    final boolean l;
    private final int m;

    private amb(String s, int i1, int j1, boolean flag)
    {
        super(s, i1);
        m = j1;
        l = flag;
    }

    public static amb a(int i1)
    {
        amb aamb[] = values();
        int k1 = aamb.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            amb amb1 = aamb[j1];
            if (amb1.m == i1)
            {
                return amb1;
            }
        }

        return k;
    }

    public static amb valueOf(String s)
    {
        return (amb)Enum.valueOf(amb, s);
    }

    public static amb[] values()
    {
        return (amb[])n.clone();
    }

    static 
    {
        a = new amb("UNSTARTED", 0, -1, false);
        b = new amb("ENDED", 1, 0, false);
        c = new amb("PLAYING", 2, 1, true);
        d = new amb("PAUSED", 3, 2, true);
        e = new amb("BUFFERING", 4, 3, true);
        f = new amb("VIDEO_CUED", 5, 5, true);
        g = new amb("ADVERTISEMENT", 6, 1081, true);
        h = new amb("SKIPPED", 7, 1082, false);
        i = new amb("UNCONFIRMED", 8, -8002, false);
        j = new amb("ERROR", 9, -8003, false);
        k = new amb("UNKNOWN", 10, -8001, false);
        n = (new amb[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
