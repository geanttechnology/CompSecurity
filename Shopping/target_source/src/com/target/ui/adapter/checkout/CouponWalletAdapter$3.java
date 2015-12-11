// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.view.View;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;

// Referenced classes of package com.target.ui.adapter.checkout:
//            CouponWalletAdapter

class .WalletItem
    implements android.view.onWalletAdapter._cls3
{

    final CouponWalletAdapter this$0;
    final WalletItem val$walletItem;

    public void onClick(View view)
    {
        if (CouponWalletAdapter.a(CouponWalletAdapter.this) == null)
        {
            return;
        } else
        {
            CouponWalletAdapter.a(CouponWalletAdapter.this).b(val$walletItem);
            return;
        }
    }

    .WalletItem()
    {
        this$0 = final_couponwalletadapter;
        val$walletItem = WalletItem.this;
        super();
    }
}
