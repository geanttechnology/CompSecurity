// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay;


public final class PlayerActionBarMenuType extends Enum
{

    private static final PlayerActionBarMenuType $VALUES[];
    public static final PlayerActionBarMenuType BABY_GUIDE;
    public static final PlayerActionBarMenuType FAVORITE;
    public static final PlayerActionBarMenuType HISTORY;

    private PlayerActionBarMenuType(String s, int i)
    {
        super(s, i);
    }

    public static PlayerActionBarMenuType valueOf(String s)
    {
        return (PlayerActionBarMenuType)Enum.valueOf(com/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType, s);
    }

    public static PlayerActionBarMenuType[] values()
    {
        return (PlayerActionBarMenuType[])$VALUES.clone();
    }

    static 
    {
        BABY_GUIDE = new PlayerActionBarMenuType("BABY_GUIDE", 0);
        HISTORY = new PlayerActionBarMenuType("HISTORY", 1);
        FAVORITE = new PlayerActionBarMenuType("FAVORITE", 2);
        $VALUES = (new PlayerActionBarMenuType[] {
            BABY_GUIDE, HISTORY, FAVORITE
        });
    }
}
