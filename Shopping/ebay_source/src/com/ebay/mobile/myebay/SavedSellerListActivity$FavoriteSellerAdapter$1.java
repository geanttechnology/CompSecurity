// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.View;
import android.widget.ListView;
import com.ebay.mobile.activities.UserDetailActivity;

// Referenced classes of package com.ebay.mobile.myebay:
//            SavedSellerListActivity

class val.ratingStar
    implements android.view.Adapter._cls1
{

    final val.ratingStar this$1;
    final String val$ratingStar;
    final String val$strSellerId;

    public void onClick(View view)
    {
        if (!SavedSellerListActivity.access$200(_fld0))
        {
            SavedSellerListActivity.access$302(_fld0, getListView().getFirstVisiblePosition());
            UserDetailActivity.StartActivity(_fld0, val$strSellerId, null, val$ratingStar, true);
        }
    }

    ()
    {
        this$1 = final_;
        val$strSellerId = s;
        val$ratingStar = String.this;
        super();
    }
}
