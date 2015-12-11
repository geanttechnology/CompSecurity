// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.util.AttributeSet;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.views.messaging.Availability;
import com.amazon.retailsearch.android.ui.results.views.messaging.FastTrack;
import com.amazon.retailsearch.android.ui.results.views.messaging.SuperSaverShipping;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, ViewType

public class GalleryProduct extends ProductView
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/results/GalleryProduct);
    private Availability availability;
    private FastTrack fastTrack;
    FeatureConfiguration featureConfig;
    private SuperSaverShipping superSaverShipping;

    public GalleryProduct(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        viewType = ViewType.GalleryView;
    }

    protected void buildView()
    {
        super.buildView();
        try
        {
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
            if (featureConfig.isFeatureActivated("SX_Shop_Android_Gallery_Messaging"))
            {
                if (fastTrack != null)
                {
                    com.amazon.retailsearch.android.ui.results.views.messaging.FastTrackModel fasttrackmodel = (new com.amazon.retailsearch.android.ui.results.views.messaging.FastTrackModel.Builder()).build(availabilityInfo);
                    fastTrack.buildView(fasttrackmodel, viewType);
                }
                if (superSaverShipping != null)
                {
                    com.amazon.retailsearch.android.ui.results.views.messaging.SuperSaverShippingModel supersavershippingmodel = (new com.amazon.retailsearch.android.ui.results.views.messaging.SuperSaverShippingModel.Builder()).build(shippingInfo);
                    superSaverShipping.buildView(supersavershippingmodel, viewType);
                }
                if (availability != null)
                {
                    com.amazon.retailsearch.android.ui.results.views.messaging.AvailabilityModel availabilitymodel = (new com.amazon.retailsearch.android.ui.results.views.messaging.AvailabilityModel.Builder()).build(availabilityInfo);
                    availability.buildView(availabilitymodel, viewType);
                }
            }
            return;
        }
        catch (Exception exception)
        {
            log.error("Error", exception);
        }
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
            superSaverShipping = (SuperSaverShipping)findViewById(com.amazon.retailsearch.R.id.rs_results_super_saver_shipping);
            availability = (Availability)findViewById(com.amazon.retailsearch.R.id.rs_results_availability);
            return;
        }
        catch (Exception exception)
        {
            log.error("Error", exception);
        }
    }

}
