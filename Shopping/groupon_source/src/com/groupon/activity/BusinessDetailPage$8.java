// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;
import com.groupon.db.models.Special;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage, BusinessSpecialPage

class val.special
    implements android.view.lPage._cls8
{

    final BusinessDetailPage this$0;
    final Special val$special;

    public void onClick(View view)
    {
        BusinessDetailPage.access$500(BusinessDetailPage.this).logClick("", "special_click", val$special.remoteId, BusinessDetailPage.access$500(BusinessDetailPage.this).encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
        startActivity((new Intent(BusinessDetailPage.this, com/groupon/activity/BusinessSpecialPage)).putExtra("special_id", val$special.remoteId).putExtra("isDeepLinked", false).putExtra("business_id", businessId));
    }

    tIdMetadata()
    {
        this$0 = final_businessdetailpage;
        val$special = Special.this;
        super();
    }
}
