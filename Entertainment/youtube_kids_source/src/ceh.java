// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ceh extends Enum
{

    public static final ceh a;
    public static final ceh b;
    public static final ceh c;
    public static final ceh d;
    public static final ceh e;
    public static final ceh f;
    public static final ceh g;
    public static final ceh h;
    public static final ceh i;
    public static final ceh j;
    public static final ceh k;
    public static final ceh l;
    public static final ceh m;
    public static final ceh n;
    public static final ceh o;
    public static final ceh p;
    public static final ceh q;
    public static final ceh r;
    public static final ceh s;
    private static ceh t;
    private static final ceh u[];

    private ceh(String s1, int i1, int j1)
    {
        super(s1, i1);
    }

    public static ceh valueOf(String s1)
    {
        return (ceh)Enum.valueOf(ceh, s1);
    }

    public static ceh[] values()
    {
        return (ceh[])u.clone();
    }

    static 
    {
        a = new ceh("PLAYABLE", 0, -1);
        b = new ceh("PROCESSING", 1, 0x7f0b007a);
        c = new ceh("DELETED", 2, 0x7f0b007b);
        t = new ceh("OFFLINE_DELETED", 3, 0x7f0b007c);
        d = new ceh("COUNTRY_RESTRICTED", 4, 0x7f0b007d);
        e = new ceh("NOT_AVAILABLE_ON_MOBILE", 5, 0x7f0b007e);
        f = new ceh("PRIVATE", 6, 0x7f0b007f);
        g = new ceh("BLOCKED_FOR_CLIENT_APP", 7, 0x7f0b0080);
        h = new ceh("COPYRIGHT", 8, 0x7f0b0081);
        i = new ceh("INAPPROPRIATE", 9, 0x7f0b0082);
        j = new ceh("DUPLICATE", 10, 0x7f0b0083);
        k = new ceh("TERMS_OF_USE", 11, 0x7f0b0084);
        l = new ceh("ACCOUNT_SUSPENDED", 12, 0x7f0b0085);
        m = new ceh("VIDEO_TOO_LONG", 13, 0x7f0b0086);
        n = new ceh("BLOCKED_BY_OWNER", 14, 0x7f0b0087);
        o = new ceh("CANT_PROCESS", 15, 0x7f0b0088);
        p = new ceh("INVALID_FORMAT", 16, 0x7f0b0089);
        q = new ceh("UNSUPPORTED_CODEC", 17, 0x7f0b008a);
        r = new ceh("EMPTY", 18, 0x7f0b008b);
        s = new ceh("TOO_SMALL", 19, 0x7f0b008c);
        u = (new ceh[] {
            a, b, c, t, d, e, f, g, h, i, 
            j, k, l, m, n, o, p, q, r, s
        });
    }
}
