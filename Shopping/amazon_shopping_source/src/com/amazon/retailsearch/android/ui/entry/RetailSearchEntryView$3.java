// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEntryView

class this._cls0
    implements android.widget.istener
{

    final RetailSearchEntryView this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 2)
        {
            textview = textview.getText().toString().trim();
            if (TextUtils.isEmpty(textview))
            {
                return true;
            } else
            {
                doSearch(textview.trim());
                return true;
            }
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = RetailSearchEntryView.this;
        super();
    }
}
