// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import com.poshmark.utils.meta_data.MySizePickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            MySizePickerFragment, MetaItemListViewFragment

class this._cls0
    implements android.view.erFragment._cls1
{

    final MySizePickerFragment this$0;

    public void onClick(View view)
    {
        view = new MetaItemPickerInfo();
        Bundle bundle;
        if (info.categoryFacetList != null)
        {
            view.allItems = info.categoryFacetList;
        } else
        {
            view.allItems = DbApi.getAllCategories();
        }
        view.currentSelection = null;
        bundle = new Bundle();
        bundle.putInt("META_ITEM_MODE", t.META_ITEM_MODES.CATEGORY_MODE.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MetaItemListViewFragment, view, MySizePickerFragment.this, 4);
    }

    t()
    {
        this$0 = MySizePickerFragment.this;
        super();
    }
}
