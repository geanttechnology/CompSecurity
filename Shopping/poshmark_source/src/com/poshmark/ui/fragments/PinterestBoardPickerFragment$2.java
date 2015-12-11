// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import android.widget.ImageView;
import com.poshmark.data_model.adapters.PinterestBoardListAdapter;
import com.poshmark.utils.meta_data.PinterestBoard;
import com.poshmark.utils.meta_data.PinterestBoardPickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            PinterestBoardPickerFragment

class val.checkMark
    implements android.view.erFragment._cls2
{

    final PinterestBoardPickerFragment this$0;
    final ImageView val$checkMark;

    public void onClick(View view)
    {
        val$checkMark.setVisibility(0);
        view = new PinterestBoard();
        view.enabled = false;
        view.name = "";
        view.board_id = "0";
        data.currentSelection = view;
        adapter.notifyDataSetChanged();
        PinterestBoardPickerFragment.access$100(PinterestBoardPickerFragment.this);
    }

    r()
    {
        this$0 = final_pinterestboardpickerfragment;
        val$checkMark = ImageView.this;
        super();
    }
}
