// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.util.AttributeSet;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.ui.buttons.InlineActionsButton;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.layout.ImmersiveProduct;
import com.amazon.retailsearch.android.ui.results.views.MultiStoreView;
import com.amazon.retailsearch.android.ui.results.views.messaging.Availability;
import com.amazon.retailsearch.android.ui.results.views.messaging.FastTrack;
import com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLine;
import com.amazon.retailsearch.android.ui.results.views.price.Price;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.model.Product;
import dagger.Lazy;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, ResultLayoutType, ContentSwitcherModel, ProductViewModel

public class GalleryProduct extends ProductView
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/results/GalleryProduct);
    private Availability availability;
    Lazy dataProvider;
    private FastTrack fastTrack;
    FeatureConfiguration featureConfig;
    private InlineActionsButton inlineActionsButton;
    private MultiStoreView multiStoreView;
    private ShippingLine superSaverShipping;

    public GalleryProduct(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        resultLayoutType = ResultLayoutType.GalleryView;
    }

    protected void buildView()
    {
        super.buildView();
        Object obj;
        Exception exception;
        boolean flag;
        boolean flag1;
        if (useOffers && numOffers > 0 && multiStoreView != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        com.amazon.retailsearch.android.ui.results.views.MultiStoreModel multistoremodel = (new com.amazon.retailsearch.android.ui.results.views.MultiStoreModel.Builder()).build(storeManager, resourceProvider, gestureListener, this, product.getOffers(), product.getNumVisibleOffers(), contentSwitcher, model);
        multiStoreView.buildView(multistoremodel, resultLayoutType);
        price.setVisibility(8);
_L9:
        if (fastTrack != null)
        {
            fastTrack.setVisibility(8);
        }
        if (superSaverShipping != null)
        {
            superSaverShipping.setVisibility(8);
        }
        if (availability != null)
        {
            availability.setVisibility(8);
        }
        if (inlineActionsButton == null) goto _L4; else goto _L3
_L3:
        if (flag) goto _L6; else goto _L5
_L5:
        inlineActionsButton.setVisibility(0);
        obj = (new com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel.Builder()).setViewSwitching(this, new ContentSwitcherModel(5, com/amazon/retailsearch/android/ui/results/layout/ImmersiveProduct, model)).setOffer(model.getActiveOffer());
        if (useOffers && numOffers > 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj = ((com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel.Builder) (obj)).setHasMultipleOffers(flag1).build(product, model.getVisibleOfferCartState());
        inlineActionsButton.buildView(((com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel) (obj)), resultLayoutType);
_L4:
        if (featureConfig.isFeatureActivated("SX_Shop_Android_Gallery_Messaging"))
        {
            if (fastTrack != null)
            {
                com.amazon.retailsearch.android.ui.results.views.messaging.FastTrackModel fasttrackmodel = (new com.amazon.retailsearch.android.ui.results.views.messaging.FastTrackModel.Builder()).build(availabilityInfo);
                fastTrack.buildView(fasttrackmodel, resultLayoutType);
            }
            if (superSaverShipping != null)
            {
                com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel shippinglinemodel = (new com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel.Builder()).setShippingMessageType(com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel.Builder.ShippingMessageType.SUPER_SAVER_SHIPPING).build(shippingInfo);
                superSaverShipping.buildView(shippinglinemodel, resultLayoutType);
            }
            if (availability != null)
            {
                com.amazon.retailsearch.android.ui.results.views.messaging.AvailabilityModel availabilitymodel = (new com.amazon.retailsearch.android.ui.results.views.messaging.AvailabilityModel.Builder()).build(availabilityInfo);
                availability.buildView(availabilitymodel, resultLayoutType);
                return;
            }
        }
          goto _L7
_L2:
        if (multiStoreView != null)
        {
            multiStoreView.setVisibility(8);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        try
        {
            inlineActionsButton.setVisibility(8);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            log.error("Error", exception);
            return;
        }
          goto _L4
_L7:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void init(Context context)
    {
        super.init(context);
        inflate(context, com.amazon.retailsearch.R.layout.gallery_product_items, this);
        initProductElements();
    }

    protected void initProductElements()
    {
        super.initProductElements();
        gestureListener.addTapTarget(twister);
        try
        {
            fastTrack = (FastTrack)findViewById(com.amazon.retailsearch.R.id.rs_results_fast_track);
            superSaverShipping = (ShippingLine)findViewById(com.amazon.retailsearch.R.id.rs_results_super_saver_shipping);
            availability = (Availability)findViewById(com.amazon.retailsearch.R.id.rs_results_availability);
            inlineActionsButton = (InlineActionsButton)findViewById(com.amazon.retailsearch.R.id.rs_item_button);
            multiStoreView = (MultiStoreView)findViewById(com.amazon.retailsearch.R.id.rs_multi_store_container);
            return;
        }
        catch (Exception exception)
        {
            log.error("Error", exception);
        }
    }

}
