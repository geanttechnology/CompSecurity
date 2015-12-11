// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMCustomSearchWidget

class this._cls0
    implements Runnable
{

    final PMCustomSearchWidget this$0;

    public void run()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
        if (inputmethodmanager != null)
        {
            inputmethodmanager.showSoftInput(searchView, 0);
        }
    }

    ()
    {
        this$0 = PMCustomSearchWidget.this;
        super();
    }
}
