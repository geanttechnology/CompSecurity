// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import com.ebay.mobile.Item;
import com.ebay.mobile.sell.shippinglabel.ShippingLabelActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewBaseActivity;
import java.util.ArrayList;

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
        obj = actionsfactory.fragment.getActivity();
        if (!Util.hasNetwork() && obj != null && (obj instanceof ItemViewBaseActivity))
        {
            actionsfactory = (ItemViewBaseActivity)obj;
            actionsfactory.showButterBarMessage(0, actionsfactory.getNetworkErrorToastString(), false);
            return;
        }
        obj = actionsfactory.fragment;
        long l = ActionsFactory.access$1900(actionsfactory).id;
        long l1 = ActionsFactory.access$1900(actionsfactory).transactionId.longValue();
        if (ActionsFactory.access$1900(actionsfactory).pictureUrls != null && !ActionsFactory.access$1900(actionsfactory).pictureUrls.isEmpty())
        {
            actionsfactory = (String)ActionsFactory.access$1900(actionsfactory).pictureUrls.get(0);
        } else
        {
            actionsfactory = null;
        }
        ShippingLabelActivity.startActivity(((android.app.Fragment) (obj)), l, l1, actionsfactory);
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
