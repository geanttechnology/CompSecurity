// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.i.e.a;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.analytics.player.PlayAllButtonAnalyticsInfo;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.social.ConnectionState;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class PlayerEventFactory extends UserEventEventFactory
{

    private static final String FLAG_0 = "0";
    private static final String FLAG_1 = "1";
    public static final String PLAYER_SWIPED_DISLIKE_TYPE = "playerswipeddislike";
    public static final String PLAYER_SWIPED_LIKE_TYPE = "playerswipedlike";
    public static final String PLAYER_TAPPED_DISLIKE_TYPE = "playertappeddislike";
    public static final String PLAYER_TAPPED_LIKE_TYPE = "playertappedlike";
    public static final String PROVIDER_NAME_RDIO = "Rdio";
    public static final String PROVIDER_NAME_SPOTIFY = "Spotify";
    private static final Map connectionStateProviderNameMap;

    public PlayerEventFactory()
    {
    }

    public static Event createErrorEvent(String s, String s1, PlaylistItem playlistitem)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.CODE, "streamingerror").putNotEmptyOrNullParameter(DefinedEventParameterKey.ERROR_DESCRIPTION, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, trackId(null, playlistitem)).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, trackKey(null, playlistitem)).putNotEmptyOrNullParameter(DefinedEventParameterKey.RDIO_TRACK_ID, rdioTrackId(s, playlistitem)).build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.ERROR).withParameters(s).build();
    }

    public static Event createHidePlayMenuEvent()
    {
        EventParameters eventparameters = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "hideplaymenu").build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(eventparameters).build();
    }

    public static Event createLikeDislike(String s, String s1, PlaybackProvider playbackprovider)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, s1);
        populateCorrectProviderAndPreviewParameters(s, playbackprovider);
        return aUserEventWith(s.build());
    }

    public static Event createPlayAllUserEvent(PlayAllButtonAnalyticsInfo playallbuttonanalyticsinfo)
    {
        return aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "playall").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, getConnectedProviderName()).putNotEmptyOrNullParameter(DefinedEventParameterKey.PLAY_QUEUE, playallbuttonanalyticsinfo.playQueue).build());
    }

    public static Event createPlayMenuEvent(String s)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "playmenu").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, s).build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(s).build();
    }

    public static Event createPlayerCoverArtClicked(boolean flag, String s, PlaybackProvider playbackprovider)
    {
        return playerEventWithType(flag, s, playbackprovider, "playeralbumartclicked");
    }

    public static Event createPlayerEnd(String s, PlaybackProvider playbackprovider, boolean flag, int i, int j)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters();
        populateDurationParameters(builder, flag, i, j);
        return playerEventWithType(builder.build(), null, s, playbackprovider, "playerend");
    }

    public static Event createPlayerNext()
    {
        return aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "playernext").build());
    }

    public static Event createPlayerPause(boolean flag, String s, PlaybackProvider playbackprovider, int i, int j)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters();
        populateDurationParameters(builder, false, i, j);
        return playerEventWithType(builder.build(), Boolean.valueOf(flag), s, playbackprovider, "playerpause");
    }

    public static Event createPlayerPlay(boolean flag, String s, PlaybackProvider playbackprovider)
    {
        return createPlayerPlay(flag, s, playbackprovider, -1, 0);
    }

    public static Event createPlayerPlay(boolean flag, String s, PlaybackProvider playbackprovider, int i, int j)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters();
        populateDurationParameters(builder, false, i, j);
        return playerEventWithType(builder.build(), Boolean.valueOf(flag), s, playbackprovider, "playerplay");
    }

    public static Event createPlayerPrevious()
    {
        return aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "playerprevious").build());
    }

    public static Event createPlayerScrubber(String s)
    {
        return aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "playerscrubber").putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, s).build());
    }

    public static Event createShowPlayMenuEvent()
    {
        return aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "showplaymenu").build());
    }

    public static String getConnectedProviderName()
    {
        String s = null;
        Iterator iterator = connectionStateProviderNameMap.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((ConnectionState)entry.getKey()).a())
            {
                s = (String)entry.getValue();
            }
        } while (true);
        return s;
    }

    private static String getProviderNameForTrack(PlaybackProvider playbackprovider)
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[PlaybackProvider.values().length];
                try
                {
                    a[PlaybackProvider.RDIO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[PlaybackProvider.SPOTIFY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.shazam.android.analytics.event.factory._cls1.a[playbackprovider.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return "Rdio";

        case 2: // '\002'
            return "Spotify";
        }
    }

    private static Event playerEventWithType(EventParameters eventparameters, Boolean boolean1, String s, PlaybackProvider playbackprovider, String s1)
    {
        eventparameters = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().eventParametersFrom(eventparameters).putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, s);
        populateCorrectProviderAndPreviewParameters(eventparameters, playbackprovider);
        populateMinimisedParameter(eventparameters, boolean1);
        return aUserEventWith(eventparameters.build());
    }

    private static Event playerEventWithType(boolean flag, String s, PlaybackProvider playbackprovider, String s1)
    {
        return playerEventWithType(EventParameters.EMPTY_PARAMETERS, Boolean.valueOf(flag), s, playbackprovider, s1);
    }

    private static void populateCorrectProviderAndPreviewParameters(com.shazam.android.analytics.event.EventParameters.Builder builder, PlaybackProvider playbackprovider)
    {
        String s = getProviderNameForTrack(playbackprovider);
        if (com.shazam.b.e.a.a(s))
        {
            playbackprovider = "1";
        } else
        {
            playbackprovider = "0";
        }
        builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.PREVIEW, playbackprovider);
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder populateDurationParameters(com.shazam.android.analytics.event.EventParameters.Builder builder, boolean flag, int i, int j)
    {
        if (i >= 0)
        {
            String s = String.valueOf(i);
            builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_DURATION, s);
            DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.PLAYBACK_DURATION;
            if (!flag)
            {
                s = String.valueOf(j);
            }
            builder.putNotEmptyOrNullParameter(definedeventparameterkey, s);
        }
        return builder;
    }

    private static void populateMinimisedParameter(com.shazam.android.analytics.event.EventParameters.Builder builder, Boolean boolean1)
    {
        if (boolean1 == null)
        {
            return;
        }
        if (boolean1.booleanValue())
        {
            boolean1 = "1";
        } else
        {
            boolean1 = "0";
        }
        builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.MINIMISED, boolean1);
    }

    private static String rdioTrackId(String s, PlaylistItem playlistitem)
    {
        if ("Rdio".equals(s) && playlistitem != null)
        {
            return playlistitem.a().a(PlaybackProvider.RDIO);
        } else
        {
            return null;
        }
    }

    private static String trackId(PreviewViewData previewviewdata, PlaylistItem playlistitem)
    {
        if (previewviewdata != null && com.shazam.b.e.a.c(previewviewdata.trackId))
        {
            return previewviewdata.trackId;
        }
        if (playlistitem != null)
        {
            return playlistitem.key;
        } else
        {
            return null;
        }
    }

    private static String trackKey(PreviewViewData previewviewdata, PlaylistItem playlistitem)
    {
        if (previewviewdata != null && com.shazam.b.e.a.c(previewviewdata.beaconKey))
        {
            return previewviewdata.beaconKey;
        }
        if (playlistitem != null)
        {
            return playlistitem.key;
        } else
        {
            return null;
        }
    }

    static 
    {
        Map map = a.a(0);
        connectionStateProviderNameMap = map;
        map.put(com.shazam.i.b.ap.a.b(), "Spotify");
        connectionStateProviderNameMap.put(com.shazam.i.b.ap.a.a(), "Rdio");
    }
}
