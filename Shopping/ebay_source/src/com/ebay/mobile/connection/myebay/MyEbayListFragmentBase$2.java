// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.eBay;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayListFragmentBase

class this._cls0
    implements android.view.ayListFragmentBase._cls2
{

    final MyEbayListFragmentBase this$0;

    public void onClick(View view)
    {
        view = getActivity();
        Intent intent = new Intent(view, com/ebay/mobile/activities/eBay);
        intent.putExtra("HomeStartChannelTab", ChannelEnum.SHOP);
        startActivity(intent);
        view.finish();
    }

    ()
    {
        this$0 = MyEbayListFragmentBase.this;
        super();
    }
}
