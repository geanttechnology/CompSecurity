// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.facebook;


public final class Q extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/cyberlink/beautycircle/view/widgetpool/facebook/LoginButton$ToolTipMode, s);
    }

    public static Q[] values()
    {
        return (Q[])d.clone();
    }

    static 
    {
        a = new <init>("DEFAULT", 0);
        b = new <init>("DISPLAY_ALWAYS", 1);
        c = new <init>("NEVER_DISPLAY", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
