// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ebay.mobile.Item;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        headerText.append(resources.getString(0x7f0704c7));
        if (!item.isBinOnly && !item.finalized)
        {
            headerText.clear();
        }
        viewitemdatamanager = Util.getFormattedDateTimeStringFromDate(actionsfactory.fragment.getActivity(), item.startDate);
        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0705df), viewitemdatamanager));
        if (item.endDate != null)
        {
            viewitemdatamanager = Util.getFormattedDateTimeStringFromDate(actionsfactory.fragment.getActivity(), item.endDate);
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0703b8), viewitemdatamanager));
            long l = (item.endDate.getTime() - item.startDate.getTime()) / 0x5265c00L;
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f07029e), (new com.ebay.nautilus.domain.data.ion(com.ebay.nautilus.domain.data.ionUnitEnum.CALENDAR_DAY, l)).toString(resources)));
        }
        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070702), Integer.toString(item.watchCount)));
        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070701), Integer.toString(item.hitCount)));
        buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704de), LIST_ITEM));
        if (item.isShowSellSimilar)
        {
            ess._mth600(actionsfactory, resources, buttonsContainer);
        }
    }

    itEnum(String s, int i)
    {
        super(s, i, null);
    }
}
