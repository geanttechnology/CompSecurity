// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class akv extends Enum
{

    public static final akv a;
    public static final akv b;
    public static final akv c;
    private static final akv e[];
    final int d;

    private akv(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static boolean a(int i)
    {
        return (a.d & i) == 0;
    }

    public static boolean b(int i)
    {
        return (b.d & i) == 0;
    }

    public static boolean c(int i)
    {
        return (c.d & i) != 0;
    }

    public static akv valueOf(String s)
    {
        return (akv)Enum.valueOf(android/support/v7/akv, s);
    }

    public static akv[] values()
    {
        return (akv[])e.clone();
    }

    static 
    {
        a = new akv("NO_CACHE", 0, 1);
        b = new akv("NO_STORE", 1, 2);
        c = new akv("OFFLINE", 2, 4);
        e = (new akv[] {
            a, b, c
        });
    }
}
