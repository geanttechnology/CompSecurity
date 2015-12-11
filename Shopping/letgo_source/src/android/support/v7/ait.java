// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class ait extends Enum
{

    public static final ait a;
    public static final ait b;
    public static final ait c;
    public static final ait d;
    public static final ait e;
    public static final ait f;
    private static final ait g[];

    private ait(String s, int i)
    {
        super(s, i);
    }

    public static ait valueOf(String s)
    {
        return (ait)Enum.valueOf(android/support/v7/ait, s);
    }

    public static ait[] values()
    {
        return (ait[])g.clone();
    }

    static 
    {
        a = new ait("NONE", 0);
        b = new ait("NONE_SAFE", 1);
        c = new ait("IN_SAMPLE_POWER_OF_2", 2);
        d = new ait("IN_SAMPLE_INT", 3);
        e = new ait("EXACTLY", 4);
        f = new ait("EXACTLY_STRETCHED", 5);
        g = (new ait[] {
            a, b, c, d, e, f
        });
    }
}
