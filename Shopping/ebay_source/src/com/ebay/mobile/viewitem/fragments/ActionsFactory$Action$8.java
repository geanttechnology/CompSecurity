// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import com.ebay.mobile.bestoffer.SellerReviewOffersActivity;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class nit> extends nit>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).toString());
        }
        SellerReviewOffersActivity.StartActivity(actionsfactory.fragment.getActivity(), ActionsFactory.access$100(actionsfactory), 112);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
