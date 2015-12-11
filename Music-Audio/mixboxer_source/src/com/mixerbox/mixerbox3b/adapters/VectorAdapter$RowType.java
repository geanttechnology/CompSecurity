// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.adapters;


public final class  extends Enum
{

    private static final DJ_INFO_ITEM $VALUES[];
    public static final DJ_INFO_ITEM DIVIDER_ITEM;
    public static final DJ_INFO_ITEM DJ_INFO_ITEM;
    public static final DJ_INFO_ITEM DJ_ITEM;
    public static final DJ_INFO_ITEM EMPTY_ITEM;
    public static final DJ_INFO_ITEM GENERAL_ITEM;
    public static final DJ_INFO_ITEM MORE_ITEM;
    public static final DJ_INFO_ITEM MUSIC_ITEM;
    public static final DJ_INFO_ITEM PLAYLIST_ITEM;
    public static final DJ_INFO_ITEM VECTOR_ITEM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VECTOR_ITEM = new <init>("VECTOR_ITEM", 0);
        DIVIDER_ITEM = new <init>("DIVIDER_ITEM", 1);
        MORE_ITEM = new <init>("MORE_ITEM", 2);
        DJ_ITEM = new <init>("DJ_ITEM", 3);
        PLAYLIST_ITEM = new <init>("PLAYLIST_ITEM", 4);
        MUSIC_ITEM = new <init>("MUSIC_ITEM", 5);
        GENERAL_ITEM = new <init>("GENERAL_ITEM", 6);
        EMPTY_ITEM = new <init>("EMPTY_ITEM", 7);
        DJ_INFO_ITEM = new <init>("DJ_INFO_ITEM", 8);
        $VALUES = (new .VALUES[] {
            VECTOR_ITEM, DIVIDER_ITEM, MORE_ITEM, DJ_ITEM, PLAYLIST_ITEM, MUSIC_ITEM, GENERAL_ITEM, EMPTY_ITEM, DJ_INFO_ITEM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
