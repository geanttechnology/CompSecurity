// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.common;


public final class CollageType extends Enum
{

    private static final CollageType $VALUES[];
    public static final CollageType COLLAGE_COMIC;
    public static final CollageType COLLAGE_MAGZINE;

    private CollageType(String s, int i)
    {
        super(s, i);
    }

    public static CollageType valueOf(String s)
    {
        return (CollageType)Enum.valueOf(com/instamag/common/CollageType, s);
    }

    public static CollageType[] values()
    {
        return (CollageType[])$VALUES.clone();
    }

    static 
    {
        COLLAGE_MAGZINE = new CollageType("COLLAGE_MAGZINE", 0);
        COLLAGE_COMIC = new CollageType("COLLAGE_COMIC", 1);
        $VALUES = (new CollageType[] {
            COLLAGE_MAGZINE, COLLAGE_COMIC
        });
    }
}
