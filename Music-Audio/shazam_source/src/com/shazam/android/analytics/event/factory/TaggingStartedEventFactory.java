// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.TaggedBeaconData;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class TaggingStartedEventFactory
{

    public TaggingStartedEventFactory()
    {
    }

    public static Event taggingStartedEventFrom(TaggedBeaconData taggedbeacondata)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "taggingstarted").putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, taggedbeacondata.getTaggingOrigin().getOrigin());
        taggedbeacondata.addAdditionalTaggedBeaconParamsTo(builder);
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(builder.build()).build();
    }
}
