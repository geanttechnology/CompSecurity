// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class amt extends Enum
{

    public static final amt a;
    public static final amt b;
    public static final amt c;
    public static final amt d;
    private static final amt f[];
    private final int e;

    private amt(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static amt a(String s)
    {
        if ("io.crash.air".equals(s))
        {
            return c;
        }
        if (s != null)
        {
            return d;
        } else
        {
            return a;
        }
    }

    public static amt valueOf(String s)
    {
        return (amt)Enum.valueOf(android/support/v7/amt, s);
    }

    public static amt[] values()
    {
        return (amt[])f.clone();
    }

    public int a()
    {
        return e;
    }

    public String toString()
    {
        return Integer.toString(e);
    }

    static 
    {
        a = new amt("DEVELOPER", 0, 1);
        b = new amt("USER_SIDELOAD", 1, 2);
        c = new amt("TEST_DISTRIBUTION", 2, 3);
        d = new amt("APP_STORE", 3, 4);
        f = (new amt[] {
            a, b, c, d
        });
    }
}
