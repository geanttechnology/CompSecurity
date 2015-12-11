// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;
import com.groupon.db.models.Business;
import com.groupon.service.LoginService;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage, IntentFactory

class val.messageLengthFinal
    implements android.view.lPage._cls5
{

    final BusinessDetailPage this$0;
    final Business val$business;
    final int val$messageLengthFinal;

    public void onClick(View view)
    {
        LoggingUtils loggingutils = BusinessDetailPage.access$500(BusinessDetailPage.this);
        String s = val$business.remoteId;
        if (val$messageLengthFinal >= 0)
        {
            view = BusinessDetailPage.access$600(BusinessDetailPage.this, val$messageLengthFinal);
        } else
        {
            view = "0";
        }
        loggingutils.logClick("", "rad_click", s, view);
        if (BusinessDetailPage.access$700(BusinessDetailPage.this).isLoggedIn())
        {
            BusinessDetailPage.access$800(BusinessDetailPage.this, val$messageLengthFinal);
            return;
        } else
        {
            startActivity(BusinessDetailPage.access$400(BusinessDetailPage.this).newLoginIntent(getApplicationContext(), BusinessDetailPage.access$400(BusinessDetailPage.this).newMerchantPageIntent(businessId).putExtra("is_request_deal_clicked", true)));
            finish();
            return;
        }
    }

    ()
    {
        this$0 = final_businessdetailpage;
        val$business = business1;
        val$messageLengthFinal = I.this;
        super();
    }
}
