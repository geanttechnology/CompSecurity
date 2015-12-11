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
        int i = 0x7f070503;
        if (item.relistedId != null)
        {
            i = 0x7f0704c8;
        }
        headerText.append(resources.getString(i));
        if (!item.isBinOnly && !item.finalized)
        {
            headerText.clear();
        }
        if (item.relistedId != null)
        {
            buttonsContainer.add(ActionsFactory.access$200(actionsfactory, resources.getString(0x7f07050d), HOW_RELISTED_ITEM, true));
        }
        if (item.isShowSimilar)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070a02), ELLERS_OTHER_ITEMS));
        }
        if (item.isShowSellLike)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704e4), ELL_ONE_LIKE_THIS));
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
