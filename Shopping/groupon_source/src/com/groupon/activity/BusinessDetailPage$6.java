// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

class this._cls0
    implements android.view.lPage._cls6
{

    final BusinessDetailPage this$0;

    public void onClick(View view)
    {
        BusinessDetailPage.access$500(BusinessDetailPage.this).logClick("", "mp_offers_see_all", businessId, "");
        startActivity((new Intent(BusinessDetailPage.this, com/groupon/activity/BusinessDetailPage)).putExtra("business_id", businessId).putExtra("is_list_offers", true));
    }

    ()
    {
        this$0 = BusinessDetailPage.this;
        super();
    }
}
