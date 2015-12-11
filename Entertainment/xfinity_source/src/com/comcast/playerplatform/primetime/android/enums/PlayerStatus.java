// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.enums;


public final class PlayerStatus extends Enum
{

    private static final PlayerStatus $VALUES[];
    public static final PlayerStatus COMPLETE;
    public static final PlayerStatus ERROR;
    public static final PlayerStatus IDLE;
    public static final PlayerStatus INITIALIZED;
    public static final PlayerStatus INITIALIZING;
    public static final PlayerStatus PAUSED;
    public static final PlayerStatus PLAYING;
    public static final PlayerStatus PREPARED;
    public static final PlayerStatus PREPARING;
    public static final PlayerStatus READY;
    public static final PlayerStatus RELEASED;
    public static final PlayerStatus SUSPENDED;

    private PlayerStatus(String s, int i)
    {
        super(s, i);
    }

    public static PlayerStatus valueOf(String s)
    {
        return (PlayerStatus)Enum.valueOf(com/comcast/playerplatform/primetime/android/enums/PlayerStatus, s);
    }

    public static PlayerStatus[] values()
    {
        return (PlayerStatus[])$VALUES.clone();
    }

    static 
    {
        IDLE = new PlayerStatus("IDLE", 0);
        INITIALIZING = new PlayerStatus("INITIALIZING", 1);
        INITIALIZED = new PlayerStatus("INITIALIZED", 2);
        PREPARING = new PlayerStatus("PREPARING", 3);
        PREPARED = new PlayerStatus("PREPARED", 4);
        READY = new PlayerStatus("READY", 5);
        PLAYING = new PlayerStatus("PLAYING", 6);
        PAUSED = new PlayerStatus("PAUSED", 7);
        COMPLETE = new PlayerStatus("COMPLETE", 8);
        ERROR = new PlayerStatus("ERROR", 9);
        RELEASED = new PlayerStatus("RELEASED", 10);
        SUSPENDED = new PlayerStatus("SUSPENDED", 11);
        $VALUES = (new PlayerStatus[] {
            IDLE, INITIALIZING, INITIALIZED, PREPARING, PREPARED, READY, PLAYING, PAUSED, COMPLETE, ERROR, 
            RELEASED, SUSPENDED
        });
    }
}
