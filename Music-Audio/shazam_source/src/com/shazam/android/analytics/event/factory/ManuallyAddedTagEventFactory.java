// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class ManuallyAddedTagEventFactory
{

    public ManuallyAddedTagEventFactory()
    {
    }

    public static com.shazam.android.analytics.event.EventParameters.Builder commonEventParameters(String s, String s1, String s2, String s3)
    {
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, s2).putNotEmptyOrNullParameter(DefinedEventParameterKey.TAG_RESULT_VERSION, s3);
    }

    public static Event createAddedTagUserEvent(String s, String s1, String s2, String s3)
    {
        s = commonEventParameters(s, s1, s2, s3).putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "addtagtapped").build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(s).build();
    }

    public static Event createDeletedTagUserEvent(String s, String s1, String s2, String s3)
    {
        s = commonEventParameters(s, s1, s2, s3).putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "deletetagtapped").build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(s).build();
    }
}
