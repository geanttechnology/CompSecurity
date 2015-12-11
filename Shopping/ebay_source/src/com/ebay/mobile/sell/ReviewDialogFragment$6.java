// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.text.style.ClickableSpan;
import android.view.View;
import com.ebay.mobile.activities.ShowWebViewActivity;

// Referenced classes of package com.ebay.mobile.sell:
//            ReviewDialogFragment

class val.url extends ClickableSpan
{

    final ReviewDialogFragment this$0;
    final String val$url;

    public void onClick(View view)
    {
        ShowWebViewActivity.start(getActivity(), val$url, getString(0x7f070547), "SellerFeesInfo");
    }

    ty()
    {
        this$0 = final_reviewdialogfragment;
        val$url = String.this;
        super();
    }
}
