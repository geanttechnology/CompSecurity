// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.orbit;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.analytics.orbit:
//            OrbitErrorAnalytics

public class BeaconingOrbitErrorAnalytics
    implements OrbitErrorAnalytics
{
    public static final class EventErrorCodes extends Enum
    {

        private static final EventErrorCodes $VALUES[];
        public static final EventErrorCodes BAD_SERVER_RESPONSE;
        public static final EventErrorCodes INTERNAL_SERVER;
        private final String errorCode;

        public static EventErrorCodes valueOf(String s)
        {
            return (EventErrorCodes)Enum.valueOf(com/shazam/android/analytics/orbit/BeaconingOrbitErrorAnalytics$EventErrorCodes, s);
        }

        public static EventErrorCodes[] values()
        {
            return (EventErrorCodes[])$VALUES.clone();
        }

        public final String getErrorCode()
        {
            return errorCode;
        }

        static 
        {
            BAD_SERVER_RESPONSE = new EventErrorCodes("BAD_SERVER_RESPONSE", 0, "badserverresponse");
            INTERNAL_SERVER = new EventErrorCodes("INTERNAL_SERVER", 1, "internalservererror");
            $VALUES = (new EventErrorCodes[] {
                BAD_SERVER_RESPONSE, INTERNAL_SERVER
            });
        }

        private EventErrorCodes(String s, int i, String s1)
        {
            super(s, i);
            errorCode = s1;
        }
    }


    private final EventAnalytics eventAnalytics;

    public BeaconingOrbitErrorAnalytics(EventAnalytics eventanalytics)
    {
        eventAnalytics = eventanalytics;
    }

    private void sendServerError(com.shazam.android.analytics.event.EventParameters.Builder builder, String s)
    {
        builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.REQUEST_URL, s);
        eventAnalytics.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.ERROR).withParameters(builder.build()).build());
    }

    public void sendBadServerResponse(String s, int i)
    {
        sendServerError(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.CODE, EventErrorCodes.BAD_SERVER_RESPONSE.getErrorCode()).putNotEmptyOrNullParameter(DefinedEventParameterKey.STATUS_CODE, String.valueOf(i)), s);
    }

    public void sendInternalServerError(String s, String s1)
    {
        sendServerError(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.CODE, EventErrorCodes.INTERNAL_SERVER.getErrorCode()).putNotEmptyOrNullParameter(DefinedEventParameterKey.INTERNAL_SERVER_CODE, s1), s);
    }
}
