// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Loader;
import com.groupon.db.models.CouponDetail;
import com.groupon.loader.CouponLoaderCallbacks;

// Referenced classes of package com.groupon.activity:
//            CouponDetails

class cks extends CouponLoaderCallbacks
{

    final CouponDetails this$0;

    public void onLoadFinished(Loader loader, CouponDetail coupondetail)
    {
        if (coupondetail != null && coupondetail.couponMerchant != null)
        {
            CouponDetails.access$000(CouponDetails.this, coupondetail);
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (CouponDetail)obj);
    }

    cks(Context context, String s, String s1)
    {
        this$0 = CouponDetails.this;
        super(context, s, s1);
    }
}
