// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.poshmark.data_model.adapters.ColorListAdapter;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.utils.meta_data.ColorPickerInfo;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            ColorPickerFragment

class this._cls0
    implements android.widget.kListener
{

    final ColorPickerFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (listView.getHeaderViewsCount() > 0 && i == 0)
        {
            if (!isAllSelected)
            {
                isAllSelected = true;
                ColorPickerFragment.access$000(ColorPickerFragment.this, true, headerView);
                info.clearSelectionList();
                adapter.notifyDataSetChanged();
                dataChanged = true;
            }
            if (mode != LOR_MODE.COLOR_LISTING_FLOW)
            {
                returnData();
            }
        }
        if (i - listView.getHeaderViewsCount() < 0) goto _L2; else goto _L1
_L1:
        boolean flag;
        i = info.selectedColors.size();
        adapterview = (PMColor)view.getTag();
        view = (ImageView)view.findViewById(0x7f0c00d3);
        flag = info.isColorInSelectColorList(adapterview);
        if (mode != LOR_MODE.COLOR_LISTING_FLOW) goto _L4; else goto _L3
_L3:
        if (i >= MAX_COUNT) goto _L6; else goto _L5
_L5:
        dataChanged = true;
        if (!flag) goto _L8; else goto _L7
_L7:
        view.setImageDrawable(null);
        info.removeColorFromSelectedColorList(adapterview);
_L2:
        return;
_L8:
        view.setImageDrawable(getActivity().getResources().getDrawable(0x7f02007e));
        info.selectedColors.add(adapterview);
        return;
_L6:
        if (flag)
        {
            dataChanged = true;
            view.setImageDrawable(null);
            info.removeColorFromSelectedColorList(adapterview);
            return;
        } else
        {
            showAutoHideSuccessMessage(String.format("You can only select up to %s colors", new Object[] {
                Integer.valueOf(MAX_COUNT)
            }));
            return;
        }
_L4:
        if (mode == LOR_MODE.COLOR_FILTER)
        {
            dataChanged = true;
            isAllSelected = false;
            ColorPickerFragment.access$000(ColorPickerFragment.this, false, headerView);
            info.clearSelectionList();
            info.selectedColors.add(adapterview);
            adapter.notifyDataSetChanged();
            returnData();
            return;
        }
        if (mode == LOR_MODE.COLOR_BROWSE)
        {
            dataChanged = true;
            ColorPickerFragment.access$100(ColorPickerFragment.this, adapterview);
            return;
        }
        if (true) goto _L2; else goto _L9
_L9:
    }

    LOR_MODE()
    {
        this$0 = ColorPickerFragment.this;
        super();
    }
}
