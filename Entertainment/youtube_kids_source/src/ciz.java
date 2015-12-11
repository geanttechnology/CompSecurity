// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ciz extends Enum
{

    public static final ciz a;
    public static final ciz b;
    public static final ciz c;
    private static final ciz d[];

    private ciz(String s, int i)
    {
        super(s, i);
    }

    public static ciz valueOf(String s)
    {
        return (ciz)Enum.valueOf(ciz, s);
    }

    public static ciz[] values()
    {
        return (ciz[])d.clone();
    }

    static 
    {
        a = new ciz("MOBILE", 0);
        b = new ciz("WIFI", 1);
        c = new ciz("UNSPECIFIED", 2);
        d = (new ciz[] {
            a, b, c
        });
    }
}
