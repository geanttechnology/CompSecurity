// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.amazon.mShop.util.ConfigUtils;

// Referenced classes of package com.amazon.mShop.details:
//            ProductImagesView, GalleryPinchImageView

class this._cls0
    implements android.view.
{

    final ProductImagesView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (ConfigUtils.isEnabledForApp(getContext(), com.amazon.mShop.android.lib.ortPinchZoom))
        {
            ProductImagesView.access$600(ProductImagesView.this).onTouchEvent(motionevent);
            if (!ProductImagesView.access$600(ProductImagesView.this).isInProgress())
            {
                ProductImagesView.access$400(ProductImagesView.this).onTouchEvent(motionevent);
            }
        } else
        {
            ProductImagesView.access$400(ProductImagesView.this).onTouchEvent(motionevent);
        }
        if (ProductImagesView.access$1200(ProductImagesView.this).getVisibility() != 4 || motionevent.getPointerCount() > 1)
        {
            return true;
        } else
        {
            view.onTouchEvent(motionevent);
            return true;
        }
    }

    w()
    {
        this$0 = ProductImagesView.this;
        super();
    }
}
