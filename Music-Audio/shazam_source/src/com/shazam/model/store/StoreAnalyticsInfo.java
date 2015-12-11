// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import com.shazam.model.analytics.ScreenOrigin;

public class StoreAnalyticsInfo
{
    public static class Builder
    {

        public String beaconKey;
        public String campaign;
        public String cardType;
        public String eventId;
        public String key;
        public ScreenOrigin origin;
        public String screenName;
        public String trackCategory;
        public String trackId;
        public String trackStyle;

        static ScreenOrigin a(Builder builder)
        {
            return builder.origin;
        }

        public static Builder a()
        {
            return new Builder();
        }

        static String b(Builder builder)
        {
            return builder.cardType;
        }

        static String c(Builder builder)
        {
            return builder.eventId;
        }

        static String d(Builder builder)
        {
            return builder.trackCategory;
        }

        static String e(Builder builder)
        {
            return builder.trackId;
        }

        static String f(Builder builder)
        {
            return builder.beaconKey;
        }

        static String g(Builder builder)
        {
            return builder.campaign;
        }

        static String h(Builder builder)
        {
            return builder.key;
        }

        static String i(Builder builder)
        {
            return builder.screenName;
        }

        static String j(Builder builder)
        {
            return builder.trackStyle;
        }

        public final StoreAnalyticsInfo b()
        {
            return new StoreAnalyticsInfo(this, null);
        }

        public Builder()
        {
        }
    }


    final String beaconKey;
    final String campaign;
    final String cardType;
    final String eventId;
    private final String key;
    final ScreenOrigin origin;
    final String screenName;
    final String trackCategory;
    final String trackId;
    final String trackStyle;

    private StoreAnalyticsInfo(Builder builder)
    {
        origin = Builder.a(builder);
        cardType = Builder.b(builder);
        eventId = Builder.c(builder);
        trackCategory = Builder.d(builder);
        trackId = Builder.e(builder);
        beaconKey = Builder.f(builder);
        campaign = Builder.g(builder);
        key = Builder.h(builder);
        screenName = Builder.i(builder);
        trackStyle = Builder.j(builder);
    }

    StoreAnalyticsInfo(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
