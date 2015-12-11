// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;


public final class PlayerVideoIntent extends Enum
{

    private static final PlayerVideoIntent $VALUES[];
    public static final PlayerVideoIntent POSITION;
    public static final PlayerVideoIntent WATCHABLE_KEY;

    private PlayerVideoIntent(String s, int i)
    {
        super(s, i);
    }

    public static PlayerVideoIntent valueOf(String s)
    {
        return (PlayerVideoIntent)Enum.valueOf(com/xfinity/playerlib/view/videoplay/PlayerVideoIntent, s);
    }

    public static PlayerVideoIntent[] values()
    {
        return (PlayerVideoIntent[])$VALUES.clone();
    }

    static 
    {
        WATCHABLE_KEY = new PlayerVideoIntent("WATCHABLE_KEY", 0);
        POSITION = new PlayerVideoIntent("POSITION", 1);
        $VALUES = (new PlayerVideoIntent[] {
            WATCHABLE_KEY, POSITION
        });
    }
}
