// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.app.Activity;
import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ListingViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;

// Referenced classes of package com.ebay.mobile.deals:
//            DealsContentAdapter

class this._cls0
    implements com.ebay.mobile.common.view.ner
{

    final DealsContentAdapter this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof ListingViewModel)
        {
            viewmodel = (ListingViewModel)viewmodel;
            ItemViewActivity.StartActivity((Activity)view.getContext(), Long.parseLong(((ListingViewModel) (viewmodel)).listingId), com.ebay.common.nd.Deals);
        }
    }

    kListener()
    {
        this$0 = DealsContentAdapter.this;
        super();
    }
}
