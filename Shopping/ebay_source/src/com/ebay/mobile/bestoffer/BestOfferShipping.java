// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.ebay.mobile.Item;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.List;

public class BestOfferShipping
{

    public BestOfferShipping()
    {
    }

    public static SpannableStringBuilder getImportChargeText(Context context, Item item)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(EbayCurrencyUtil.formatDisplay(item.shippingInfo.importCharge, 0));
        spannablestringbuilder.setSpan(new StyleSpan(1), 0, spannablestringbuilder.length(), 33);
        spannablestringbuilder.append('\n').append(context.getString(0x7f07008c));
        return spannablestringbuilder;
    }

    private static SpannableStringBuilder getShippingCostText(Context context, ItemCurrency itemcurrency)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if ((new CurrencyAmount(itemcurrency)).isZero())
        {
            spannablestringbuilder.append(context.getString(0x7f070422));
            spannablestringbuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(0x7f0d00ee)), 0, spannablestringbuilder.length(), 33);
            return spannablestringbuilder;
        } else
        {
            spannablestringbuilder.append(EbayCurrencyUtil.formatDisplay(itemcurrency, 0));
            return spannablestringbuilder;
        }
    }

    public static SpannableStringBuilder getShippingString(Context context, Item item, int i)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (ViewItemShippingInfo.IsLocalPickupOnly(item))
        {
            spannablestringbuilder.append(context.getText(0x7f0700b7));
            return spannablestringbuilder;
        }
        if (item.shippingInfo.orderedOptions == null || item.shippingInfo.orderedOptions.isEmpty())
        {
            spannablestringbuilder.append(ViewItemShippingInfo.getShippingError(context, item));
            return spannablestringbuilder;
        }
        String s = ViewItemShippingInfo.getShippingService(context.getResources(), item);
        ItemCurrency itemcurrency = item.shippingInfo.shippingServiceCost;
        if (itemcurrency == null || TextUtils.isEmpty(s))
        {
            spannablestringbuilder.append(ViewItemShippingInfo.getShippingError(context, item));
            return spannablestringbuilder;
        }
        item = getShippingCostText(context, itemcurrency);
        if (i > 1)
        {
            item.append(" ").append(context.getResources().getQuantityString(0x7f080023, i, new Object[] {
                Integer.valueOf(i)
            }));
        }
        item.setSpan(new StyleSpan(1), 0, item.length(), 33);
        item.append("\n").append(s);
        return item;
    }
}
