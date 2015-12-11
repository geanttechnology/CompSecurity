// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.support.v4.view.ViewPager;
import android.widget.TabHost;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            DirectDebitActivity

class Listener extends android.support.v4.view.ChangeListener
{

    final DirectDebitActivity this$0;

    public void onPageSelected(int i)
    {
        DirectDebitActivity.access$000(DirectDebitActivity.this).setCurrentTab(i);
        DirectDebitActivity.access$100(DirectDebitActivity.this).setCurrentItem(i, true);
    }

    Listener()
    {
        this$0 = DirectDebitActivity.this;
        super();
    }
}
