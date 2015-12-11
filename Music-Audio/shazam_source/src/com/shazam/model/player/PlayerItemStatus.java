// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;


public final class PlayerItemStatus extends Enum
{

    private static final PlayerItemStatus $VALUES[];
    public static final PlayerItemStatus DISLIKED;
    public static final PlayerItemStatus LIKED;
    public static final PlayerItemStatus NEUTRAL;

    private PlayerItemStatus(String s, int i)
    {
        super(s, i);
    }

    public static PlayerItemStatus defaultStatus()
    {
        return NEUTRAL;
    }

    public static PlayerItemStatus valueOf(String s)
    {
        return (PlayerItemStatus)Enum.valueOf(com/shazam/model/player/PlayerItemStatus, s);
    }

    public static PlayerItemStatus[] values()
    {
        return (PlayerItemStatus[])$VALUES.clone();
    }

    static 
    {
        LIKED = new PlayerItemStatus("LIKED", 0);
        DISLIKED = new PlayerItemStatus("DISLIKED", 1);
        NEUTRAL = new PlayerItemStatus("NEUTRAL", 2);
        $VALUES = (new PlayerItemStatus[] {
            LIKED, DISLIKED, NEUTRAL
        });
    }
}
