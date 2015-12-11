// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cth extends Enum
{

    public static final cth a;
    public static final cth b;
    private static final cth c[];

    private cth(String s, int i)
    {
        super(s, i);
    }

    public static cth valueOf(String s)
    {
        return (cth)Enum.valueOf(cth, s);
    }

    public static cth[] values()
    {
        return (cth[])c.clone();
    }

    static 
    {
        a = new cth("NAVIGATION", 0);
        b = new cth("PLAYER_CONTROL", 1);
        c = (new cth[] {
            a, b
        });
    }
}
