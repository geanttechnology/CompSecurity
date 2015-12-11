// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.checkout:
//            BillingView, AddressFormView, PaymentCardEntryView, PaymentCardStaticView

static class iew extends a
{

    AddressFormView address;
    PaymentCardEntryView card;
    PaymentCardStaticView cardNonEditable;
    View progressBar;

    iew(View view)
    {
        super(view);
    }
}
