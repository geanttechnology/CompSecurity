// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.layout.mosaic;

import android.graphics.RectF;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicGenerationResult;

// Referenced classes of package com.amazon.gallery.foundation.ui.layout.mosaic:
//            ImageEater, SplitDimension

public class FillRectImageEater extends ImageEater
{

    public FillRectImageEater(int i)
    {
        super(i, SplitDimension.NONE, new ImageEater[0]);
    }

    protected int addPostcards(RectF rectf, MosaicGenerationResult mosaicgenerationresult, int i, int j, int k)
    {
        mosaicgenerationresult.setRect(i, rectf, k);
        return 1;
    }
}
