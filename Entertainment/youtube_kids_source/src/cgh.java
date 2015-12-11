// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cgh extends Enum
{

    public static final cgh a;
    public static final cgh b;
    private static final cgh c[];

    private cgh(String s, int i)
    {
        super(s, i);
    }

    public static cgh valueOf(String s)
    {
        return (cgh)Enum.valueOf(cgh, s);
    }

    public static cgh[] values()
    {
        return (cgh[])c.clone();
    }

    static 
    {
        a = new cgh("REMOTE_CONTROL", 0);
        b = new cgh("LOUNGE_SCREEN", 1);
        c = (new cgh[] {
            a, b
        });
    }
}
