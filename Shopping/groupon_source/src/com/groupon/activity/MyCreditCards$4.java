// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.models.payment.AbstractPaymentMethod;

// Referenced classes of package com.groupon.activity:
//            MyCreditCards

class ymentMethod
    implements android.view.ener
{

    final MyCreditCards this$0;
    final AbstractPaymentMethod val$paymentMethod;

    public void onClick(View view)
    {
        MyCreditCards.access$300(MyCreditCards.this, val$paymentMethod);
    }

    ymentMethod()
    {
        this$0 = final_mycreditcards;
        val$paymentMethod = AbstractPaymentMethod.this;
        super();
    }
}
