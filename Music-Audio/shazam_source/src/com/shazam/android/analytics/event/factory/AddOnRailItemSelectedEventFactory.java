// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.android.e.a.a;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class AddOnRailItemSelectedEventFactory
{

    public AddOnRailItemSelectedEventFactory()
    {
    }

    public static Event createAddOnRailItemSelectedEvent(String s, String s1, String s2, a a1)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "addonrailitemselected").putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.MATCH_CATEGORY, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, s2);
        if (a1 != null)
        {
            s.putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, a1.a).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, a1.b);
        }
        return createAddOnRailItemSelectedEventWith(s.build());
    }

    private static Event createAddOnRailItemSelectedEventWith(EventParameters eventparameters)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(eventparameters).build();
    }
}
