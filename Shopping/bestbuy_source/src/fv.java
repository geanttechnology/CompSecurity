// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class fv extends Enum
{

    public static final fv a;
    public static final fv b;
    private static final fv e[];
    public String c;
    public String d;

    private fv(String s, int i, String s1, String s2)
    {
        super(s, i);
        c = s1;
        d = s2;
    }

    public static fv a(String s)
    {
        return (fv)Enum.valueOf(fv, s);
    }

    static 
    {
        a = new fv("PROD", 0, "http://api.remix.bestbuy.com/v1", "k79nejwehxtssudf9ktp8ncr");
        b = new fv("CUSTOM", 1, "", "");
        e = (new fv[] {
            a, b
        });
    }
}
