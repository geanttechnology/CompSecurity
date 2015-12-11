// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.view.MotionEvent;
import android.widget.Gallery;

// Referenced classes of package com.amazon.mShop.details:
//            ProductImagesView, GalleryPinchImageView, CustomizedGallery

private class <init> extends android.view.tener
{

    final ProductImagesView this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        if (ProductImagesView.access$100(ProductImagesView.this).getVisibility() == 0)
        {
            ProductImagesView.access$1200(ProductImagesView.this).setBackendResource();
            ProductImagesView.access$100(ProductImagesView.this).setVisibility(4);
            ProductImagesView.access$1200(ProductImagesView.this).setVisibility(0);
        }
        ProductImagesView.access$1200(ProductImagesView.this).zoomTo(ProductImagesView.access$1200(ProductImagesView.this).onDoubleTapPost(ProductImagesView.access$1200(ProductImagesView.this).getScale(), 4F), motionevent.getX(), motionevent.getY());
        ((CustomizedGallery)ProductImagesView.access$100(ProductImagesView.this)).logImageZoomedRefMarker();
        return true;
    }

    private ()
    {
        this$0 = ProductImagesView.this;
        super();
    }

    ( )
    {
        this();
    }
}
