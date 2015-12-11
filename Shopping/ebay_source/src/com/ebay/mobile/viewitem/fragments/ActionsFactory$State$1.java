// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.mobile.Item;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.FwActivity;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class nit> extends nit>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        boolean flag1 = DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow);
        if (!item.isReserveMet)
        {
            headerText.append(resources.getString(0x7f070cca));
        }
        if (item.isOutbid)
        {
            headerText.clear();
            headerText.append(resources.getString(0x7f070cce));
        }
        if (headerText.length() == 0)
        {
            headerText.append(resources.getString(0x7f070cc9));
        }
        android.app.Activity activity = actionsfactory.fragment.getActivity();
        Object obj;
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency;
        boolean flag;
        if (item.isDisplayPriceCurrencyCode)
        {
            obj = Item.getApproximateString(activity, item.convertedCurrentPrice).toString();
        } else
        {
            obj = null;
        }
        if (!flag1)
        {
            statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f070278), item.displayCurrentPrice, ((String) (obj))));
        } else
        {
            LinearLayout linearlayout = (LinearLayout)layoutinflater.inflate(0x7f030283, null, false);
            ((TextView)linearlayout.findViewById(0x7f1002ef)).setText(item.displayCurrentPrice);
            if (obj != null)
            {
                TextView textview = (TextView)linearlayout.findViewById(0x7f1002f0);
                textview.setText(((CharSequence) (obj)));
                textview.setVisibility(0);
            }
            if (item.bidCount > 0)
            {
                obj = (TextView)linearlayout.findViewById(0x7f100895);
                ((TextView) (obj)).setText(String.format(resources.getQuantityString(0x7f08001b, item.bidCount), new Object[] {
                    Integer.valueOf(item.bidCount)
                }));
                ((TextView) (obj)).setVisibility(0);
            }
            obj = new ArrayList();
            ((List) (obj)).add(linearlayout);
            statsContainer.add(Util.createViewItemStatFullWidth(layoutinflater, viewgroup, ((List) (obj))));
        }
        itemcurrency = item.getMaxBid(viewitemdatamanager, ActionsFactory.access$100(actionsfactory).nameValueList);
        if (itemcurrency != null && (flag1 || !item.isOutbid))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = null;
            viewitemdatamanager = ((ViewItemDataManager) (obj));
            if (item.isDisplayPriceCurrencyCode)
            {
                com.ebay.nautilus.domain.data.ItemCurrency itemcurrency1 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), itemcurrency);
                viewitemdatamanager = ((ViewItemDataManager) (obj));
                if (itemcurrency1 != null)
                {
                    viewitemdatamanager = Item.getApproximateString(activity, itemcurrency1).toString();
                }
            }
            obj = EbayCurrencyUtil.formatDisplay(itemcurrency, item.getCurrencyUtilFlag());
            statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f070cdc), ((String) (obj)), viewitemdatamanager));
        }
        if (item.endDate != null)
        {
            statsContainer.add(Util.createViewItemStatCountDown(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f070b5a), item.endDate, true));
        }
        if (item.isOutbid)
        {
            if (!flag1)
            {
                layoutinflater = null;
                viewgroup = actionsfactory.fragment.priceEditor;
                viewitemdatamanager = layoutinflater;
                if (viewgroup != null)
                {
                    viewitemdatamanager = layoutinflater;
                    if (!viewgroup.isEmpty())
                    {
                        viewitemdatamanager = viewgroup.getText().toString();
                    }
                }
                item = resources.getString(0x7f07018f, new Object[] {
                    EbayCurrencyUtil.formatDisplay(item.minimumToBid.nd, item.getCurrencyUtilFlag())
                });
                buttonsContainer.add(ActionsFactory.access$200(actionsfactory, item, ID_THIS_AMOUNT, true));
                actionsfactory = ActionsFactory.access$300(actionsfactory, resources.getString(0x7f0705dd), resources.getString(0x7f07079b), ET_AUTO_BID);
                if (!TextUtils.isEmpty(viewitemdatamanager))
                {
                    item = (PriceView)actionsfactory.findViewById(0x7f1008a0);
                    if (item != null)
                    {
                        item.setPriceRaw(viewitemdatamanager);
                        item.requestFocus();
                    }
                }
                buttonsContainer.add(actionsfactory);
                return;
            } else
            {
                buttonsContainer.add(ActionsFactory.access$200(actionsfactory, resources.getString(0x7f070480), NCREASE_MAX_BID, true));
                return;
            }
        }
        item = buttonsContainer;
        if (flag1)
        {
            viewitemdatamanager = resources.getString(0x7f070480);
        } else
        {
            viewitemdatamanager = resources.getString(0x7f07047f);
        }
        item.add(ActionsFactory.access$400(actionsfactory, viewitemdatamanager, NCREASE_MAX_BID));
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
