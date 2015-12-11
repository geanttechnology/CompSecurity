// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class tk extends Enum
{

    private static tk a;
    private static tk b;
    private static tk c;
    private static tk d;
    private static tk e;
    private static final tk g[];
    private float f;

    private tk(String s, int i, int j, float f1)
    {
        super(s, i);
        f = f1;
    }

    public static float a()
    {
        return values()[2].f;
    }

    public static tk valueOf(String s)
    {
        return (tk)Enum.valueOf(tk, s);
    }

    public static tk[] values()
    {
        return (tk[])g.clone();
    }

    static 
    {
        a = new tk("VERY_SMALL", 0, 0x7f0b00c3, 0.25F);
        b = new tk("SMALL", 1, 0x7f0b00c4, 0.5F);
        c = new tk("NORMAL", 2, 0x7f0b00c5, 1.0F);
        d = new tk("LARGE", 3, 0x7f0b00c6, 1.5F);
        e = new tk("VERY_LARGE", 4, 0x7f0b00c7, 2.0F);
        g = (new tk[] {
            a, b, c, d, e
        });
    }
}
