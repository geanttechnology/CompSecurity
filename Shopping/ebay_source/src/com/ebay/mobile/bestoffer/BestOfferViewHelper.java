// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.ebay.mobile.Item;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;

public class BestOfferViewHelper
{

    public BestOfferViewHelper()
    {
    }

    public static int getAttributeColor(Activity activity, int i)
    {
        activity = activity.obtainStyledAttributes(i, new int[] {
            i
        });
        i = activity.getColor(0, -1);
        activity.recycle();
        return i;
    }

    public static String getAutoAcceptMessage(Resources resources, ItemCurrency itemcurrency, Double double1)
    {
        Object obj = new CurrencyAmount((new StringBuilder()).append("").append(double1).toString(), itemcurrency.code);
        obj = String.format(resources.getString(0x7f070737), new Object[] {
            EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 0)
        });
        float f = Float.parseFloat(itemcurrency.value);
        itemcurrency = ((ItemCurrency) (obj));
        if (double1.doubleValue() < (double)f)
        {
            int i = (int)((((double)f - double1.doubleValue()) / (double)f) * 100D);
            resources = String.format(resources.getString(0x7f070736), new Object[] {
                Integer.valueOf(i)
            });
            itemcurrency = (new StringBuilder()).append(((String) (obj))).append(" ").append(resources).toString();
        }
        return itemcurrency;
    }

    public static String getAutoDeclineMessage(Resources resources, int i, Double double1, Item item)
    {
        double1 = new CurrencyAmount((new StringBuilder()).append("").append(double1).toString(), item.currentPrice.code);
        item = String.format(resources.getString(0x7f070724), new Object[] {
            item.sellerUserId, EbayCurrencyUtil.formatDisplay(double1, 0)
        });
        double1 = item;
        if (i > 0)
        {
            double1 = (new StringBuilder()).append(item).append("\n").append(resources.getString(0x7f070731)).toString();
        }
        return double1;
    }

    public static String getBidValueStr(Resources resources, CurrencyAmount currencyamount, int i)
    {
        if (i < 2)
        {
            return EbayCurrencyUtil.formatDisplay(currencyamount, 0);
        } else
        {
            CurrencyAmount currencyamount1 = currencyamount.multiplyBy(i);
            return String.format(resources.getString(0x7f070b7b), new Object[] {
                EbayCurrencyUtil.formatDisplay(currencyamount1, 0), (new StringBuilder()).append("").append(i).toString(), EbayCurrencyUtil.formatDisplay(currencyamount, 0)
            });
        }
    }

    public static int getExpiresColor(Activity activity, long l)
    {
        if (l < 1L)
        {
            return activity.getResources().getColor(0x7f0d00f0);
        }
        if (l < 43200L)
        {
            return activity.getResources().getColor(0x7f0d00f0);
        } else
        {
            return getAttributeColor(activity, 0x7f01004e);
        }
    }

    public static String getExpiresStr(Resources resources, long l)
    {
        StringBuilder stringbuilder;
        long l1;
        if (l < 1L)
        {
            return resources.getString(0x7f07072e);
        }
        l1 = l / 1000L / 60L;
        l = l1 / 60L;
        l1 %= 60L;
        stringbuilder = new StringBuilder();
        if (l <= 0L) goto _L2; else goto _L1
_L1:
        stringbuilder.append(l);
        stringbuilder.append(resources.getString(0x7f07004c));
        stringbuilder.append(" ");
        stringbuilder.append(l1);
        stringbuilder.append(resources.getString(0x7f07004f));
_L4:
        return stringbuilder.toString();
_L2:
        if (l1 > 0L)
        {
            stringbuilder.append(l1);
            stringbuilder.append(resources.getString(0x7f07004f));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int getStatusColor(Resources resources, String s)
    {
        if ("Accepted".equals(s) || "Pending".equals(s))
        {
            return resources.getColor(0x7f0d00ee);
        }
        if ("Declined".equals(s) || "Expired".equals(s) || "Retracted".equals(s) || "AdminEnded".equals(s))
        {
            return resources.getColor(0x7f0d00f0);
        } else
        {
            return resources.getColor(0x106000c);
        }
    }
}
