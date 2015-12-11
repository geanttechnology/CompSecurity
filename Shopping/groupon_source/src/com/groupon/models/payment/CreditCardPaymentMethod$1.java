// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.view.View;
import com.groupon.activity.IntentFactory;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.models.payment:
//            CreditCardPaymentMethod

class this._cls0
    implements android.view.ymentMethod._cls1
{

    final CreditCardPaymentMethod this$0;

    public void onClick(View view)
    {
        view = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
        activity.startActivity(view.newEditCreditCardIntent(billingRecord));
    }

    ()
    {
        this$0 = CreditCardPaymentMethod.this;
        super();
    }
}
