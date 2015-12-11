// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ft extends Enum
{

    public static final ft a;
    public static final ft b;
    public static final ft c;
    public static final ft d;
    public static final ft e;
    public static final ft f;
    public static final ft g;
    public static final ft h;
    public static final ft i;
    public static final ft j;
    public static final ft k;
    public static final ft l;
    private static final ft m[];

    private ft(String s, int i1)
    {
        super(s, i1);
    }

    static 
    {
        a = new ft("PROD", 0);
        b = new ft("PROD_LIKE", 1);
        c = new ft("CLOUD_TEST", 2);
        d = new ft("STAGE", 3);
        e = new ft("QA", 4);
        f = new ft("QA1", 5);
        g = new ft("QA2", 6);
        h = new ft("QA3", 7);
        i = new ft("CDC", 8);
        j = new ft("DEV", 9);
        k = new ft("LOCAL", 10);
        l = new ft("CUSTOM", 11);
        m = (new ft[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
    }
}
