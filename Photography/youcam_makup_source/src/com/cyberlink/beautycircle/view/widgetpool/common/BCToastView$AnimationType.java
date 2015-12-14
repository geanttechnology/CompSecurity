// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;


public final class Q extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/cyberlink/beautycircle/view/widgetpool/common/BCToastView$AnimationType, s);
    }

    public static Q[] values()
    {
        return (Q[])c.clone();
    }

    static 
    {
        a = new <init>("FADE", 0);
        b = new <init>("TRANSLATE", 1);
        c = (new c[] {
            a, b
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
