// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.types;


public final class CollageType extends Enum
{

    public static final CollageType a;
    public static final CollageType b;
    public static final CollageType c;
    private static final CollageType d[];

    private CollageType(String s, int i)
    {
        super(s, i);
    }

    public static CollageType valueOf(String s)
    {
        return (CollageType)Enum.valueOf(com/cyberlink/youcammakeup/database/more/types/CollageType, s);
    }

    public static CollageType[] values()
    {
        return (CollageType[])d.clone();
    }

    static 
    {
        a = new CollageType("CLASSIC", 0);
        b = new CollageType("MODERN", 1);
        c = new CollageType("NONE", 2);
        d = (new CollageType[] {
            a, b, c
        });
    }
}
