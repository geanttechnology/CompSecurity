// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.analytics.BaseAnalyticsData;

final class MapAnalyticsDataInternal extends BaseAnalyticsData
{
    static final class Builder extends com.pointinside.analytics.BaseAnalyticsData.Builder
    {

        private String imageType;
        private String referrer;
        private String storeId;
        private String venue;
        private String zone;

        public MapAnalyticsDataInternal build()
        {
            return new MapAnalyticsDataInternal(this);
        }

        public volatile com.pointinside.analytics.BaseAnalyticsData.Builder getThis()
        {
            return getThis();
        }

        public Builder getThis()
        {
            return this;
        }

        public Builder imageType(String s)
        {
            imageType = s;
            return this;
        }

        public Builder referrer(String s)
        {
            referrer = s;
            return this;
        }

        public Builder storeID(String s)
        {
            storeId = s;
            return this;
        }

        public Builder venueUUID(String s)
        {
            venue = s;
            return this;
        }

        public Builder zoneUUID(String s)
        {
            zone = s;
            return this;
        }






        public Builder()
        {
        }
    }


    public final String imageType;
    public final String referrer;
    public final String storeId;
    public final String venue;
    public final String zone;

    private MapAnalyticsDataInternal(Builder builder)
    {
        super(builder);
        zone = builder.zone;
        imageType = builder.imageType;
        referrer = builder.referrer;
        venue = builder.venue;
        storeId = builder.storeId;
    }

}
