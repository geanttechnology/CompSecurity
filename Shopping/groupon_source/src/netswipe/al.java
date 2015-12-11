// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


public final class al extends Enum
{

    public static final al a;
    public static final al b;
    private static final al c[];

    private al(String s, int i)
    {
        super(s, i);
    }

    public static al valueOf(String s)
    {
        return (al)Enum.valueOf(netswipe/al, s);
    }

    public static al[] values()
    {
        return (al[])c.clone();
    }

    static 
    {
        a = new al("NATIVE", 0);
        b = new al("NONE", 1);
        c = (new al[] {
            a, b
        });
    }
}
