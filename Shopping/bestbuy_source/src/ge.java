// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ge extends Enum
{

    public static final ge a;
    public static final ge b;
    public static final ge c;
    private static final ge f[];
    public String d;
    public String e;

    private ge(String s, int i, String s1, String s2)
    {
        super(s, i);
        d = s1;
        e = s2;
    }

    public static ge a(String s)
    {
        return (ge)Enum.valueOf(ge, s);
    }

    static 
    {
        a = new ge("PROD", 0, "http://api.deals.bestbuy.com/v1", "kus5hgbf8sgaen7fjegqdcfb");
        b = new ge("PROD_LIKE", 1, "http://pl.deals.bestbuy.com/v1", "kus5hgbf8sgaen7fjegqdcfb");
        c = new ge("CUSTOM", 2, "", "");
        f = (new ge[] {
            a, b, c
        });
    }
}
