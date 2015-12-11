// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.amazon.retailsearch.android.ui.SearchImageLoaderListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            PastPurchasesWidget

class this._cls0
    implements SearchImageLoaderListener
{

    final PastPurchasesWidget this$0;

    public void onLoad(Bitmap bitmap)
    {
        PastPurchasesWidget.access$100(PastPurchasesWidget.this).setImageBitmap(bitmap);
        PastPurchasesWidget.access$100(PastPurchasesWidget.this).setVisibility(0);
    }

    ()
    {
        this$0 = PastPurchasesWidget.this;
        super();
    }
}
