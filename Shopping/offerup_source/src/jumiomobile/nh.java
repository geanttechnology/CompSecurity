// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class nh extends Enum
{

    public static final nh a;
    public static final nh b;
    public static final nh c;
    private static final nh d[];

    private nh(String s, int i)
    {
        super(s, i);
    }

    public static nh valueOf(String s)
    {
        return (nh)Enum.valueOf(jumiomobile/nh, s);
    }

    public static nh[] values()
    {
        return (nh[])d.clone();
    }

    static 
    {
        a = new nh("PENDING", 0);
        b = new nh("SUCCESS", 1);
        c = new nh("ERROR", 2);
        d = (new nh[] {
            a, b, c
        });
    }
}
