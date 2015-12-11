// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            PpaUpgradeActivity

private class <init> extends com.ebay.nautilus.domain.content.dm.
{

    final PpaUpgradeActivity this$0;

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        if (!isFinishing())
        {
            if (!content.getStatus().hasError() && flag)
            {
                BaseCheckoutActivity.handleDefaultAddressChange(PpaUpgradeActivity.this, PpaUpgradeActivity.access$100(PpaUpgradeActivity.this), (List)content.getData(), true, "PPA Upgrade");
            }
            if (PpaUpgradeActivity.access$200(PpaUpgradeActivity.this))
            {
                finish();
                return;
            }
        }
    }

    private ()
    {
        this$0 = PpaUpgradeActivity.this;
        super();
    }

    init>(init> init>)
    {
        this();
    }
}
