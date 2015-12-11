// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.zip.Checksum;

abstract class elz extends Enum
    implements egf
{

    public static final elz a;
    public static final elz b;
    private static final elz d[];
    private final int c;

    elz(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    static int a(elz elz1)
    {
        return elz1.c;
    }

    public static elz valueOf(String s)
    {
        return (elz)Enum.valueOf(elz, s);
    }

    public static elz[] values()
    {
        return (elz[])d.clone();
    }

    public abstract Checksum a();

    public Object get()
    {
        return a();
    }

    static 
    {
        a = new ema("CRC_32", 0, 32);
        b = new emb("ADLER_32", 1, 32);
        d = (new elz[] {
            a, b
        });
    }
}
