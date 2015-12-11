// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class fh extends Enum
{

    public static final fh a;
    public static final fh b;
    private static final fh e[];
    private String c;
    private int d;

    private fh(String s, int i, String s1, int j)
    {
        super(s, i);
        c = s1;
        d = j;
    }

    static String a(fh fh1)
    {
        return fh1.c;
    }

    static int b(fh fh1)
    {
        return fh1.d;
    }

    public static fh valueOf(String s)
    {
        return (fh)Enum.valueOf(a/a/fh, s);
    }

    public static fh[] values()
    {
        return (fh[])e.clone();
    }

    static 
    {
        a = new fh("HTTP", 0, "http", 80);
        b = new fh("HTTPS", 1, "https", 443);
        e = (new fh[] {
            a, b
        });
    }
}
