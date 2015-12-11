// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.TaggedBeacon;
import com.shazam.android.analytics.TaggedBeaconData;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.analytics.TaggingOutcome;
import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class TaggingEndedEventFactory
{

    public TaggingEndedEventFactory()
    {
    }

    public static Event taggingEndedEventFrom(TaggedBeacon taggedbeacon)
    {
        TaggedBeaconData taggedbeacondata = taggedbeacon.getTaggedBeaconData();
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "taggingended").putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, taggedbeacondata.getTaggingOrigin().getOrigin()).putNotEmptyOrNullParameter(DefinedEventParameterKey.OUTCOME, taggedbeacon.getOutcome().getOutcome()).putNotEmptyOrNullParameter(DefinedEventParameterKey.START_TIME, String.valueOf(taggedbeacon.getStartTime())).putNotEmptyOrNullParameter(DefinedEventParameterKey.END_TIME, String.valueOf(taggedbeacon.getEndTime())).putNotEmptyOrNullParameter(DefinedEventParameterKey.TIME_SPENT, String.valueOf(taggedbeacon.getUiTime())).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, taggedbeacon.getTrackId()).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, taggedbeacon.getBeaconKey()).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, taggedbeacon.getCampaign()).putNotEmptyOrNullParameter(DefinedEventParameterKey.TAG_ID, taggedbeacon.getRequestId());
        taggedbeacondata.addAdditionalTaggedBeaconParamsTo(builder);
        TaggedBeacon.appendWatermarkParametersToParameterMap(builder, taggedbeacon.getWatermark());
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(builder.build()).build();
    }
}
