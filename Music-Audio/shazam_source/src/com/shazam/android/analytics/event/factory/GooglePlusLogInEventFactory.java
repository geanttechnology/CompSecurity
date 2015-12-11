// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class GooglePlusLogInEventFactory
{
    public static final class GooglePlusLoginActions extends Enum
    {

        private static final GooglePlusLoginActions $VALUES[];
        public static final GooglePlusLoginActions CANCEL;
        public static final GooglePlusLoginActions ERROR;
        public static final GooglePlusLoginActions LOGIN;
        public static final GooglePlusLoginActions SUCCESS;
        private final String action;

        public static GooglePlusLoginActions valueOf(String s)
        {
            return (GooglePlusLoginActions)Enum.valueOf(com/shazam/android/analytics/event/factory/GooglePlusLogInEventFactory$GooglePlusLoginActions, s);
        }

        public static GooglePlusLoginActions[] values()
        {
            return (GooglePlusLoginActions[])$VALUES.clone();
        }

        public final String getAction()
        {
            return action;
        }

        static 
        {
            CANCEL = new GooglePlusLoginActions("CANCEL", 0, "cancel");
            ERROR = new GooglePlusLoginActions("ERROR", 1, "error");
            SUCCESS = new GooglePlusLoginActions("SUCCESS", 2, "success");
            LOGIN = new GooglePlusLoginActions("LOGIN", 3, "login");
            $VALUES = (new GooglePlusLoginActions[] {
                CANCEL, ERROR, SUCCESS, LOGIN
            });
        }

        private GooglePlusLoginActions(String s, int i, String s1)
        {
            super(s, i);
            action = s1;
        }
    }


    public GooglePlusLogInEventFactory()
    {
    }

    public static Event createGooglePlusLogInEvent(GooglePlusLoginActions googleplusloginactions)
    {
        googleplusloginactions = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "googlepluslogin").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, googleplusloginactions.getAction()).build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(googleplusloginactions).build();
    }
}
