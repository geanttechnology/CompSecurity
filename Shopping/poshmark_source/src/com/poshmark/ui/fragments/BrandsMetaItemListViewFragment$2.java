// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandsMetaItemListViewFragment, PMFilterableFragment

class this._cls0
    implements android.view.ewFragment._cls2
{

    final BrandsMetaItemListViewFragment this$0;

    public void onClick(View view)
    {
        metaItem = null;
        brandsMetaItemInfo.currentSelection = null;
        if (parentFragment != null)
        {
            parentFragment.getFilterManager().getSearchModel().clearBrand();
        }
        hideKeyboard();
        returnData();
    }

    ()
    {
        this$0 = BrandsMetaItemListViewFragment.this;
        super();
    }
}
