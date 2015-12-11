// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

class this._cls0
    implements android.widget.ctionListener
{

    final ListDetailView this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6 || i == 5 || keyevent.getAction() == 0)
        {
            ListDetailView.a(ListDetailView.this, textview.getText().toString());
            return true;
        } else
        {
            return false;
        }
    }

    ener()
    {
        this$0 = ListDetailView.this;
        super();
    }
}
