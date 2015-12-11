// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import com.shazam.model.advert.Ad;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType

public class AdFeedCard extends FeedCard
{
    public static class Builder
    {

        private Actions actions;
        public Ad ad;
        private final Map beaconData = new HashMap();
        public String id;
        public String sponsorshipText;
        private long timestamp;

        static long a(Builder builder)
        {
            return builder.timestamp;
        }

        public static Builder a()
        {
            return new Builder();
        }

        static Actions b(Builder builder)
        {
            return builder.actions;
        }

        static String c(Builder builder)
        {
            return builder.id;
        }

        static Map d(Builder builder)
        {
            return builder.beaconData;
        }

        static Ad e(Builder builder)
        {
            return builder.ad;
        }

        static String f(Builder builder)
        {
            return builder.sponsorshipText;
        }

        public final AdFeedCard b()
        {
            return new AdFeedCard(this);
        }

        public Builder()
        {
        }
    }


    public Ad ad;
    public String sponsorshipText;

    protected AdFeedCard()
    {
    }

    private AdFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        ad = Builder.e(builder);
        sponsorshipText = Builder.f(builder);
    }


    public final FeedCardType a()
    {
        return FeedCardType.AD;
    }
}
