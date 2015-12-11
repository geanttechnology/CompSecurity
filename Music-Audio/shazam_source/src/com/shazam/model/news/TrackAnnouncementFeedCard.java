// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType, Content, TrackInfoCard

public class TrackAnnouncementFeedCard extends FeedCard
{
    public static class Builder
    {

        public Actions actions;
        public final Map beaconData = new HashMap();
        public Content content;
        public String id;
        public long timestamp;
        public TrackInfoCard trackInfo;

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

        static Content e(Builder builder)
        {
            return builder.content;
        }

        static TrackInfoCard f(Builder builder)
        {
            return builder.trackInfo;
        }

        public Builder()
        {
        }
    }


    public Content content;
    public TrackInfoCard trackInfo;

    private TrackAnnouncementFeedCard()
    {
    }

    private TrackAnnouncementFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        content = Builder.e(builder);
        trackInfo = Builder.f(builder);
    }


    public final FeedCardType a()
    {
        return FeedCardType.TRACK;
    }
}
