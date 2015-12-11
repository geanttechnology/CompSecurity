// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.widget.Gallery;

// Referenced classes of package com.amazon.mShop.details:
//            ProductImagesView, CustomizedGallery

class this._cls0
    implements Runnable
{

    final ProductImagesView this$0;

    public void run()
    {
        setSelectedState(ProductImagesView.access$100(ProductImagesView.this).getSelectedItemPosition(), ((CustomizedGallery)ProductImagesView.access$100(ProductImagesView.this)).getAction());
    }

    ()
    {
        this$0 = ProductImagesView.this;
        super();
    }
}
