// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            DirectDebitActivity, DirectDebitTabFragmentAdapter, DirectDebitTabFragment

class this._cls0
    implements android.view.tDebitActivity._cls2
{

    final DirectDebitActivity this$0;

    public void onClick(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        ((DirectDebitTabFragment)DirectDebitActivity.access$200(DirectDebitActivity.this).getRegisteredFragment(DirectDebitActivity.access$100(DirectDebitActivity.this).getCurrentItem())).addOrUpdateFundingInstrumentFromFormData();
    }

    ()
    {
        this$0 = DirectDebitActivity.this;
        super();
    }
}
