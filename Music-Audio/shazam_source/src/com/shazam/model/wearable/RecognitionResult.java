// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.wearable;

import com.shazam.model.lyrics.DynamicLyricsData;
import java.io.Serializable;

public class RecognitionResult
    implements Serializable
{
    public static class Builder
    {

        public String artistName;
        public String coverArt;
        public DynamicLyricsData dynamicLyricsData;
        public String trackTitle;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.coverArt;
        }

        static String b(Builder builder)
        {
            return builder.artistName;
        }

        static String c(Builder builder)
        {
            return builder.trackTitle;
        }

        static DynamicLyricsData d(Builder builder)
        {
            return builder.dynamicLyricsData;
        }

        public Builder()
        {
        }
    }


    private String artistName;
    private String coverArt;
    private DynamicLyricsData dynamicLyricsData;
    private String trackTitle;

    private RecognitionResult()
    {
    }

    private RecognitionResult(Builder builder)
    {
        coverArt = Builder.a(builder);
        artistName = Builder.b(builder);
        trackTitle = Builder.c(builder);
        dynamicLyricsData = Builder.d(builder);
    }

}
