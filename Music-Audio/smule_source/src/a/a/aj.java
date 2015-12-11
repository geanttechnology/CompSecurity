// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


final class aj extends Enum
{

    public static final aj a;
    public static final aj b;
    public static final aj c;
    public static final aj d;
    public static final aj e;
    public static final aj f;
    public static final aj g;
    public static final aj h;
    public static final aj i;
    private static final aj j[];

    private aj(String s, int k)
    {
        super(s, k);
    }

    public static aj valueOf(String s)
    {
        return (aj)Enum.valueOf(a/a/aj, s);
    }

    public static aj[] values()
    {
        return (aj[])j.clone();
    }

    static 
    {
        a = new aj("CREATED", 0);
        b = new aj("STARTED", 1);
        c = new aj("SUCCESS", 2);
        d = new aj("SLOW", 3);
        e = new aj("FAILED", 4);
        f = new aj("TIMEOUT", 5);
        g = new aj("CRASHED", 6);
        h = new aj("ABORTED", 7);
        i = new aj("INTERRUPTED", 8);
        j = (new aj[] {
            a, b, c, d, e, f, g, h, i
        });
    }
}
