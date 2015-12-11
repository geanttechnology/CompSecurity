// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cyu extends Enum
{

    public static final cyu a;
    public static final cyu b;
    private static final cyu c[];

    private cyu(String s, int i)
    {
        super(s, i);
    }

    public static cyu valueOf(String s)
    {
        return (cyu)Enum.valueOf(cyu, s);
    }

    public static cyu[] values()
    {
        return (cyu[])c.clone();
    }

    static 
    {
        a = new cyu("ENTER", 0);
        b = new cyu("EXIT", 1);
        c = (new cyu[] {
            a, b
        });
    }
}
