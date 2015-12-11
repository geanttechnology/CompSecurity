// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class VideoPlayedEventFactory
{
    public static final class VideoPlayedEventAction extends Enum
    {

        private static final VideoPlayedEventAction $VALUES[];
        public static final VideoPlayedEventAction PAUSE;
        public static final VideoPlayedEventAction PLAY;
        private final String action;

        public static VideoPlayedEventAction valueOf(String s)
        {
            return (VideoPlayedEventAction)Enum.valueOf(com/shazam/android/analytics/event/factory/VideoPlayedEventFactory$VideoPlayedEventAction, s);
        }

        public static VideoPlayedEventAction[] values()
        {
            return (VideoPlayedEventAction[])$VALUES.clone();
        }

        public final String getAction()
        {
            return action;
        }

        static 
        {
            PLAY = new VideoPlayedEventAction("PLAY", 0, "play");
            PAUSE = new VideoPlayedEventAction("PAUSE", 1, "pause");
            $VALUES = (new VideoPlayedEventAction[] {
                PLAY, PAUSE
            });
        }

        private VideoPlayedEventAction(String s, int i, String s1)
        {
            super(s, i);
            action = s1;
        }
    }


    public VideoPlayedEventFactory()
    {
    }

    public static Event createInteractionEvent(VideoPlayedEventAction videoplayedeventaction, String s, String s1, String s2)
    {
        videoplayedeventaction = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "videosyncinteraction").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, videoplayedeventaction.getAction()).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, s2).build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(videoplayedeventaction).build();
    }

    public static Event createVideoPlayedEvent(String s, String s1, String s2, int i, int j, boolean flag)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "videosyncplayed").putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, s2).putNotEmptyOrNullParameter(DefinedEventParameterKey.START_OFFSET, String.valueOf(i)).putNotEmptyOrNullParameter(DefinedEventParameterKey.END_OFFSET, String.valueOf(j)).putNotEmptyOrNullParameter(DefinedEventParameterKey.VIEW_LENGTH, String.valueOf(j - i)).putNotEmptyOrNullParameter(DefinedEventParameterKey.COMPLETED, String.valueOf(flag)).build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(s).build();
    }
}
