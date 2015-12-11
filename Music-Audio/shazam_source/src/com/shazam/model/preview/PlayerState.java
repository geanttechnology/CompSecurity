// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.preview;


public final class PlayerState extends Enum
{

    private static final PlayerState $VALUES[];
    public static final PlayerState IDLE;
    public static final PlayerState PAUSED;
    public static final PlayerState PLAYING;
    public static final PlayerState PREPARING;

    private PlayerState(String s, int i)
    {
        super(s, i);
    }

    public static PlayerState valueOf(String s)
    {
        return (PlayerState)Enum.valueOf(com/shazam/model/preview/PlayerState, s);
    }

    public static PlayerState[] values()
    {
        return (PlayerState[])$VALUES.clone();
    }

    static 
    {
        IDLE = new PlayerState("IDLE", 0);
        PREPARING = new PlayerState("PREPARING", 1);
        PLAYING = new PlayerState("PLAYING", 2);
        PAUSED = new PlayerState("PAUSED", 3);
        $VALUES = (new PlayerState[] {
            IDLE, PREPARING, PLAYING, PAUSED
        });
    }
}
