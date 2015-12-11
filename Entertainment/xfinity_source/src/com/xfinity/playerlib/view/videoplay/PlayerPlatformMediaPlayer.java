// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.comcast.cim.cmasl.android708compatlib.view.preference.CCPreviewPreference;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.analytics.java.util.HostInfo;
import com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.player.PlayerPlatformAPI;
import com.comcast.playerplatform.primetime.android.primetime.PlayerAudioTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.util.ClosedCaptionFormatBuilder;
import com.comcast.playerplatform.util.android.BitrateParameters;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PlayerPlatformMediaPlayer
{

    private PlayerPlatformAPI mediaPlayer;

    public PlayerPlatformMediaPlayer(Activity activity, HttpClient httpclient)
    {
        mediaPlayer = new PlayerPlatformAPI(activity, httpclient);
    }

    private static com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color convertClosedCaptionsColor(int i)
    {
        int j = Color.red(i);
        int k = Color.green(i);
        int l = Color.blue(i);
        ArrayList arraylist = new ArrayList();
        for (i = 1; i < com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.values().length; i++)
        {
            int i1 = CCPreviewPreference.convertColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.values()[i], "ff");
            arraylist.add(Integer.valueOf(Double.valueOf(Math.sqrt(Math.pow(j - Color.red(i1), 2D) + Math.pow(k - Color.green(i1), 2D) + Math.pow(l - Color.blue(i1), 2D))).intValue()));
        }

        i = arraylist.indexOf(Collections.min(arraylist));
        return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.values()[i + 1];
    }

    private com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge convertClosedCaptionsEdgeType(int i)
    {
        if (i == 0)
        {
            return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.NONE;
        }
        if (i == 2)
        {
            return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.DROP_SHADOW_RIGHT;
        }
        if (i == 1)
        {
            return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.UNIFORM;
        } else
        {
            return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.DEFAULT;
        }
    }

    private com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size convertClosedCaptionsFontScale(float f)
    {
        if ((double)f <= 0.5D)
        {
            return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.SMALL;
        }
        if ((double)f > 0.5D && (double)f < 1.5D)
        {
            return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.MEDIUM;
        }
        if ((double)f >= 1.5D)
        {
            return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.LARGE;
        } else
        {
            return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.DEFAULT;
        }
    }

    private com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font convertClosedCaptionsTypeface(Typeface typeface)
    {
        if (typeface != null)
        {
            if (typeface.equals(Typeface.SANS_SERIF))
            {
                return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.PROPORTIONAL_WITHOUT_SERIFS;
            }
            if (typeface.equals(Typeface.SERIF))
            {
                return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.PROPORTIONAL_WITH_SERIFS;
            }
            if (typeface.equals(Typeface.MONOSPACE))
            {
                return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.MONOSPACED_WITH_SERIFS;
            }
        }
        return com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.DEFAULT;
    }

    private ClosedCaptionFormatBuilder getCCFormatBuilderForCaptionStyle(android.view.accessibility.CaptioningManager.CaptionStyle captionstyle)
    {
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color = convertClosedCaptionsColor(captionstyle.backgroundColor);
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color1 = convertClosedCaptionsColor(captionstyle.foregroundColor);
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color2 = convertClosedCaptionsColor(captionstyle.edgeColor);
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font font = convertClosedCaptionsTypeface(captionstyle.getTypeface());
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge fontedge = convertClosedCaptionsEdgeType(captionstyle.edgeType);
        int i = (Color.alpha(captionstyle.backgroundColor) * 100) / 255;
        return (new ClosedCaptionFormatBuilder()).setBackgroundColor(color).setFontColor(color1).setEdgeColor(color2).setFont(font).setFontEdge(fontedge).setBackgroundOpacity(i);
    }

    public void addEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        mediaPlayer.addEventListener(abstractplayerplatformvideoeventlistener);
    }

    public void configureAnalytics(HostInfo hostinfo)
    {
        mediaPlayer.configureAnalytics(hostinfo);
    }

    public void configureAuditudeAds()
    {
        mediaPlayer.configureAuditudeAds();
    }

    public void configureC3Ads(List list)
    {
        mediaPlayer.configureC3Ads(list);
    }

    public void destroy()
    {
        mediaPlayer.destroy();
    }

    public boolean getAutoPlay()
    {
        return mediaPlayer.getAutoPlay();
    }

    public List getAvailableBitrates()
    {
        return mediaPlayer.getAvailableBitrates();
    }

    public List getAvailableLanguages()
    {
        Object obj = mediaPlayer.getAvailableAudioLanguages();
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((PlayerAudioTrack)((Iterator) (obj)).next()).getLanguage())) { }
        return arraylist;
    }

    public long getCurrentAdDuration()
    {
        return mediaPlayer.getCurrentAd().getDuration();
    }

    public long getDuration()
    {
        return mediaPlayer.getDuration();
    }

    public String getLanguage()
    {
        return mediaPlayer.getCurrentAudioTrack().getLanguage();
    }

    public PlayerStatus getPlayerStatus()
    {
        return mediaPlayer.getPlayerStatus();
    }

    public long getPosition()
    {
        return mediaPlayer.getCurrentPosition();
    }

    public PlayerTimeline getTimeline()
    {
        return mediaPlayer.getTimeline();
    }

    public View getView()
    {
        return mediaPlayer.getView();
    }

    public boolean hasCC()
    {
        return mediaPlayer.hasCC();
    }

    public boolean isAdPlaying()
    {
        return mediaPlayer.isAdPlaying();
    }

    public boolean isCurrentAdClickable()
    {
        return mediaPlayer.isAdPlaying() && mediaPlayer.getCurrentAd().isClickable();
    }

    public void pause()
    {
        mediaPlayer.pause();
    }

    public void play()
    {
        mediaPlayer.play();
    }

    public void prepare(Asset asset, Long long1)
    {
        setAsset(asset, long1);
    }

    public void removeEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        mediaPlayer.removeEventListener(abstractplayerplatformvideoeventlistener);
    }

    public void setAsset(Asset asset, Long long1)
    {
        mediaPlayer.setAsset(asset, long1.longValue());
    }

    public void setAutoPlay(boolean flag)
    {
        mediaPlayer.setAutoPlay(Boolean.valueOf(flag));
    }

    public void setBitrateParameters(BitrateParameters bitrateparameters)
    {
        mediaPlayer.setBitrateParameters(bitrateparameters);
    }

    public void setCCEnabled(boolean flag)
    {
        if (flag)
        {
            List list = mediaPlayer.getAvailableClosedCaptionTracks();
            PlayerPlatformAPI playerplatformapi = mediaPlayer;
            if (list.size() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            playerplatformapi.setClosedCaptionsEnabled(flag);
            if (list.size() > 0)
            {
                mediaPlayer.setClosedCaptionsTrack((PlayerClosedCaptionsTrack)list.get(0));
            }
            return;
        } else
        {
            mediaPlayer.setClosedCaptionsEnabled(flag);
            return;
        }
    }

    public void setDimensionsOfVideo(int i, int j)
    {
        mediaPlayer.setDimensionsOfVideo(i, j);
    }

    public void setLanguage(int i)
    {
        List list = mediaPlayer.getAvailableAudioLanguages();
        if (list.size() > i)
        {
            mediaPlayer.setPreferredAudioLanguage((PlayerAudioTrack)list.get(i));
        }
    }

    public void setPlayerAdBreakPolicies(PlayerAdBreakPolicies playeradbreakpolicies)
    {
        mediaPlayer.setPlayerAdBreakPolicies(playeradbreakpolicies);
    }

    public void setPlayerStatus(PlayerStatus playerstatus)
    {
    }

    public void setPosition(long l, boolean flag)
    {
        mediaPlayer.setPosition(l, flag);
    }

    public void styleClosedCaptions(CaptioningManager captioningmanager)
    {
        ClosedCaptionFormatBuilder closedcaptionformatbuilder = getCCFormatBuilderForCaptionStyle(captioningmanager.getUserStyle());
        closedcaptionformatbuilder.setSize(convertClosedCaptionsFontScale(captioningmanager.getFontScale()));
        mediaPlayer.setClosedCaptionsOptions(closedcaptionformatbuilder);
    }

    public void styleClosedCaptions(PlayerUserSettings playerusersettings)
    {
        playerusersettings = (new ClosedCaptionFormatBuilder()).setFontColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.valueOfOrdinal(playerusersettings.getCCTextColor())).setEdgeColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.valueOfOrdinal(playerusersettings.getCCEdgeColor())).setFont(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.valueOfOrdinal(playerusersettings.getCCFontFamily())).setSize(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.valueOfOrdinal(playerusersettings.getCCTextSize())).setFontEdge(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.valueOfOrdinal(playerusersettings.getCCEdgeType())).setBackgroundColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.valueOfOrdinal(playerusersettings.getCCBackgroundColor())).setBackgroundOpacity(playerusersettings.getCCBackgroundOpacity());
        mediaPlayer.setClosedCaptionsOptions(playerusersettings);
    }
}
