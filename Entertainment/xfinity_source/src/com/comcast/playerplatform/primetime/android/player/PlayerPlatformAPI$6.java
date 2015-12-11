// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import com.comcast.playerplatform.primetime.android.enums.InitialPlayerState;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            PlayerPlatformAPI

static class 
{

    static final int $SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState[];
    static final int $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[];

    static 
    {
        $SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState = new int[InitialPlayerState.values().length];
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState[InitialPlayerState.PLAY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState[InitialPlayerState.PAUSE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus = new int[PlayerStatus.values().length];
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.INITIALIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.PREPARED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.PAUSED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.PLAYING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.SUSPENDED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.ERROR.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
