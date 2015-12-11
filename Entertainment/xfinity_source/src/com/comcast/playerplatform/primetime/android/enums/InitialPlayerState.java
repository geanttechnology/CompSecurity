// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.enums;


public final class InitialPlayerState extends Enum
{

    private static final InitialPlayerState $VALUES[];
    public static final InitialPlayerState PAUSE;
    public static final InitialPlayerState PLAY;
    public static final InitialPlayerState USE_AUTO_PLAY;

    private InitialPlayerState(String s, int i)
    {
        super(s, i);
    }

    public static InitialPlayerState valueOf(String s)
    {
        return (InitialPlayerState)Enum.valueOf(com/comcast/playerplatform/primetime/android/enums/InitialPlayerState, s);
    }

    public static InitialPlayerState[] values()
    {
        return (InitialPlayerState[])$VALUES.clone();
    }

    static 
    {
        PLAY = new InitialPlayerState("PLAY", 0);
        PAUSE = new InitialPlayerState("PAUSE", 1);
        USE_AUTO_PLAY = new InitialPlayerState("USE_AUTO_PLAY", 2);
        $VALUES = (new InitialPlayerState[] {
            PLAY, PAUSE, USE_AUTO_PLAY
        });
    }
}
