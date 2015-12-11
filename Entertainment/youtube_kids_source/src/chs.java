// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class chs extends Enum
{

    public static final chs d;
    private static chs e;
    private static chs f;
    private static final chs g[];
    public final String a;
    public final String b;
    public final String c;

    private chs(String s, int i, String s1, String s2, String s3, String s4)
    {
        super(s, i);
        a = s2;
        b = s3;
        c = s4;
    }

    public static chs valueOf(String s)
    {
        return (chs)Enum.valueOf(chs, s);
    }

    public static chs[] values()
    {
        return (chs[])g.clone();
    }

    static 
    {
        e = new chs("PRODUCTION", 0, "/api/lounge/bc/", "https://www.youtube.com/api/lounge/bc/bind", "https://www.youtube.com/api/lounge/pairing/", "");
        f = new chs("STAGING", 1, "/api/loungedev/bc/", "https://www.youtube.com/api/loungedev/bc/bind", "https://www.youtube.com/api/loungedev/pairing/", "&env_useStageMdx=1");
        g = (new chs[] {
            e, f
        });
        d = e;
    }
}
