// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType

public class ChartFeedCard extends FeedCard
{
    public static class Builder
    {

        public Actions actions;
        private final Map beaconData = new HashMap();
        public boolean hideHeader;
        public String id;
        public long timestamp;
        public String title;
        public List tracks;
        public String url;

        static long a(Builder builder)
        {
            return builder.timestamp;
        }

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(ChartFeedCard chartfeedcard)
        {
            Builder builder = new Builder();
            builder.id = ((FeedCard) (chartfeedcard)).id;
            builder.actions = chartfeedcard.c();
            builder.timestamp = ((FeedCard) (chartfeedcard)).timestamp;
            builder.title = chartfeedcard.title;
            builder.url = chartfeedcard.url;
            builder.tracks = chartfeedcard.tracks;
            builder.hideHeader = chartfeedcard.hideHeader;
            return builder.a(chartfeedcard.d());
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

        static String e(Builder builder)
        {
            return builder.title;
        }

        static String f(Builder builder)
        {
            return builder.url;
        }

        static List g(Builder builder)
        {
            return builder.tracks;
        }

        static boolean h(Builder builder)
        {
            return builder.hideHeader;
        }

        public final Builder a(Map map)
        {
            beaconData.clear();
            beaconData.putAll(map);
            return this;
        }

        public final ChartFeedCard b()
        {
            return new ChartFeedCard(this);
        }

        public Builder()
        {
        }
    }


    public boolean hideHeader;
    public String title;
    public List tracks;
    public String url;

    private ChartFeedCard()
    {
    }

    private ChartFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        title = Builder.e(builder);
        url = Builder.f(builder);
        tracks = Builder.g(builder);
        hideHeader = Builder.h(builder);
    }


    public final FeedCardType a()
    {
        return FeedCardType.RAIL;
    }
}
