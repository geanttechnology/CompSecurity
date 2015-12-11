// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType

public class WhatsNewFeedCard extends FeedCard
{
    public static class Builder
    {

        public Actions actions;
        public final Map beaconData = new HashMap();
        public String body;
        public String id;
        public long timestamp;
        public String title;

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
            return builder.title;
        }

        static String f(Builder builder)
        {
            return builder.body;
        }

        public Builder()
        {
        }
    }


    public String body;
    public String title;

    private WhatsNewFeedCard()
    {
    }

    private WhatsNewFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
        title = Builder.e(builder);
        body = Builder.f(builder);
    }


    public final FeedCardType a()
    {
        return FeedCardType.WHATS_NEW;
    }
}
