// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.view.ScaleGestureDetector;
import android.widget.Gallery;

// Referenced classes of package com.amazon.mShop.details:
//            ProductImagesView, GalleryPinchImageView

private class <init> extends android.view.leGestureListener
{

    final ProductImagesView this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        if (ProductImagesView.access$100(ProductImagesView.this).getVisibility() == 0)
        {
            if (scalegesturedetector.getScaleFactor() <= 1.0F)
            {
                return false;
            }
            ProductImagesView.access$1200(ProductImagesView.this).setBackendResource();
            ProductImagesView.access$1200(ProductImagesView.this).setVisibility(0);
            ProductImagesView.access$100(ProductImagesView.this).setVisibility(4);
        }
        ProductImagesView.access$1200(ProductImagesView.this).updateScale(scalegesturedetector);
        return true;
    }

    private tener()
    {
        this$0 = ProductImagesView.this;
        super();
    }

    tener(tener tener)
    {
        this();
    }
}
