// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            PayUponInvoiceActivity

class this._cls0
    implements android.view.nvoiceActivity._cls3
{

    final PayUponInvoiceActivity this$0;

    public void onClick(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        PayUponInvoiceActivity.access$100(PayUponInvoiceActivity.this);
    }

    ()
    {
        this$0 = PayUponInvoiceActivity.this;
        super();
    }
}
