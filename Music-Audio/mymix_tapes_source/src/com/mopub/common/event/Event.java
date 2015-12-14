// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.common.event:
//            BaseEvent, EventDetails

public class Event extends BaseEvent
{
    public static class Builder extends BaseEvent.Builder
    {

        public volatile BaseEvent build()
        {
            return build();
        }

        public Event build()
        {
            return new Event(this);
        }

        public Builder(BaseEvent.Name name, BaseEvent.Category category, double d)
        {
            super(BaseEvent.ScribeCategory.EXCHANGE_CLIENT_EVENT, name, category, d);
        }
    }


    private Event(Builder builder)
    {
        super(builder);
    }


    public static BaseEvent createEventFromDetails(BaseEvent.Name name, BaseEvent.Category category, BaseEvent.SamplingRate samplingrate, EventDetails eventdetails)
    {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(category);
        Preconditions.checkNotNull(samplingrate);
        if (eventdetails == null)
        {
            MoPubLog.d("Unable to log event due to no details present");
            return null;
        } else
        {
            return (new Builder(name, category, samplingrate.getSamplingRate())).withAdUnitId(eventdetails.getAdUnitId()).withAdCreativeId(eventdetails.getDspCreativeId()).withAdType(eventdetails.getAdType()).withAdNetworkType(eventdetails.getAdNetworkType()).withAdWidthPx(eventdetails.getAdWidthPx()).withAdHeightPx(eventdetails.getAdHeightPx()).withGeoLat(eventdetails.getGeoLatitude()).withGeoLon(eventdetails.getGeoLongitude()).withGeoAccuracy(eventdetails.getGeoAccuracy()).withPerformanceDurationMs(eventdetails.getPerformanceDurationMs()).withRequestId(eventdetails.getRequestId()).withRequestStatusCode(eventdetails.getRequestStatusCode()).withRequestUri(eventdetails.getRequestUri()).build();
        }
    }
}
