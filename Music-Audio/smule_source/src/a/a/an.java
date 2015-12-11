// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class an extends Enum
{

    public static final an a;
    public static final an b;
    private static final an c[];

    private an(String s, int i)
    {
        super(s, i);
    }

    public static an valueOf(String s)
    {
        return (an)Enum.valueOf(a/a/an, s);
    }

    public static an[] values()
    {
        return (an[])c.clone();
    }

    static 
    {
        a = new an("ACTIVATED", 0);
        b = new an("DEACTIVATED", 1);
        c = (new an[] {
            a, b
        });
    }
}
