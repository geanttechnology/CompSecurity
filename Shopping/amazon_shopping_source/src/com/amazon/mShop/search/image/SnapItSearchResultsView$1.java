// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.search.image.ImageSearchController;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItSearchResultsView

class this._cls0
    implements com.amazon.mShop.error.BoxActionListener
{

    final SnapItSearchResultsView this$0;

    public void onActionButtonClick(int i)
    {
        SnapItSearchResultsView.access$100(SnapItSearchResultsView.this).doImageSearch(SnapItSearchResultsView.access$000(SnapItSearchResultsView.this));
        SnapItSearchResultsView.access$200(SnapItSearchResultsView.this).updateTitle(SnapItSearchResultsView.this);
    }

    ler()
    {
        this$0 = SnapItSearchResultsView.this;
        super();
    }
}
