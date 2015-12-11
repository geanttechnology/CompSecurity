// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import com.ebay.mobile.Item;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment, ViewItemFragmentBestOfferUtil

static final class nit> extends nit>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).toString());
        }
        byte byte0 = 103;
        if (ActionsFactory.access$1900(actionsfactory).isSeller)
        {
            byte0 = 104;
        }
        ViewItemFragmentBestOfferUtil.reviewOffer(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), ActionsFactory.access$1900(actionsfactory).isSeller, byte0, null, null);
    }

    rUtil(String s, int i)
    {
        super(s, i, null);
    }
}
