// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.ebay.mobile.myebay:
//            ComposeMessageFragment

class this._cls0
    implements android.view.r
{

    final ComposeMessageFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        Object obj = getActivity();
        if (obj != null)
        {
            obj = (InputMethodManager)((Activity) (obj)).getSystemService("input_method");
            if (flag)
            {
                ((InputMethodManager) (obj)).showSoftInput(view, 1);
            } else
            {
                ((InputMethodManager) (obj)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
        if (flag && ComposeMessageFragment.access$100(ComposeMessageFragment.this) != null)
        {
            ComposeMessageFragment.access$100(ComposeMessageFragment.this).ick(getView());
        }
    }

    ()
    {
        this$0 = ComposeMessageFragment.this;
        super();
    }
}
