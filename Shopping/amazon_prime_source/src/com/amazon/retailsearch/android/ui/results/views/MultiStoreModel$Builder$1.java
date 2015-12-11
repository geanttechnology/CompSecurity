// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.layout.ImmersiveProduct;
import com.amazon.retailsearch.interaction.MultiStoreOfferInteractionListener;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            MultiStoreModel

class val.productView
    implements MultiStoreOfferInteractionListener
{

    final val.productView this$0;
    final ProductView val$productView;

    public void offerSelected(EditionsPriceInfo editionspriceinfo)
    {
        val$productView.getModel().setActiveOffer(editionspriceinfo);
        editionspriceinfo = new ContentSwitcherModel(5, com/amazon/retailsearch/android/ui/results/layout/ImmersiveProduct, val$productView.getModel());
        val$productView.switchViewTypes(editionspriceinfo);
        val$productView.scrollIntoView();
    }

    ()
    {
        this$0 = final_;
        val$productView = ProductView.this;
        super();
    }
}
