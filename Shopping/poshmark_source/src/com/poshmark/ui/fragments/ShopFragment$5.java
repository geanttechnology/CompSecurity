// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            ShopFragment, CategoryListFragment

class this._cls0
    implements android.view.tener
{

    final ShopFragment this$0;

    public void onClick(View view)
    {
        new MetaItemPickerInfo();
        view = new Bundle();
        view.putInt("META_ITEM_MODE", wFragment.META_ITEM_MODES.CATEGORY_MODE.ordinal());
        view.putBoolean("ENABLE_BROWSE_MODE", true);
        view.putBoolean("RETURN_RESULT", false);
        ((PMActivity)getActivity()).launchFragmentInNewActivityForResult(view, com/poshmark/ui/fragments/CategoryListFragment, null, ShopFragment.this, 1);
    }

    gment()
    {
        this$0 = ShopFragment.this;
        super();
    }
}
