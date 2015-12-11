// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import com.target.ui.util.q;

// Referenced classes of package com.target.ui.view.product:
//            PlpAvailableCouponOfferView

class this._cls0
    implements com.target.ui.view.mcoupons.his._cls0
{

    final PlpAvailableCouponOfferView this$0;

    public void a()
    {
        if (PlpAvailableCouponOfferView.a(PlpAvailableCouponOfferView.this) == null)
        {
            return;
        }
        if (PlpAvailableCouponOfferView.b(PlpAvailableCouponOfferView.this) == null)
        {
            q.a(PlpAvailableCouponOfferView.TAG, "Add to my coupons clicked for null offer");
            return;
        } else
        {
            PlpAvailableCouponOfferView.a(PlpAvailableCouponOfferView.this).a(PlpAvailableCouponOfferView.b(PlpAvailableCouponOfferView.this));
            return;
        }
    }

    ()
    {
        this$0 = PlpAvailableCouponOfferView.this;
        super();
    }
}
