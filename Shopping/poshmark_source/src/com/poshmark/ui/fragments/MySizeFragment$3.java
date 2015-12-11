// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.meta_data.MySizePickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            MySizeFragment, MySizePickerFragment

class this._cls0
    implements android.view.ner
{

    final MySizeFragment this$0;

    public void onClick(View view)
    {
        view = (String)view.getTag();
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", ent.MODE.MY_SIZE.ordinal());
        bundle.putString("CATEGORY", view);
        MySizePickerInfo mysizepickerinfo = new MySizePickerInfo();
        mysizepickerinfo.allItems = DbApi.getSizesForCategory(view);
        mysizepickerinfo.selectedItems = MySizeFragment.access$200(MySizeFragment.this, view);
        mysizepickerinfo.currentCategory = new MetaItem(view, view);
        ((PMContainerActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MySizePickerFragment, mysizepickerinfo, MySizeFragment.this, 3);
    }

    ent()
    {
        this$0 = MySizeFragment.this;
        super();
    }
}
