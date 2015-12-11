// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.View;
import com.ebay.common.model.cart.Incentive;
import com.ebay.mobile.activities.ShowWebViewActivity;

// Referenced classes of package com.ebay.mobile.myebay:
//            ReminderItemsActivity

class val.incentive
    implements android.view.Adapter._cls1
{

    final this._cls1 this$1;
    final Incentive val$incentive;

    public void onClick(View view)
    {
        ShowWebViewActivity.start(_fld0, val$incentive.campaign.incentive, cess._mth1500(this._cls1.this), "IncentiveFaqInfo");
    }

    ()
    {
        this$1 = final_;
        val$incentive = Incentive.this;
        super();
    }
}
