// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.view.View;
import com.ebay.common.model.ItemTransaction;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.UserDetailActivity;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class val.item
    implements android.view.ner
{

    final ActionsFactory val$factory;
    final Item val$item;

    public void onClick(View view)
    {
        UserDetailActivity.StartActivityForBuyer(val$factory.fragment.getActivity(), val$factory.fragment.viewData, val$item.iTransaction.buyerUserId, null, null);
    }

    agment(ActionsFactory actionsfactory, Item item1)
    {
        val$factory = actionsfactory;
        val$item = item1;
        super();
    }
}
