// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.ui.buttons.InlineActionsButton;
import com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonStyle;
import com.amazon.retailsearch.android.ui.results.views.PrimeOptionsView;
import com.amazon.retailsearch.android.ui.results.views.messaging.ConsumableMessaging;
import com.amazon.retailsearch.android.ui.results.views.messaging.Coupon;
import com.amazon.retailsearch.android.ui.results.views.messaging.Promotions;
import com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLine;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.NativeBadge;
import com.amazon.searchapp.retailsearch.model.PriceInfo;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.Promotion;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, ResultLayoutType, ProductViewModel

public class ConsumableListProduct extends ProductView
{

    private static final String FRESH_CART_BUTTON_TYPE = "ADD_TO_FRESH_CART";
    public static final String PANTRY = "PANTRY";
    private TextView byLine;
    private Coupon coupon;
    private ConsumableMessaging exclusivityMessaging;
    FeatureConfiguration featureConfig;
    private TextView freshPastPurchases;
    private View freshPastPurchasesContainer;
    private ShippingLine generalShippingLine;
    private InlineActionsButton inlineActionsButton;
    private ConsumableMessaging offerMessaging;
    private PrimeOptionsView primeOptionsView;
    private Promotions promotions;

    public ConsumableListProduct(Context context)
    {
        super(context);
    }

    public ConsumableListProduct(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        resultLayoutType = ResultLayoutType.ListView;
    }

    protected void buildView()
    {
        super.buildView();
        Object obj;
        Object obj1;
        com.amazon.retailsearch.android.ui.results.views.messaging.ConsumableMessagingModel consumablemessagingmodel;
        if (TextUtils.isEmpty(product.getByLine()))
        {
            byLine.setVisibility(8);
        } else
        {
            byLine.setText(product.getByLine());
            byLine.setVisibility(0);
        }
        if (product.getCoupon() == null)
        {
            coupon.setVisibility(8);
        } else
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.CouponModel.Builder()).setBadgeText(product.getCoupon().getBadgeText()).setLabel(product.getCoupon().getLabel()).build();
            coupon.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.CouponModel) (obj)), resultLayoutType);
            coupon.setVisibility(0);
        }
        obj1 = null;
        consumablemessagingmodel = null;
        obj = null;
        if (product.getPrices() == null || product.getPrices().getBuy() == null)
        {
            freshPastPurchasesContainer.setVisibility(8);
            freshPastPurchases.setVisibility(8);
            offerMessaging.setVisibility(8);
            exclusivityMessaging.setVisibility(8);
            primeOptionsView.setVisibility(8);
        } else
        {
            Object obj2 = null;
            obj = obj2;
            if (product.getPrices().getBuy().getShipping() != null)
            {
                obj = obj2;
                if (product.getPrices().getBuy().getShipping().getMessage() != null)
                {
                    obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.ConsumableMessagingModel.Builder()).setStyledBadgeMessage(product.getPrices().getBuy().getShipping().getMessage()).build(product.getPrices().getBuy().getShipping());
                }
            }
            exclusivityMessaging.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.ConsumableMessagingModel) (obj)), resultLayoutType);
            if ("amazonfresh".equals(model.getStore()))
            {
                primeOptionsView.setVisibility(8);
                if (hasPastPurchases() && ((StyledText)product.getHeaderBadge().getBadgeText().get(0)).getText() != null)
                {
                    freshPastPurchases.setText(((StyledText)product.getHeaderBadge().getBadgeText().get(0)).getText());
                    freshPastPurchasesContainer.setVisibility(0);
                    freshPastPurchases.setVisibility(0);
                } else
                {
                    freshPastPurchasesContainer.setVisibility(8);
                    freshPastPurchases.setVisibility(8);
                }
                if (product.getPrices().getBuy().getShipping() != null)
                {
                    obj = product.getPrices().getBuy().getShipping().getMessage();
                } else
                {
                    obj = null;
                }
                consumablemessagingmodel = (new com.amazon.retailsearch.android.ui.results.views.messaging.ConsumableMessagingModel.Builder()).setStyledBadgeMessage(((List) (obj))).build(product.getPrices().getBuy().getShipping());
                obj = obj1;
                obj1 = consumablemessagingmodel;
            } else
            {
label0:
                {
                    freshPastPurchasesContainer.setVisibility(8);
                    freshPastPurchases.setVisibility(8);
                    obj = consumablemessagingmodel;
                    if (product.getPromotions() == null)
                    {
                        break label0;
                    }
                    obj1 = product.getPromotions().iterator();
                    do
                    {
                        obj = consumablemessagingmodel;
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break label0;
                        }
                        obj = (Promotion)((Iterator) (obj1)).next();
                    } while (!"PANTRY".equalsIgnoreCase(((Promotion) (obj)).getType()));
                    obj = ((Promotion) (obj)).getText();
                }
                obj1 = (new com.amazon.retailsearch.android.ui.results.views.messaging.ConsumableMessagingModel.Builder()).setBadgeMessage(((String) (obj))).build(product.getPrices().getBuy().getShipping());
                if (Utils.isEmpty(product.getPrices().getEditions()))
                {
                    primeOptionsView.setVisibility(8);
                } else
                {
                    com.amazon.retailsearch.android.ui.results.views.PrimeOptionsViewModel primeoptionsviewmodel = (new com.amazon.retailsearch.android.ui.results.views.PrimeOptionsViewModel.Builder(product.getPrices().getEditions(), product.getAsin(), product.getGroup(), gestureListener)).build();
                    primeOptionsView.buildView(primeoptionsviewmodel, resultLayoutType);
                }
            }
            offerMessaging.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.ConsumableMessagingModel) (obj1)), resultLayoutType);
        }
        if ("C".equals(FeatureStateUtil.getDisableConsumableAddToCartWeblab(featureConfig)))
        {
            obj1 = (new com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel.Builder()).setOffer(model.getActiveOffer());
            boolean flag;
            if (useOffers && numOffers > 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = ((com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel.Builder) (obj1)).setHasMultipleOffers(flag).setIsQuantitySwitcherEnabled(false).setUseLongText(true).setStyle(InlineActionsButtonStyle.FRESH).setIsEnabledForStore("amazonfresh", model.getStore()).setIsEnabledForButtonType("ADD_TO_FRESH_CART", product.getActionButtons()).setIsViewOptionsEnabled(false).build(product, model.getVisibleOfferCartState());
            inlineActionsButton.buildView(((com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel) (obj1)), resultLayoutType);
        } else
        {
            inlineActionsButton.setVisibility(8);
        }
        obj1 = (new com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel.Builder()).build(shippingInfo);
        generalShippingLine.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel) (obj1)), resultLayoutType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.PromotionsModel.Builder()).setHasAutoRip(hasAutoRip).setPromotions(product.getPromotions()).setHidePantryPromotion(TextUtils.isEmpty(((CharSequence) (obj)))).build();
        promotions.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.PromotionsModel) (obj)), resultLayoutType);
    }

    protected boolean hasPastPurchases()
    {
        return product.getHeaderBadge() != null && !Utils.isEmpty(product.getHeaderBadge().getBadgeText());
    }

    protected void init(Context context)
    {
        super.init(context);
        inflate(context, com.amazon.retailsearch.R.layout.list_product_items_consumables, this);
        initProductElements();
    }

    protected void initProductElements()
    {
        super.initProductElements();
        byLine = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_item_byline);
        coupon = (Coupon)findViewById(com.amazon.retailsearch.R.id.rs_results_coupon);
        offerMessaging = (ConsumableMessaging)findViewById(com.amazon.retailsearch.R.id.rs_results_consumable_offer_messaging);
        exclusivityMessaging = (ConsumableMessaging)findViewById(com.amazon.retailsearch.R.id.rs_results_exclusivity_messaging);
        promotions = (Promotions)findViewById(com.amazon.retailsearch.R.id.rs_results_promotions);
        primeOptionsView = (PrimeOptionsView)findViewById(com.amazon.retailsearch.R.id.rs_results_prime_options_container);
        freshPastPurchases = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_fresh_past_purchases);
        freshPastPurchasesContainer = findViewById(com.amazon.retailsearch.R.id.rs_fresh_past_purchases_container);
        inlineActionsButton = (InlineActionsButton)findViewById(com.amazon.retailsearch.R.id.rs_item_button);
        generalShippingLine = (ShippingLine)findViewById(com.amazon.retailsearch.R.id.rs_results_shipping_line);
    }
}
