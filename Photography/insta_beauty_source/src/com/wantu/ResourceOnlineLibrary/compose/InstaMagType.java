// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;


public final class InstaMagType extends Enum
{

    private static final InstaMagType $VALUES[];
    public static final InstaMagType ALL_SIZE_TYPE;
    public static final InstaMagType LANDSCAPE_LIB_SIZE_TYPE;
    public static final InstaMagType LINK_LIB_SIZE_TYPE;
    public static final InstaMagType RECT_LIB_SIZE_TYPE;
    public static final InstaMagType SQ_LIB_SIZE_TYPE;

    private InstaMagType(String s, int i)
    {
        super(s, i);
    }

    public static InstaMagType valueOf(String s)
    {
        return (InstaMagType)Enum.valueOf(com/wantu/ResourceOnlineLibrary/compose/InstaMagType, s);
    }

    public static InstaMagType[] values()
    {
        return (InstaMagType[])$VALUES.clone();
    }

    static 
    {
        ALL_SIZE_TYPE = new InstaMagType("ALL_SIZE_TYPE", 0);
        SQ_LIB_SIZE_TYPE = new InstaMagType("SQ_LIB_SIZE_TYPE", 1);
        RECT_LIB_SIZE_TYPE = new InstaMagType("RECT_LIB_SIZE_TYPE", 2);
        LANDSCAPE_LIB_SIZE_TYPE = new InstaMagType("LANDSCAPE_LIB_SIZE_TYPE", 3);
        LINK_LIB_SIZE_TYPE = new InstaMagType("LINK_LIB_SIZE_TYPE", 4);
        $VALUES = (new InstaMagType[] {
            ALL_SIZE_TYPE, SQ_LIB_SIZE_TYPE, RECT_LIB_SIZE_TYPE, LANDSCAPE_LIB_SIZE_TYPE, LINK_LIB_SIZE_TYPE
        });
    }
}
