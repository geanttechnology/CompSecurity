// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.layout.mosaic;

import android.graphics.RectF;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicGenerationResult;

// Referenced classes of package com.amazon.gallery.foundation.ui.layout.mosaic:
//            FillRectImageEater, RootImageEater, SplitImageEater, SplitDimension

public abstract class ImageEater
{

    protected final ImageEater children[];
    protected final SplitDimension dimension;
    protected final int numSpanned;

    public transient ImageEater(int i, SplitDimension splitdimension, ImageEater aimageeater[])
    {
        numSpanned = i;
        dimension = splitdimension;
        children = aimageeater;
    }

    public static FillRectImageEater fillEater()
    {
        return fillEater(1);
    }

    public static FillRectImageEater fillEater(int i)
    {
        return new FillRectImageEater(i);
    }

    public static RootImageEater rootEater(int i, int j, ImageEater imageeater)
    {
        return new RootImageEater(i, j, imageeater);
    }

    public static transient SplitImageEater splitEater(SplitDimension splitdimension, ImageEater aimageeater[])
    {
        return new SplitImageEater(splitdimension, aimageeater);
    }

    protected abstract int addPostcards(RectF rectf, MosaicGenerationResult mosaicgenerationresult, int i, int j, int k);
}
