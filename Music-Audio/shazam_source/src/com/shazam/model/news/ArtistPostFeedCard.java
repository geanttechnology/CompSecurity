// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.like.Like;

// Referenced classes of package com.shazam.model.news:
//            TagFeedCard, FeedCardType

public class ArtistPostFeedCard extends TagFeedCard
{
    public static class Builder
    {

        public String captionText;
        public Like like;
        public TagFeedCard.Builder tagNewsCardBuilder;

        public static Builder a()
        {
            return new Builder();
        }

        static TagFeedCard.Builder a(Builder builder)
        {
            return builder.tagNewsCardBuilder;
        }

        static Like b(Builder builder)
        {
            return builder.like;
        }

        static String c(Builder builder)
        {
            return builder.captionText;
        }

        public final ArtistPostFeedCard b()
        {
            return new ArtistPostFeedCard(this);
        }

        public Builder()
        {
        }
    }


    public String captionText;
    private Like like;

    protected ArtistPostFeedCard()
    {
    }

    protected ArtistPostFeedCard(Builder builder)
    {
        super(Builder.a(builder));
        like = Builder.b(builder);
        captionText = Builder.c(builder);
    }

    public final FeedCardType a()
    {
        return FeedCardType.ARTIST_POST;
    }

    public final Like b()
    {
        if (like != null)
        {
            return like;
        } else
        {
            return com.shazam.model.like.Like.Builder.a().b();
        }
    }
}
