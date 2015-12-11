// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class uc extends Enum
{

    public static final uc a;
    public static final uc b;
    public static final uc c;
    private static final uc d[];

    private uc(String s, int i)
    {
        super(s, i);
    }

    public static uc valueOf(String s)
    {
        return (uc)Enum.valueOf(uc, s);
    }

    public static uc[] values()
    {
        return (uc[])d.clone();
    }

    public final boolean a()
    {
        return this == b || this == c;
    }

    static 
    {
        a = new uc("NOT_AVAILABLE", 0);
        b = new uc("AVAILABLE", 1);
        c = new uc("PENDING", 2);
        d = (new uc[] {
            a, b, c
        });
    }
}
