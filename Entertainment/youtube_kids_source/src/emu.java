// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class emu extends Enum
{

    public static final emu a;
    private static final emu b[];

    private emu(String s, int i)
    {
        super(s, 0);
    }

    public static emu valueOf(String s)
    {
        return (emu)Enum.valueOf(emu, s);
    }

    public static emu[] values()
    {
        return (emu[])b.clone();
    }

    static 
    {
        a = new emu("APPEND", 0);
        b = (new emu[] {
            a
        });
    }
}
