// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class mg extends Enum
{

    public static final mg a;
    public static final mg b;
    private static mg c;
    private static mg d;
    private static final mg e[];

    private mg(String s, int i)
    {
        super(s, i);
    }

    public static mg valueOf(String s)
    {
        return (mg)Enum.valueOf(mg, s);
    }

    public static mg[] values()
    {
        return (mg[])e.clone();
    }

    static 
    {
        c = new mg("LOW", 0);
        a = new mg("NORMAL", 1);
        d = new mg("HIGH", 2);
        b = new mg("IMMEDIATE", 3);
        e = (new mg[] {
            c, a, d, b
        });
    }
}
