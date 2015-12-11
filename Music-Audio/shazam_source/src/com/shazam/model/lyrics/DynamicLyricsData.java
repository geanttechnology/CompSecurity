// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.lyrics;

import java.io.Serializable;

// Referenced classes of package com.shazam.model.lyrics:
//            LyricPlay

public class DynamicLyricsData
    implements Serializable
{
    public static class Builder
    {

        public String copyright;
        public String coverArt;
        public LyricPlay lyricPlay;
        public long tagTimestamp;
        public String title;
        public String writers;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.coverArt;
        }

        static LyricPlay b(Builder builder)
        {
            return builder.lyricPlay;
        }

        static String c(Builder builder)
        {
            return builder.title;
        }

        static long d(Builder builder)
        {
            return builder.tagTimestamp;
        }

        static String e(Builder builder)
        {
            return builder.writers;
        }

        static String f(Builder builder)
        {
            return builder.copyright;
        }

        public final DynamicLyricsData b()
        {
            return new DynamicLyricsData(this, null);
        }

        public Builder()
        {
        }
    }


    public String copyright;
    public String coverArt;
    public LyricPlay lyricPlay;
    public long tagTimestamp;
    public String title;
    public String writers;

    private DynamicLyricsData()
    {
    }

    private DynamicLyricsData(Builder builder)
    {
        coverArt = Builder.a(builder);
        lyricPlay = Builder.b(builder);
        title = Builder.c(builder);
        tagTimestamp = Builder.d(builder);
        writers = Builder.e(builder);
        copyright = Builder.f(builder);
    }

    DynamicLyricsData(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
