// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.poshmark.data_model.adapters.BundlesAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMBundle;
import com.poshmark.data_model.models.PMData;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.view_holders.BundleViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            MyLikesFragment, ViewBundleFragment

class this._cls0
    implements android.widget.ClickListener
{

    final MyLikesFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CustomMatrixCursor)MyLikesFragment.access$100(MyLikesFragment.this).getCursor();
        adapterview.moveToPosition(i - 1);
        adapterview = (PMBundle)adapterview.get(adapterview.getColumnIndex(PMData.DATA_COL));
        view = (BundleViewHolder)view.getTag();
        view = getParentActivity();
        Bundle bundle = new Bundle();
        bundle.putString("ID", adapterview.getSellerId());
        view.launchFragment(bundle, com/poshmark/ui/fragments/ViewBundleFragment, null);
    }

    ()
    {
        this$0 = MyLikesFragment.this;
        super();
    }
}
