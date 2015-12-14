// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public final class A extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static final A a(String s)
    {
        if ("Natural".equals(s))
        {
            return a;
        }
        if ("Costume".equals(s))
        {
            return b;
        } else
        {
            return a;
        }
    }

    public static final String a(a a1)
    {
        if (a1 == a)
        {
            return "Natural";
        }
        if (a1 == b)
        {
            return "Costume";
        } else
        {
            return "Natural";
        }
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$LookType, s);
    }

    public static b[] values()
    {
        return (b[])c.clone();
    }

    static 
    {
        a = new <init>("NATURAL", 0);
        b = new <init>("COSTUME", 1);
        c = (new c[] {
            a, b
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
