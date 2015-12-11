// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class gb extends Enum
{

    public static final gb a;
    public static final gb b;
    public static final gb c;
    public static final gb d;
    public static final gb e;
    public static final gb f;
    private static final gb h[];
    public String g;

    private gb(String s, int i, String s1)
    {
        super(s, i);
        g = s1;
    }

    public static gb a(String s)
    {
        return (gb)Enum.valueOf(gb, s);
    }

    static 
    {
        a = new gb("PROD", 0, "http://www.bestbuy.com/cartitems/cart/");
        b = new gb("QA1", 1, "http://www.qa.bestbuy.com/cartitems/cart/");
        c = new gb("QA3", 2, "http://bby-qa3.bestbuy.com/cartitems/cart/");
        d = new gb("STAGE", 3, "http://www.stage.bestbuy.com/cartitems/cart/");
        e = new gb("CDC", 4, "https://ets-commerceproductteam-cart1541release-atgci.cdc.bestbuy.com/cartitems/cart/");
        f = new gb("CUSTOM", 5, "");
        h = (new gb[] {
            a, b, c, d, e, f
        });
    }
}
