// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            ShopFragment, BrandsMetaItemListViewFragment

class this._cls0
    implements android.view.tener
{

    final ShopFragment this$0;

    public void onClick(View view)
    {
        view = new BrandsMetaItemPickerInfo();
        ((BrandsMetaItemPickerInfo) (view)).allItems.addAll(DbApi.getBrandsForAllCategories());
        Bundle bundle = new Bundle();
        bundle.putBoolean("SHOW_ALL", false);
        bundle.putInt("META_ITEM_MODE", wFragment.META_ITEM_MODES.BRAND_MODE.ordinal());
        bundle.putBoolean("SEARCH_ENABLED", true);
        ((PMActivity)getActivity()).launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/BrandsMetaItemListViewFragment, view, ShopFragment.this, 2);
    }

    istViewFragment()
    {
        this$0 = ShopFragment.this;
        super();
    }
}
