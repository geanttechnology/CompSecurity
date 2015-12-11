// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.CompoundButton;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.utils.meta_data.NWTOptionsMetaData;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingConditionPickerFragment

class this._cls0
    implements android.widget.tener
{

    final ListingConditionPickerFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            currentCondition = MetaItem.clone(NWTOptionsMetaData.getConditionMetaItemForListingFlow("ret"));
            return;
        } else
        {
            currentCondition = MetaItem.clone(NWTOptionsMetaData.getConditionMetaItemForListingFlow("nwt"));
            return;
        }
    }

    ()
    {
        this$0 = ListingConditionPickerFragment.this;
        super();
    }
}
