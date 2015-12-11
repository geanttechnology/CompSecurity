// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.PMSearchViewListener;
import com.poshmark.utils.SearchFilterModel;

// Referenced classes of package com.poshmark.ui.fragments:
//            ShopFragment, BrandFragment, SearchResultsFragment

class this._cls0
    implements PMSearchViewListener
{

    final ShopFragment this$0;

    public void clearSearchString()
    {
        searchKeyword = null;
    }

    public void fireKeywordSearch(Bundle bundle, SearchFilterModel searchfiltermodel, boolean flag)
    {
        searchKeyword = searchfiltermodel.getQueryText();
        PMContainerActivity pmcontaineractivity = (PMContainerActivity)getActivity();
        if (flag)
        {
            pmcontaineractivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/BrandFragment, searchfiltermodel);
            return;
        } else
        {
            pmcontaineractivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/SearchResultsFragment, searchfiltermodel);
            return;
        }
    }

    agment()
    {
        this$0 = ShopFragment.this;
        super();
    }
}
