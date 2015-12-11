// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class yz extends Enum
{

    public static final yz a;
    public static final yz b;
    public static final yz c;
    public static final yz d;
    public static final yz e;
    private static final yz f[];

    private yz(String s, int i)
    {
        super(s, i);
    }

    public static yz valueOf(String s)
    {
        return (yz)Enum.valueOf(yz, s);
    }

    public static yz[] values()
    {
        return (yz[])f.clone();
    }

    static 
    {
        a = new yz("INIT", 0);
        b = new yz("READY_TO_RECORD", 1);
        c = new yz("COUNTDOWN", 2);
        d = new yz("RECORDING", 3);
        e = new yz("DONE_RECORDING", 4);
        f = (new yz[] {
            a, b, c, d, e
        });
    }
}
