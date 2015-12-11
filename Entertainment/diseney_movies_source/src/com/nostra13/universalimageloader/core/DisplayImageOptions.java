// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            DefaultConfigurationFactory

public final class DisplayImageOptions
{
    public static class Builder
    {

        private boolean cacheInMemory;
        private boolean cacheOnDisc;
        private android.graphics.BitmapFactory.Options decodingOptions;
        private int delayBeforeLoading;
        private BitmapDisplayer displayer;
        private Object extraForDownloader;
        private Handler handler;
        private int imageForEmptyUri;
        private int imageOnFail;
        private ImageScaleType imageScaleType;
        private BitmapProcessor postProcessor;
        private BitmapProcessor preProcessor;
        private boolean resetViewBeforeLoading;
        private int stubImage;

        public Builder bitmapConfig(android.graphics.Bitmap.Config config)
        {
            decodingOptions.inPreferredConfig = config;
            return this;
        }

        public DisplayImageOptions build()
        {
            return new DisplayImageOptions(this, null);
        }

        public Builder cacheInMemory()
        {
            cacheInMemory = true;
            return this;
        }

        public Builder cacheOnDisc()
        {
            cacheOnDisc = true;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions displayimageoptions)
        {
            stubImage = displayimageoptions.stubImage;
            imageForEmptyUri = displayimageoptions.imageForEmptyUri;
            imageOnFail = displayimageoptions.imageOnFail;
            resetViewBeforeLoading = displayimageoptions.resetViewBeforeLoading;
            cacheInMemory = displayimageoptions.cacheInMemory;
            cacheOnDisc = displayimageoptions.cacheOnDisc;
            imageScaleType = displayimageoptions.imageScaleType;
            decodingOptions = displayimageoptions.decodingOptions;
            delayBeforeLoading = displayimageoptions.delayBeforeLoading;
            extraForDownloader = displayimageoptions.extraForDownloader;
            preProcessor = displayimageoptions.preProcessor;
            postProcessor = displayimageoptions.postProcessor;
            displayer = displayimageoptions.displayer;
            handler = displayimageoptions.handler;
            return this;
        }

        public Builder decodingOptions(android.graphics.BitmapFactory.Options options)
        {
            decodingOptions = options;
            return this;
        }

        public Builder delayBeforeLoading(int i)
        {
            delayBeforeLoading = i;
            return this;
        }

        public Builder displayer(BitmapDisplayer bitmapdisplayer)
        {
            displayer = bitmapdisplayer;
            return this;
        }

        public Builder extraForDownloader(Object obj)
        {
            extraForDownloader = obj;
            return this;
        }

        public Builder handler(Handler handler1)
        {
            handler = handler1;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imagescaletype)
        {
            imageScaleType = imagescaletype;
            return this;
        }

        public Builder postProcessor(BitmapProcessor bitmapprocessor)
        {
            postProcessor = bitmapprocessor;
            return this;
        }

        public Builder preProcessor(BitmapProcessor bitmapprocessor)
        {
            preProcessor = bitmapprocessor;
            return this;
        }

        public Builder resetViewBeforeLoading()
        {
            resetViewBeforeLoading = true;
            return this;
        }

        public Builder showImageForEmptyUri(int i)
        {
            imageForEmptyUri = i;
            return this;
        }

        public Builder showImageOnFail(int i)
        {
            imageOnFail = i;
            return this;
        }

        public Builder showStubImage(int i)
        {
            stubImage = i;
            return this;
        }















        public Builder()
        {
            stubImage = 0;
            imageForEmptyUri = 0;
            imageOnFail = 0;
            resetViewBeforeLoading = false;
            cacheInMemory = false;
            cacheOnDisc = false;
            imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
            decodingOptions = new android.graphics.BitmapFactory.Options();
            delayBeforeLoading = 0;
            extraForDownloader = null;
            preProcessor = null;
            postProcessor = null;
            displayer = DefaultConfigurationFactory.createBitmapDisplayer();
            handler = null;
            decodingOptions.inPurgeable = true;
            decodingOptions.inInputShareable = true;
        }
    }


    private final boolean cacheInMemory;
    private final boolean cacheOnDisc;
    private final android.graphics.BitmapFactory.Options decodingOptions;
    private final int delayBeforeLoading;
    private final BitmapDisplayer displayer;
    private final Object extraForDownloader;
    private final Handler handler;
    private final int imageForEmptyUri;
    private final int imageOnFail;
    private final ImageScaleType imageScaleType;
    private final BitmapProcessor postProcessor;
    private final BitmapProcessor preProcessor;
    private final boolean resetViewBeforeLoading;
    private final int stubImage;

    private DisplayImageOptions(Builder builder)
    {
        stubImage = builder.stubImage;
        imageForEmptyUri = builder.imageForEmptyUri;
        imageOnFail = builder.imageOnFail;
        resetViewBeforeLoading = builder.resetViewBeforeLoading;
        cacheInMemory = builder.cacheInMemory;
        cacheOnDisc = builder.cacheOnDisc;
        imageScaleType = builder.imageScaleType;
        decodingOptions = builder.decodingOptions;
        delayBeforeLoading = builder.delayBeforeLoading;
        extraForDownloader = builder.extraForDownloader;
        preProcessor = builder.preProcessor;
        postProcessor = builder.postProcessor;
        displayer = builder.displayer;
        handler = builder.handler;
    }

    DisplayImageOptions(Builder builder, DisplayImageOptions displayimageoptions)
    {
        this(builder);
    }

    public static DisplayImageOptions createSimple()
    {
        return (new Builder()).build();
    }

    public android.graphics.BitmapFactory.Options getDecodingOptions()
    {
        return decodingOptions;
    }

    public int getDelayBeforeLoading()
    {
        return delayBeforeLoading;
    }

    public BitmapDisplayer getDisplayer()
    {
        return displayer;
    }

    public Object getExtraForDownloader()
    {
        return extraForDownloader;
    }

    public Handler getHandler()
    {
        if (handler == null)
        {
            return new Handler();
        } else
        {
            return handler;
        }
    }

    public int getImageForEmptyUri()
    {
        return imageForEmptyUri;
    }

    public int getImageOnFail()
    {
        return imageOnFail;
    }

    public ImageScaleType getImageScaleType()
    {
        return imageScaleType;
    }

    public BitmapProcessor getPostProcessor()
    {
        return postProcessor;
    }

    public BitmapProcessor getPreProcessor()
    {
        return preProcessor;
    }

    public int getStubImage()
    {
        return stubImage;
    }

    public boolean isCacheInMemory()
    {
        return cacheInMemory;
    }

    public boolean isCacheOnDisc()
    {
        return cacheOnDisc;
    }

    public boolean isResetViewBeforeLoading()
    {
        return resetViewBeforeLoading;
    }

    public boolean shouldDelayBeforeLoading()
    {
        return delayBeforeLoading > 0;
    }

    public boolean shouldPostProcess()
    {
        return postProcessor != null;
    }

    public boolean shouldPreProcess()
    {
        return preProcessor != null;
    }

    public boolean shouldShowImageForEmptyUri()
    {
        return imageForEmptyUri != 0;
    }

    public boolean shouldShowImageOnFail()
    {
        return imageOnFail != 0;
    }

    public boolean shouldShowStubImage()
    {
        return stubImage != 0;
    }














}
