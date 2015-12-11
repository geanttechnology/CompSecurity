// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cux extends Enum
{

    public static final cux a;
    public static final cux b;
    public static final cux c;
    public static final cux d;
    public static final cux e;
    private static final cux p[];
    public final boolean f;
    public final boolean g;
    public final int h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    private cux(String s, int i1, boolean flag, boolean flag1, int j1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, boolean flag6, boolean flag7, boolean flag8)
    {
        super(s, i1);
        f = flag;
        g = flag1;
        h = j1;
        i = flag2;
        j = flag3;
        k = flag4;
        l = flag5;
        m = flag6;
        n = flag7;
        o = flag8;
    }

    public static cux valueOf(String s)
    {
        return (cux)Enum.valueOf(cux, s);
    }

    public static cux[] values()
    {
        return (cux[])p.clone();
    }

    static 
    {
        a = new cux("YOUTUBE", 0, false, true, 0xb2cc181e, true, true, true, true, false, true, true);
        b = new cux("REMOTE", 1, false, true, 0xb2cc181e, false, true, true, true, false, true, true);
        c = new cux("AD", 2, false, true, 0xffe8bb2b, false, false, true, false, true, false, false);
        d = new cux("LIVE", 3, false, true, 0xb2cc181e, false, false, true, true, false, false, true);
        e = new cux("HIDDEN", 4, true, false, 0xb2cc181e, false, false, false, false, false, false, false);
        p = (new cux[] {
            a, b, c, d, e
        });
    }
}
