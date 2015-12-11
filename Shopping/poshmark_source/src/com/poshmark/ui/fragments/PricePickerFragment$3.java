// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.view.View;
import com.poshmark.data_model.models.PriceInfo;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.utils.meta_data.PricePickerInfo;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PricePickerFragment

class this._cls0
    implements android.view.erFragment._cls3
{

    final PricePickerFragment this$0;

    public void onClick(View view)
    {
        dataChanged = true;
        PriceInfo priceinfo = (PriceInfo)info.allItems.get(((Integer)view.getTag()).intValue());
        view = (PMButton)view;
        if (info.selectedItems.contains(priceinfo))
        {
            info.selectedItems.remove(priceinfo);
            view.setBackgroundColor(0);
            view.setBackgroundDrawable(getResources().getDrawable(0x7f020014));
            view.setTextColor(getResources().getColor(0x7f090035));
            return;
        } else
        {
            view.setBackgroundDrawable(getResources().getDrawable(0x7f020015));
            view.setTextColor(getResources().getColor(0x7f090040));
            info.selectedItems.add(priceinfo);
            return;
        }
    }

    ()
    {
        this$0 = PricePickerFragment.this;
        super();
    }
}
