// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.db.models.CouponDetail;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            CouponDetails

class val.responseDetail
    implements android.view.ener
{

    final CouponDetails this$0;
    final CouponDetail val$responseDetail;

    public void onClick(View view)
    {
        if (Strings.notEmpty(val$responseDetail.productImageUrl))
        {
            CouponDetails.access$100(CouponDetails.this);
        }
    }

    ()
    {
        this$0 = final_coupondetails;
        val$responseDetail = CouponDetail.this;
        super();
    }
}
