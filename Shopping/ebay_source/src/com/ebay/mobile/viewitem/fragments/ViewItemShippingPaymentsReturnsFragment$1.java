// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.view.View;
import com.ebay.mobile.activities.SignInModalActivity;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemShippingPaymentsReturnsFragment

class this._cls0
    implements android.view.entsReturnsFragment._cls1
{

    final ViewItemShippingPaymentsReturnsFragment this$0;

    public void onClick(View view)
    {
        view = SignInModalActivity.getIntentForSignIn("ViewItem", ViewItemShippingPaymentsReturnsFragment.access$000(ViewItemShippingPaymentsReturnsFragment.this));
        ViewItemShippingPaymentsReturnsFragment.access$000(ViewItemShippingPaymentsReturnsFragment.this).startActivityForResult(view, 11);
    }

    ()
    {
        this$0 = ViewItemShippingPaymentsReturnsFragment.this;
        super();
    }
}
