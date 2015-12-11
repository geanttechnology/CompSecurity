// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;


public final class e extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    private static final e f[];
    public final String e;

    private e(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static e a(String s)
    {
        e ae[] = values();
        int j = ae.length;
        for (int i = 0; i < j; i++)
        {
            e e1 = ae[i];
            if (e1.e.equals(s))
            {
                return e1;
            }
        }

        return null;
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/wishabi/flipp/content/e, s);
    }

    public static e[] values()
    {
        return (e[])f.clone();
    }

    static 
    {
        a = new e("PRINT", 0, "print");
        b = new e("CARD", 1, "card");
        c = new e("MOBILE", 2, "mobile");
        d = new e("PICTURE", 3, "picture");
        f = (new e[] {
            a, b, c, d
        });
    }
}
