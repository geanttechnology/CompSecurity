// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bvb extends Enum
{

    public static final bvb a;
    public static final bvb b;
    public static final bvb c;
    private static final bvb e[];
    public final String d;

    private bvb(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static bvb valueOf(String s)
    {
        return (bvb)Enum.valueOf(bvb, s);
    }

    public static bvb[] values()
    {
        return (bvb[])e.clone();
    }

    static 
    {
        a = new bvb("NONE", 0, "0");
        b = new bvb("SKIPPABLE", 1, "1");
        c = new bvb("SURVEY", 2, "3");
        e = (new bvb[] {
            a, b, c
        });
    }
}
