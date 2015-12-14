// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.types;


public final class CollageLayoutType extends Enum
{

    public static final CollageLayoutType a;
    public static final CollageLayoutType b;
    public static final CollageLayoutType c;
    private static final CollageLayoutType d[];

    private CollageLayoutType(String s, int i)
    {
        super(s, i);
    }

    public static CollageLayoutType valueOf(String s)
    {
        return (CollageLayoutType)Enum.valueOf(com/cyberlink/youcammakeup/database/more/types/CollageLayoutType, s);
    }

    public static CollageLayoutType[] values()
    {
        return (CollageLayoutType[])d.clone();
    }

    static 
    {
        a = new CollageLayoutType("LANDSCAPE", 0);
        b = new CollageLayoutType("PORTRAIT", 1);
        c = new CollageLayoutType("NONE", 2);
        d = (new CollageLayoutType[] {
            a, b, c
        });
    }
}
