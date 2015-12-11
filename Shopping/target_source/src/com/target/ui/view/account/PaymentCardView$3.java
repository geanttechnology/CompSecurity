// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.widget.CompoundButton;

// Referenced classes of package com.target.ui.view.account:
//            PaymentCardView

class this._cls0
    implements android.widget.heckedChangeListener
{

    final PaymentCardView this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag && PaymentCardView.a(PaymentCardView.this) != null)
        {
            PaymentCardView.a(PaymentCardView.this).b(PaymentCardView.this);
        }
    }

    Listener()
    {
        this$0 = PaymentCardView.this;
        super();
    }
}
