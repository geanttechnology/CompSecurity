// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType

public class TvFeedCard extends FeedCard
{
    public static class Builder
    {

        public Actions actions;
        public final Map beaconData = new HashMap();
        public String id;
        public String image;
        public float imageRatio;
        public String overlayBody;
        public String overlayDecoration;
        public String overlayImage;
        public float overlayImageRatio;
        public String overlayTitle;
        public long timestamp;

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
            return builder.image;
        }

        static String f(Builder builder)
        {
            return builder.overlayImage;
        }

        static String g(Builder builder)
        {
            return builder.overlayTitle;
        }

        static String h(Builder builder)
        {
            return builder.overlayBody;
        }

        static float i(Builder builder)
        {
            return builder.imageRatio;
        }

        static float j(Builder builder)
        {
            return builder.overlayImageRatio;
        }

        static String k(Builder builder)
        {
            return builder.overlayDecoration;
        }

        public Builder()
        {
        }
    }


    public String image;
    public float imageRatio;
    public String overlayBody;
    public String overlayDecoration;
    public String overlayImage;
    public float overlayImageRatio;
    public String overlayTitle;

    private TvFeedCard()
    {
    }

    public TvFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        image = Builder.e(builder);
        overlayImage = Builder.f(builder);
        overlayTitle = Builder.g(builder);
        overlayBody = Builder.h(builder);
        imageRatio = Builder.i(builder);
        overlayImageRatio = Builder.j(builder);
        overlayDecoration = Builder.k(builder);
    }

    public final FeedCardType a()
    {
        return FeedCardType.TV;
    }
}
