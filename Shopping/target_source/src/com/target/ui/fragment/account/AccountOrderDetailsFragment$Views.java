// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.target.ui.view.account.AccountOrderDetailsDeliveryView;
import com.target.ui.view.account.AccountOrderDetailsPaymentView;
import com.target.ui.view.account.AccountOrderDetailsProductListView;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountOrderDetailsFragment

static class 
{

    TargetErrorView errorView;
    AccountOrderDetailsDeliveryView orderDetailsDeliveryView;
    AccountOrderDetailsPaymentView orderDetailsPaymentView;
    AccountOrderDetailsProductListView orderDetailsProductListView;
    View orderDetailsScrollContent;
    TextView orderPlacedDate;

    (View view)
    {
        ButterKnife.bind(this, view);
    }
}
