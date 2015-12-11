// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.barcodeSearch;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.barcodeSearch:
//            BarcodeSearchResultsView

class this._cls0
    implements com.amazon.mShop.error.oxActionListener
{

    final BarcodeSearchResultsView this$0;

    public void onActionButtonClick(int i)
    {
        BarcodeSearchResultsView.access$000(BarcodeSearchResultsView.this);
        BarcodeSearchResultsView.access$100(BarcodeSearchResultsView.this).updateTitle(BarcodeSearchResultsView.this);
    }

    Listener()
    {
        this$0 = BarcodeSearchResultsView.this;
        super();
    }
}
