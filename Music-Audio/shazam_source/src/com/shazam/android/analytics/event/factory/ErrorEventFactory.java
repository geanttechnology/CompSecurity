// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class ErrorEventFactory
{

    public ErrorEventFactory()
    {
    }

    private static Event anErrorEventWith(EventParameters eventparameters)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.ERROR).withParameters(eventparameters).build();
    }

    public static Event mediaUnitLoadFailureErrorEvent(String s, String s1, String s2)
    {
        return anErrorEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.CODE, "muloadfailure").putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, s2).build());
    }

    public static Event ncmConnectionErrorErrorEvent()
    {
        return anErrorEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.CODE, "ncmconnectionerror").build());
    }

    public static Event videoSyncLoadFailureErrorEvent(String s, String s1, String s2, String s3)
    {
        return anErrorEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.CODE, "videosyncloadfailure").putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, s2).putNotEmptyOrNullParameter(DefinedEventParameterKey.VIDEO_URL, s3).build());
    }
}
