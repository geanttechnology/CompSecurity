// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;


// Referenced classes of package com.conviva.streamerProxies:
//            VisualOnImplProxy

static class O_OSMP_CB_EVENT_ID
{

    static final int $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[];

    static 
    {
        $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID = new int[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.values().length];
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_ADAPTIVE_STREAMING_ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_FAIL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_LOSS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_REJECTED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_TIMEOUT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DOWNLOAD_FAIL.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_AV_OUT_FAIL.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_FAIL.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_NOT_SECURE.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PLAYLIST_PARSE_ERR.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_ADAPTIVE_STREAMING_INFO.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_PLAY_COMPLETE.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PD_BUFFERING_PERCENT.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_AUDIO_START_BUFFER.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_START_BUFFER.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_AUDIO_STOP_BUFFER.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_STOP_BUFFER.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.er.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_RENDER_START.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
