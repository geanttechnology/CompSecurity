// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public final class  extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$TattooMask$TattooPosition, s);
    }

    public static [] values()
    {
        return ([])f.clone();
    }

    static 
    {
        a = new <init>("LEFT", 0);
        b = new <init>("RIGHT", 1);
        c = new <init>("UPPER", 2);
        d = new <init>("LOWER", 3);
        e = new <init>("NONE", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
