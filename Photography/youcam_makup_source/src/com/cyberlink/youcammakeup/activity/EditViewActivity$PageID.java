// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


public final class A extends Enum
{

    public static final a a;
    private static final a b[];

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/cyberlink/youcammakeup/activity/EditViewActivity$PageID, s);
    }

    public static A[] values()
    {
        return (A[])b.clone();
    }

    static 
    {
        a = new <init>("singleView", 0);
        b = (new b[] {
            a
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
