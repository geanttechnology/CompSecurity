// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;


// Referenced classes of package com.target.ui.view.checkout:
//            BillingView

private class <init>
    implements w.a
{

    String addressLine;
    String apartment;
    String city;
    String firstName;
    boolean isValid;
    String lastName;
    String phoneNumber;
    String state;
    final BillingView this$0;
    String zipCode;

    public void a()
    {
        isValid = false;
    }

    public void a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        firstName = s;
        lastName = s1;
        addressLine = s2;
        apartment = s3;
        city = s4;
        zipCode = s5;
        state = s6;
        phoneNumber = s7;
        isValid = true;
    }

    private w.a()
    {
        this$0 = BillingView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
