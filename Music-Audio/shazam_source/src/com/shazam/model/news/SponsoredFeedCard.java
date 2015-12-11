// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;


// Referenced classes of package com.shazam.model.news:
//            FeedCard, FeedCardType

public class SponsoredFeedCard extends FeedCard
{
    public static class Builder
    {

        public String id;
        public String providerName;
        public String siteKey;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.id;
        }

        static String b(Builder builder)
        {
            return builder.providerName;
        }

        static String c(Builder builder)
        {
            return builder.siteKey;
        }

        public Builder()
        {
        }
    }


    private String providerName;
    public String siteKey;

    private SponsoredFeedCard()
    {
    }

    private SponsoredFeedCard(Builder builder)
    {
        super(0L, null, Builder.a(builder), null);
        providerName = Builder.b(builder);
        siteKey = Builder.c(builder);
    }


    public final FeedCardType a()
    {
        return FeedCardType.SPONSORED;
    }
}
