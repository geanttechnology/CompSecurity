// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.utils.L;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoadingInfo, DisplayImageOptions, ImageLoaderEngine

final class DisplayBitmapTask
    implements Runnable
{

    private static final String LOG_DISPLAY_IMAGE_IN_IMAGEVIEW = "Display image in ImageView [%s]";
    private static final String LOG_TASK_CANCELLED = "ImageView is reused for another image. Task is cancelled. [%s]";
    private final Bitmap bitmap;
    private final BitmapDisplayer displayer;
    private final ImageLoaderEngine engine;
    private final String imageUri;
    private final ImageView imageView;
    private final ImageLoadingListener listener;
    private boolean loggingEnabled;
    private final String memoryCacheKey;

    public DisplayBitmapTask(Bitmap bitmap1, ImageLoadingInfo imageloadinginfo, ImageLoaderEngine imageloaderengine)
    {
        bitmap = bitmap1;
        imageUri = imageloadinginfo.uri;
        imageView = imageloadinginfo.imageView;
        memoryCacheKey = imageloadinginfo.memoryCacheKey;
        displayer = imageloadinginfo.options.getDisplayer();
        listener = imageloadinginfo.listener;
        engine = imageloaderengine;
    }

    private boolean isViewWasReused()
    {
        String s = engine.getLoadingUriForView(imageView);
        return !memoryCacheKey.equals(s);
    }

    public void run()
    {
        if (isViewWasReused())
        {
            if (loggingEnabled)
            {
                L.i("ImageView is reused for another image. Task is cancelled. [%s]", new Object[] {
                    memoryCacheKey
                });
            }
            listener.onLoadingCancelled(imageUri, imageView);
            return;
        }
        if (loggingEnabled)
        {
            L.i("Display image in ImageView [%s]", new Object[] {
                memoryCacheKey
            });
        }
        Bitmap bitmap1 = displayer.display(bitmap, imageView);
        listener.onLoadingComplete(imageUri, imageView, bitmap1);
        engine.cancelDisplayTaskFor(imageView);
    }

    void setLoggingEnabled(boolean flag)
    {
        loggingEnabled = flag;
    }
}
