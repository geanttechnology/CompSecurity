// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;


// Referenced classes of package com.target.ui.view.mcoupons:
//            CouponsSignUpView

public final class this._cls0
    implements com.target.ui.view.common.b
{

    String firstName;
    boolean isValid;
    String lastName;
    final CouponsSignUpView this$0;

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

    public String b()
    {
        return firstName;
    }

    public String c()
    {
        return lastName;
    }

    public ()
    {
        this$0 = CouponsSignUpView.this;
        super();
    }
}
