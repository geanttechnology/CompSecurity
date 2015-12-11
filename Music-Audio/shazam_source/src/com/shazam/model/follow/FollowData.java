// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.follow;


public class FollowData
{
    public static class Builder
    {

        public String artistId;
        public String followKey;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(FollowData followdata)
        {
            Builder builder = new Builder();
            builder.followKey = FollowData.a(followdata);
            builder.artistId = FollowData.b(followdata);
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.followKey;
        }

        static String b(Builder builder)
        {
            return builder.artistId;
        }

        public final FollowData b()
        {
            return new FollowData(this, null);
        }

        public Builder()
        {
        }
    }


    public String artistId;
    public String followKey;

    private FollowData()
    {
    }

    private FollowData(Builder builder)
    {
        followKey = Builder.a(builder);
        artistId = Builder.b(builder);
    }

    FollowData(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static String a(FollowData followdata)
    {
        return followdata.followKey;
    }

    static String b(FollowData followdata)
    {
        return followdata.artistId;
    }
}
