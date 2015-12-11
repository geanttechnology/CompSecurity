// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType

public class SocialLoginFeedCard extends FeedCard
{
    public static class Builder
    {

        private Actions actions;
        public final Map beaconData = new HashMap();
        public String id;
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

        public Builder()
        {
        }
    }


    private SocialLoginFeedCard()
    {
    }

    private SocialLoginFeedCard(Builder builder)
    {
        super(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder));
    }


    public final FeedCardType a()
    {
        return FeedCardType.SOCIAL_LOGIN;
    }
}
