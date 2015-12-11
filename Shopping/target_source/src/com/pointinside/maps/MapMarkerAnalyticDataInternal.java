// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.analytics.BaseAnalyticsData;

// Referenced classes of package com.pointinside.maps:
//            Location

final class MapMarkerAnalyticDataInternal extends BaseAnalyticsData
{
    static class Builder extends com.pointinside.analytics.BaseAnalyticsData.Builder
    {

        private String itemId;
        private com.pointinside.analytics.MapMarkerAnalyticData.ItemType itemType;
        private Location location;
        private String referrer;

        public MapMarkerAnalyticDataInternal build()
        {
            return new MapMarkerAnalyticDataInternal(this);
        }

        public volatile com.pointinside.analytics.BaseAnalyticsData.Builder getThis()
        {
            return getThis();
        }

        public Builder getThis()
        {
            return this;
        }

        public Builder itemId(String s)
        {
            itemId = s;
            return this;
        }

        public Builder itemType(com.pointinside.analytics.MapMarkerAnalyticData.ItemType itemtype)
        {
            itemType = itemtype;
            return this;
        }

        public Builder location(Location location1)
        {
            location = location1;
            return this;
        }

        public Builder referrer(String s)
        {
            referrer = s;
            return this;
        }





        public Builder()
        {
        }
    }


    public final String itemId;
    public final com.pointinside.analytics.MapMarkerAnalyticData.ItemType itemType;
    public final Location location;
    public final String referrer;

    private MapMarkerAnalyticDataInternal(Builder builder)
    {
        super(builder);
        referrer = builder.referrer;
        itemId = builder.itemId;
        itemType = builder.itemType;
        location = builder.location;
    }

}
