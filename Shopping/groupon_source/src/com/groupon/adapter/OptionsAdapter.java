// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.db.models.PricingMetadata;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.UrgencyPricingUtils;
import com.groupon.view.optioncards.OptionCardBaseView;
import java.util.List;
import roboguice.util.Strings;

public class OptionsAdapter extends BaseAdapter
{

    private final Context context;
    private final CurrencyFormatter currencyFormatter;
    private final List data;
    private final Deal deal;
    private final boolean isUSACompatible;

    public OptionsAdapter(Context context1, Deal deal1, List list, CurrencyFormatter currencyformatter, boolean flag)
    {
        context = context1;
        deal = deal1;
        data = list;
        isUSACompatible = flag;
        currencyFormatter = currencyformatter;
    }

    private String formatString(String s, String s1)
    {
        return String.format("%s %s", new Object[] {
            s, s1
        });
    }

    public int getCount()
    {
        if (data != null)
        {
            return data.size();
        } else
        {
            return 0;
        }
    }

    public Option getItem(int i)
    {
        if (data != null)
        {
            return (Option)data.get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        OptionCardBaseView optioncardbaseview;
label0:
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = new OptionCardBaseView(context);
            }
            optioncardbaseview = (OptionCardBaseView)viewgroup;
            Object obj = getItem(i);
            if (obj != null)
            {
                boolean flag2 = deal.getDisplayOption("quantity", true);
                boolean flag3 = deal.getDisplayOption("discount", true);
                boolean flag4 = ((Option) (obj)).isSoldOut();
                boolean flag5 = ((Option) (obj)).isExpired();
                boolean flag;
                boolean flag1;
                if (flag4 || flag5)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag3 && isUSACompatible && Strings.notEmpty(UrgencyPricingUtils.getUrgencyPricingAvailability(((Option) (obj)).regularPrice, ((Option) (obj)).pricingMetadata)) && Strings.notEmpty(((Option) (obj)).pricingMetadata.offerLabelDescriptive))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag1)
                {
                    i = 1;
                } else
                {
                    i = ((Option) (obj)).getMinimumPurchaseQuantity();
                }
                if (flag4)
                {
                    view = context.getString(0x7f0803b3);
                } else
                if (flag5)
                {
                    view = context.getString(0x7f0802b6);
                } else
                {
                    view = ((Option) (obj)).getPrice();
                    view = currencyFormatter.formatWithQuantity(view, i);
                }
                optioncardbaseview.setTitleText(((Option) (obj)).getTitle());
                optioncardbaseview.setPriceText(view);
                if (flag1)
                {
                    i = 0x7f0e00d7;
                } else
                {
                    i = 0x7f0e00c2;
                }
                if (flag)
                {
                    i = 0x7f0e0144;
                }
                optioncardbaseview.setPriceColor(context.getResources().getColor(i));
                optioncardbaseview.setSoldOutOrExpiredOverlayVisibility(flag1);
                if (!flag1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                optioncardbaseview.setPriceEnabled(flag1);
                i = ((Option) (obj)).getDiscountPercent();
                if (i > 0 && flag3 && !flag)
                {
                    optioncardbaseview.setDiscountVisibility(true);
                    optioncardbaseview.setDiscount(formatString(context.getString(0x7f080132), String.format(context.getString(0x7f0804d5), new Object[] {
                        Integer.valueOf(i)
                    })));
                } else
                {
                    optioncardbaseview.setDiscountVisibility(false);
                }
                if (flag)
                {
                    optioncardbaseview.setUrgencyPricingLabelVisibility(true);
                    optioncardbaseview.setUrgencyPricingLabel(((Option) (obj)).pricingMetadata.offerLabelDescriptive);
                } else
                {
                    optioncardbaseview.setUrgencyPricingLabelVisibility(false);
                }
                i = ((Option) (obj)).getSoldQuantity();
                view = ((Option) (obj)).getSoldQuantityMessage();
                if (i <= 0 || !flag2)
                {
                    break label0;
                }
                optioncardbaseview.setBoughtVisibility(true);
                obj = Strings.capitalize(context.getResources().getQuantityString(0x7f0c0002, i));
                if (!Strings.notEmpty(view))
                {
                    view = String.valueOf(i);
                }
                optioncardbaseview.setBought(formatString(((String) (obj)), view));
            }
            return viewgroup;
        }
        optioncardbaseview.setBoughtVisibility(false);
        return viewgroup;
    }

    public boolean isEnabled(int i)
    {
        for (Option option = getItem(i); option == null || option.isSoldOutOrExpired();)
        {
            return false;
        }

        return true;
    }
}
