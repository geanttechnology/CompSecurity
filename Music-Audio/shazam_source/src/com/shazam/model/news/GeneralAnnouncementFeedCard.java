// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import com.shazam.model.details.InteractiveInfo;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType, Content

public class GeneralAnnouncementFeedCard extends FeedCard
{
    public static class Builder
    {

        public Actions actions;
        public final Map beaconData = new HashMap();
        public Content content;
        public String id;
        public InteractiveInfo interactiveInfo;
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

        static Content e(Builder builder)
        {
            return builder.content;
        }

        static InteractiveInfo f(Builder builder)
        {
            return builder.interactiveInfo;
        }

        public Builder()
        {
        }
    }


    public Content content;
    public InteractiveInfo interactiveInfo;

    private GeneralAnnouncementFeedCard()
    {
    }

    private GeneralAnnouncementFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        content = Builder.e(builder);
        interactiveInfo = Builder.f(builder);
    }


    public final FeedCardType a()
    {
        return FeedCardType.GENERAL;
    }
}
