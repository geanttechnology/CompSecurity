// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;


// Referenced classes of package com.target.ui.view.checkout:
//            DeliveryView

public final class this._cls0
    implements ew.b
{

    public String firstName;
    public boolean isValid;
    public String lastName;
    final DeliveryView this$0;

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

    public ew.b()
    {
        this$0 = DeliveryView.this;
        super();
    }
}
