// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;


public final class FlipViewType extends Enum
{

    private static final FlipViewType $VALUES[];
    public static final FlipViewType FLIP_HORIZONTAL;
    public static final FlipViewType FLIP_HORIZONTAL_AND_VERTICAL;
    public static final FlipViewType FLIP_NORMAL;
    public static final FlipViewType FLIP_VERTICAL;

    private FlipViewType(String s, int i)
    {
        super(s, i);
    }

    public static FlipViewType valueOf(String s)
    {
        return (FlipViewType)Enum.valueOf(com/wantu/ResourceOnlineLibrary/compose/FlipViewType, s);
    }

    public static FlipViewType[] values()
    {
        return (FlipViewType[])$VALUES.clone();
    }

    static 
    {
        FLIP_NORMAL = new FlipViewType("FLIP_NORMAL", 0);
        FLIP_HORIZONTAL = new FlipViewType("FLIP_HORIZONTAL", 1);
        FLIP_VERTICAL = new FlipViewType("FLIP_VERTICAL", 2);
        FLIP_HORIZONTAL_AND_VERTICAL = new FlipViewType("FLIP_HORIZONTAL_AND_VERTICAL", 3);
        $VALUES = (new FlipViewType[] {
            FLIP_NORMAL, FLIP_HORIZONTAL, FLIP_VERTICAL, FLIP_HORIZONTAL_AND_VERTICAL
        });
    }
}
