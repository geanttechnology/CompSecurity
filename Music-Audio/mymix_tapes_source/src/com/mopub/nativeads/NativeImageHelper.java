// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.mopub.nativeads:
//            NativeErrorCode

public class NativeImageHelper
{
    public static interface ImageListener
    {

        public abstract void onImagesCached();

        public abstract void onImagesFailedToCache(NativeErrorCode nativeerrorcode);
    }


    public NativeImageHelper()
    {
    }

    public static void loadImageView(String s, ImageView imageview)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(imageview, "Cannot load image into null ImageView"))
        {
            return;
        }
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "Cannot load image with null url"))
        {
            imageview.setImageDrawable(null);
            return;
        } else
        {
            Networking.getImageLoader(imageview.getContext()).get(s, new com.mopub.volley.toolbox.ImageLoader.ImageListener(imageview) {

                final ImageView val$imageView;

                public void onErrorResponse(VolleyError volleyerror)
                {
                    MoPubLog.d("Failed to load image.", volleyerror);
                    imageView.setImageDrawable(null);
                }

                public void onResponse(com.mopub.volley.toolbox.ImageLoader.ImageContainer imagecontainer, boolean flag)
                {
                    if (!flag)
                    {
                        MoPubLog.d("Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process.");
                    }
                    imageView.setImageBitmap(imagecontainer.getBitmap());
                }

            
            {
                imageView = imageview;
                super();
            }
            });
            return;
        }
    }

    public static void preCacheImages(Context context, List list, ImageListener imagelistener)
    {
        context = Networking.getImageLoader(context);
        Object obj = new AtomicInteger(list.size());
        AtomicBoolean atomicboolean = new AtomicBoolean(false);
        obj = new com.mopub.volley.toolbox.ImageLoader.ImageListener(((AtomicInteger) (obj)), atomicboolean, imagelistener) {

            final AtomicBoolean val$anyFailures;
            final AtomicInteger val$imageCounter;
            final ImageListener val$imageListener;

            public void onErrorResponse(VolleyError volleyerror)
            {
                MoPubLog.d("Failed to download a native ads image:", volleyerror);
                boolean flag = anyFailures.getAndSet(true);
                imageCounter.decrementAndGet();
                if (!flag)
                {
                    imageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
                }
            }

            public void onResponse(com.mopub.volley.toolbox.ImageLoader.ImageContainer imagecontainer, boolean flag)
            {
                if (imagecontainer.getBitmap() != null && imageCounter.decrementAndGet() == 0 && !anyFailures.get())
                {
                    imageListener.onImagesCached();
                }
            }

            
            {
                imageCounter = atomicinteger;
                anyFailures = atomicboolean;
                imageListener = imagelistener;
                super();
            }
        };
        list = list.iterator();
        do
        {
            String s;
label0:
            {
                if (list.hasNext())
                {
                    s = (String)list.next();
                    if (!TextUtils.isEmpty(s))
                    {
                        break label0;
                    }
                    atomicboolean.set(true);
                    imagelistener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
                }
                return;
            }
            context.get(s, ((com.mopub.volley.toolbox.ImageLoader.ImageListener) (obj)));
        } while (true);
    }
}
