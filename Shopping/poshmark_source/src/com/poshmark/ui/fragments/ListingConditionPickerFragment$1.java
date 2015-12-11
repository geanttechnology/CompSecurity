// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.utils.meta_data.NWTOptionsMetaData;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingConditionPickerFragment

class this._cls0
    implements android.view.erFragment._cls1
{

    final ListingConditionPickerFragment this$0;

    public void onClick(View view)
    {
        ntw_retail_container.setVisibility(0);
        retailSwitch.setChecked(false);
        ntw_no_checkmark.setVisibility(4);
        ntw_yes_checkmark.setVisibility(0);
        nwt_yes_text.setTextColor(getActivity().getResources().getColor(0x7f09003c));
        nwt_yes_text.setTypeface(null, 1);
        nwt_no_text.setTextColor(getActivity().getResources().getColor(0x7f090035));
        nwt_no_text.setTypeface(null, 0);
        retailMessage.setVisibility(0);
        currentCondition = MetaItem.clone(NWTOptionsMetaData.getConditionMetaItemForListingFlow("nwt"));
    }

    ()
    {
        this$0 = ListingConditionPickerFragment.this;
        super();
    }
}
