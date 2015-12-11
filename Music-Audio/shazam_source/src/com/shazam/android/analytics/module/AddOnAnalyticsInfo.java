// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.module;

import com.shazam.android.k.f.r;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.share.ShareStyle;

public class AddOnAnalyticsInfo
{
    public static class Builder
    {

        private String artistId;
        private String beaconKey;
        private String campaign;
        private String cardType;
        private String eventId;
        private String providerName;
        private String requestId;
        private String screenName;
        private ScreenOrigin screenOrigin;
        private ShareStyle shareStyle;
        private r shazamUri;
        private String tagId;
        private String tagResultVersion;
        private String trackCategory;
        private String trackId;
        private String uuid;

        static String a(Builder builder)
        {
            return builder.trackId;
        }

        public static Builder addOnAnalyticsInfo()
        {
            return new Builder();
        }

        public static Builder addOnAnalyticsInfo(AddOnAnalyticsInfo addonanalyticsinfo)
        {
            Builder builder = addOnAnalyticsInfo();
            builder.trackId = AddOnAnalyticsInfo.a(addonanalyticsinfo);
            builder.beaconKey = AddOnAnalyticsInfo.b(addonanalyticsinfo);
            builder.campaign = AddOnAnalyticsInfo.c(addonanalyticsinfo);
            builder.trackCategory = AddOnAnalyticsInfo.d(addonanalyticsinfo);
            builder.providerName = AddOnAnalyticsInfo.e(addonanalyticsinfo);
            builder.shazamUri = AddOnAnalyticsInfo.f(addonanalyticsinfo);
            builder.screenOrigin = AddOnAnalyticsInfo.g(addonanalyticsinfo);
            builder.eventId = AddOnAnalyticsInfo.h(addonanalyticsinfo);
            builder.screenName = AddOnAnalyticsInfo.i(addonanalyticsinfo);
            builder.tagResultVersion = AddOnAnalyticsInfo.j(addonanalyticsinfo);
            builder.cardType = AddOnAnalyticsInfo.k(addonanalyticsinfo);
            builder.uuid = AddOnAnalyticsInfo.l(addonanalyticsinfo);
            builder.artistId = AddOnAnalyticsInfo.m(addonanalyticsinfo);
            builder.tagId = AddOnAnalyticsInfo.n(addonanalyticsinfo);
            builder.requestId = AddOnAnalyticsInfo.o(addonanalyticsinfo);
            builder.shareStyle = AddOnAnalyticsInfo.p(addonanalyticsinfo);
            return builder;
        }

        static String b(Builder builder)
        {
            return builder.beaconKey;
        }

        static String c(Builder builder)
        {
            return builder.campaign;
        }

        static String d(Builder builder)
        {
            return builder.trackCategory;
        }

        static String e(Builder builder)
        {
            return builder.providerName;
        }

        static r f(Builder builder)
        {
            return builder.shazamUri;
        }

        static ScreenOrigin g(Builder builder)
        {
            return builder.screenOrigin;
        }

        static String h(Builder builder)
        {
            return builder.eventId;
        }

        static String i(Builder builder)
        {
            return builder.screenName;
        }

        static String j(Builder builder)
        {
            return builder.tagResultVersion;
        }

        static String k(Builder builder)
        {
            return builder.cardType;
        }

        static String l(Builder builder)
        {
            return builder.uuid;
        }

        static String m(Builder builder)
        {
            return builder.artistId;
        }

        static String n(Builder builder)
        {
            return builder.tagId;
        }

        static String o(Builder builder)
        {
            return builder.requestId;
        }

        static ShareStyle p(Builder builder)
        {
            return builder.shareStyle;
        }

        public AddOnAnalyticsInfo build()
        {
            return new AddOnAnalyticsInfo(this, (byte)0);
        }

        public Builder withArtistId(String s)
        {
            artistId = s;
            return this;
        }

        public Builder withBeaconKey(String s)
        {
            beaconKey = s;
            return this;
        }

        public Builder withCampaign(String s)
        {
            campaign = s;
            return this;
        }

        public Builder withCardType(String s)
        {
            cardType = s;
            return this;
        }

        public Builder withEventId(String s)
        {
            eventId = s;
            return this;
        }

        public Builder withProviderName(String s)
        {
            providerName = s;
            return this;
        }

        public Builder withRequestId(String s)
        {
            requestId = s;
            return this;
        }

        public Builder withScreenName(String s)
        {
            screenName = s;
            return this;
        }

        public Builder withScreenOrigin(ScreenOrigin screenorigin)
        {
            screenOrigin = screenorigin;
            return this;
        }

        public Builder withShareStyle(ShareStyle sharestyle)
        {
            shareStyle = sharestyle;
            return this;
        }

        public Builder withShazamUri(r r)
        {
            shazamUri = r;
            return this;
        }

        public Builder withTagId(String s)
        {
            tagId = s;
            return this;
        }

        public Builder withTagResultVersion(String s)
        {
            tagResultVersion = s;
            return this;
        }

        public Builder withTrackCategory(String s)
        {
            trackCategory = s;
            return this;
        }

        public Builder withTrackId(String s)
        {
            trackId = s;
            return this;
        }

        public Builder withUuid(String s)
        {
            uuid = s;
            return this;
        }

        public Builder()
        {
        }
    }


    private final String artistId;
    private final String beaconKey;
    private final String campaign;
    private final String cardType;
    private final String eventId;
    private final String providerName;
    private final String requestId;
    private final String screenName;
    private final ScreenOrigin screenOrigin;
    private final ShareStyle shareStyle;
    private final r shazamUri;
    private final String tagId;
    private final String tagResultVersion;
    private final String trackCategory;
    private final String trackId;
    private final String uuid;

    private AddOnAnalyticsInfo(Builder builder)
    {
        trackId = Builder.a(builder);
        beaconKey = Builder.b(builder);
        campaign = Builder.c(builder);
        trackCategory = Builder.d(builder);
        providerName = Builder.e(builder);
        shazamUri = Builder.f(builder);
        screenOrigin = Builder.g(builder);
        eventId = Builder.h(builder);
        screenName = Builder.i(builder);
        tagResultVersion = Builder.j(builder);
        cardType = Builder.k(builder);
        uuid = Builder.l(builder);
        artistId = Builder.m(builder);
        tagId = Builder.n(builder);
        requestId = Builder.o(builder);
        shareStyle = Builder.p(builder);
    }

    AddOnAnalyticsInfo(Builder builder, byte byte0)
    {
        this(builder);
    }

    static String a(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.trackId;
    }

    static String b(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.beaconKey;
    }

    static String c(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.campaign;
    }

    static String d(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.trackCategory;
    }

    static String e(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.providerName;
    }

    static r f(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.shazamUri;
    }

    static ScreenOrigin g(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.screenOrigin;
    }

    static String h(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.eventId;
    }

    static String i(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.screenName;
    }

    static String j(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.tagResultVersion;
    }

    static String k(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.cardType;
    }

    static String l(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.uuid;
    }

    static String m(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.artistId;
    }

    static String n(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.tagId;
    }

    static String o(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.requestId;
    }

    static ShareStyle p(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        return addonanalyticsinfo.shareStyle;
    }

    public String getArtistId()
    {
        return artistId;
    }

    public String getBeaconKey()
    {
        return beaconKey;
    }

    public String getCampaign()
    {
        return campaign;
    }

    public String getCardType()
    {
        return cardType;
    }

    public String getEventId()
    {
        return eventId;
    }

    public String getProviderName()
    {
        return providerName;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public String getScreenName()
    {
        return screenName;
    }

    public ScreenOrigin getScreenOrigin()
    {
        return screenOrigin;
    }

    public ShareStyle getShareStyle()
    {
        return shareStyle;
    }

    public r getShazamUri()
    {
        return shazamUri;
    }

    public String getTagId()
    {
        return tagId;
    }

    public String getTagResultVersion()
    {
        return tagResultVersion;
    }

    public String getTrackCategory()
    {
        return trackCategory;
    }

    public String getTrackId()
    {
        return trackId;
    }

    public String getUuid()
    {
        return uuid;
    }
}
