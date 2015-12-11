// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.target.mothership.common.coupon_wallets.CouponPromotionId;

// Referenced classes of package com.target.ui.view.product:
//            PdpCartwheelAndPromotionView

private class mCouponPromotionId
    implements android.view.omotionView.a
{

    private CouponPromotionId mCouponPromotionId;
    final PdpCartwheelAndPromotionView this$0;

    public void onClick(View view)
    {
        if (PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this) == null)
        {
            return;
        } else
        {
            PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this).a(mCouponPromotionId);
            return;
        }
    }

    public nId(CouponPromotionId couponpromotionid)
    {
        this$0 = PdpCartwheelAndPromotionView.this;
        super();
        mCouponPromotionId = couponpromotionid;
    }
}
