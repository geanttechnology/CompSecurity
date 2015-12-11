// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.meta_data.ColorPickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            ShopFragment, ColorPickerFragment

class this._cls0
    implements android.view.tener
{

    final ShopFragment this$0;

    public void onClick(View view)
    {
        view = new ColorPickerInfo();
        view.allItems = DbApi.getAllColors();
        PMActivity pmactivity = (PMActivity)getActivity();
        Bundle bundle = new Bundle();
        bundle.putInt("COLOR_PICKER_MODE", ment.COLOR_MODE.COLOR_BROWSE.ordinal());
        bundle.putBoolean("RETURN_RESULT", false);
        pmactivity.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/ColorPickerFragment, view, ShopFragment.this, 3);
    }

    ment()
    {
        this$0 = ShopFragment.this;
        super();
    }
}
