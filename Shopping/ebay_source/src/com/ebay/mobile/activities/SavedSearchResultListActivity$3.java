// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.View;
import android.widget.AdapterView;
import com.ebay.common.model.search.SavedSearch;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

class this._cls0
    implements android.widget.er
{

    final SavedSearchResultListActivity this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this) == null || SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this).savedSearch == null) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this).savedSearch.newItemsOnly = false;
_L6:
        SavedSearchResultListActivity.access$600(SavedSearchResultListActivity.this, new archResults(SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this).savedSearch));
_L2:
        return;
_L4:
        if (i == 1)
        {
            SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this).savedSearch.newItemsOnly = true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    archResults()
    {
        this$0 = SavedSearchResultListActivity.this;
        super();
    }
}
