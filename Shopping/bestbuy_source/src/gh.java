// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class gh extends Enum
{

    public static final gh a;
    public static final gh b;
    public static final gh c;
    public static final gh d;
    public static final gh e;
    private static final gh k[];
    public String f;
    public String g;
    public String h;
    public String i;
    public boolean j;

    private gh(String s, int l, String s1, String s2, Boolean boolean1, String s3, String s4)
    {
        super(s, l);
        f = s1;
        g = s2;
        j = boolean1.booleanValue();
        h = s3;
        i = s4;
    }

    public static gh a(String s)
    {
        return (gh)Enum.valueOf(gh, s);
    }

    static 
    {
        a = new gh("PROD", 0, "http://context.bestbuy.com", "TA1:MXRVMEFJUTRZajJCb25ERC9HLy91cytNdkdrNXF4RlJCS0N3bUlFNDR4OD0=", Boolean.valueOf(false), "", "");
        b = new gh("PROD_LIKE", 1, "http://pl.context.bestbuy.com", "TA1:WHdjUkV4dkhZYnRIeWo2dU1OOFRwa3NZMytoV1BrWk5KY0VWQmVJYXBqVT0=", Boolean.valueOf(false), "", "");
        c = new gh("QA", 2, "http://qa.context.bestbuy.com", "", Boolean.valueOf(true), "bby_context", "BestBuy1");
        d = new gh("DEV", 3, "http://dev.context.bestbuy.com", "", Boolean.valueOf(true), "bby_context", "BestBuy1");
        e = new gh("CUSTOM", 4, "", "", Boolean.valueOf(true), "bby_context", "BestBuy1");
        k = (new gh[] {
            a, b, c, d, e
        });
    }
}
