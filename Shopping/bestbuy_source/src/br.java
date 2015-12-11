// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class br extends Enum
{

    public static final br a;
    public static final br b;
    public static final br c;
    public static final br d;
    private static final br e[];

    private br(String s, int i)
    {
        super(s, i);
    }

    static 
    {
        a = new br("NATIVE_APP_INTENT", 0);
        b = new br("PRODUCT_SEARCH_LINK", 1);
        c = new br("ZXING_LINK", 2);
        d = new br("NONE", 3);
        e = (new br[] {
            a, b, c, d
        });
    }
}
