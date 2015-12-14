// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.widget.MediaItemImageView;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayCollectionViewAdapter

static final class title extends ItemViewHolder
    implements RequestListener
{

    MediaItemImageView cachedImageViews[];
    private int numImagesLoaded;
    private final int numImagesToLoad;
    View parentView;
    TextView title;

    public boolean isLoading()
    {
        return isLoading;
    }

    public volatile boolean onException(Exception exception, Persistable persistable, Target target, boolean flag)
    {
        return onException(exception, (MediaItem)persistable, target, flag);
    }

    public boolean onException(Exception exception, MediaItem mediaitem, Target target, boolean flag)
    {
        numImagesLoaded = numImagesLoaded + 1;
        if (numImagesLoaded == numImagesToLoad)
        {
            isLoading = false;
        }
        return false;
    }

    public volatile boolean onException(Exception exception, Object obj, Target target, boolean flag)
    {
        return onException(exception, (MediaItem)obj, target, flag);
    }

    public volatile boolean onResourceReady(Bitmap bitmap, Persistable persistable, Target target, boolean flag, boolean flag1)
    {
        return onResourceReady(bitmap, (MediaItem)persistable, target, flag, flag1);
    }

    public boolean onResourceReady(Bitmap bitmap, MediaItem mediaitem, Target target, boolean flag, boolean flag1)
    {
        numImagesLoaded = numImagesLoaded + 1;
        if (numImagesLoaded == numImagesToLoad)
        {
            isLoading = false;
        }
        return false;
    }

    public volatile boolean onResourceReady(Object obj, Object obj1, Target target, boolean flag, boolean flag1)
    {
        return onResourceReady((Bitmap)obj, (MediaItem)obj1, target, flag, flag1);
    }

    public void resetLoading()
    {
        isLoading = true;
        numImagesLoaded = 0;
    }

    (View view, MediaItemImageView amediaitemimageview[])
    {
        super(null, view);
        parentView = view;
        cachedImageViews = amediaitemimageview;
        numImagesToLoad = cachedImageViews.length;
        title = (TextView)view.findViewById(0x7f0c01f5);
    }
}
