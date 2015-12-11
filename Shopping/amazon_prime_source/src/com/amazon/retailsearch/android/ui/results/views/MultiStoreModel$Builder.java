// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.results.ContentSwitcher;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.layout.ImmersiveProduct;
import com.amazon.retailsearch.data.stores.StoreManager;
import com.amazon.retailsearch.interaction.MultiStoreOfferInteractionListener;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            MultiStoreModel

public static class _cls1.val.productView
{

    public MultiStoreModel build(StoreManager storemanager, ResourceProvider resourceprovider, ProductGestureListener productgesturelistener, final ProductView productView, List list, int i, ContentSwitcher contentswitcher, 
            ProductViewModel productviewmodel)
    {
        if (storemanager == null || resourceprovider == null || productgesturelistener == null || productView == null || Utils.isEmpty(list) || contentswitcher == null || productviewmodel == null)
        {
            return null;
        } else
        {
            MultiStoreModel multistoremodel = new MultiStoreModel();
            MultiStoreModel.access$000(multistoremodel, storemanager);
            MultiStoreModel.access$100(multistoremodel, resourceprovider);
            MultiStoreModel.access$200(multistoremodel, productgesturelistener);
            MultiStoreModel.access$300(multistoremodel, list);
            MultiStoreModel.access$400(multistoremodel, i);
            MultiStoreModel.access$500(multistoremodel, productView);
            MultiStoreModel.access$600(multistoremodel, new MultiStoreOfferInteractionListener() {

                final MultiStoreModel.Builder this$0;
                final ProductView val$productView;

                public void offerSelected(EditionsPriceInfo editionspriceinfo)
                {
                    productView.getModel().setActiveOffer(editionspriceinfo);
                    editionspriceinfo = new ContentSwitcherModel(5, com/amazon/retailsearch/android/ui/results/layout/ImmersiveProduct, productView.getModel());
                    productView.switchViewTypes(editionspriceinfo);
                    productView.scrollIntoView();
                }

            
            {
                this$0 = MultiStoreModel.Builder.this;
                productView = productview;
                super();
            }
            });
            MultiStoreModel.access$700(multistoremodel, contentswitcher);
            MultiStoreModel.access$800(multistoremodel, productviewmodel);
            return multistoremodel;
        }
    }

    public _cls1.val.productView()
    {
    }
}
