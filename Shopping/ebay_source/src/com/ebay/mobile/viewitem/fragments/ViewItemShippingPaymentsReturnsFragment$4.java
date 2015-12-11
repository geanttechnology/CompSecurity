// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.view.View;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemShippingPaymentsReturnsFragment

class this._cls0
    implements android.view.entsReturnsFragment._cls4
{

    final ViewItemShippingPaymentsReturnsFragment this$0;

    public void onClick(View view)
    {
        ShowWebViewActivity.start(getActivity(), DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.ore), "", null);
    }

    ()
    {
        this$0 = ViewItemShippingPaymentsReturnsFragment.this;
        super();
    }
}
