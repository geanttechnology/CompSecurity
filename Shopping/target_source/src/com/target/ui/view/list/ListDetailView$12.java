// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.KeyEvent;
import android.view.View;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

class this._cls0
    implements android.view.
{

    final ListDetailView this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 0 && i == 66)
        {
            ListDetailView.a(ListDetailView.this, ListDetailView.a(ListDetailView.this).addItemEditText.getText().toString());
            ListDetailView.a(ListDetailView.this).addItemEditText.requestFocus();
            return true;
        } else
        {
            return false;
        }
    }

    ws()
    {
        this$0 = ListDetailView.this;
        super();
    }
}
