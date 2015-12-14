// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.gallery.framework.data.store.RewindHelper;
import com.amazon.gallery.framework.glide.BitmapResizer;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ItemViewFactory, ThumbnailSizeLookUp, CoverViewInterface

public class SingleItemViewFactory extends ItemViewFactory
{
    public static class SingleImageSizeLookUp
        implements ThumbnailSizeLookUp
    {

        private final Context context;
        private int orientation;
        private final Point size = new Point();

        private void updateScreenSize()
        {
            ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getSize(size);
        }

        private void updateScreenSizeIfNeeded()
        {
            int i = context.getResources().getConfiguration().orientation;
            if (orientation != i)
            {
                orientation = i;
                updateScreenSize();
            }
        }

        public int getHeight(int i)
        {
            updateScreenSizeIfNeeded();
            return size.y;
        }

        public int getWidth(int i)
        {
            updateScreenSizeIfNeeded();
            return size.x;
        }

        public SingleImageSizeLookUp(Context context1)
        {
            orientation = 0;
            context = context1;
        }
    }


    private ThumbnailSizeLookUp singleItemSizeLookUp;
    private final ThumbnailSizeLookUp thumbnailSizeLookUp;

    public SingleItemViewFactory(ThumbnailSizeLookUp thumbnailsizelookup, CoverViewInterface coverviewinterface)
    {
        super(coverviewinterface);
        thumbnailSizeLookUp = thumbnailsizelookup;
        forceFitCenter = true;
    }

    protected volatile GenericRequestBuilder getThumbnailRequest(Context context, Persistable persistable, int i)
    {
        return getThumbnailRequest(context, (MediaItem)persistable, i);
    }

    protected GenericRequestBuilder getThumbnailRequest(Context context, MediaItem mediaitem, int i)
    {
        if (context instanceof Activity)
        {
            context = Glide.with((Activity)context).from(com/amazon/gallery/framework/model/media/MediaItem).asBitmap().load(mediaitem).fitCenter().override(thumbnailSizeLookUp.getWidth(i), thumbnailSizeLookUp.getHeight(i));
            RewindHelper.getInstance().insertSignature(mediaitem, context);
            return context;
        } else
        {
            return null;
        }
    }

    public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
    {
        overrideSizeToGlideBuilder(i, (MediaItem)persistable, genericrequestbuilder);
    }

    public void overrideSizeToGlideBuilder(int i, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
    {
        BitmapResizer.overrideSizeToGlideBuilder(singleItemSizeLookUp.getWidth(i), singleItemSizeLookUp.getHeight(i), mediaitem, android.widget.ImageView.ScaleType.FIT_CENTER, genericrequestbuilder);
    }

    public void setContext(Context context)
    {
        super.setContext(context);
        singleItemSizeLookUp = new SingleImageSizeLookUp(context);
    }
}
