// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.app.Activity;
import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ListOfListingsViewModel;

// Referenced classes of package com.ebay.mobile.deals:
//            DealsContentAdapter, DealsDetailsActivity

class this._cls0
    implements com.ebay.mobile.common.view.ner
{

    final DealsContentAdapter this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof ListOfListingsViewModel)
        {
            viewmodel = (ListOfListingsViewModel)viewmodel;
            DealsDetailsActivity.startActivity((Activity)view.getContext(), ((ListOfListingsViewModel) (viewmodel)).listingsTitle, ((ListOfListingsViewModel) (viewmodel)).categoryId, true);
        }
    }

    wModel()
    {
        this$0 = DealsContentAdapter.this;
        super();
    }
}
