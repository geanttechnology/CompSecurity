// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ceg extends Enum
{

    public static final ceg a;
    public static final ceg b;
    public static final ceg c;
    private static final ceg d[];

    private ceg(String s, int i, int j)
    {
        super(s, i);
    }

    public static ceg valueOf(String s)
    {
        return (ceg)Enum.valueOf(ceg, s);
    }

    public static ceg[] values()
    {
        return (ceg[])d.clone();
    }

    static 
    {
        a = new ceg("PUBLIC", 0, 0x7f0b008d);
        b = new ceg("UNLISTED", 1, 0x7f0b008f);
        c = new ceg("PRIVATE", 2, 0x7f0b008e);
        d = (new ceg[] {
            a, b, c
        });
    }
}
