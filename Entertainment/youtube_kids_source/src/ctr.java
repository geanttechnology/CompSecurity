// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ctr extends Enum
{

    public static final ctr a;
    public static final ctr b;
    public static final ctr c;
    public static final ctr d;
    public static final ctr e;
    public static final ctr f;
    private static ctr h;
    private static final ctr i[];
    public final int g;

    private ctr(String s, int j, int k)
    {
        super(s, j);
        g = k;
    }

    public static ctr valueOf(String s)
    {
        return (ctr)Enum.valueOf(ctr, s);
    }

    public static ctr[] values()
    {
        return (ctr[])i.clone();
    }

    static 
    {
        a = new ctr("INLINE", 0, 0);
        b = new ctr("MINIMIZED", 1, 1);
        c = new ctr("FULLSCREEN", 2, 2);
        d = new ctr("BACKGROUND", 3, 3);
        e = new ctr("AUDIO_ONLY", 4, 3);
        h = new ctr("EXTERNAL", 5, 4);
        f = new ctr("REMOTE", 6, -1);
        i = (new ctr[] {
            a, b, c, d, e, h, f
        });
    }
}
