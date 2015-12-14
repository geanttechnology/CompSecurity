// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.livemixtapes.ui.widgets:
//            SearchView

class this._cls0
    implements android.widget.itorActionListener
{

    final SearchView this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 3 && SearchView.access$6(SearchView.this) != null)
        {
            SearchView.access$6(SearchView.this).onQueryTextChange(SearchView.access$5(SearchView.this).getText().toString());
            setExpand(false);
        }
        return false;
    }

    eryTextListener()
    {
        this$0 = SearchView.this;
        super();
    }
}
