// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping;


// Referenced classes of package com.target.ui.fragment.shipping:
//            ShippingAddressDetailsFragment

public final class this._cls0
    implements com.target.ui.view.checkout.t.a
{

    public String addressLine;
    public String apartment;
    public String city;
    public String firstName;
    boolean isValid;
    public String lastName;
    public String phoneNumber;
    public String state;
    final ShippingAddressDetailsFragment this$0;
    public String zipCode;

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
        state = s6;
        zipCode = s5;
        phoneNumber = s7;
        isValid = true;
    }

    public ()
    {
        this$0 = ShippingAddressDetailsFragment.this;
        super();
    }
}
