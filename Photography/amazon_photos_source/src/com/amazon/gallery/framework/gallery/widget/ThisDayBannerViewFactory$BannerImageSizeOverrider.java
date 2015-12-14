// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.bumptech.glide.GenericRequestBuilder;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ItemViewFactory, ThisDayBannerViewFactory

static class boundingHeight extends ItemViewFactory
{

    private final int boundingHeight;
    private final int boundingWidth;

    public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
    {
        overrideSizeToGlideBuilder(i, (MediaItem)persistable, genericrequestbuilder);
    }

    public void overrideSizeToGlideBuilder(int i, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
    {
        genericrequestbuilder.override(boundingWidth, boundingHeight);
    }

    public (int i, int j)
    {
        super(null);
        boundingWidth = i;
        boundingHeight = j;
    }
}
