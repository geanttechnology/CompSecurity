// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.views.messaging.Availability;
import com.amazon.retailsearch.android.ui.results.views.messaging.EsrbRating;
import com.amazon.retailsearch.android.ui.results.views.messaging.FastTrack;
import com.amazon.retailsearch.android.ui.results.views.messaging.LoyaltyPoints;
import com.amazon.retailsearch.android.ui.results.views.messaging.NewerEditionAvailable;
import com.amazon.retailsearch.android.ui.results.views.messaging.Promotions;
import com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLine;
import com.amazon.retailsearch.android.ui.results.views.messaging.TradeIn;
import com.amazon.retailsearch.android.ui.results.views.messaging.Variations;
import com.amazon.retailsearch.android.ui.results.views.price.ForcedPrime;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, ResultLayoutType

public class ListProduct extends ProductView
{

    private TextView ageRange;
    private Availability availability;
    private TextView byLine;
    private EsrbRating esrbRating;
    private FastTrack fastTrack;
    private ForcedPrime forcedPrime;
    private LoyaltyPoints loyaltyPoints;
    protected NewerEditionAvailable newerEditionAvailable;
    private Promotions promotions;
    private ShippingLine superSaverShipping;
    private TradeIn tradeIn;
    private Variations variations;

    public ListProduct(Context context)
    {
        super(context);
    }

    public ListProduct(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        resultLayoutType = ResultLayoutType.ListView;
    }

    protected void buildView()
    {
        super.buildView();
        Object obj;
        if (TextUtils.isEmpty(product.getByLine()))
        {
            byLine.setVisibility(8);
        } else
        {
            byLine.setText(product.getByLine());
            byLine.setVisibility(0);
        }
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.FastTrackModel.Builder()).build(availabilityInfo);
        fastTrack.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.FastTrackModel) (obj)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.PromotionsModel.Builder()).setHasAutoRip(hasAutoRip).setPromotions(product.getPromotions()).build();
        promotions.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.PromotionsModel) (obj)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.LoyaltyPointsModel.Builder()).build(product.getPoints());
        loyaltyPoints.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.LoyaltyPointsModel) (obj)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel.Builder()).setShippingMessageType(com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel.Builder.ShippingMessageType.SUPER_SAVER_SHIPPING).build(shippingInfo);
        superSaverShipping.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel) (obj)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.AvailabilityModel.Builder()).build(availabilityInfo);
        availability.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.AvailabilityModel) (obj)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.price.ForcedPrimeModel.Builder()).build(product.getNonPrimeOffer(), product.getGroup());
        forcedPrime.buildView(((com.amazon.retailsearch.android.ui.results.views.price.ForcedPrimeModel) (obj)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.TradeInModel.Builder()).build(product.getTradeIn());
        tradeIn.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.TradeInModel) (obj)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.VariationsModel.Builder()).build(product.getVariations());
        variations.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.VariationsModel) (obj)), resultLayoutType);
        if (TextUtils.isEmpty(product.getAgeRange()))
        {
            ageRange.setVisibility(8);
        } else
        {
            ageRange.setText(product.getAgeRange());
            ageRange.setVisibility(0);
        }
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.EsrbRatingModel.Builder()).build(product.getAudienceRating());
        esrbRating.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.EsrbRatingModel) (obj)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.NewerEditionAvailableModel.Builder()).build(product.getNewerVersion(), product.getGroup());
        newerEditionAvailable.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.NewerEditionAvailableModel) (obj)), resultLayoutType);
    }

    protected void init(Context context)
    {
        super.init(context);
        inflate(context, com.amazon.retailsearch.R.layout.list_product_items, this);
        initProductElements();
    }

    protected void initProductElements()
    {
        super.initProductElements();
        byLine = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_item_byline);
        fastTrack = (FastTrack)findViewById(com.amazon.retailsearch.R.id.rs_results_fast_track);
        promotions = (Promotions)findViewById(com.amazon.retailsearch.R.id.rs_results_promotions);
        loyaltyPoints = (LoyaltyPoints)findViewById(com.amazon.retailsearch.R.id.rs_results_points);
        superSaverShipping = (ShippingLine)findViewById(com.amazon.retailsearch.R.id.rs_results_super_saver_shipping);
        availability = (Availability)findViewById(com.amazon.retailsearch.R.id.rs_results_availability);
        forcedPrime = (ForcedPrime)findViewById(com.amazon.retailsearch.R.id.rs_results_forced_prime);
        gestureListener.addTapTarget(forcedPrime);
        tradeIn = (TradeIn)findViewById(com.amazon.retailsearch.R.id.rs_results_trade_in);
        variations = (Variations)findViewById(com.amazon.retailsearch.R.id.rs_results_variations);
        ageRange = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_item_age_range);
        esrbRating = (EsrbRating)findViewById(com.amazon.retailsearch.R.id.rs_results_esrb_rating);
        newerEditionAvailable = (NewerEditionAvailable)findViewById(com.amazon.retailsearch.R.id.rs_results_newer_edition_available);
        gestureListener.addTapTarget(newerEditionAvailable);
        gestureListener.addTapTarget(twister);
    }
}
