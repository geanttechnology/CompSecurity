// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.model.Persistable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            LoadingHolderInterface

public class ItemViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    implements LoadingHolderInterface, RequestListener
{
    public static interface ResourceReadyListener
    {

        public abstract void onResourceReady(ImageView imageview, Bitmap bitmap);
    }


    public static final String TAG = com/amazon/gallery/framework/gallery/widget/holder/ItemViewHolder.getName();
    public GalleryBadgeableCoverView badges;
    private int boundingImageHeight;
    private int boundingImageWidth;
    private ImageView imageView;
    protected boolean isLoading;
    protected Persistable item;
    protected LaunchTimeMetrics launchTimeMetrics;
    protected ResourceReadyListener resourceReadyListener;

    public ItemViewHolder(Persistable persistable, View view)
    {
        super(view);
        isLoading = true;
        item = persistable;
    }

    public ImageView getImageView()
    {
        return imageView;
    }

    public Persistable getItem()
    {
        return item;
    }

    protected boolean isBoundingSizeCorrect(View view)
    {
        view = view.getLayoutParams();
        return ((android.view.ViewGroup.LayoutParams) (view)).width == boundingImageWidth && ((android.view.ViewGroup.LayoutParams) (view)).height == boundingImageHeight;
    }

    public boolean isLoading()
    {
        return isLoading;
    }

    public boolean onException(Exception exception, Persistable persistable, Target target, boolean flag)
    {
        GLogger.exf(TAG, exception, "Exception happens in Glide. model: %s, target: %s, isFirstResource: %b", new Object[] {
            persistable.getObjectId(), target, Boolean.valueOf(flag)
        });
        isLoading = false;
        return false;
    }

    public volatile boolean onException(Exception exception, Object obj, Target target, boolean flag)
    {
        return onException(exception, (Persistable)obj, target, flag);
    }

    public boolean onResourceReady(Bitmap bitmap, Persistable persistable, Target target, boolean flag, boolean flag1)
    {
        isLoading = false;
        if (launchTimeMetrics != null)
        {
            launchTimeMetrics.thumbnailLoaded();
        }
        if (resourceReadyListener != null && imageView != null)
        {
            resourceReadyListener.onResourceReady(imageView, bitmap);
        }
        TimeTracker.log("ViewHolder.onImageLoaded");
        return false;
    }

    public volatile boolean onResourceReady(Object obj, Object obj1, Target target, boolean flag, boolean flag1)
    {
        return onResourceReady((Bitmap)obj, (Persistable)obj1, target, flag, flag1);
    }

    public void resetItem()
    {
        item = null;
    }

    public void resetLoading()
    {
        isLoading = true;
    }

    protected void setImageView(ImageView imageview)
    {
        imageView = imageview;
    }

    public void setResourceReadyListener(ResourceReadyListener resourcereadylistener)
    {
        resourceReadyListener = resourcereadylistener;
    }

    public boolean updateBoundingImageSize(int i, int j)
    {
        if (boundingImageWidth != i || boundingImageHeight != j)
        {
            boundingImageWidth = i;
            boundingImageHeight = j;
            return true;
        } else
        {
            return false;
        }
    }

    public void updateView(Persistable persistable, Context context)
    {
        item = persistable;
        if (!isBoundingSizeCorrect(imageView))
        {
            updateViewSize(imageView);
        }
    }

    protected void updateViewSize(View view)
    {
        view = view.getLayoutParams();
        view.width = boundingImageWidth;
        view.height = boundingImageHeight;
    }

}
