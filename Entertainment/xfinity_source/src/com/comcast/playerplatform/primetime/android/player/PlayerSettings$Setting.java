// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;


// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            PlayerSettings

public static final class  extends Enum
{

    private static final AUDIO_TRACK $VALUES[];
    public static final AUDIO_TRACK AD_BREAK_POLICIES;
    public static final AUDIO_TRACK AD_TYPE;
    public static final AUDIO_TRACK AUDIO_TRACK;
    public static final AUDIO_TRACK AUTOPLAY;
    public static final AUDIO_TRACK BITRATE_PARAMS;
    public static final AUDIO_TRACK BITRATE_RANGE;
    public static final AUDIO_TRACK C3_ADS;
    public static final AUDIO_TRACK CAPTIONS_ENABLED;
    public static final AUDIO_TRACK CAPTIONS_TRACK;
    public static final AUDIO_TRACK CAPTION_FORMAT;
    public static final AUDIO_TRACK DEVICE_ID;
    public static final AUDIO_TRACK HEIGHT;
    public static final AUDIO_TRACK INITIAL_BITRATE;
    public static final AUDIO_TRACK LOGGER_VERBOSITY;
    public static final AUDIO_TRACK LOG_FACTORY;
    public static final AUDIO_TRACK UPDATE_INTERVAL;
    public static final AUDIO_TRACK VOLUME;
    public static final AUDIO_TRACK WIDTH;
    public static final AUDIO_TRACK ZOOM_SETTING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        WIDTH = new <init>("WIDTH", 0);
        HEIGHT = new <init>("HEIGHT", 1);
        BITRATE_PARAMS = new <init>("BITRATE_PARAMS", 2);
        CAPTION_FORMAT = new <init>("CAPTION_FORMAT", 3);
        AD_BREAK_POLICIES = new <init>("AD_BREAK_POLICIES", 4);
        LOGGER_VERBOSITY = new <init>("LOGGER_VERBOSITY", 5);
        LOG_FACTORY = new <init>("LOG_FACTORY", 6);
        UPDATE_INTERVAL = new <init>("UPDATE_INTERVAL", 7);
        AUTOPLAY = new <init>("AUTOPLAY", 8);
        VOLUME = new <init>("VOLUME", 9);
        ZOOM_SETTING = new <init>("ZOOM_SETTING", 10);
        AD_TYPE = new <init>("AD_TYPE", 11);
        C3_ADS = new <init>("C3_ADS", 12);
        INITIAL_BITRATE = new <init>("INITIAL_BITRATE", 13);
        BITRATE_RANGE = new <init>("BITRATE_RANGE", 14);
        DEVICE_ID = new <init>("DEVICE_ID", 15);
        CAPTIONS_ENABLED = new <init>("CAPTIONS_ENABLED", 16);
        CAPTIONS_TRACK = new <init>("CAPTIONS_TRACK", 17);
        AUDIO_TRACK = new <init>("AUDIO_TRACK", 18);
        $VALUES = (new .VALUES[] {
            WIDTH, HEIGHT, BITRATE_PARAMS, CAPTION_FORMAT, AD_BREAK_POLICIES, LOGGER_VERBOSITY, LOG_FACTORY, UPDATE_INTERVAL, AUTOPLAY, VOLUME, 
            ZOOM_SETTING, AD_TYPE, C3_ADS, INITIAL_BITRATE, BITRATE_RANGE, DEVICE_ID, CAPTIONS_ENABLED, CAPTIONS_TRACK, AUDIO_TRACK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
