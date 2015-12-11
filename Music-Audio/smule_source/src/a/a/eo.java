// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class eo extends Enum
{

    public static final eo a;
    public static final eo b;
    public static final eo c;
    private static final eo d[];

    private eo(String s, int i)
    {
        super(s, i);
    }

    public static eo valueOf(String s)
    {
        return (eo)Enum.valueOf(a/a/eo, s);
    }

    public static eo[] values()
    {
        return (eo[])d.clone();
    }

    static 
    {
        a = new eo("UNINITIALIZED", 0);
        b = new eo("ON", 1);
        c = new eo("OFF", 2);
        d = (new eo[] {
            a, b, c
        });
    }
}
