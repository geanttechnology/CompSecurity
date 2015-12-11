// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.g;


public final class q extends Enum
{

    public static final q a;
    public static final q b;
    public static final q c;
    private static final q d[];

    private q(String s, int i)
    {
        super(s, i);
    }

    public static q valueOf(String s)
    {
        return (q)Enum.valueOf(c/a/a/a/a/g/q, s);
    }

    public static q[] values()
    {
        return (q[])d.clone();
    }

    static 
    {
        a = new q("USE_CACHE", 0);
        b = new q("SKIP_CACHE_LOOKUP", 1);
        c = new q("IGNORE_CACHE_EXPIRATION", 2);
        d = (new q[] {
            a, b, c
        });
    }
}
