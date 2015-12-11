// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class pj extends Enum
{

    public static final pj a;
    public static final pj b;
    public static final pj c;
    private static final pj d[];

    private pj(String s, int i)
    {
        super(s, i);
    }

    public static pj valueOf(String s)
    {
        return (pj)Enum.valueOf(jumiomobile/pj, s);
    }

    public static pj[] values()
    {
        return (pj[])d.clone();
    }

    static 
    {
        a = new pj("SLOW", 0);
        b = new pj("MEDIUM", 1);
        c = new pj("FAST", 2);
        d = (new pj[] {
            a, b, c
        });
    }
}
