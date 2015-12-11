// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditText

class this._cls0
    implements Runnable
{

    final RetailSearchEditText this$0;

    public void run()
    {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(RetailSearchEditText.this, 0);
    }

    ()
    {
        this$0 = RetailSearchEditText.this;
        super();
    }
}
