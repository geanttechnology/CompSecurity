// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.details.InteractiveInfo;

public class TrackInfoCard
{
    public static class Builder
    {

        public String coverArtUrl;
        public String id;
        public InteractiveInfo interactiveInfo;
        public String trackArtist;
        public String trackKey;
        public String trackTitle;

        static InteractiveInfo a(Builder builder)
        {
            return builder.interactiveInfo;
        }

        public static Builder a()
        {
            return new Builder();
        }

        static String b(Builder builder)
        {
            return builder.trackArtist;
        }

        static String c(Builder builder)
        {
            return builder.trackTitle;
        }

        static String d(Builder builder)
        {
            return builder.coverArtUrl;
        }

        static String e(Builder builder)
        {
            return builder.trackKey;
        }

        static String f(Builder builder)
        {
            return builder.id;
        }

        public final TrackInfoCard b()
        {
            return new TrackInfoCard(this);
        }

        public Builder()
        {
        }
    }


    public String coverArtUrl;
    public String id;
    public InteractiveInfo interactiveInfo;
    public String trackArtist;
    public String trackKey;
    public String trackTitle;

    private TrackInfoCard()
    {
    }

    private TrackInfoCard(Builder builder)
    {
        interactiveInfo = Builder.a(builder);
        trackArtist = Builder.b(builder);
        trackTitle = Builder.c(builder);
        coverArtUrl = Builder.d(builder);
        trackKey = Builder.e(builder);
        id = Builder.f(builder);
    }

}
