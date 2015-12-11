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
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            AllPartiesFragment, PartyFragment, PartyInviteFragment

class this._cls0
    implements android.widget.ckListener
{

    final AllPartiesFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CustomMatrixCursor)((CursorAdapter)eventListView.getWrappedAdapter()).getCursor();
        if (adapterview.moveToPosition(i))
        {
            adapterview = (PartyEvent)adapterview.get(adapterview.getColumnIndex(PMData.DATA_COL));
            Object obj = adapterview.getId();
            view = new Bundle();
            view.putString("ID", ((String) (obj)));
            obj = (PMActivity)getActivity();
            if (obj != null && ((PMActivity) (obj)).isActivityInForeground())
            {
                if (adapterview.isHappeningNow() || adapterview.isPastEvent())
                {
                    ((PMActivity) (obj)).launchFragment(view, com/poshmark/ui/fragments/PartyFragment, adapterview);
                } else
                if (adapterview.isFutureEvent())
                {
                    ((PMActivity) (obj)).launchFragment(view, com/poshmark/ui/fragments/PartyInviteFragment, adapterview);
                    return;
                }
            }
        }
    }

    rixCursor()
    {
        this$0 = AllPartiesFragment.this;
        super();
    }
}
