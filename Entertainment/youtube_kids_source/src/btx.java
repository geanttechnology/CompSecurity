// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class btx extends Enum
{

    public static final btx a;
    public static final btx b;
    public static final btx c;
    public static final btx d;
    public static final btx e;
    private static btx f;
    private static final btx h[];
    private final int g;

    private btx(String s, int i, int j)
    {
        super(s, i);
        g = j;
    }

    static int a(btx btx1)
    {
        return btx1.g;
    }

    public static btx a(int i)
    {
        btx abtx[] = values();
        int k = abtx.length;
        for (int j = 0; j < k; j++)
        {
            btx btx1 = abtx[j];
            if (btx1.g == i)
            {
                return btx1;
            }
        }

        return f;
    }

    public static btx valueOf(String s)
    {
        return (btx)Enum.valueOf(btx, s);
    }

    public static btx[] values()
    {
        return (btx[])h.clone();
    }

    static 
    {
        a = new btx("MS", 0, -2);
        f = new btx("NO_OP", 1, -1);
        b = new btx("C", 2, 1);
        c = new btx("CPN", 3, 2);
        d = new btx("CONN", 4, 8);
        e = new btx("CMT", 5, 10);
        h = (new btx[] {
            a, f, b, c, d, e
        });
    }
}
