// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.ebay.mobile.checkout:
//            IncentivesActivity

class this._cls0
    implements android.view.tener
{

    final IncentivesActivity this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
            return;
        } else
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
    }

    ()
    {
        this$0 = IncentivesActivity.this;
        super();
    }
}
