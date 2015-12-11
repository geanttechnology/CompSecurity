// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.ui.view.checkout:
//            BillingView

private class <init>
    implements ryView.a
{

    String cardNumber;
    a cardType;
    String expMonth;
    String expYear;
    boolean isValid;
    String security;
    final BillingView this$0;

    public void a()
    {
        isValid = false;
    }

    public void a(a a1, String s, String s1, String s2, String s3)
    {
        cardType = a1;
        cardNumber = s;
        expMonth = s1;
        expYear = s2;
        security = s3;
        isValid = true;
    }

    private ryView.a()
    {
        this$0 = BillingView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
