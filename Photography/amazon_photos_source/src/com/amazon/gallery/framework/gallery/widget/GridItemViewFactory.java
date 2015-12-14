// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.glide.BitmapResizer;
import com.amazon.gallery.framework.kindle.activity.BasicListActivity;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.bumptech.glide.GenericRequestBuilder;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ItemViewFactory, ThumbnailSizeLookUp, CoverViewInterface

public class GridItemViewFactory extends ItemViewFactory
{
    public static class GridThumbnailSizeLookUp
        implements ThumbnailSizeLookUp
    {

        private final int thumbnail;

        public int getHeight(int i)
        {
            return thumbnail;
        }

        public int getWidth(int i)
        {
            return thumbnail;
        }

        public GridThumbnailSizeLookUp(Context context)
        {
            Resources resources = context.getResources();
            int i = resources.getInteger(0x7f0d0001);
            int j = resources.getDimensionPixelSize(0x7f0a003d);
            int k = resources.getDimensionPixelSize(0x7f0a003c);
            thumbnail = BasicListActivity.calculateImageWidth(context, i, j, k);
            if (thumbnail == 0)
            {
                GLogger.warnStackTrace(GridItemViewFactory.TAG, "Invalid thumbnail size of 0! numColumns: %d, sidePadding: %d, horizontalPadding: %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
                });
            }
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/widget/GridItemViewFactory.getName();
    private final MediaItemDao mediaItemDao;
    private final ThumbnailSizeLookUp thumbnailSizeLookUp;

    public GridItemViewFactory(Context context, CoverViewInterface coverviewinterface, MediaItemDao mediaitemdao)
    {
        super(coverviewinterface);
        mediaItemDao = mediaitemdao;
        thumbnailSizeLookUp = getThumbnailSizeLookUp(context);
    }

    public ThumbnailSizeLookUp getThumbnailSizeLookUp(Context context)
    {
        return new GridThumbnailSizeLookUp(context);
    }

    public void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
    {
        Object obj = null;
        if (!(persistable instanceof MediaItem)) goto _L2; else goto _L1
_L1:
        persistable = (MediaItem)persistable;
_L4:
        BitmapResizer.overrideSizeToGlideBuilder(thumbnailSizeLookUp.getWidth(i), thumbnailSizeLookUp.getHeight(i), persistable, android.widget.ImageView.ScaleType.CENTER_CROP, genericrequestbuilder);
        return;
_L2:
        persistable = (Tag)persistable;
        com.amazon.gallery.framework.model.ObjectID objectid;
        if (persistable.getCustomCoverId() != null)
        {
            objectid = persistable.getCustomCoverId();
        } else
        {
            objectid = persistable.getCoverId();
        }
        persistable = obj;
        if (objectid != null)
        {
            persistable = mediaItemDao.getItemById(objectid);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


}
