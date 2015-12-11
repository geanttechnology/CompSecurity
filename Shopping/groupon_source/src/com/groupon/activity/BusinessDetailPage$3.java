// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.db.models.Business;
import com.groupon.models.nst.MerchantPageTipsMetadata;
import com.groupon.util.LoggingUtils;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage, IntentFactory

class val.tips
    implements android.view.lPage._cls3
{

    final BusinessDetailPage this$0;
    final Business val$business;
    final List val$tips;

    public void onClick(View view)
    {
        view = BusinessDetailPage.access$400(BusinessDetailPage.this).newBusinessTipsIntent(businessId);
        BusinessDetailPage.access$500(BusinessDetailPage.this).logClick("", "mp_tips_see_all", val$business.remoteId, BusinessDetailPage.access$500(BusinessDetailPage.this).encodeAsJson(new MerchantPageTipsMetadata(Integer.toString(val$tips.size()), Integer.toString(val$business.tipCount))));
        startActivity(view);
    }

    adata()
    {
        this$0 = final_businessdetailpage;
        val$business = business1;
        val$tips = List.this;
        super();
    }
}
