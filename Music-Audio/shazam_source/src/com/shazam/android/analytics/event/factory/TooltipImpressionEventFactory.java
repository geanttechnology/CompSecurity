// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class TooltipImpressionEventFactory
{

    public TooltipImpressionEventFactory()
    {
    }

    public static Event createAddToMyTagsTooltipImpressionEvent(ScreenOrigin screenorigin)
    {
        screenorigin = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, "addtomytagstooltip").putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_ORIGIN, ScreenOrigin.a(screenorigin)).build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.IMPRESSION).withParameters(screenorigin).build();
    }
}
