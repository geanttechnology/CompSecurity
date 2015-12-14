// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.net.Uri;

public class VideoFramesParams
{
    public static class Builder
    {

        private int framesCount;
        private int max;
        private int maxVideoDuration;
        private int min;
        private int minVideoDuration;
        private boolean rescale;
        private Uri videoUri;

        public VideoFramesParams build()
        {
            return new VideoFramesParams(this);
        }

        public Builder withMax(int i)
        {
            max = i;
            return this;
        }

        public Builder withMaxVideoDuration(int i)
        {
            maxVideoDuration = i;
            return this;
        }

        public Builder withMin(int i)
        {
            min = i;
            return this;
        }

        public Builder withVideoUri(Uri uri)
        {
            videoUri = uri;
            return this;
        }








        public Builder()
        {
            minVideoDuration = 1000;
            maxVideoDuration = 30000;
            framesCount = 10;
            rescale = true;
        }
    }


    public final int framesCount;
    public final int max;
    public final int maxVideoDuration;
    public final int min;
    public final int minVideoDuration;
    public final boolean rescale;
    public final Uri videoUri;

    private VideoFramesParams(Builder builder)
    {
        min = builder.min;
        max = builder.max;
        minVideoDuration = builder.minVideoDuration;
        maxVideoDuration = builder.maxVideoDuration;
        framesCount = builder.framesCount;
        videoUri = builder.videoUri;
        rescale = builder.rescale;
    }

}
