// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class gl extends Enum
{

    public static final gl a;
    public static final gl b;
    public static final gl c;
    public static final gl d;
    public static final gl e;
    private static final gl g[];
    public String f;

    private gl(String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }

    static 
    {
        a = new gl("PROD", 0, "https://app-ssl.bestbuy.com");
        b = new gl("QA1", 1, "https://qa1.iam-secure.bestbuy.com");
        c = new gl("STAGE", 2, "https://app-ssl.stage.bestbuy.com");
        d = new gl("CLOUD_TEST", 3, "https://app-ssl.cloud-test.bestbuy.com");
        e = new gl("CUSTOM", 4, "");
        g = (new gl[] {
            a, b, c, d, e
        });
    }
}
