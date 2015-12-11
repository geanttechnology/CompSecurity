// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.opl;

import android.app.Activity;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.BuyButtonController;
import com.amazon.mShop.control.item.BuyButtonType;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.details.BuyButtonView;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.opl:
//            PurchaseParams

public class BuyNowAction
    implements android.view.View.OnClickListener
{

    public BuyNowAction()
    {
    }

    public void onClick(View view)
    {
        if (view instanceof BuyButtonView)
        {
            BuyButtonController buybuttoncontroller = ((BuyButtonView)view).getBuyButtonController();
            ProductController productcontroller = buybuttoncontroller.getProductController();
            view = (Activity)view.getContext();
            if (view instanceof AmazonActivity)
            {
                ((AmazonActivity)view).skipNextStopBehavior();
            }
            ActivityUtils.startPurchaseActivity(view, new PurchaseParams(productcontroller.getAsin(), buybuttoncontroller.getOfferId(), productcontroller.getListId(), productcontroller.getListItemId(), buybuttoncontroller.getDealId(), buybuttoncontroller.getShippingSpeed(), productcontroller.getClickStreamTag().getTag()));
            if (buybuttoncontroller.getBuyButtonType() == BuyButtonType.BUY_NOW)
            {
                RefMarkerObserver.logRefMarker("dp_buy");
            } else
            {
                if (buybuttoncontroller.getBuyButtonType() == BuyButtonType.BUY_NOW_1_CLICK || buybuttoncontroller.getBuyButtonType() == BuyButtonType.BUY_NOW_1_CLICK_PRIME)
                {
                    RefMarkerObserver.logRefMarker("dp_buy_1clk");
                    return;
                }
                if (buybuttoncontroller.getBuyButtonType() == BuyButtonType.PRE_ORDER_NOW || buybuttoncontroller.getBuyButtonType() == BuyButtonType.PRE_ORDER_1_CLICK || buybuttoncontroller.getBuyButtonType() == BuyButtonType.PRE_ORDER_1_CLICK_PRIME)
                {
                    RefMarkerObserver.logRefMarker("dp_buy_pre");
                    return;
                }
            }
        }
    }
}
