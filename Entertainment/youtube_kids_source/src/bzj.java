// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bzj extends Enum
{

    public static final bzj a;
    private static bzj c;
    private static final bzj d[];
    public final String b;

    private bzj(String s, int i, String s1)
    {
        super(s, i);
        b = s1;
    }

    public static bzj a(String s)
    {
        if ("2.1".equals(s))
        {
            return a;
        } else
        {
            return c;
        }
    }

    public static bzj valueOf(String s)
    {
        return (bzj)Enum.valueOf(bzj, s);
    }

    public static bzj[] values()
    {
        return (bzj[])d.clone();
    }

    public final String toString()
    {
        return b;
    }

    static 
    {
        c = new bzj("V_2", 0, "2");
        a = new bzj("V_2_1", 1, "2.1");
        d = (new bzj[] {
            c, a
        });
    }
}
