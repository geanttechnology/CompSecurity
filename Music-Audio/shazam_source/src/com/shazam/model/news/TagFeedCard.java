// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType, TrackInfoCard

public class TagFeedCard extends FeedCard
{
    public static class Builder
    {

        public Actions actions;
        public String authorId;
        public String authorImageUrl;
        public String authorName;
        private final Map beaconData = new HashMap();
        public String event;
        public String id;
        public long timestamp;
        public TrackInfoCard trackInfoCard;
        public Map urlParams;

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
            return builder.authorName;
        }

        static String f(Builder builder)
        {
            return builder.authorImageUrl;
        }

        static String g(Builder builder)
        {
            return builder.event;
        }

        static Map h(Builder builder)
        {
            return builder.urlParams;
        }

        static TrackInfoCard i(Builder builder)
        {
            return builder.trackInfoCard;
        }

        static String j(Builder builder)
        {
            return builder.authorId;
        }

        public final Builder a(Map map)
        {
            beaconData.clear();
            beaconData.putAll(map);
            return this;
        }

        public final TagFeedCard b()
        {
            return new TagFeedCard(this);
        }

        public Builder()
        {
        }
    }


    public String authorId;
    public String authorImageUrl;
    public String authorName;
    public String event;
    public TrackInfoCard trackInfoCard;
    private Map urlParams;

    protected TagFeedCard()
    {
    }

    protected TagFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        authorName = Builder.e(builder);
        authorImageUrl = Builder.f(builder);
        event = Builder.g(builder);
        urlParams = Builder.h(builder);
        trackInfoCard = Builder.i(builder);
        authorId = Builder.j(builder);
    }

    public FeedCardType a()
    {
        return FeedCardType.TAG;
    }
}
