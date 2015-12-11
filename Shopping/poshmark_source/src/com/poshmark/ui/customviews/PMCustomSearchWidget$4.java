// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;
import android.widget.AdapterView;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.SuggestedSearchItem;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMCustomSearchWidget, PMAutoCompleteSearchView

class this._cls0
    implements android.widget.Listener
{

    final PMCustomSearchWidget this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CustomMatrixCursor)searchView.getCursor();
        if (adapterview.moveToPosition(i))
        {
            adapterview = (SuggestedSearchItem)adapterview.get(adapterview.getColumnIndex(PMData.DATA_COL));
            searchView.setText(null);
            launchSearch(adapterview, false);
        }
    }

    ursor()
    {
        this$0 = PMCustomSearchWidget.this;
        super();
    }
}
