// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;

// Referenced classes of package com.poshmark.ui.fragments:
//            PartyShowroomListFragment, PMFragment

class this._cls0
    implements android.widget.ner
{

    final PartyShowroomListFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (((CustomMatrixCursor)((CursorAdapter)PartyShowroomListFragment.access$000(PartyShowroomListFragment.this).getWrappedAdapter()).getCursor()).moveToPosition(i - 1))
        {
            adapterview = new Bundle();
            adapterview.putInt("SHOWROOM_INDEX", i - 1);
            view = (PMFragment)getTargetFragment();
            if (view != null)
            {
                view.onFragmentResult(adapterview, getTargetRequestCode());
            }
            dismiss();
        }
    }

    or()
    {
        this$0 = PartyShowroomListFragment.this;
        super();
    }
}
