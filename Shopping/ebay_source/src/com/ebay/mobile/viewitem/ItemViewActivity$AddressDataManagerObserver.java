// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.viewitem.fragments.ViewItemShippingPaymentsReturnsFragment;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity, ViewItemDataManager, ViewItemViewData

private class <init> extends com.ebay.nautilus.domain.content.dm.
{

    final ItemViewActivity this$0;

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        if (!isFinishing())
        {
            if (content.getStatus().hasError())
            {
                ItemViewActivity.access$402(ItemViewActivity.this, null);
            } else
            {
                ItemViewActivity.access$402(ItemViewActivity.this, (List)content.getData());
            }
            viewData.primaryAddress = ViewItemDataManager.getPrimaryAddress(MyApp.getPrefs().getAuthentication(), ItemViewActivity.access$400(ItemViewActivity.this));
            viewData.shippingCostsPostalCode = ItemViewActivity.getShippingCostsPostalCode(viewData);
            ItemViewActivity.access$500(ItemViewActivity.this, true, true);
            if (ItemViewActivity.access$600(ItemViewActivity.this) != null)
            {
                ItemViewActivity.access$600(ItemViewActivity.this).setForceReRender();
            }
            viewItemDataManager.loadData(ItemViewActivity.this, viewData);
            if (flag)
            {
                BaseCheckoutActivity.handleDefaultAddressChange(ItemViewActivity.this, (UserContextDataManager)DataManager.get(getEbayContext(), UserContextDataManager.KEY), ItemViewActivity.access$400(ItemViewActivity.this), true, "ViewItem");
                return;
            }
        }
    }

    private gment()
    {
        this$0 = ItemViewActivity.this;
        super();
    }

    ( )
    {
        this();
    }
}
