// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class no extends Enum
{

    public static final no a;
    public static final no b;
    private static final no c[];

    private no(String s, int i)
    {
        super(s, i);
    }

    public static no valueOf(String s)
    {
        return (no)Enum.valueOf(jumiomobile/no, s);
    }

    public static no[] values()
    {
        return (no[])c.clone();
    }

    static 
    {
        a = new no("CLOCKWISE", 0);
        b = new no("COUNTERCLOCKWISE", 1);
        c = (new no[] {
            a, b
        });
    }
}
