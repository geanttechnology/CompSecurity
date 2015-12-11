// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.KeyEvent;
import android.widget.TextView;
import com.poshmark.data_model.models.SuggestedSearchItem;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMCustomSearchWidget

class this._cls0
    implements android.widget.Listener
{

    final PMCustomSearchWidget this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 3)
        {
            textview = textview.getText().toString();
            keyevent = new SuggestedSearchItem();
            keyevent.kw = textview.trim();
            keyevent.type = "kw";
            launchSearch(keyevent, true);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = PMCustomSearchWidget.this;
        super();
    }
}
