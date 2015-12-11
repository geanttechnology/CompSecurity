// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.view.View;
import android.view.Window;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            CreditCardActivity

class this._cls0
    implements android.view.tener
{

    final CreditCardActivity this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            CreditCardActivity.access$100(CreditCardActivity.this, view);
            getWindow().setSoftInputMode(5);
        }
    }

    ()
    {
        this$0 = CreditCardActivity.this;
        super();
    }
}
