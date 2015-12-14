// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.graphics.RectF;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicLayoutCache;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ThumbnailSizeLookUp, MosaicItemViewFactory

public static class mosaicCache
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

    public a(MosaicLayoutCache mosaiclayoutcache)
    {
        mosaicCache = mosaiclayoutcache;
    }
}
