// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.view.View;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;

// Referenced classes of package com.target.ui.adapter.checkout:
//            CouponWalletAdapter

class .WalletItem
    implements android.view.onWalletAdapter._cls2
{

    final CouponWalletAdapter this$0;
    final int val$position;
    final WalletItem val$walletItem;

    public void onClick(View view)
    {
        CouponWalletAdapter.a(CouponWalletAdapter.this, val$position, val$walletItem);
    }

    .WalletItem()
    {
        this$0 = final_couponwalletadapter;
        val$position = i;
        val$walletItem = WalletItem.this;
        super();
    }
}
