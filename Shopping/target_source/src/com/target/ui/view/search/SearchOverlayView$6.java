// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.search:
//            SearchOverlayView

class this._cls0
    implements android.widget.ionListener
{

    final SearchOverlayView this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        i;
        JVM INSTR tableswitch 3 3: default 20
    //                   3 22;
           goto _L1 _L2
_L1:
        return false;
_L2:
        if (SearchOverlayView.a(SearchOverlayView.this) != null)
        {
            SearchOverlayView.a(SearchOverlayView.this).a(SearchOverlayView.b(SearchOverlayView.this).searchField.getText().toString());
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    ews()
    {
        this$0 = SearchOverlayView.this;
        super();
    }
}
