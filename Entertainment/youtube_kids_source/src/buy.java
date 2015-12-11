// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class buy extends Enum
{

    public static final buy a;
    public static final buy b;
    public static final buy c;
    private static final buy e[];
    final String d;

    private buy(String s, int i, String s1)
    {
        super(s, i);
        d = (String)b.a(s1);
    }

    public static buy a(String s)
    {
        buy abuy[] = values();
        int j = abuy.length;
        for (int i = 0; i < j; i++)
        {
            buy buy1 = abuy[i];
            if (buy1.d.equals(s))
            {
                return buy1;
            }
        }

        return c;
    }

    public static buy valueOf(String s)
    {
        return (buy)Enum.valueOf(buy, s);
    }

    public static buy[] values()
    {
        return (buy[])e.clone();
    }

    static 
    {
        a = new buy("SINGLE_ANSWERS", 0, "single-answer");
        b = new buy("MULTI_SELECT", 1, "multi-select");
        c = new buy("UNSUPPORTED", 2, "unsupported");
        e = (new buy[] {
            a, b, c
        });
    }
}
