// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Business;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchResultFragment

class this._cls1
    implements android.view.apter._cls1
{

    final actMatchBusiness this$1;

    public void onClick(View view)
    {
        loggingUtils.logClick("", "merchant_impression_click", Channel.MERCHANT_PAGE.toString(), loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(actMatchBusiness.remoteId)));
        startActivity(GlobalSearchResultFragment.access$1000(_fld0).newMerchantPageIntent(actMatchBusiness.remoteId));
    }

    Q()
    {
        this$1 = this._cls1.this;
        super();
    }
}
