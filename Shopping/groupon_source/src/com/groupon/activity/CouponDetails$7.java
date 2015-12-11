// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;

// Referenced classes of package com.groupon.activity:
//            CouponDetails, IntentFactory

class this._cls0
    implements android.view.ener
{

    final CouponDetails this$0;

    public void onClick(View view)
    {
        startActivity(CouponDetails.access$500(CouponDetails.this).newCouponMerchantFilterPageIntent(CouponDetails.access$400(CouponDetails.this), inePage.PageType.ONLINE));
    }

    inePage.PageType()
    {
        this$0 = CouponDetails.this;
        super();
    }
}
