// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.view.View;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.utils.meta_data.MySizePickerInfo;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            MySizePickerFragment

class this._cls0
    implements android.view.erFragment._cls6
{

    final MySizePickerFragment this$0;

    public void onClick(View view)
    {
        PMButton pmbutton = (PMButton)view;
        sizeDataChanged = true;
        view = (MetaItem)info.allItems.get(((Integer)view.getTag()).intValue());
        if (info.selectedItems.contains(view))
        {
            info.selectedItems.remove(view);
            pmbutton.setBackgroundColor(0);
            pmbutton.setBackgroundDrawable(getResources().getDrawable(0x7f020014));
            pmbutton.setTextColor(getResources().getColor(0x7f090035));
            return;
        }
        if (info.selectedItems.size() == 4 && mode == DE.MY_SIZE)
        {
            showAlertMessage("", "You can select a maximum of 4 options. Please un select an existing option to select a new one");
            return;
        } else
        {
            pmbutton.setBackgroundDrawable(getResources().getDrawable(0x7f020015));
            pmbutton.setTextColor(getResources().getColor(0x7f090040));
            info.selectedItems.add(view);
            return;
        }
    }

    DE()
    {
        this$0 = MySizePickerFragment.this;
        super();
    }
}
