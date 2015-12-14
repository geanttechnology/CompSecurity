// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.graphics.RectF;
import com.amazon.gallery.framework.glide.BitmapResizer;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicLayoutCache;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.bumptech.glide.GenericRequestBuilder;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ItemViewFactory, CoverViewInterface, ThumbnailSizeLookUp

public class MosaicItemViewFactory extends ItemViewFactory
{
    public static class MosaicThumbnailSizeLookUp
        implements ThumbnailSizeLookUp
    {

        private final MosaicLayoutCache mosaicCache;

        public int getHeight(int i)
        {
            return (int)mosaicCache.getRect(i).height();
        }

        public int getWidth(int i)
        {
            return (int)mosaicCache.getRect(i).width();
        }

        public MosaicThumbnailSizeLookUp(MosaicLayoutCache mosaiclayoutcache)
        {
            mosaicCache = mosaiclayoutcache;
        }
    }


    MosaicLayoutCache cache;
    private final MosaicThumbnailSizeLookUp thumbnailSizeLookUp;

    public MosaicItemViewFactory(CoverViewInterface coverviewinterface, MosaicLayoutCache mosaiclayoutcache)
    {
        super(coverviewinterface);
        cache = mosaiclayoutcache;
        thumbnailSizeLookUp = new MosaicThumbnailSizeLookUp(mosaiclayoutcache);
    }

    protected int getBoundingHeight(int i)
    {
        return (int)cache.getRect(i).height();
    }

    protected int getBoundingWidth(int i)
    {
        return (int)cache.getRect(i).width();
    }

    public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
    {
        overrideSizeToGlideBuilder(i, (MediaItem)persistable, genericrequestbuilder);
    }

    public void overrideSizeToGlideBuilder(int i, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
    {
        BitmapResizer.overrideSizeToGlideBuilder(thumbnailSizeLookUp.getWidth(i), thumbnailSizeLookUp.getHeight(i), mediaitem, android.widget.ImageView.ScaleType.CENTER_CROP, genericrequestbuilder);
    }

    public void setBoundingSize(int i)
    {
    }

    public void setBoundingSize(int i, int j)
    {
    }
}
