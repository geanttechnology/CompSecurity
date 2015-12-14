// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.graphics.RectF;
import com.amazon.gallery.framework.kindle.config.GalleryViewConfig;
import java.util.NavigableMap;
import java.util.TreeMap;

// Referenced classes of package com.amazon.gallery.framework.kindle.recyclerview:
//            MosaicAndroidGenerator, AspectRatioLookUp, MosaicGenerationResult

public class MosaicLayoutCache
{

    private AspectRatioLookUp aspectLookUp;
    private final MosaicAndroidGenerator generator = new MosaicAndroidGenerator();
    private final NavigableMap mosaics = new TreeMap();

    public MosaicLayoutCache(int i)
    {
        generator.setEaters(GalleryViewConfig.constructEaters(i));
    }

    private int getPageBound(int i)
    {
        int j = i % 23;
        if (j == 0)
        {
            return i;
        } else
        {
            return i - j;
        }
    }

    public void clearCache()
    {
        mosaics.clear();
    }

    public MosaicGenerationResult getMosaic(int i)
    {
        int j = getPageBound(i);
        java.util.Map.Entry entry = mosaics.floorEntry(Integer.valueOf(j));
        Object obj = entry;
        if (entry != null)
        {
            obj = entry;
            if (((Integer)entry.getKey()).intValue() + 23 <= j)
            {
                obj = null;
            }
        }
        if (obj == null)
        {
            if (j + 23 >= aspectLookUp.getItemCount())
            {
                i = aspectLookUp.getItemCount();
            } else
            {
                i = j + 23;
            }
            obj = generator.generate(aspectLookUp.getItemCount(), j, i, false);
            mosaics.put(Integer.valueOf(j), obj);
            return ((MosaicGenerationResult) (obj));
        } else
        {
            return (MosaicGenerationResult)((java.util.Map.Entry) (obj)).getValue();
        }
    }

    public RectF getRect(int i)
    {
        return getMosaic(i).getRectForPosition(i);
    }

    public void setAspectRatioLookUp(AspectRatioLookUp aspectratiolookup)
    {
        aspectLookUp = aspectratiolookup;
        generator.setAspectRatioLookUp(aspectratiolookup);
    }

    public void setClientRect(RectF rectf)
    {
        if (rectf.height() != generator.getClientRect().height())
        {
            clearCache();
        }
        generator.setClientRect(rectf);
    }
}
