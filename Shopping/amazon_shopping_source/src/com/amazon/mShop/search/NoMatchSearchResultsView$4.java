// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.Intent;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.barcodeSearch.HelpWithBarcodeScansActivity;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.search:
//            NoMatchSearchResultsView

class this._cls0
    implements android.view.ultsView._cls4
{

    final NoMatchSearchResultsView this$0;

    public void onClick(View view)
    {
        if (!Util.isEmpty(NoMatchSearchResultsView.access$100(NoMatchSearchResultsView.this)) && NoMatchSearchResultsView.access$100(NoMatchSearchResultsView.this).equals("scanItSearchResultsType"))
        {
            view = new Intent(NoMatchSearchResultsView.access$000(NoMatchSearchResultsView.this), com/amazon/mShop/barcodeSearch/HelpWithBarcodeScansActivity);
            view.setFlags(0x20000);
            NoMatchSearchResultsView.access$000(NoMatchSearchResultsView.this).startActivity(view);
        }
    }

    Activity()
    {
        this$0 = NoMatchSearchResultsView.this;
        super();
    }
}
