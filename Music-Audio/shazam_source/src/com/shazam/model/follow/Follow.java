// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.follow;


public class Follow
{
    public static class Builder
    {

        public String defaultAvatar;
        public String followKey;
        public String id;
        public boolean isFollowing;
        public String name;
        public boolean verified;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(Follow follow)
        {
            Builder builder = new Builder();
            builder.id = Follow.a(follow);
            builder.name = Follow.b(follow);
            builder.defaultAvatar = Follow.c(follow);
            builder.followKey = Follow.d(follow);
            builder.verified = Follow.e(follow);
            builder.isFollowing = Follow.f(follow);
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.id;
        }

        static String b(Builder builder)
        {
            return builder.name;
        }

        static String c(Builder builder)
        {
            return builder.defaultAvatar;
        }

        static boolean d(Builder builder)
        {
            return builder.verified;
        }

        static boolean e(Builder builder)
        {
            return builder.isFollowing;
        }

        static String f(Builder builder)
        {
            return builder.followKey;
        }

        public final Follow b()
        {
            return new Follow(this, null);
        }

        public Builder()
        {
        }
    }


    public String defaultAvatar;
    public String followKey;
    public String id;
    public boolean isFollowing;
    public String name;
    public boolean verified;

    private Follow()
    {
    }

    private Follow(Builder builder)
    {
        id = Builder.a(builder);
        name = Builder.b(builder);
        defaultAvatar = Builder.c(builder);
        verified = Builder.d(builder);
        isFollowing = Builder.e(builder);
        followKey = Builder.f(builder);
    }

    Follow(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static String a(Follow follow)
    {
        return follow.id;
    }

    static String b(Follow follow)
    {
        return follow.name;
    }

    static String c(Follow follow)
    {
        return follow.defaultAvatar;
    }

    static String d(Follow follow)
    {
        return follow.followKey;
    }

    static boolean e(Follow follow)
    {
        return follow.verified;
    }

    static boolean f(Follow follow)
    {
        return follow.isFollowing;
    }
}
