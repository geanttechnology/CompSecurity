// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import com.shazam.model.follow.FollowData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType

public class ArtistJustJoinedFeedCard extends FeedCard
{
    public static class Builder
    {

        public Actions actions;
        public final Map beaconData = new HashMap();
        public String body;
        public FollowData followData;
        public String headline;
        public String id;
        public String imageUrl;
        public long timestamp;
        public final List tracks = new ArrayList();

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
            return builder.headline;
        }

        static String f(Builder builder)
        {
            return builder.body;
        }

        static String g(Builder builder)
        {
            return builder.imageUrl;
        }

        static List h(Builder builder)
        {
            return builder.tracks;
        }

        static FollowData i(Builder builder)
        {
            return builder.followData;
        }

        public Builder()
        {
        }
    }


    public String body;
    private FollowData followData;
    public String headline;
    public String imageUrl;
    public List tracks;

    protected ArtistJustJoinedFeedCard()
    {
    }

    private ArtistJustJoinedFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        headline = Builder.e(builder);
        body = Builder.f(builder);
        imageUrl = Builder.g(builder);
        tracks = Builder.h(builder);
        followData = Builder.i(builder);
    }


    public final FeedCardType a()
    {
        return FeedCardType.ARTIST_JUST_JOINED;
    }

    public final FollowData b()
    {
        if (followData == null)
        {
            return com.shazam.model.follow.FollowData.Builder.a().b();
        } else
        {
            return followData;
        }
    }
}
