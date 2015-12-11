// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.Channel;
import com.groupon.db.models.Special;
import com.groupon.util.ImageUrl;
import java.util.ArrayList;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage, IntentFactory

class this._cls0
    implements android.view.lPage._cls5
{

    final BusinessSpecialPage this$0;

    public void onClick(View view)
    {
        view = new ArrayList(1);
        view.add(new ImageUrl(BusinessSpecialPage.access$000(BusinessSpecialPage.this).redemptionUnit));
        startActivity(BusinessSpecialPage.access$600(BusinessSpecialPage.this).newDealImageCarouselIntent(view, 0, BusinessSpecialPage.access$000(BusinessSpecialPage.this).remoteId, Channel.MERCHANT_SPECIAL, ""));
    }

    ()
    {
        this$0 = BusinessSpecialPage.this;
        super();
    }
}
