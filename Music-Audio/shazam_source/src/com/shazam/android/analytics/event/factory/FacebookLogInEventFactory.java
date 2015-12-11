// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.facebook.FacebookLoginErrorSource;

public class FacebookLogInEventFactory
{
    public static final class FacebookLoginActions extends Enum
    {

        private static final FacebookLoginActions $VALUES[];
        public static final FacebookLoginActions CONNECT;
        public static final FacebookLoginActions CONNECT_CANCEL;
        public static final FacebookLoginActions CONNECT_ERROR;
        public static final FacebookLoginActions CONNECT_SUCCESS;
        public static final FacebookLoginActions DISCONNECT;
        public static final FacebookLoginActions DISCONNECT_ERROR;
        public static final FacebookLoginActions DISCONNECT_SUCCESS;
        private final String action;

        public static FacebookLoginActions valueOf(String s)
        {
            return (FacebookLoginActions)Enum.valueOf(com/shazam/android/analytics/event/factory/FacebookLogInEventFactory$FacebookLoginActions, s);
        }

        public static FacebookLoginActions[] values()
        {
            return (FacebookLoginActions[])$VALUES.clone();
        }

        public final String getAction()
        {
            return action;
        }

        static 
        {
            CONNECT = new FacebookLoginActions("CONNECT", 0, "fbconnect");
            CONNECT_CANCEL = new FacebookLoginActions("CONNECT_CANCEL", 1, "fbconnectcancel");
            CONNECT_ERROR = new FacebookLoginActions("CONNECT_ERROR", 2, "fbconnecterror");
            CONNECT_SUCCESS = new FacebookLoginActions("CONNECT_SUCCESS", 3, "fbconnectsuccess");
            DISCONNECT = new FacebookLoginActions("DISCONNECT", 4, "fbdisconnect");
            DISCONNECT_ERROR = new FacebookLoginActions("DISCONNECT_ERROR", 5, "fbdisconnecterror");
            DISCONNECT_SUCCESS = new FacebookLoginActions("DISCONNECT_SUCCESS", 6, "fbdisconnectsuccess");
            $VALUES = (new FacebookLoginActions[] {
                CONNECT, CONNECT_CANCEL, CONNECT_ERROR, CONNECT_SUCCESS, DISCONNECT, DISCONNECT_ERROR, DISCONNECT_SUCCESS
            });
        }

        private FacebookLoginActions(String s, int i, String s1)
        {
            super(s, i);
            action = s1;
        }
    }


    public FacebookLogInEventFactory()
    {
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder commonEventParameters(FacebookLoginActions facebookloginactions)
    {
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "accountlogin").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, "fb").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, facebookloginactions.getAction());
    }

    private static Event createEvent(EventParameters eventparameters)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(eventparameters).build();
    }

    public static Event createFacebookConnectUserEvent(FacebookLoginActions facebookloginactions, String s, String s1)
    {
        return createEvent(commonEventParameters(facebookloginactions).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, s1).build());
    }

    public static Event createFacebookErrorUserEvent(FacebookLoginActions facebookloginactions, FacebookLoginErrorSource facebookloginerrorsource, String s, String s1)
    {
        return createEvent(commonEventParameters(facebookloginactions).putNotEmptyOrNullParameter(DefinedEventParameterKey.SOURCE, facebookloginerrorsource.getSource()).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, s1).build());
    }
}
