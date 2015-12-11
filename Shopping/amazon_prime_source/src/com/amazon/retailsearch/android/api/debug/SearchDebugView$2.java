// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.widget.EditText;
import android.widget.RadioGroup;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView

class this._cls0
    implements android.widget.edChangeListener
{

    final SearchDebugView this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (i == com.amazon.retailsearch.o_secure || i == com.amazon.retailsearch.o_insecure)
        {
            SearchDebugView.access$000(SearchDebugView.this);
            return;
        } else
        {
            SearchDebugView.access$300(SearchDebugView.this).setText("");
            return;
        }
    }

    A()
    {
        this$0 = SearchDebugView.this;
        super();
    }
}
