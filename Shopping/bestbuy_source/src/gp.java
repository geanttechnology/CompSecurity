// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class gp extends Enum
{

    public static final gp a;
    public static final gp b;
    public static final gp c;
    public static final gp d;
    private static final gp f[];
    public String e;

    private gp(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    static 
    {
        a = new gp("PROD", 0, "https://www-ssl.bestbuy.com");
        b = new gp("QA1", 1, "http://www.qa.bestbuy.com/api/");
        c = new gp("QA3", 2, "http://bby-qa3.bestbuy.com");
        d = new gp("CUSTOM", 3, "");
        f = (new gp[] {
            a, b, c, d
        });
    }
}
