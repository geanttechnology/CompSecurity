// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import butterknife.ButterKnife;
import com.target.ui.view.account.AccountOrderHistoryFooterView;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountOrderHistoryFragment

static class 
{

    View emptyView;
    TargetErrorView errorView;
    LinearLayout listContainer;
    AccountOrderHistoryFooterView orderHistoryFooterView;
    ScrollView scrollView;

    (View view)
    {
        ButterKnife.bind(this, view);
    }
}
