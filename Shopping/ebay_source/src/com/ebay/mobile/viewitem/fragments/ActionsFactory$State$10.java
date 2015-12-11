// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        int i;
        int j;
        if (item.isSeller)
        {
            i = 0x7f0709f8;
        } else
        {
            i = 0x7f0709f7;
        }
        if (item.isTotalAmountRefunded)
        {
            if (item.isSeller)
            {
                i = 0x7f0709f6;
            } else
            {
                i = 0x7f0709f5;
            }
        }
        j = i;
        if (ActionsFactory.access$700(item.iTransaction))
        {
            j = Util.getAfterSalesHeaderResId(item.iTransaction, item.isSeller, i, actionsfactory.fragment.overrideStatus);
        }
        headerText.append(resources.getString(j));
        if (item.isShowBuyAnother && item.quantity > 1 && item.getQuantityAvailable(null) > 0 && (actionsfactory.fragment.getActivity() instanceof ItemViewActivity))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0701b6), Y_ANOTHER));
        }
        if (ActionsFactory.access$700(item.iTransaction))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, ActionsFactory.access$800(item, resources.getString(0x7f07088a), resources), TER_SALES));
        }
        if (item.isShowLeaveFeedback)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0705d8), AVE_FEEDBACK));
        }
        if (item.isShowSellSimilar)
        {
            ess._mth600(actionsfactory, resources, buttonsContainer);
        }
        if (MyApp.getDeviceConfiguration().isAfterSalesEnabled() && !item.isSeller)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f07088a), RE_OPTIONS));
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
