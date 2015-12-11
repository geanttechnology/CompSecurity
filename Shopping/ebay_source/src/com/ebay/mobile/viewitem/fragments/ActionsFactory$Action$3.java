// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment, ViewItemFragmentBiddingUtil

static final class nit> extends nit>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).append(" with value: ").append(obj).toString());
        }
        obj = (Double)obj;
        if (Item.isValidBid(ActionsFactory.access$1900(actionsfactory), ((Double) (obj)).doubleValue()))
        {
            obj = new ItemCurrency(ActionsFactory.access$1900(actionsfactory).minimumToBid.d.getCurrencyCode(), Double.toString(((Double) (obj)).doubleValue()));
            ViewItemFragmentBiddingUtil.placeBid(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), ((ItemCurrency) (obj)), 106, null, null);
            return;
        } else
        {
            ViewItemFragmentBiddingUtil.placeBidAmount(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), ((Double) (obj)), 105, null, null);
            return;
        }
    }

    til(String s, int i)
    {
        super(s, i, null);
    }
}
