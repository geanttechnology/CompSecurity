// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;

import android.location.Location;

// Referenced classes of package com.pointinside.analytics:
//            BaseAnalyticsData

public final class CommonAnalyticsData extends BaseAnalyticsData
{
    public static class Builder extends BaseAnalyticsData.Builder
    {

        public CommonAnalyticsData build()
        {
            return new CommonAnalyticsData(this);
        }

        protected volatile BaseAnalyticsData.Builder getThis()
        {
            return getThis();
        }

        protected Builder getThis()
        {
            return this;
        }

        public Builder()
        {
        }
    }


    protected CommonAnalyticsData(Builder builder)
    {
        super(builder);
    }

    public static CommonAnalyticsData copy(CommonAnalyticsData commonanalyticsdata)
    {
        Builder builder = (Builder)(new Builder()).custData(commonanalyticsdata.custData);
        if (commonanalyticsdata.datetime != null)
        {
            builder.datetime(commonanalyticsdata.datetime.longValue());
        }
        if (commonanalyticsdata.getLocation() != null)
        {
            builder.location(new Location(commonanalyticsdata.getLocation()));
        }
        if (commonanalyticsdata.proximity != null)
        {
            ((Builder)builder.proximity(commonanalyticsdata.proximity)).build();
        }
        return builder.build();
    }
}
