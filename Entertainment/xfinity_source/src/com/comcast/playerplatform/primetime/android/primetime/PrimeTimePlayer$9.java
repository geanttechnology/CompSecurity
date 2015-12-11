// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer

static class g
{

    static final int $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[];
    static final int $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType[];
    static final int $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow[];
    static final int $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[];

    static 
    {
        $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting = new int[com.comcast.playerplatform.primetime.android.player.ting.values().length];
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.ting.BITRATE_PARAMS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.ting.INITIAL_BITRATE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.ting.BITRATE_RANGE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.ting.CAPTION_FORMAT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.ting.CAPTIONS_ENABLED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.ting.CAPTIONS_TRACK.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.ting.AUDIO_TRACK.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow = new int[DrmWorkflow.values().length];
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow[DrmWorkflow.STREAMING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow[DrmWorkflow.LOCAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow[DrmWorkflow.WHITE_LIST.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType = new int[com.adobe.mediacore.ation.EntryType.values().length];
        try
        {
            $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType[com.adobe.mediacore.ation.EntryType.ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType[com.adobe.mediacore.ation.EntryType.WARN.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState = new int[com.adobe.mediacore.State.values().length];
        try
        {
            $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[com.adobe.mediacore.State.INITIALIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[com.adobe.mediacore.State.PREPARED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[com.adobe.mediacore.State.PLAYING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[com.adobe.mediacore.State.ERROR.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
