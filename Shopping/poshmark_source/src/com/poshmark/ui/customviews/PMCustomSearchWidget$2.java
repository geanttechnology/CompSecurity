// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMCustomSearchWidget, PMAutoCompleteSearchView

class this._cls0
    implements android.view.SearchWidget._cls2
{

    final PMCustomSearchWidget this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            searchView.setText(searchView.getText());
        }
        return false;
    }

    w()
    {
        this$0 = PMCustomSearchWidget.this;
        super();
    }
}
