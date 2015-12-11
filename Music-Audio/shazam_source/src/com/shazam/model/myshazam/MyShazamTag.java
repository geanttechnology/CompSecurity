// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.myshazam;

import com.shazam.model.TrackStyle;
import com.shazam.model.post.Post;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.Store;

public class MyShazamTag
{
    public static class Builder
    {

        public String artUrl;
        public String artistsDescription;
        public boolean isFull;
        public Post post;
        public PreviewViewData previewViewData;
        public boolean publishable;
        public String requestId;
        public Store store;
        public Long timestamp;
        public String trackId;
        public String trackKey;
        public TrackStyle trackStyle;
        public String trackTitle;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.requestId;
        }

        static String b(Builder builder)
        {
            return builder.trackId;
        }

        static String c(Builder builder)
        {
            return builder.artistsDescription;
        }

        static Long d(Builder builder)
        {
            return builder.timestamp;
        }

        static String e(Builder builder)
        {
            return builder.trackTitle;
        }

        static String f(Builder builder)
        {
            return builder.artUrl;
        }

        static PreviewViewData g(Builder builder)
        {
            return builder.previewViewData;
        }

        static Store h(Builder builder)
        {
            return builder.store;
        }

        static boolean i(Builder builder)
        {
            return builder.isFull;
        }

        static Post j(Builder builder)
        {
            return builder.post;
        }

        static TrackStyle k(Builder builder)
        {
            return builder.trackStyle;
        }

        static boolean l(Builder builder)
        {
            return builder.publishable;
        }

        static String m(Builder builder)
        {
            return builder.trackKey;
        }

        public final MyShazamTag b()
        {
            return new MyShazamTag(this, null);
        }

        public Builder()
        {
        }
    }


    public final String artUrl;
    public final String artistsDescription;
    public final boolean isFull;
    private final Post post;
    public final PreviewViewData previewViewData;
    public final boolean publishable;
    public final String requestId;
    public final Store store;
    private final Long timestamp;
    public final String trackId;
    public final String trackKey;
    public final TrackStyle trackStyle;
    public final String trackTitle;

    private MyShazamTag(Builder builder)
    {
        requestId = Builder.a(builder);
        trackId = Builder.b(builder);
        artistsDescription = Builder.c(builder);
        timestamp = Builder.d(builder);
        trackTitle = Builder.e(builder);
        artUrl = Builder.f(builder);
        previewViewData = Builder.g(builder);
        store = Builder.h(builder);
        isFull = Builder.i(builder);
        post = Builder.j(builder);
        trackStyle = Builder.k(builder);
        publishable = Builder.l(builder);
        trackKey = Builder.m(builder);
    }

    MyShazamTag(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final Long a()
    {
        long l;
        if (timestamp != null)
        {
            l = timestamp.longValue();
        } else
        {
            l = System.currentTimeMillis();
        }
        return Long.valueOf(l);
    }

    public final Post b()
    {
        if (post != null)
        {
            return post;
        } else
        {
            return com.shazam.model.post.Post.Builder.a().b();
        }
    }
}
