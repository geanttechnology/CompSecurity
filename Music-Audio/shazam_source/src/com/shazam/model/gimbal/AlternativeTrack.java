// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.gimbal;

import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.Stores;

public class AlternativeTrack
{
    public static class Builder
    {

        public String artist;
        public String id;
        public String image;
        public PreviewViewData previewViewData;
        public Stores stores;
        public String title;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.id;
        }

        static String b(Builder builder)
        {
            return builder.artist;
        }

        static String c(Builder builder)
        {
            return builder.title;
        }

        static String d(Builder builder)
        {
            return builder.image;
        }

        static Stores e(Builder builder)
        {
            return builder.stores;
        }

        static PreviewViewData f(Builder builder)
        {
            return builder.previewViewData;
        }

        public Builder()
        {
        }
    }


    public String artist;
    public String id;
    public String image;
    public PreviewViewData previewViewData;
    public Stores stores;
    public String title;

    public AlternativeTrack()
    {
    }

    private AlternativeTrack(Builder builder)
    {
        id = Builder.a(builder);
        artist = Builder.b(builder);
        title = Builder.c(builder);
        image = Builder.d(builder);
        stores = Builder.e(builder);
        previewViewData = Builder.f(builder);
    }

}
