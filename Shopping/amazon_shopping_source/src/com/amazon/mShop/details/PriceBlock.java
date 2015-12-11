// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.ExtraOfferListing;
import com.amazon.rio.j2me.client.services.mShop.Savings;

public class PriceBlock
{

    public PriceBlock()
    {
    }

    protected static String getShippingPrice(ViewGroup viewgroup, BasicOfferListing basicofferlisting, ExtraOfferListing extraofferlisting)
    {
        Object obj = null;
        if (viewgroup != null)
        {
            basicofferlisting = ProductController.getOfferShippingPrice(basicofferlisting, extraofferlisting);
            obj = basicofferlisting;
            if (!Util.isEmpty(basicofferlisting))
            {
                obj = viewgroup.getResources().getString(com.amazon.mShop.android.lib.R.string.dp_plus_shipping, new Object[] {
                    basicofferlisting
                });
            }
        }
        return ((String) (obj));
    }

    public static void updateActualPriceLabel(ViewGroup viewgroup, ProductController productcontroller)
    {
        TextView textview = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.item_price_title);
        if (!productcontroller.isPriceHidden() && productcontroller.getDisplayPrice() != null)
        {
            String s = viewgroup.getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.dp_price);
            if (productcontroller.getProductSavings() != null && productcontroller.getProductSavings().getPromoPriceLabel() != null)
            {
                productcontroller = productcontroller.getProductSavings().getPromoPriceLabel();
                textview.setTextColor(viewgroup.getContext().getResources().getColor(com.amazon.mShop.android.lib.R.color.price));
            } else
            {
                textview.setTextColor(viewgroup.getContext().getResources().getColor(com.amazon.mShop.android.lib.R.color.gray_text));
                productcontroller = s;
            }
            textview.setText(viewgroup.getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.name_colon_value, new Object[] {
                productcontroller, ""
            }).trim());
        }
    }
}
