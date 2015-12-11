// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class gr extends Enum
{

    public static final gr a;
    public static final gr b;
    public static final gr c;
    public static final gr d;
    public static final gr e;
    private static final gr g[];
    public String f;

    private gr(String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }

    public static gr a(String s)
    {
        return (gr)Enum.valueOf(gr, s);
    }

    public String a()
    {
        return f;
    }

    static 
    {
        a = new gr("PROD", 0, "https://app-ssl.bestbuy.com");
        b = new gr("QA1", 1, "http://qa1-serviceinterceptor.cdc.bestbuy.com");
        c = new gr("QA3", 2, "http://app-ssl.qa3.bestbuy.com");
        d = new gr("STAGE", 3, "https://app-ssl.stage.bestbuy.com");
        e = new gr("CUSTOM", 4, "");
        g = (new gr[] {
            a, b, c, d, e
        });
    }
}
