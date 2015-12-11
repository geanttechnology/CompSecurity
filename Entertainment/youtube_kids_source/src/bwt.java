// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bwt extends Enum
{

    public static final bwt a;
    public static final bwt b;
    public static final bwt c;
    public static final bwt d;
    private static final bwt e[];

    private bwt(String s, int i)
    {
        super(s, i);
    }

    public static bwt valueOf(String s)
    {
        return (bwt)Enum.valueOf(bwt, s);
    }

    public static bwt[] values()
    {
        return (bwt[])e.clone();
    }

    static 
    {
        a = new bwt("SURFACE_VIEW", 0);
        b = new bwt("SURFACE_VIEW_SECURE", 1);
        c = new bwt("SAFE_TEXTURE_VIEW", 2);
        d = new bwt("SERVER_EXPERIMENT", 3);
        e = (new bwt[] {
            a, b, c, d
        });
    }
}
