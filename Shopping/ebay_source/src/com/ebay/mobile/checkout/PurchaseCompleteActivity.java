// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.merch.MerchandiseFragment;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PurchaseCompleteActivity extends ModalActivity
    implements android.view.View.OnClickListener
{

    public static final String EXTRA_BOPIS_CHECKOUT = "bopis_in_cart";
    public static final String EXTRA_CHARITY_CHECKOUT = "charity_in_cart";
    public static final String EXTRA_CHARITY_DONATION = "charity_donation";
    public static final String EXTRA_CHARITY_ID = "charity_id";
    public static final String EXTRA_CHARITY_NAME = "charity_name";
    public static final String EXTRA_EBN_CHECKOUT = "ebn_in_cart";
    public static final String EXTRA_MORE_CHECKOUTABLE_ITEMS_IN_CART = "checkoutable_items_in_cart";
    public static final String EXTRA_NOT_ALL_ITEMS_PURCHASED = "not_all_items_purchased";
    public static final String EXTRA_PURCHASED_ITEM_IDS = "purchased_item_ids";
    public static final String EXTRA_SHOPPING_CART_CHECKOUT = "shopping_cart_checkout";
    public static final String MIMS_SCOPE_XFER = "MimsScope";
    private boolean bopisCheckout;
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private boolean ebnCheckout;
    private boolean isMoreXOItemsInCart;
    private boolean notAllItemsPurchased;
    private long purchasedItemIds[];

    public PurchaseCompleteActivity()
    {
        isMoreXOItemsInCart = false;
    }

    private void returnToMyEbay()
    {
        Intent intent = MyEbayLandingActivity.getBuyingActivityIntent(this);
        intent.setFlags(0x4000000);
        startActivity(intent);
        finish();
    }

    public String getTrackingEventName()
    {
        return "PaymentSent";
    }

    public void onBackPressed()
    {
        returnToMyEbay();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131757518: 
            returnToMyEbay();
            return;

        case 2131757517: 
            Resources resources = getResources();
            view = DeviceConfiguration.getAsync().get(DcsString.BopisTermsLink);
            if (!TextUtils.isEmpty(view))
            {
                view = String.format(resources.getString(0x7f070478), new Object[] {
                    view, resources.getString(0x7f070c8a)
                });
            } else
            {
                view = resources.getString(0x7f070c8a);
            }
            view = String.format(resources.getString(0x7f070c8b), new Object[] {
                view
            });
            dialogManager.showDynamicAlertDialog(getString(0x7f070c89), view, false);
            return;

        case 2131757516: 
            view = new Intent(this, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
            view.setFlags(0x4000000);
            startActivity(view);
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0302d5);
        findViewById(0x7f1009ce).setOnClickListener(this);
        bundle = (Button)findViewById(0x7f1009cd);
        bundle.setOnClickListener(this);
        Object obj = getIntent();
        notAllItemsPurchased = ((Intent) (obj)).getBooleanExtra("not_all_items_purchased", false);
        bopisCheckout = ((Intent) (obj)).getBooleanExtra("bopis_in_cart", false);
        ebnCheckout = ((Intent) (obj)).getBooleanExtra("ebn_in_cart", false);
        purchasedItemIds = ((Intent) (obj)).getLongArrayExtra("purchased_item_ids");
        isMoreXOItemsInCart = ((Intent) (obj)).getBooleanExtra("checkoutable_items_in_cart", false);
        obj = (TextView)findViewById(0x7f1009c2);
        TextView textview1 = (TextView)findViewById(0x7f1009c6);
        TextView textview2 = (TextView)findViewById(0x7f1009c3);
        View view = findViewById(0x7f1009c7);
        if (notAllItemsPurchased)
        {
            ((TextView) (obj)).setText(0x7f070c7b);
            textview1.setText(0x7f070c15);
            textview2.setVisibility(4);
        } else
        if (ebnCheckout)
        {
            bundle.setVisibility(8);
            textview1.setText(0x7f070c8e);
            textview2.setVisibility(0);
            findViewById(0x7f1009ce).setVisibility(0);
        } else
        if (bopisCheckout)
        {
            bundle.setVisibility(0);
            view.setVisibility(0);
            textview1.setText(0x7f070c8c);
            findViewById(0x7f1009ce).setVisibility(8);
        } else
        {
            bundle.setVisibility(8);
            textview1.setText(0x7f070c14);
            textview2.setVisibility(0);
            bundle = getIntent().getStringExtra("charity_name");
            if (bundle != null)
            {
                TextView textview = (TextView)findViewById(0x7f1009c5);
                textview.setText(getString(0x7f070c86, new Object[] {
                    bundle
                }));
                textview.setVisibility(0);
            }
            findViewById(0x7f1009ce).setVisibility(0);
        }
        bundle = MyApp.getDeviceConfiguration().getConfig();
        obj = findViewById(0x7f10088c);
        if (isMoreXOItemsInCart && bundle.get(DcsBoolean.UseShoppingCartMultipleCurrency))
        {
            findViewById(0x7f1009c4).setVisibility(8);
            ((View) (obj)).setVisibility(8);
            findViewById(0x7f1009c0).setVisibility(8);
            findViewById(0x7f1009ca).setVisibility(0);
            findViewById(0x7f1009cc).setOnClickListener(this);
        }
        if (bundle.get(DcsBoolean.checkoutMerchandiseItems) && !isMoreXOItemsInCart)
        {
            MerchandiseFragment.attach(this, "MERCH_XO_COMPLETE", 0x7f10088c, 0x1873dL, purchasedItemIds, false);
        }
        initDataManagers();
        hideBackButton();
        showCloseButton();
        setCancelable(false);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (getIntent().getBooleanExtra("shopping_cart_checkout", false))
        {
            com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi serviceapi;
            if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Payments.B.shopCaseCart))
            {
                serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.SHOPCASE;
            } else
            {
                serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.ECAS;
            }
            ((ShoppingCartDataManagerBase)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.KeyParams(serviceapi), null)).getCartAsync(true);
        }
    }

    protected void onPause()
    {
        TrackingData trackingdata = new TrackingData("CheckoutPaymentSuccess", TrackingType.EVENT);
        Map map = (Map)getIntent().getSerializableExtra("tracking_key_values");
        if (map != null && map.size() > 0)
        {
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); trackingdata.addKeyValuePair(s, (String)map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        trackingdata.send(this);
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            MimsUtil.releaseScopedProvider(Long.valueOf(bundle.getLong("MimsScope")));
        }
    }
}
