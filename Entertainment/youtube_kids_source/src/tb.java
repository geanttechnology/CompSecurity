// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class tb extends Enum
{

    public static final tb a;
    public static final tb b;
    public static final tb c;
    public static final tb d;
    public static final tb e;
    private static tb f;
    private static tb g;
    private static tb h;
    private static tb i;
    private static final tb k[];
    private int j;

    private tb(String s, int l, int i1, int j1)
    {
        super(s, l);
        j = j1;
    }

    public static int a()
    {
        return values()[2].j;
    }

    static int a(tb tb1)
    {
        return tb1.j;
    }

    public static int b()
    {
        return values()[0].j;
    }

    public static int c()
    {
        return values()[1].j;
    }

    public static int d()
    {
        return values()[2].j;
    }

    public static tb valueOf(String s)
    {
        return (tb)Enum.valueOf(tb, s);
    }

    public static tb[] values()
    {
        return (tb[])k.clone();
    }

    static 
    {
        a = new tb("NONE", 0, 0x7f0b00ba, 0);
        b = new tb("WHITE", 1, 0x7f0b00bb, -1);
        c = new tb("BLACK", 2, 0x7f0b00bc, 0xff000000);
        f = new tb("RED", 3, 0x7f0b00bd, 0xffff0000);
        d = new tb("YELLOW", 4, 0x7f0b00be, -256);
        g = new tb("GREEN", 5, 0x7f0b00bf, 0xff00ff00);
        h = new tb("CYAN", 6, 0x7f0b00c0, 0xff00ffff);
        e = new tb("BLUE", 7, 0x7f0b00c1, 0xff0000ff);
        i = new tb("MAGENTA", 8, 0x7f0b00c2, -65281);
        k = (new tb[] {
            a, b, c, f, d, g, h, e, i
        });
    }
}
