// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.view.View;
import com.target.ui.fragment.checkout.b.a;
import com.target.ui.model.checkout.DeliveryDetailsModel;

// Referenced classes of package com.target.ui.fragment.checkout:
//            CheckoutHomeFragment

class this._cls0
    implements android.view.koutHomeFragment._cls1
{

    final CheckoutHomeFragment this$0;

    public void onClick(View view)
    {
        view = com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this).contactView;
        com.target.ui.view.checkout.DeliveryView deliveryview = com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this).deliveryView;
        com.target.ui.model.checkout.DeliveryTypedProducts deliverytypedproducts = CheckoutHomeFragment.b(CheckoutHomeFragment.this).a();
        CheckoutHomeFragment.f(CheckoutHomeFragment.this).a(com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this, CheckoutHomeFragment.c(CheckoutHomeFragment.this)), CheckoutHomeFragment.d(CheckoutHomeFragment.this), CheckoutHomeFragment.e(CheckoutHomeFragment.this), deliverytypedproducts, com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this, view, deliveryview), com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this, view, deliverytypedproducts), CheckoutHomeFragment.b(CheckoutHomeFragment.this, view, deliverytypedproducts));
    }

    ews()
    {
        this$0 = CheckoutHomeFragment.this;
        super();
    }
}
