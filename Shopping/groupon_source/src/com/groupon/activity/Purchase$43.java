// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            Purchase, IntentFactory

class this._cls0
    implements android.view.Listener
{

    final Purchase this$0;

    public void onClick(View view)
    {
        logger.logClick("", "incentive_ticket_select_option_click", "incentive_ticket", dealId);
        view = Purchase.this;
        IntentFactory intentfactory = intentFactory;
        String s = selectedIncentiveTicket;
        boolean flag;
        if (giftCode != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.startActivityForResult(intentfactory.newIncentiveTicketsIntent(true, s, flag, dealId), 10126);
    }

    y()
    {
        this$0 = Purchase.this;
        super();
    }
}
