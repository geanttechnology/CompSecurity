// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.db.models.Special;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.service.LoginService;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage, IntentFactory

class this._cls0
    implements android.view.lPage._cls2
{

    final BusinessSpecialPage this$0;

    public void onClick(View view)
    {
        if (BusinessSpecialPage.access$300(BusinessSpecialPage.this).isLoggedIn())
        {
            BusinessSpecialPage.access$400(BusinessSpecialPage.this).logClick("", "save_special_click", BusinessSpecialPage.access$000(BusinessSpecialPage.this).remoteId, BusinessSpecialPage.access$400(BusinessSpecialPage.this).encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
            BusinessSpecialPage.access$500(BusinessSpecialPage.this);
            return;
        } else
        {
            startActivity(BusinessSpecialPage.access$600(BusinessSpecialPage.this).newSpecialIntent(specialId, businessId, true));
            finish();
            return;
        }
    }

    IdMetadata()
    {
        this$0 = BusinessSpecialPage.this;
        super();
    }
}
