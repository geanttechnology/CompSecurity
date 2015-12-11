// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import com.comcast.playerplatform.drm.java.client.ClientState;
import com.comcast.playerplatform.drm.java.util.AuthenticationDelegate;
import com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies;
import com.comcast.playerplatform.primetime.android.enums.AdType;
import com.comcast.playerplatform.primetime.android.enums.ZoomSetting;
import com.comcast.playerplatform.primetime.android.primetime.PlayerAudioTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.util.ClosedCaptionFormatBuilder;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.util.android.Range;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            PlayerSettingsListener

public class PlayerSettings
{
    public static final class Setting extends Enum
    {

        private static final Setting $VALUES[];
        public static final Setting AD_BREAK_POLICIES;
        public static final Setting AD_TYPE;
        public static final Setting AUDIO_TRACK;
        public static final Setting AUTOPLAY;
        public static final Setting BITRATE_PARAMS;
        public static final Setting BITRATE_RANGE;
        public static final Setting C3_ADS;
        public static final Setting CAPTIONS_ENABLED;
        public static final Setting CAPTIONS_TRACK;
        public static final Setting CAPTION_FORMAT;
        public static final Setting DEVICE_ID;
        public static final Setting HEIGHT;
        public static final Setting INITIAL_BITRATE;
        public static final Setting LOGGER_VERBOSITY;
        public static final Setting LOG_FACTORY;
        public static final Setting UPDATE_INTERVAL;
        public static final Setting VOLUME;
        public static final Setting WIDTH;
        public static final Setting ZOOM_SETTING;

        public static Setting valueOf(String s)
        {
            return (Setting)Enum.valueOf(com/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting, s);
        }

        public static Setting[] values()
        {
            return (Setting[])$VALUES.clone();
        }

        static 
        {
            WIDTH = new Setting("WIDTH", 0);
            HEIGHT = new Setting("HEIGHT", 1);
            BITRATE_PARAMS = new Setting("BITRATE_PARAMS", 2);
            CAPTION_FORMAT = new Setting("CAPTION_FORMAT", 3);
            AD_BREAK_POLICIES = new Setting("AD_BREAK_POLICIES", 4);
            LOGGER_VERBOSITY = new Setting("LOGGER_VERBOSITY", 5);
            LOG_FACTORY = new Setting("LOG_FACTORY", 6);
            UPDATE_INTERVAL = new Setting("UPDATE_INTERVAL", 7);
            AUTOPLAY = new Setting("AUTOPLAY", 8);
            VOLUME = new Setting("VOLUME", 9);
            ZOOM_SETTING = new Setting("ZOOM_SETTING", 10);
            AD_TYPE = new Setting("AD_TYPE", 11);
            C3_ADS = new Setting("C3_ADS", 12);
            INITIAL_BITRATE = new Setting("INITIAL_BITRATE", 13);
            BITRATE_RANGE = new Setting("BITRATE_RANGE", 14);
            DEVICE_ID = new Setting("DEVICE_ID", 15);
            CAPTIONS_ENABLED = new Setting("CAPTIONS_ENABLED", 16);
            CAPTIONS_TRACK = new Setting("CAPTIONS_TRACK", 17);
            AUDIO_TRACK = new Setting("AUDIO_TRACK", 18);
            $VALUES = (new Setting[] {
                WIDTH, HEIGHT, BITRATE_PARAMS, CAPTION_FORMAT, AD_BREAK_POLICIES, LOGGER_VERBOSITY, LOG_FACTORY, UPDATE_INTERVAL, AUTOPLAY, VOLUME, 
                ZOOM_SETTING, AD_TYPE, C3_ADS, INITIAL_BITRATE, BITRATE_RANGE, DEVICE_ID, CAPTIONS_ENABLED, CAPTIONS_TRACK, AUDIO_TRACK
            });
        }

        private Setting(String s, int i)
        {
            super(s, i);
        }
    }


    private PlayerAdBreakPolicies adBreakPolicies;
    private AdType adType;
    private AuthenticationDelegate authDelegate;
    private boolean autoplay;
    private Range bitRange;
    private List c3ads;
    private ClosedCaptionFormatBuilder captionFormat;
    private boolean ccEnabled;
    private ClientState clientState;
    private PlayerClosedCaptionsTrack closedCaptionsTrack;
    private boolean comscoreEnabled;
    private String deviceId;
    private int height;
    private int initialBitrate;
    private List listeners;
    private LogFactory logFactory;
    private com.adobe.mediacore.logging.Logger.Verbosity loggerVerbosity;
    private PlayerAudioTrack preferredAudioLanguage;
    private Map targetingParameters;
    private int updateInterval;
    private int volume;
    private int width;
    private ZoomSetting zoomSetting;

    public PlayerSettings()
    {
        width = -1;
        height = -1;
        updateInterval = 1000;
        autoplay = true;
        volume = 100;
        zoomSetting = ZoomSetting.None;
        adType = AdType.NONE;
        listeners = new ArrayList();
    }

    public void addListener(PlayerSettingsListener playersettingslistener)
    {
        listeners.add(playersettingslistener);
    }

    public PlayerAdBreakPolicies getAdBreakPolicies()
    {
        return adBreakPolicies;
    }

    public AdType getAdType()
    {
        return adType;
    }

    public AuthenticationDelegate getAuthDelegate()
    {
        return authDelegate;
    }

    public Range getBitRange()
    {
        return bitRange;
    }

    public List getC3Ads()
    {
        return c3ads;
    }

    public ClosedCaptionFormatBuilder getCaptionFormat()
    {
        return captionFormat;
    }

    public ClientState getClientState()
    {
        return clientState;
    }

    public boolean getClosedCaptionsEnabled()
    {
        return ccEnabled;
    }

    public PlayerClosedCaptionsTrack getClosedCaptionsTrack()
    {
        return closedCaptionsTrack;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public int getHeight()
    {
        return height;
    }

    public int getInitialBitrate()
    {
        return initialBitrate;
    }

    public LogFactory getLogFactory()
    {
        return logFactory;
    }

    public com.adobe.mediacore.logging.Logger.Verbosity getLoggerVerbosity()
    {
        return loggerVerbosity;
    }

    public PlayerAudioTrack getPreferredAudioLanguage()
    {
        return preferredAudioLanguage;
    }

    public Map getTargetingParameters()
    {
        return targetingParameters;
    }

    public int getUpdateInterval()
    {
        return updateInterval;
    }

    public int getVolume()
    {
        return volume;
    }

    public int getWidth()
    {
        return width;
    }

    public ZoomSetting getZoomSetting()
    {
        return zoomSetting;
    }

    public boolean isAutoplay()
    {
        return autoplay;
    }

    public boolean isComscoreEnabled()
    {
        return comscoreEnabled;
    }

    public void removeListener(PlayerSettingsListener playersettingslistener)
    {
        listeners.remove(playersettingslistener);
    }

    public void setAdBreakPolicies(PlayerAdBreakPolicies playeradbreakpolicies)
    {
        adBreakPolicies = playeradbreakpolicies;
        settingUpdated(Setting.AD_BREAK_POLICIES);
    }

    public void setAdType(AdType adtype)
    {
        adType = adtype;
        settingUpdated(Setting.AD_TYPE);
    }

    public void setAuthDelegate(AuthenticationDelegate authenticationdelegate)
    {
        authDelegate = authenticationdelegate;
    }

    public void setAutoplay(boolean flag)
    {
        autoplay = flag;
        settingUpdated(Setting.AUTOPLAY);
    }

    public void setBitRange(Range range)
    {
        bitRange = range;
        settingUpdated(Setting.BITRATE_RANGE);
    }

    public void setC3Ads(List list)
    {
        c3ads = list;
        settingUpdated(Setting.C3_ADS);
    }

    public void setCaptionFormat(ClosedCaptionFormatBuilder closedcaptionformatbuilder)
    {
        captionFormat = closedcaptionformatbuilder;
        settingUpdated(Setting.CAPTION_FORMAT);
    }

    public void setClosedCaptionsEnabled(boolean flag)
    {
        ccEnabled = flag;
        settingUpdated(Setting.CAPTIONS_ENABLED);
    }

    public void setClosedCaptionsTrack(PlayerClosedCaptionsTrack playerclosedcaptionstrack)
    {
        closedCaptionsTrack = playerclosedcaptionstrack;
        settingUpdated(Setting.CAPTIONS_TRACK);
    }

    public void setComscoreEnabled(boolean flag)
    {
        comscoreEnabled = flag;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
        settingUpdated(Setting.DEVICE_ID);
    }

    public void setHeight(int i)
    {
        height = i;
        settingUpdated(Setting.HEIGHT);
    }

    public void setInitialBitrate(int i)
    {
        initialBitrate = i;
        settingUpdated(Setting.INITIAL_BITRATE);
    }

    public void setLogFactory(LogFactory logfactory)
    {
        logFactory = logfactory;
        settingUpdated(Setting.LOG_FACTORY);
    }

    public void setLoggerVerbosity(com.adobe.mediacore.logging.Logger.Verbosity verbosity)
    {
        loggerVerbosity = verbosity;
        settingUpdated(Setting.LOGGER_VERBOSITY);
    }

    public void setPreferredAudioLanguage(PlayerAudioTrack playeraudiotrack)
    {
        preferredAudioLanguage = playeraudiotrack;
        settingUpdated(Setting.AUDIO_TRACK);
    }

    public void setTargetingParameters(Map map)
    {
        targetingParameters = map;
    }

    public void setUpdateInterval(int i)
    {
        updateInterval = i;
        settingUpdated(Setting.UPDATE_INTERVAL);
    }

    public void setVolume(int i)
    {
        volume = i;
        settingUpdated(Setting.VOLUME);
    }

    public void setWidth(int i)
    {
        width = i;
        settingUpdated(Setting.WIDTH);
    }

    public void setZoomSetting(ZoomSetting zoomsetting)
    {
        zoomSetting = zoomsetting;
        settingUpdated(Setting.ZOOM_SETTING);
    }

    public void setclientState(ClientState clientstate)
    {
        clientState = clientstate;
    }

    public void settingUpdated(Setting setting)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PlayerSettingsListener)iterator.next()).settingUpdated(setting)) { }
    }
}
