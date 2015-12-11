// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.post;

import com.shazam.model.share.ShareData;

public class Post
{
    public static class Builder
    {

        public String caption;
        public String likeKey;
        public ShareData shareData;
        public String tagId;
        public String trackKey;
        public String uuid;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.trackKey;
        }

        static String b(Builder builder)
        {
            return builder.uuid;
        }

        static String c(Builder builder)
        {
            return builder.caption;
        }

        static String d(Builder builder)
        {
            return builder.tagId;
        }

        static String e(Builder builder)
        {
            return builder.likeKey;
        }

        static ShareData f(Builder builder)
        {
            return builder.shareData;
        }

        public final Post b()
        {
            return new Post(this, null);
        }

        public Builder()
        {
        }
    }


    public final String caption;
    public final String likeKey;
    public final ShareData shareData;
    public final String tagId;
    public final String trackKey;
    public final String uuid;

    private Post(Builder builder)
    {
        trackKey = Builder.a(builder);
        uuid = Builder.b(builder);
        caption = Builder.c(builder);
        tagId = Builder.d(builder);
        likeKey = Builder.e(builder);
        shareData = Builder.f(builder);
    }

    Post(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final boolean a()
    {
        return uuid != null;
    }
}
