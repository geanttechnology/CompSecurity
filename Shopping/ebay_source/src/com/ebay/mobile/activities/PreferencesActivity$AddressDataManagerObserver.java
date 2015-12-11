// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

private class <init> extends com.ebay.nautilus.domain.content.dm.
{

    final PreferencesActivity this$0;

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        if (!isFinishing())
        {
            if (content.getStatus().hasError())
            {
                shippingAddresses = null;
            } else
            {
                shippingAddresses = (List)content.getData();
            }
            updateShippingAddressLayout();
            if (flag)
            {
                BaseCheckoutActivity.handleDefaultAddressChange(PreferencesActivity.this, userContextDataManager, shippingAddresses, false, "Sign In");
                return;
            }
        }
    }

    private ()
    {
        this$0 = PreferencesActivity.this;
        super();
    }

    t>(t> t>)
    {
        this();
    }
}
