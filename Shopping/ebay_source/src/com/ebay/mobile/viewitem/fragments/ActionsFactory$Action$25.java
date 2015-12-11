// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.Item;
import com.ebay.mobile.viewitem.ViewItemViewData;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.verboseLogger)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).toString());
        }
        ActivityStarter.startSellerItemsSearchResultList(actionsfactory.fragment.getBaseActivity(), ActionsFactory.access$1900(actionsfactory).sellerUserId, ActionsFactory.access$100(actionsfactory).searchOtherCountries, null);
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
