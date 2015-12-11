// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.view.View;
import android.widget.ListView;
import com.target.ui.view.TargetButton;

// Referenced classes of package com.target.ui.fragment.checkout:
//            CouponWalletItemListFragment

private static class applyButton
{

    private TargetButton applyButton;
    private ListView couponWalletList;

    static ListView a(applyButton applybutton)
    {
        return applybutton.couponWalletList;
    }

    static TargetButton b(couponWalletList couponwalletlist)
    {
        return couponwalletlist.applyButton;
    }

    public (View view)
    {
        couponWalletList = (ListView)view.findViewById(0x7f100163);
        applyButton = (TargetButton)view.findViewById(0x7f100164);
    }
}
