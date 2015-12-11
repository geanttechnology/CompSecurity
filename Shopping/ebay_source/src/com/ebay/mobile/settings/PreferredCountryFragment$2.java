// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.widget.EditText;
import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.mobile.settings:
//            PreferredCountryFragment

class val.filterView
    implements Runnable
{

    final PreferredCountryFragment this$0;
    final EditText val$filterView;

    public void run()
    {
        Util.forceEditTextFocus(val$filterView);
    }

    _cls9()
    {
        this$0 = final_preferredcountryfragment;
        val$filterView = EditText.this;
        super();
    }
}
