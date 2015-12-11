// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.view.View;
import com.ebay.mobile.Item;
import com.ebay.mobile.viewitem.ViewItemChooseVariationsActivity;
import com.ebay.mobile.viewitem.ViewItemShippingPaymentsReturnsActivity;
import com.ebay.mobile.viewitem.ViewItemViewData;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemShippingPaymentsReturnsFragment

class this._cls0
    implements android.view.entsReturnsFragment._cls6
{

    final ViewItemShippingPaymentsReturnsFragment this$0;

    public void onClick(View view)
    {
        if (item.isMultiSku && (item.isPudoable || item.isBopisable || item.isEbayNowAvailable) && !item.hasMultiSkuValues(viewData.nameValueList))
        {
            ViewItemChooseVariationsActivity.startActivity(ViewItemShippingPaymentsReturnsFragment.access$000(ViewItemShippingPaymentsReturnsFragment.this), viewData, com.ebay.mobile.viewitem.ction.SPR);
            return;
        } else
        {
            ViewItemShippingPaymentsReturnsActivity.StartActivity(ViewItemShippingPaymentsReturnsFragment.access$000(ViewItemShippingPaymentsReturnsFragment.this), viewData, 19);
            return;
        }
    }

    ()
    {
        this$0 = ViewItemShippingPaymentsReturnsFragment.this;
        super();
    }
}
