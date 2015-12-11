// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.preview;

import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.player.PlaylistItem;
import java.util.List;

public class PreviewViewData
{
    public static class Builder
    {

        public String beaconKey;
        public String campaign;
        public String eventId;
        public String matchCategory;
        public List playDataInfo;
        public PlaylistItem playlistItem;
        public ScreenOrigin screenOrigin;
        public String trackId;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(PreviewViewData previewviewdata)
        {
            Builder builder = new Builder();
            builder.beaconKey = previewviewdata.beaconKey;
            builder.campaign = previewviewdata.campaign;
            builder.eventId = previewviewdata.eventId;
            builder.matchCategory = previewviewdata.matchCategory;
            builder.screenOrigin = previewviewdata.screenOrigin;
            builder.playlistItem = previewviewdata.playlistItem;
            builder.playDataInfo = previewviewdata.playDataInfo;
            builder.trackId = previewviewdata.trackId;
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.trackId;
        }

        static String b(Builder builder)
        {
            return builder.eventId;
        }

        static ScreenOrigin c(Builder builder)
        {
            return builder.screenOrigin;
        }

        static String d(Builder builder)
        {
            return builder.matchCategory;
        }

        static PlaylistItem e(Builder builder)
        {
            return builder.playlistItem;
        }

        static List f(Builder builder)
        {
            return builder.playDataInfo;
        }

        static String g(Builder builder)
        {
            return builder.beaconKey;
        }

        static String h(Builder builder)
        {
            return builder.campaign;
        }

        public final PreviewViewData b()
        {
            return new PreviewViewData(this, null);
        }

        public Builder()
        {
        }
    }


    public String beaconKey;
    String campaign;
    String eventId;
    String matchCategory;
    public List playDataInfo;
    public PlaylistItem playlistItem;
    ScreenOrigin screenOrigin;
    public String trackId;

    private PreviewViewData()
    {
    }

    private PreviewViewData(Builder builder)
    {
        trackId = Builder.a(builder);
        eventId = Builder.b(builder);
        screenOrigin = Builder.c(builder);
        matchCategory = Builder.d(builder);
        playlistItem = Builder.e(builder);
        playDataInfo = Builder.f(builder);
        beaconKey = Builder.g(builder);
        campaign = Builder.h(builder);
    }

    PreviewViewData(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
