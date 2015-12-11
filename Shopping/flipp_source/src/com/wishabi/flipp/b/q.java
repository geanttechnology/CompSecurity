// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;


public final class q extends Enum
{

    public static final q a;
    public static final q b;
    public static final q c;
    public static final q d;
    public static final q e;
    private static final q h[];
    final int f;
    final String g;

    private q(String s, int i, int j, String s1)
    {
        super(s, i);
        f = j;
        g = s1;
    }

    public static q valueOf(String s)
    {
        return (q)Enum.valueOf(com/wishabi/flipp/b/q, s);
    }

    public static q[] values()
    {
        return (q[])h.clone();
    }

    static 
    {
        a = new q("OPEN", 0, 0, "open");
        b = new q("BARCODE", 1, 1, "barcode");
        c = new q("ADD", 2, 2, "add");
        d = new q("ADD_MATCHED", 3, 3, "addMatched");
        e = new q("SEND", 4, 4, "send");
        h = (new q[] {
            a, b, c, d, e
        });
    }
}
