// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class nw extends Enum
{

    public static final nw a;
    public static final nw b;
    public static final nw c;
    private static final nw d[];

    private nw(String s, int i)
    {
        super(s, i);
    }

    static 
    {
        a = new nw("UNKNOWN", 0);
        b = new nw("MALE", 1);
        c = new nw("FEMALE", 2);
        d = (new nw[] {
            a, b, c
        });
    }
}
