// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceView, BuyButtonView

public class MarketPlaceAction
    implements android.view.View.OnClickListener
{

    private final AmazonActivity activity;
    private final ProductController productController;

    public MarketPlaceAction(AmazonActivity amazonactivity, ProductController productcontroller)
    {
        activity = amazonactivity;
        productController = productcontroller;
    }

    public void onClick(View view)
    {
        activity.pushView(new MarketPlaceView(activity, productController));
        if (view instanceof BuyButtonView)
        {
            RefMarkerObserver.logRefMarker("dp_buy_opt");
            return;
        } else
        {
            RefMarkerObserver.logRefMarker("dp_olp");
            return;
        }
    }
}
