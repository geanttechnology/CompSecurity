// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;


public final class A extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/cyberlink/beautycircle/utility/DialogUtils$ReportSource, s);
    }

    public static A[] values()
    {
        return (A[])d.clone();
    }

    static 
    {
        a = new <init>("POST", 0);
        b = new <init>("PRODUCT", 1);
        c = new <init>("CONTEST_POST", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
