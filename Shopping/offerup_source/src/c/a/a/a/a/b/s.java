// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;


public final class s extends Enum
{

    private static s a;
    private static s b;
    private static s c;
    private static s d;
    private static final s f[];
    private final int e;

    private s(String s1, int i, int j)
    {
        super(s1, i);
        e = j;
    }

    public static s a(String s1)
    {
        if ("io.crash.air".equals(s1))
        {
            return c;
        }
        if (s1 != null)
        {
            return d;
        } else
        {
            return a;
        }
    }

    public static s valueOf(String s1)
    {
        return (s)Enum.valueOf(c/a/a/a/a/b/s, s1);
    }

    public static s[] values()
    {
        return (s[])f.clone();
    }

    public final int a()
    {
        return e;
    }

    public final String toString()
    {
        return Integer.toString(e);
    }

    static 
    {
        a = new s("DEVELOPER", 0, 1);
        b = new s("USER_SIDELOAD", 1, 2);
        c = new s("TEST_DISTRIBUTION", 2, 3);
        d = new s("APP_STORE", 3, 4);
        f = (new s[] {
            a, b, c, d
        });
    }
}
