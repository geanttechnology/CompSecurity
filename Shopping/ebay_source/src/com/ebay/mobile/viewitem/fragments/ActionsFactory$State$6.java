// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ebay.mobile.Item;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory

static final class nit> extends nit>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        int i = item.numberOfPendingBestOffersForSeller();
        headerText.append(resources.getQuantityString(0x7f080024, i, new Object[] {
            Integer.valueOf(i)
        }));
        buttonsContainer.add(ActionsFactory.access$200(actionsfactory, resources.getString(0x7f070936), IEW_OFFERS, true));
        if (item.isSeller)
        {
            if (item.isShowRevise)
            {
                buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070939), EVISE_LISTING));
            }
            if (item.isShowSellSimilar)
            {
                cess._mth600(actionsfactory, resources, buttonsContainer);
            }
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
