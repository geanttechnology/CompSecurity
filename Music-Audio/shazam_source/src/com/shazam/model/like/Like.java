// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.like;


public class Like
{
    public static class Builder
    {

        public int count;
        public boolean isLiked;
        public String key;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(Like like)
        {
            Builder builder = new Builder();
            builder.key = Like.a(like);
            builder.isLiked = Like.b(like);
            builder.count = Like.c(like);
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.key;
        }

        static boolean b(Builder builder)
        {
            return builder.isLiked;
        }

        static int c(Builder builder)
        {
            return builder.count;
        }

        public final Like b()
        {
            return new Like(this, null);
        }

        public Builder()
        {
        }
    }


    public int count;
    public boolean isLiked;
    public String key;

    private Like()
    {
    }

    private Like(Builder builder)
    {
        key = Builder.a(builder);
        isLiked = Builder.b(builder);
        count = Builder.c(builder);
    }

    Like(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static String a(Like like)
    {
        return like.key;
    }

    static boolean b(Like like)
    {
        return like.isLiked;
    }

    static int c(Like like)
    {
        return like.count;
    }
}
