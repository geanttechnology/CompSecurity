// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher, RetailSearchEditText

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (mSearchEditText != null && RetailSearchEditTextWatcher.access$200(_fld0) != null)
        {
            mSearchEditText.setCompoundDrawablesWithIntrinsicBounds(cess._mth300(this._cls1.this), null, RetailSearchEditTextWatcher.access$200(_fld0), null);
            RetailSearchEditTextWatcher.access$200(_fld0).setVisible(true, false);
        }
    }

    Y()
    {
        this$1 = this._cls1.this;
        super();
    }
}
