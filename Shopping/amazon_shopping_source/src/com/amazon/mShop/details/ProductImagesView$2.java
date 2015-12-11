// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;

// Referenced classes of package com.amazon.mShop.details:
//            ProductImagesView, GalleryPinchImageView

class this._cls0
    implements android.view.
{

    final ProductImagesView this$0;

    public void onClick(View view)
    {
        if (view.isSelected()) goto _L2; else goto _L1
_L1:
        int i;
        boolean flag;
        if (ProductImagesView.access$1100(ProductImagesView.this).getVisibility() == 0)
        {
            ProductImagesView.access$1100(ProductImagesView.this).setVisibility(8);
        }
        ProductImagesView.access$1200(ProductImagesView.this).setVisibility(4);
        ProductImagesView.access$100(ProductImagesView.this).setVisibility(0);
        flag = false;
        i = 0;
_L8:
        int j = ((flag) ? 1 : 0);
        if (i >= ProductImagesView.access$1300(ProductImagesView.this).getChildCount()) goto _L4; else goto _L3
_L3:
        if (ProductImagesView.access$1300(ProductImagesView.this).getChildAt(i) != view) goto _L6; else goto _L5
_L5:
        j = i;
_L4:
        setSelectedState(view, veAction.CLICK);
        ProductImagesView.access$100(ProductImagesView.this).setSelection(j, true);
_L2:
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    veAction()
    {
        this$0 = ProductImagesView.this;
        super();
    }
}
