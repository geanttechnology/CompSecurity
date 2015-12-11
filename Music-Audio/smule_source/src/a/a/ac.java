// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.util.SparseArray;

public final class ac extends Enum
{

    public static final ac a;
    public static final ac b;
    public static final ac c;
    public static final ac d;
    private static SparseArray e;
    private static final ac g[];
    private int f;

    private ac(String s, int i, int j)
    {
        super(s, i);
        f = j;
    }

    public static ac a(int i)
    {
        ac ac2 = (ac)e.get(i);
        ac ac1 = ac2;
        if (ac2 == null)
        {
            ac1 = c;
        }
        return ac1;
    }

    public static ac valueOf(String s)
    {
        return (ac)Enum.valueOf(a/a/ac, s);
    }

    public static ac[] values()
    {
        return (ac[])g.clone();
    }

    public final int a()
    {
        return f;
    }

    static 
    {
        a = new ac("MOBILE", 0, 0);
        b = new ac("WIFI", 1, 1);
        c = new ac("UNKNOWN", 2, 2);
        d = new ac("NOT_CONNECTED", 3, 3);
        g = (new ac[] {
            a, b, c, d
        });
        SparseArray sparsearray = new SparseArray();
        e = sparsearray;
        sparsearray.put(0, a);
        e.put(1, b);
    }
}
