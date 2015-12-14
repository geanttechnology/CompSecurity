// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import com.amazon.gallery.framework.gallery.widget.ItemViewFactory;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.bumptech.glide.GenericRequestBuilder;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayCollectionViewAdapter, CollageLayoutMeasureUtils

public static class collageLayoutMeasureUtils extends ItemViewFactory
{

    private final CollageLayoutMeasureUtils collageLayoutMeasureUtils;
    private final int numTotalItems;

    public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
    {
        overrideSizeToGlideBuilder(i, (MediaItem)persistable, genericrequestbuilder);
    }

    public void overrideSizeToGlideBuilder(int i, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
    {
        mediaitem = collageLayoutMeasureUtils.getBoundingBoxForCollageImage(numTotalItems, i);
        genericrequestbuilder.override(((numTotalItems) (mediaitem)).numTotalItems, ((numTotalItems) (mediaitem)).numTotalItems);
    }

    public (int i, CollageLayoutMeasureUtils collagelayoutmeasureutils)
    {
        super(null);
        numTotalItems = i;
        collageLayoutMeasureUtils = collagelayoutmeasureutils;
    }
}
