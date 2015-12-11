// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.ScrollView;
import com.target.ui.view.account.OrderHistoryExpandView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountOrderHistoryFragment

private final class <init>
    implements com.target.ui.view.common.nt.a
{

    private WeakReference mViewRef;
    final AccountOrderHistoryFragment this$0;

    public void a(boolean flag)
    {
        if (flag)
        {
            View view = (View)mViewRef.get();
            if (AccountOrderHistoryFragment.a(AccountOrderHistoryFragment.this) != null && view != null)
            {
                boolean flag1;
                if (view.getTop() >= AccountOrderHistoryFragment.a(AccountOrderHistoryFragment.this).scrollView.getHeight() / 2)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    AccountOrderHistoryFragment.a(AccountOrderHistoryFragment.this).scrollView.smoothScrollTo(0, view.getTop());
                    return;
                }
            }
        }
    }

    private ews(OrderHistoryExpandView orderhistoryexpandview)
    {
        this$0 = AccountOrderHistoryFragment.this;
        super();
        mViewRef = new WeakReference(orderhistoryexpandview);
    }

    mViewRef(OrderHistoryExpandView orderhistoryexpandview, mViewRef mviewref)
    {
        this(orderhistoryexpandview);
    }
}
