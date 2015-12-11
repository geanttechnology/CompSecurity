// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.github.ignition.support.cache.AbstractImageCache;
import com.github.ignition.support.images.remote.RemoteImageLoader;
import com.github.ignition.support.images.remote.RemoteImageLoaderHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.image:
//            BadUrlCache

public abstract class CimImageLoader
{
    private class CimImageLoaderHandler extends RemoteImageLoaderHandler
    {

        private OnLoadListener onLoadListener;
        final CimImageLoader this$0;

        protected boolean handleImageLoaded(Bitmap bitmap, Message message)
        {
            String s;
            message = getImageView();
            s = (String)message.getTag();
            if (bitmap != null) goto _L2; else goto _L1
_L1:
            badUrlCache.setBadUrl(getImageUrl());
            if (onLoadListener == null) goto _L2; else goto _L3
_L3:
            onLoadListener.onLoadError(message, s);
_L5:
            return false;
_L2:
            if (!getImageUrl().equals(s)) goto _L5; else goto _L4
_L4:
            if (bitmap == null) goto _L7; else goto _L6
_L6:
            Animation animation = AnimationUtils.loadAnimation(getImageView().getContext(), com.comcast.cim.android.R.anim.image_fade_in);
            message.setImageBitmap(bitmap);
            message.startAnimation(animation);
            if (onLoadListener != null)
            {
                onLoadListener.onLoad(message, s, bitmap);
            }
_L9:
            imageLoader.cancelLoad(message);
            return true;
_L7:
            if (getErrorDrawable() != null)
            {
                message.setImageDrawable(getErrorDrawable());
            }
            if (true) goto _L9; else goto _L8
_L8:
        }

        public CimImageLoaderHandler(ImageView imageview, String s, Drawable drawable, OnLoadListener onloadlistener)
        {
            this$0 = CimImageLoader.this;
            super(imageview, s, drawable);
            onLoadListener = onloadlistener;
        }
    }

    public static interface OnLoadListener
    {

        public abstract void onLoad(ImageView imageview, String s, Bitmap bitmap);

        public abstract void onLoadError(ImageView imageview, String s);
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/image/CimImageLoader);
    private BadUrlCache badUrlCache;
    private AbstractImageCache imageCache;
    private RemoteImageLoader imageLoader;

    public CimImageLoader(RemoteImageLoader remoteimageloader, AbstractImageCache abstractimagecache)
    {
        remoteimageloader.setImageCache(abstractimagecache);
        imageCache = abstractimagecache;
        badUrlCache = new BadUrlCache(72, 30);
        imageLoader = remoteimageloader;
    }

    private boolean shouldTryUrl(String s)
    {
        return s != null && !badUrlCache.isBadUrl(s);
    }

    private void stopAnimationOnView(ImageView imageview)
    {
        Animation animation = imageview.getAnimation();
        if (animation != null)
        {
            imageview.clearAnimation();
            animation.cancel();
        }
    }

    protected Bitmap getBitmapFromMemory(String s)
    {
        return imageCache.getBitmapFromMemory(s);
    }

    public void loadImage(String s, ImageView imageview)
    {
        imageview.setTag(com.comcast.cim.android.R.id.CIM_IMAGE_LOAD_TAG_KEY, s);
        imageLoader.cancelLoad(imageview);
        stopAnimationOnView(imageview);
        if (shouldTryUrl(s) && !loadImageFromMemory(s, null, imageview))
        {
            imageLoader.loadImage(s, imageview, new CimImageLoaderHandler(imageview, s, null, null));
        }
    }

    public void loadImage(String s, ImageView imageview, Drawable drawable, Drawable drawable1)
    {
        imageview.setTag(com.comcast.cim.android.R.id.CIM_IMAGE_LOAD_TAG_KEY, s);
        imageLoader.cancelLoad(imageview);
        stopAnimationOnView(imageview);
        if (shouldTryUrl(s))
        {
            if (!loadImageFromMemory(s, drawable, imageview))
            {
                imageLoader.loadImage(s, imageview, drawable, new RemoteImageLoaderHandler(imageview, s, drawable1));
            }
        } else
        if (drawable1 != null)
        {
            imageview.setImageDrawable(drawable1);
            return;
        }
    }

    public void loadImage(String s, ImageView imageview, Drawable drawable, OnLoadListener onloadlistener)
    {
        imageview.setTag(com.comcast.cim.android.R.id.CIM_IMAGE_LOAD_TAG_KEY, s);
        imageLoader.cancelLoad(imageview);
        stopAnimationOnView(imageview);
        if (shouldTryUrl(s))
        {
            if (!loadImageFromMemory(s, drawable, imageview, onloadlistener))
            {
                imageLoader.loadImage(s, imageview, new CimImageLoaderHandler(imageview, s, drawable, onloadlistener));
            }
        } else
        if (onloadlistener != null)
        {
            onloadlistener.onLoadError(imageview, s);
            return;
        }
    }

    public void loadImage(String s, ImageView imageview, OnLoadListener onloadlistener)
    {
        loadImage(s, imageview, null, onloadlistener);
    }

    public boolean loadImageFromMemory(String s, Drawable drawable, ImageView imageview)
    {
        return loadImageFromMemory(s, drawable, imageview, null);
    }

    public boolean loadImageFromMemory(String s, Drawable drawable, ImageView imageview, OnLoadListener onloadlistener)
    {
        imageview.setTag(com.comcast.cim.android.R.id.CIM_IMAGE_LOAD_TAG_KEY, s);
        imageLoader.cancelLoad(imageview);
        stopAnimationOnView(imageview);
        Bitmap bitmap = getBitmapFromMemory(s);
        if (bitmap != null)
        {
            imageview.setImageBitmap(bitmap);
            if (onloadlistener != null)
            {
                onloadlistener.onLoad(imageview, s, bitmap);
            }
            return true;
        }
        if (drawable != null)
        {
            imageview.setImageDrawable(drawable);
        }
        return false;
    }

    public void preloadImage(String s)
    {
        if (shouldTryUrl(s))
        {
            imageLoader.loadImage(s, null, new RemoteImageLoaderHandler(null, null, null) {

                final CimImageLoader this$0;

                protected boolean handleImageLoaded(Bitmap bitmap, Message message)
                {
                    if (bitmap == null)
                    {
                        badUrlCache.setBadUrl(getImageUrl());
                    }
                    return false;
                }

            
            {
                this$0 = CimImageLoader.this;
                super(imageview, s, drawable);
            }
            });
        }
    }

    public void purgeJobs()
    {
        imageLoader.purgeJobs();
    }



}
