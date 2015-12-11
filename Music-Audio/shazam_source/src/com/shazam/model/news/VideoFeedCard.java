// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType

public class VideoFeedCard extends FeedCard
{
    public static class Builder
    {

        private Actions actions;
        public final Map beaconData = new HashMap();
        public String headline;
        public String id;
        private long timestamp;
        public String url;

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

        static String e(Builder builder)
        {
            return builder.url;
        }

        static String f(Builder builder)
        {
            return builder.headline;
        }

        public Builder()
        {
        }
    }


    public String headline;
    public String url;

    public VideoFeedCard()
    {
    }

    private VideoFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        url = Builder.e(builder);
        headline = Builder.f(builder);
    }


    public final FeedCardType a()
    {
        return FeedCardType.VIDEO;
    }
}
