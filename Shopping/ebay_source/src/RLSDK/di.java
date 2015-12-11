// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


public final class di
{

    public static final di a;
    public static final di b;
    public static final di c;
    public static final di d;
    private static final di e[];
    private final int f;
    private final int g;
    private final String h;

    private di(int i, int j, String s)
    {
        f = i;
        g = j;
        h = s;
    }

    public static di a(int i)
    {
        if (i < 0 || i >= e.length)
        {
            throw new IllegalArgumentException();
        } else
        {
            return e[i];
        }
    }

    public final int a()
    {
        return f;
    }

    public final String toString()
    {
        return h;
    }

    static 
    {
        a = new di(0, 1, "L");
        b = new di(1, 0, "M");
        c = new di(2, 3, "Q");
        d = new di(3, 2, "H");
        e = (new di[] {
            b, a, d, c
        });
    }
}
