// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class this._cls0
    implements com.target.ui.e.View._cls12
{

    final ListItemView this$0;

    public void a()
    {
        ListItemView.a(ListItemView.this, mViews.titleTextView.getText().toString());
    }

    public void a(View view, Object obj)
    {
        ListItemView.a(ListItemView.this).(mItem);
    }

    public boolean a(Object obj)
    {
        return !ListItemView.e(ListItemView.this);
    }

    .a()
    {
        this$0 = ListItemView.this;
        super();
    }
}
