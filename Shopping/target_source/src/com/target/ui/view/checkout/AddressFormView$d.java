// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;


// Referenced classes of package com.target.ui.view.checkout:
//            AddressFormView

private final class <init>
    implements com.target.ui.view.common.d
{

    String firstName;
    boolean isValid;
    String lastName;
    final AddressFormView this$0;

    public void a()
    {
        isValid = false;
    }

    public void a(String s, String s1)
    {
        firstName = s;
        lastName = s1;
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
