// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ku extends Enum
{

    public static final ku a;
    public static final ku b;
    public static final ku c;
    private static final ku d[];

    private ku(String s, int i)
    {
        super(s, i);
    }

    static 
    {
        a = new ku("DEAL_OF_THE_DAY", 0);
        b = new ku("WEEKLY_DEALS", 1);
        c = new ku("UNKNOWN", 2);
        d = (new ku[] {
            a, b, c
        });
    }
}
