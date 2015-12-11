// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.Context;
import android.util.AttributeSet;
import com.amazon.retailsearch.android.ui.buttons.InlineActionsButton;
import com.amazon.retailsearch.android.ui.results.GalleryProduct;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.views.MultiStoreOfferView;
import com.amazon.retailsearch.android.ui.results.views.ResultCloseSeparator;
import com.amazon.retailsearch.android.ui.results.views.Sims;
import com.amazon.retailsearch.android.ui.results.views.messaging.ProductDescription;
import com.amazon.retailsearch.android.ui.results.views.price.Price;
import com.amazon.retailsearch.data.stores.StoreManager;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Product;

public class ImmersiveProduct extends ProductView
{

    private InlineActionsButton inlineActionsButton;
    private MultiStoreOfferView offerView;
    private ProductDescription productDescription;
    private ResultCloseSeparator resultCloseSeparator;
    private Sims simsView;

    public ImmersiveProduct(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        resultLayoutType = ResultLayoutType.ImmersiveView;
    }

    protected void buildView()
    {
        super.buildView();
        boolean flag;
        if (simsView != null)
        {
            Object obj;
            String s;
            if (model.getActiveOffer() != null)
            {
                obj = model.getActiveOffer().getMerchantId();
            } else
            {
                obj = null;
            }
            if (obj != null && storeManager.getStoreCount() > 1)
            {
                s = storeManager.getStoreName(((String) (obj)));
            } else
            {
                s = null;
            }
            obj = (new com.amazon.retailsearch.android.ui.results.views.SimsModel.Builder()).setImmersiveViewListener(model.getContentRowEntry(), model.getSearchLayout(), animationImage).setMerchantId(((String) (obj))).setStoreName(s).build(product.getAsin(), resourceProvider);
            simsView.buildView(((com.amazon.retailsearch.android.ui.results.views.SimsModel) (obj)), resultLayoutType);
        }
        if (productDescription != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.ProductDescriptionModel.Builder()).build(product.getDescription());
            productDescription.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.ProductDescriptionModel) (obj)), resultLayoutType);
        }
        if (useOffers && offerView != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.MultiStoreOfferModel.Builder()).build(storeManager, getResources(), model.getResourceProvider(), model.getActiveOffer(), model, this, numOffers);
            offerView.buildView(((com.amazon.retailsearch.android.ui.results.views.MultiStoreOfferModel) (obj)), resultLayoutType);
            if (price != null)
            {
                price.setVisibility(8);
            }
        } else
        if (offerView != null)
        {
            offerView.setVisibility(8);
        }
        if (inlineActionsButton != null)
        {
            if (flag)
            {
                inlineActionsButton.setVisibility(8);
            } else
            {
                Object obj1 = new com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel.Builder();
                boolean flag1;
                if (useOffers && numOffers > 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                obj1 = ((com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel.Builder) (obj1)).setHasMultipleOffers(flag1).setOffer(model.getActiveOffer()).setUseLongText(true).build(product, model.getVisibleOfferCartState());
                inlineActionsButton.buildView(((com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel) (obj1)), resultLayoutType);
            }
        }
        if (resultCloseSeparator != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.ResultCloseSeparatorModel.Builder()).build(this, 4, com/amazon/retailsearch/android/ui/results/GalleryProduct, model);
            resultCloseSeparator.buildView(((com.amazon.retailsearch.android.ui.results.views.ResultCloseSeparatorModel) (obj)), resultLayoutType);
        }
    }

    protected void init(Context context)
    {
        super.init(context);
        inflate(context, com.amazon.retailsearch.R.layout.rs_immersive_product_items, this);
        initProductElements();
    }

    protected void initProductElements()
    {
        super.initProductElements();
        simsView = (Sims)findViewById(com.amazon.retailsearch.R.id.rs_sim_view);
        productDescription = (ProductDescription)findViewById(com.amazon.retailsearch.R.id.rs_results_product_description);
        inlineActionsButton = (InlineActionsButton)findViewById(com.amazon.retailsearch.R.id.rs_item_button);
        resultCloseSeparator = (ResultCloseSeparator)findViewById(com.amazon.retailsearch.R.id.rs_result_close_separator);
        offerView = (MultiStoreOfferView)findViewById(com.amazon.retailsearch.R.id.rs_multi_store_item);
        gestureListener.addTapTarget(resultCloseSeparator);
    }
}
