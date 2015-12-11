// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class w extends Enum
{

    public static final w a;
    public static final w b;
    public static final w c;
    public static final w d;
    private static final w f[];
    private final int e;

    private w(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static w valueOf(String s)
    {
        return (w)Enum.valueOf(jumiomobile/w, s);
    }

    public static w[] values()
    {
        return (w[])f.clone();
    }

    public final int a()
    {
        return e;
    }

    static 
    {
        a = new w("PORTRAIT", 0, 0);
        b = new w("LANDSCAPE", 1, 90);
        c = new w("INVERTED_PORTRAIT", 2, 180);
        d = new w("INVERTED_LANDSCAPE", 3, 270);
        f = (new w[] {
            a, b, c, d
        });
    }
}
