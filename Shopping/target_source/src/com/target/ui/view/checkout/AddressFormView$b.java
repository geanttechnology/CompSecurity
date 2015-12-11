// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;


// Referenced classes of package com.target.ui.view.checkout:
//            AddressFormView

private final class <init>
    implements <init>
{

    String addressLine;
    String apartment;
    String city;
    boolean isValid;
    String state;
    final AddressFormView this$0;
    String zipCode;

    public void a()
    {
        isValid = false;
    }

    public void a(String s, String s1, String s2, String s3, String s4)
    {
        addressLine = s;
        apartment = s1;
        city = s2;
        state = s4;
        zipCode = s3;
        isValid = true;
    }

    private ()
    {
        this$0 = AddressFormView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
