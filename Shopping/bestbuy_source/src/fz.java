// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class fz extends Enum
{

    public static final fz a;
    public static final fz b;
    public static final fz c;
    public static final fz d;
    public static final fz e;
    private static final fz h[];
    private String f;
    private String g;

    private fz(String s, int i, String s1, String s2)
    {
        super(s, i);
        f = s1;
        g = s2;
    }

    public String a()
    {
        return f;
    }

    public String b()
    {
        return g;
    }

    static 
    {
        a = new fz("PROD", 0, "https://commerce-ssl.bestbuy.com", "3f96af3f-912d-4a66-b6a9-639be43e3911");
        b = new fz("QA", 1, "https://commerce.qa.bestbuy.com", "f97cb11e-d3a3-429a-9b4e-db86a671c182");
        c = new fz("QA2", 2, "https://commerce-qa2.bestbuy.com", "f97cb11e-d3a3-429a-9b4e-db86a671c182");
        d = new fz("QA3", 3, "https://commerce-qa3.bestbuy.com", "f97cb11e-d3a3-429a-9b4e-db86a671c182");
        e = new fz("STAGING", 4, "https://commerce-ssl.stage.bestbuy.com", "f97cb11e-d3a3-429a-9b4e-db86a671c182");
        h = (new fz[] {
            a, b, c, d, e
        });
    }
}
