// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import com.ebay.mobile.Item;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment, ViewItemFragmentBiddingUtil

static final class nit> extends nit>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).toString());
        }
        obj = new TrackingData("VIewItemIncreaseBidTap", TrackingType.EVENT);
        if (actionsfactory.fragment.item != null)
        {
            ((TrackingData) (obj)).addKeyValuePair("itm", actionsfactory.fragment.item.getIdString());
        }
        ((TrackingData) (obj)).send(actionsfactory.fragment.getActivity());
        ViewItemFragmentBiddingUtil.placeBidAmount(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), null, 105, null, null);
    }

    til(String s, int i)
    {
        super(s, i, null);
    }
}
