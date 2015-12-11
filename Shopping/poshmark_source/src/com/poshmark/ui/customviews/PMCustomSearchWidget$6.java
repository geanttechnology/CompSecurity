// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMCustomSearchWidget, PMAutoCompleteSearchView

class this._cls0
    implements android.view.SearchWidget._cls6
{

    final PMCustomSearchWidget this$0;

    public void onClick(View view)
    {
        searchView.setText("");
        clearButton.setVisibility(4);
    }

    w()
    {
        this$0 = PMCustomSearchWidget.this;
        super();
    }
}
