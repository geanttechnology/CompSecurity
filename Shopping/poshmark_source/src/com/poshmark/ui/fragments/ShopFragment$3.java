// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ShopFragment, ShowroomFragment

class this._cls0
    implements android.widget.temClickListener
{

    final ShopFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CustomMatrixCursor)((CursorAdapter)showroomListView.getWrappedAdapter()).getCursor();
        if (adapterview != null && adapterview.moveToPosition(i - 1))
        {
            adapterview = (Showroom)adapterview.get(adapterview.getColumnIndex(PMData.DATA_COL));
            view = adapterview.getId();
            Bundle bundle = new Bundle();
            bundle.putString("ID", view);
            ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ShowroomFragment, adapterview);
        }
    }

    t()
    {
        this$0 = ShopFragment.this;
        super();
    }
}
