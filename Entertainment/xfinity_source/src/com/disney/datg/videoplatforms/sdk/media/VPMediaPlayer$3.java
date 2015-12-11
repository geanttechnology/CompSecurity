// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaPlayer

static class e
{

    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AuthState[];
    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[];
    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[];

    static 
    {
        $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState = new int[ackableState.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.PROGRAM_START.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.PROGRAM_RESUME.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.PROGRAM_FORWARD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.PROGRAM_REWIND.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.PROGRAM_PAUSED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.PROGRAM_STOPPED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.AD_START.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.AD_END.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.AUTHORIZATION_START.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.AUTHORIZATION_FAIL.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.AUTHORIZATION_SUCCESS.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.COMPLETE_25.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.COMPLETE_50.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.COMPLETE_75.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.PROGRAM_END.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.COMPLETE.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.MEDIA_ERROR.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[ackableState.PING.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType = new int[sePlayerType.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[sePlayerType.UPLYNK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[sePlayerType.NATIVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AuthState = new int[e.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AuthState[e.AUTHORIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
