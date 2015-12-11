// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.view.View;
import android.widget.AbsListView;
import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.mobile.settings:
//            PreferredCountryFragment

class this._cls0
    implements android.widget.r
{

    final PreferredCountryFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (1 == i)
        {
            abslistview = getView().findViewById(0x7f10015e);
            Util.hideSoftInput(getActivity(), abslistview);
        }
    }

    _cls9()
    {
        this$0 = PreferredCountryFragment.this;
        super();
    }
}
