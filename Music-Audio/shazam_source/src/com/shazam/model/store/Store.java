// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import android.content.Intent;
import com.shazam.model.analytics.ScreenOrigin;
import java.util.ArrayList;
import java.util.List;

public class Store
{
    public static class Builder
    {

        String beaconKey;
        public String blurredCoverArt;
        String campaign;
        String cardType;
        public String coverArt;
        String eventId;
        String iconUrl;
        public List intents;
        public String key;
        public String previewUrl;
        String providerName;
        String screenName;
        ScreenOrigin screenOrigin;
        String trackCategory;
        public String trackId;
        String trackStyle;
        public Intent validIntent;

        static ScreenOrigin a(Builder builder)
        {
            return builder.screenOrigin;
        }

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(Store store)
        {
            Builder builder = new Builder();
            builder.providerName = store.providerName;
            builder.beaconKey = store.beaconKey;
            builder.key = store.key;
            builder.campaign = store.campaign;
            builder.cardType = store.cardType;
            builder.iconUrl = store.iconUrl;
            builder.eventId = store.eventId;
            builder.intents = store.intents;
            builder.trackCategory = store.trackCategory;
            builder.trackId = store.trackId;
            builder.previewUrl = store.previewUrl;
            builder.coverArt = store.coverArt;
            builder.blurredCoverArt = store.blurredCoverArt;
            builder.screenOrigin = store.screenOrigin;
            builder.validIntent = store.validIntent;
            builder.trackStyle = store.trackStyle;
            return builder;
        }

        static String b(Builder builder)
        {
            return builder.trackId;
        }

        static String c(Builder builder)
        {
            return builder.iconUrl;
        }

        static String d(Builder builder)
        {
            return builder.providerName;
        }

        static String e(Builder builder)
        {
            return builder.trackCategory;
        }

        static String f(Builder builder)
        {
            return builder.eventId;
        }

        static List g(Builder builder)
        {
            return builder.intents;
        }

        static String h(Builder builder)
        {
            return builder.cardType;
        }

        static Intent i(Builder builder)
        {
            return builder.validIntent;
        }

        static String j(Builder builder)
        {
            return builder.beaconKey;
        }

        static String k(Builder builder)
        {
            return builder.campaign;
        }

        static String l(Builder builder)
        {
            return builder.key;
        }

        static String m(Builder builder)
        {
            return builder.previewUrl;
        }

        static String n(Builder builder)
        {
            return builder.coverArt;
        }

        static String o(Builder builder)
        {
            return builder.blurredCoverArt;
        }

        static String p(Builder builder)
        {
            return builder.screenName;
        }

        static String q(Builder builder)
        {
            return builder.trackStyle;
        }

        public final Store b()
        {
            return new Store(this, null);
        }

        public Builder()
        {
            intents = new ArrayList();
        }
    }


    public final String beaconKey;
    final String blurredCoverArt;
    public final String campaign;
    public final String cardType;
    public final String coverArt;
    public final String eventId;
    public final String iconUrl;
    public List intents;
    public final String key;
    public final String previewUrl;
    public final String providerName;
    public final String screenName;
    public final ScreenOrigin screenOrigin;
    public final String trackCategory;
    public final String trackId;
    public final String trackStyle;
    public final Intent validIntent;

    private Store(Builder builder)
    {
        intents = new ArrayList();
        screenOrigin = Builder.a(builder);
        trackId = Builder.b(builder);
        iconUrl = Builder.c(builder);
        providerName = Builder.d(builder);
        trackCategory = Builder.e(builder);
        eventId = Builder.f(builder);
        intents = Builder.g(builder);
        cardType = Builder.h(builder);
        validIntent = Builder.i(builder);
        beaconKey = Builder.j(builder);
        campaign = Builder.k(builder);
        key = Builder.l(builder);
        previewUrl = Builder.m(builder);
        coverArt = Builder.n(builder);
        blurredCoverArt = Builder.o(builder);
        screenName = Builder.p(builder);
        trackStyle = Builder.q(builder);
    }

    Store(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String toString()
    {
        return (new StringBuilder("Store{screenOrigin='")).append(screenOrigin).append('\'').append(", key='").append(key).append('\'').append(", trackId='").append(trackId).append('\'').append(", beaconKey='").append(beaconKey).append('\'').append(", campaign='").append(campaign).append('\'').append(", iconUrl='").append(iconUrl).append('\'').append(", providerName='").append(providerName).append('\'').append(", eventId='").append(eventId).append('\'').append(", trackCategory='").append(trackCategory).append('\'').append(", cardType='").append(cardType).append('\'').append(", coverArt='").append(coverArt).append('\'').append(", intents=").append(intents).append(", validIntent=").append(validIntent).append('}').toString();
    }
}
