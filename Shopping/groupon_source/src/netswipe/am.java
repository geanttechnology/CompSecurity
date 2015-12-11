// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


public final class am extends Enum
{

    public static final am a;
    public static final am b;
    public static final am c;
    public static final am d;
    public static final am e;
    private static final am f[];

    private am(String s, int i)
    {
        super(s, i);
    }

    public static am valueOf(String s)
    {
        return (am)Enum.valueOf(netswipe/am, s);
    }

    public static am[] values()
    {
        return (am[])f.clone();
    }

    static 
    {
        a = new am("INIT", 0);
        b = new am("SCAN", 1);
        c = new am("ADDITIONAL_ENTRY", 2);
        d = new am("MANUAL_ENTRY", 3);
        e = new am("ERROR", 4);
        f = (new am[] {
            a, b, c, d, e
        });
    }
}
