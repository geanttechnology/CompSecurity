// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.SellingUtilityViewModel;
import com.ebay.mobile.sell.lists.SellingListActivity;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.Listener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof SellingUtilityViewModel)
        {
            view = (SellingUtilityViewModel)viewmodel;
            viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
            if (((SellingUtilityViewModel) (view)).sellListType == com.ebay.mobile.sell.lists.ty.ListType.SOLD)
            {
                if (!TextUtils.isEmpty(((SellingUtilityViewModel) (view)).soldItemType))
                {
                    viewmodel.putExtra("filter", ((SellingUtilityViewModel) (view)).soldItemType);
                }
                viewmodel.putExtra("listType", ((SellingUtilityViewModel) (view)).sellListType);
                view = "sold";
            } else
            {
                if (!TextUtils.isEmpty(((SellingUtilityViewModel) (view)).activeItemType))
                {
                    viewmodel.putExtra("filter", ((SellingUtilityViewModel) (view)).activeItemType);
                }
                viewmodel.putExtra("listType", ((SellingUtilityViewModel) (view)).sellListType);
                if (((SellingUtilityViewModel) (view)).sellListType == com.ebay.mobile.sell.lists.ty.ListType.UNSOLD)
                {
                    view = "unsold";
                } else
                {
                    view = "active";
                }
            }
            viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", view, "sell"));
            startActivity(viewmodel);
        }
    }

    Identification()
    {
        this$0 = StartFragment.this;
        super();
    }
}
