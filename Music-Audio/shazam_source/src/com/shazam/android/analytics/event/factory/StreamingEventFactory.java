// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.activities.streaming.b;
import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class StreamingEventFactory
{
    public static final class StreamingEventAction extends Enum
    {

        private static final StreamingEventAction $VALUES[];
        public static final StreamingEventAction BACK;
        public static final StreamingEventAction CANCEL;
        public static final StreamingEventAction CONNECT;
        public static final StreamingEventAction DONE;
        public static final StreamingEventAction DOWNLOAD_APP;
        public static final StreamingEventAction ERROR;
        public static final StreamingEventAction LOGOUT;
        public static final StreamingEventAction OPEN_APP;
        public static final StreamingEventAction SUBSCRIBE;
        public static final StreamingEventAction SUBSCRIBE_NO_APP_FOUND;
        public static final StreamingEventAction SUCCESS;
        private final String action;

        public static StreamingEventAction valueOf(String s)
        {
            return (StreamingEventAction)Enum.valueOf(com/shazam/android/analytics/event/factory/StreamingEventFactory$StreamingEventAction, s);
        }

        public static StreamingEventAction[] values()
        {
            return (StreamingEventAction[])$VALUES.clone();
        }

        public final String getAction()
        {
            return action;
        }

        static 
        {
            LOGOUT = new StreamingEventAction("LOGOUT", 0, "logout");
            CANCEL = new StreamingEventAction("CANCEL", 1, "cancel");
            SUCCESS = new StreamingEventAction("SUCCESS", 2, "success");
            ERROR = new StreamingEventAction("ERROR", 3, "error");
            BACK = new StreamingEventAction("BACK", 4, "back");
            CONNECT = new StreamingEventAction("CONNECT", 5, "connect");
            SUBSCRIBE = new StreamingEventAction("SUBSCRIBE", 6, "subscribe");
            SUBSCRIBE_NO_APP_FOUND = new StreamingEventAction("SUBSCRIBE_NO_APP_FOUND", 7, "subscribe");
            OPEN_APP = new StreamingEventAction("OPEN_APP", 8, "openapp");
            DOWNLOAD_APP = new StreamingEventAction("DOWNLOAD_APP", 9, "downloadapp");
            DONE = new StreamingEventAction("DONE", 10, "done");
            $VALUES = (new StreamingEventAction[] {
                LOGOUT, CANCEL, SUCCESS, ERROR, BACK, CONNECT, SUBSCRIBE, SUBSCRIBE_NO_APP_FOUND, OPEN_APP, DOWNLOAD_APP, 
                DONE
            });
        }

        private StreamingEventAction(String s, int i, String s1)
        {
            super(s, i);
            action = s1;
        }
    }


    public StreamingEventFactory()
    {
    }

    public static Event createMyShazamPlaylistCreatedBeacon(String s, int i)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "myshazamsplaylistcreated").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACKS_ADDED, String.valueOf(i)).build();
        return generateEventOfType(BeaconEventKey.USER_EVENT, s);
    }

    public static Event createMyShazamPlaylistCreatedErrorBeacon(String s)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "myshazamsplaylistcreationerror").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, s).build();
        return generateEventOfType(BeaconEventKey.USER_EVENT, s);
    }

    public static Event createStreamingLoginEvent(b b1, StreamingEventAction streamingeventaction, ScreenOrigin screenorigin, ScreenOrigin screenorigin1, String s)
    {
        Object obj = null;
        Object obj1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "streamingmusiclogin").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, streamingeventaction.getAction());
        DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.LOGIN_ORIGIN;
        if (screenorigin == null)
        {
            streamingeventaction = null;
        } else
        {
            streamingeventaction = screenorigin.value;
        }
        screenorigin = ((com.shazam.android.analytics.event.EventParameters.Builder) (obj1)).putNotEmptyOrNullParameter(definedeventparameterkey, streamingeventaction);
        obj1 = DefinedEventParameterKey.SCREEN_ORIGIN;
        if (screenorigin1 == null)
        {
            streamingeventaction = obj;
        } else
        {
            streamingeventaction = screenorigin1.value;
        }
        b1 = screenorigin.putNotEmptyOrNullParameter(((com.shazam.model.analytics.event.EventParameterKey) (obj1)), streamingeventaction).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, b1.toString()).build();
        return generateEventOfType(BeaconEventKey.USER_EVENT, b1);
    }

    public static Event createStreamingLoginUpsellImpression()
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.IMPRESSION).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, "streamingloginupsell").build()).build();
    }

    public static Event createStreamingLogoutEvent(b b1, StreamingEventAction streamingeventaction)
    {
        b1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "streamingmusiclogout").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, b1.toString()).putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, streamingeventaction.getAction()).build();
        return generateEventOfType(BeaconEventKey.USER_EVENT, b1);
    }

    public static Event createStreamingMusicSwitchBeacon(String s, String s1)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "streamingmusicswitch").putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, "streamingloginswitchprovider").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, s1).build();
        return generateEventOfType(BeaconEventKey.USER_EVENT, s);
    }

    public static Event createStreamingPlaylistTappedEvent(b b1, String s)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "streamingmusicplaylistaction");
        DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.PLAYLIST_WAS_SELECTED;
        int i;
        if (s == null)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        b1 = builder.putNotEmptyOrNullParameter(definedeventparameterkey, String.valueOf(i)).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, b1.toString()).build();
        return generateEventOfType(BeaconEventKey.USER_EVENT, b1);
    }

    public static Event createStreamingPlaylistUpdateErrorEvent(b b1, String s)
    {
        b1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.CODE, "playlistupdateerror").putNotEmptyOrNullParameter(DefinedEventParameterKey.REASON, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, b1.toString()).build();
        return generateEventOfType(BeaconEventKey.ERROR, b1);
    }

    public static Event createStreamingPlaylistUpdatedEvent(b b1)
    {
        b1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "playlistupdated").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, b1.toString()).build();
        return generateEventOfType(BeaconEventKey.USER_EVENT, b1);
    }

    public static Event createStreamingProviderUpsellCancelUserEvent()
    {
        return streamingLoginUpsellUserEventWithAction("cancel");
    }

    public static Event createStreamingProviderUpsellGoToProviderUserEvent(b b1)
    {
        return streamingLoginUpsellUserEventWithAction(b1.toString());
    }

    public static Event createStreamingServicesSwitchImpressionEvent()
    {
        EventParameters eventparameters = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, "streamingloginswitchprovider").build();
        return generateEventOfType(BeaconEventKey.IMPRESSION, eventparameters);
    }

    private static Event generateEventOfType(BeaconEventKey beaconeventkey, EventParameters eventparameters)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(beaconeventkey).withParameters(eventparameters).build();
    }

    public static Event streamingLoginUpsellUserEventWithAction(String s)
    {
        return UserEventEventFactory.aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "streamingloginupsell").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s).build());
    }
}
