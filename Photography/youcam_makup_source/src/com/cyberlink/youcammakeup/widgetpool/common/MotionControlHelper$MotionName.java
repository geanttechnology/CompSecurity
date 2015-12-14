// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;


public final class Q extends Enum
{

    public static final a a;
    private static final a b[];

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/MotionControlHelper$MotionName, s);
    }

    public static Q[] values()
    {
        return (Q[])b.clone();
    }

    static 
    {
        a = new <init>("MouthOpen", 0);
        b = (new b[] {
            a
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
