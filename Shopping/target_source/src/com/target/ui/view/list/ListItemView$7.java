// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.KeyEvent;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class this._cls0
    implements com.target.ui.view.xt.a
{

    final ListItemView this$0;

    public boolean a(int i, KeyEvent keyevent)
    {
        if (ListItemView.d(ListItemView.this) && keyevent.getAction() == 0 && i == 4)
        {
            ListItemView.b(ListItemView.this);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = ListItemView.this;
        super();
    }
}
