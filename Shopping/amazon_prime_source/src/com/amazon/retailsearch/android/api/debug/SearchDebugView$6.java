// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.view.KeyEvent;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView

class this._cls0
    implements android.widget.ctionListener
{

    final SearchDebugView this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            SearchDebugView.access$000(SearchDebugView.this);
            UIUtils.closeSoftKeyboard(SearchDebugView.access$300(SearchDebugView.this));
            return true;
        } else
        {
            return false;
        }
    }

    A()
    {
        this$0 = SearchDebugView.this;
        super();
    }
}
