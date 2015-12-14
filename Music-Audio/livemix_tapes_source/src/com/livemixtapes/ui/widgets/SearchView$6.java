// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.livemixtapes.ui.widgets:
//            SearchView

class this._cls0
    implements android.view.istener
{

    final SearchView this$0;

    public void onClick(View view)
    {
        SearchView.access$5(SearchView.this).setText("");
        SearchView.access$5(SearchView.this).requestFocus();
    }

    ()
    {
        this$0 = SearchView.this;
        super();
    }
}
