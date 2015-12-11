// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import android.widget.AdapterView;
import com.poshmark.data_model.adapters.PinterestBoardListAdapter;
import com.poshmark.utils.meta_data.PinterestBoard;
import com.poshmark.utils.meta_data.PinterestBoardPickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            PinterestBoardPickerFragment

class this._cls0
    implements android.widget.
{

    final PinterestBoardPickerFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (PinterestBoard)view.getTag();
        adapterview.enabled = true;
        data.currentSelection = adapterview;
        adapter.notifyDataSetChanged();
        PinterestBoardPickerFragment.access$100(PinterestBoardPickerFragment.this);
    }

    r()
    {
        this$0 = PinterestBoardPickerFragment.this;
        super();
    }
}
