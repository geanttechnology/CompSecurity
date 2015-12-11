// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.mobile.Item;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        int k = 0x7f07049e;
        if (!"PaymentPending".equals(item.paidStatus)) goto _L2; else goto _L1
_L1:
        int i = 0x7f070767;
_L5:
        k = i;
        if (ActionsFactory.access$700(item.iTransaction))
        {
            k = Util.getAfterSalesHeaderResId(item.iTransaction, item.isSeller, i, actionsfactory.fragment.overrideStatus);
        }
        headerText.append(resources.getString(k));
        Object obj = resources.getString(0x7f0704a3);
        long l;
        if (item.iTransaction.buyerFeedbackPrivate)
        {
            viewitemdatamanager = item.iTransaction.buyerUserId;
        } else
        {
            viewitemdatamanager = item.iTransaction.buyerUserId;
            int j;
            if (item.iTransaction.buyerFeedbackScore == null)
            {
                j = 0;
            } else
            {
                j = item.iTransaction.buyerFeedbackScore.intValue();
            }
            viewitemdatamanager = resources.getString(0x7f07050c, new Object[] {
                viewitemdatamanager, Integer.valueOf(j)
            });
        }
        viewitemdatamanager = Util.createViewItemStat(layoutinflater, viewgroup, ((String) (obj)), viewitemdatamanager, null, ActionsFactory.access$1000(actionsfactory, item));
        obj = (TextView)viewitemdatamanager.findViewById(0x7f1008cc);
        if (obj != null)
        {
            ((TextView) (obj)).setTextColor(actionsfactory.fragment.tertiaryColor);
        }
        statsContainer.add(viewitemdatamanager);
        statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f07093b), item.iTransaction.createdDate));
        l = ((new Date()).getTime() - item.iTransaction.createdDate.getTime()) / 0x5265c00L;
        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0704b1), Long.toString(l)));
        if (item.isShowPaymentReminder && com.ebay.mobile.e.STATE_SENT.equals(item.paymentReminderState))
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070912), item.paymentReminderSentDate));
        }
        i = item.quantitySold;
        if (item.isTransacted)
        {
            i = item.quantityPurchased;
        }
        if (i > 1)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c4), Integer.toString(i)));
        }
        if (!item.iTransaction.variation.nameValueList.isEmpty())
        {
            viewitemdatamanager = new DelimitedStringBuilder(",");
            for (Iterator iterator = item.iTransaction.variation.nameValueList.iterator(); iterator.hasNext(); viewitemdatamanager.append(((NameValue)iterator.next()).getValue())) { }
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070740), viewitemdatamanager.toString()));
        }
        if (ActionsFactory.access$700(item.iTransaction))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, ActionsFactory.access$800(item, resources.getString(0x7f07088a), resources), TER_SALES));
        }
        if (item.isShowPaymentReminder && com.ebay.mobile.e.STATE_ENABLED.equals(item.paymentReminderState))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070769), ND_REMINDER));
        }
        buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070267), NTACT_USER));
        if (item.isShowLeaveFeedback)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0705d8), AVE_FEEDBACK));
        }
        ess._mth1100(actionsfactory, resources, buttonsContainer, item);
        ess._mth1200(actionsfactory, resources, buttonsContainer, item);
        buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704de), LIST_ITEM));
        if (item.isShowSellSimilar)
        {
            ess._mth600(actionsfactory, resources, buttonsContainer);
        }
        if (ActionsFactory.access$1300(item) && !ActionsFactory.access$700(item.iTransaction))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, ActionsFactory.access$800(item, resources.getString(0x7f070885), resources), NCEL));
        }
          goto _L3
_L2:
        i = k;
        if (item.isShowPaymentReminder)
        {
            i = k;
            if (!ActionsFactory.access$700(item.iTransaction))
            {
                switch (Map.com.ebay.mobile.Item.PaymentReminderState[item.paymentReminderState.ordinal()])
                {
                default:
                    i = k;
                    break;

                case 1: // '\001'
                    subHeaderText = resources.getString(0x7f07076f);
                    i = k;
                    break;

                case 2: // '\002'
                    subHeaderText = null;
                    i = k;
                    break;

                case 3: // '\003'
                    subHeaderText = resources.getString(0x7f07076e);
                    i = k;
                    break;
                }
            }
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L3:
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
