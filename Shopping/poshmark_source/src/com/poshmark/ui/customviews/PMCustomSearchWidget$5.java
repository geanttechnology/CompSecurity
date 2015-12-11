// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMCustomSearchWidget, PMAutoCompleteSearchView

class this._cls0
    implements android.view.ner
{

    final PMCustomSearchWidget this$0;

    public void onFocusChange(View view, boolean flag)
    {
        setImeVisibility(flag);
        if (flag)
        {
            searchView.setText(searchView.getText());
        }
    }

    w()
    {
        this$0 = PMCustomSearchWidget.this;
        super();
    }
}
