// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cng extends Enum
{

    public static final cng a;
    public static final cng b;
    public static final cng c;
    private static cng e;
    private static cng f;
    private static cng g;
    private static cng h;
    private static cng i;
    private static final cng j[];
    public final String d;

    private cng(String s, int k, String s1)
    {
        super(s, k);
        d = s1;
    }

    public static cng valueOf(String s)
    {
        return (cng)Enum.valueOf(cng, s);
    }

    public static cng[] values()
    {
        return (cng[])j.clone();
    }

    static 
    {
        e = new cng("DESKTOP", 0, "desktop");
        a = new cng("MOBILE", 1, "mobile");
        b = new cng("TV", 2, "tv");
        c = new cng("TABLET", 3, "tablet");
        f = new cng("BLURAY", 4, "bluray");
        g = new cng("STB", 5, "stb");
        h = new cng("GAME_CONSOLE", 6, "game_console");
        i = new cng("UNKNOWN", 7, "unknown_platform");
        j = (new cng[] {
            e, a, b, c, f, g, h, i
        });
    }
}
