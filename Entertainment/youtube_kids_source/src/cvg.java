// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cvg extends Enum
{

    public static final cvg a;
    private static cvg b;
    private static final cvg c[];

    private cvg(String s, int i)
    {
        super(s, i);
    }

    public static cvg valueOf(String s)
    {
        return (cvg)Enum.valueOf(cvg, s);
    }

    public static cvg[] values()
    {
        return (cvg[])c.clone();
    }

    static 
    {
        a = new cvg("AD_MARKER", 0);
        b = new cvg("UNKNOWN", 1);
        c = (new cvg[] {
            a, b
        });
    }
}
