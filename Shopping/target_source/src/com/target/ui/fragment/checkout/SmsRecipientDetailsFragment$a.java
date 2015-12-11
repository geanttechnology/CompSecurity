// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;


// Referenced classes of package com.target.ui.fragment.checkout:
//            SmsRecipientDetailsFragment

public final class this._cls0
    implements com.target.ui.view.checkout.t.a
{

    public String fromName;
    boolean isValid;
    public String phoneNumber;
    final SmsRecipientDetailsFragment this$0;
    public String toName;

    public void a()
    {
        isValid = false;
    }

    public void a(String s, String s1, String s2)
    {
        toName = s;
        phoneNumber = s1;
        fromName = s2;
        isValid = true;
    }

    public ()
    {
        this$0 = SmsRecipientDetailsFragment.this;
        super();
    }
}
