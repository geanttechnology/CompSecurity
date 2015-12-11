// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bxj extends Enum
{

    public static final bxj a;
    public static final bxj b;
    private static bxj c;
    private static final bxj d[];

    private bxj(String s, int i)
    {
        super(s, i);
    }

    public static bxj valueOf(String s)
    {
        return (bxj)Enum.valueOf(bxj, s);
    }

    public static bxj[] values()
    {
        return (bxj[])d.clone();
    }

    static 
    {
        a = new bxj("DISABLED", 0);
        c = new bxj("WRITE_ONLY", 1);
        b = new bxj("ENABLED", 2);
        d = (new bxj[] {
            a, c, b
        });
    }
}
