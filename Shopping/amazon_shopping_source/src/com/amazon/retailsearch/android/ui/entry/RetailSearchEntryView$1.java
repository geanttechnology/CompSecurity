// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.view.MotionEvent;
import android.view.View;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEntryView, RetailSearchEditText

class this._cls0
    implements android.view.try.RetailSearchEntryView._cls1
{

    final RetailSearchEntryView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            mSearchEditText.setFocusableInTouchMode(false);
            mSearchEditText.clearFocus();
            UIUtils.closeSoftKeyboard(RetailSearchEntryView.this);
            return false;
        } else
        {
            mSearchEditText.setFocusableInTouchMode(true);
            return false;
        }
    }

    ()
    {
        this$0 = RetailSearchEntryView.this;
        super();
    }
}
