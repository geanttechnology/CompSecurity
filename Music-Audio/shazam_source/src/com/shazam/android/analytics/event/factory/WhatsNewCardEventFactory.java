// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.news.FeedCard;

public class WhatsNewCardEventFactory
{

    public WhatsNewCardEventFactory()
    {
    }

    public static Event createEventForClosingWhatsNewCard(FeedCard feedcard)
    {
        return createWhatsNewEvent(feedcard, "close");
    }

    public static Event createEventForTappingWhatsNewCard(FeedCard feedcard)
    {
        return createWhatsNewEvent(feedcard, "open");
    }

    private static Event createWhatsNewEvent(FeedCard feedcard, String s)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(createWhatsNewEventParameters(feedcard, s)).build();
    }

    private static EventParameters createWhatsNewEventParameters(FeedCard feedcard, String s)
    {
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "notificationmoduletapped").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.MESSAGE_ID, feedcard.id).build();
    }
}
