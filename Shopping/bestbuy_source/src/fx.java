// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class fx extends Enum
{

    public static final fx a;
    public static final fx b;
    public static final fx c;
    public static final fx d;
    private static final fx f[];
    public String e;

    private fx(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static fx a(String s)
    {
        return (fx)Enum.valueOf(fx, s);
    }

    static 
    {
        a = new fx("PROD", 0, "https://www-ssl.bestbuy.com/api/");
        b = new fx("QA1", 1, "http://www.qa.bestbuy.com/api/");
        c = new fx("QA3", 2, "http://bby-qa3.bestbuy.com/api/");
        d = new fx("CUSTOM", 3, "");
        f = (new fx[] {
            a, b, c, d
        });
    }
}
