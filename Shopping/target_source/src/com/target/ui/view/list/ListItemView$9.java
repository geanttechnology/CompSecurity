// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import com.target.mothership.util.b;
import com.target.ui.util.ai;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class this._cls0
    implements android.view.tener
{

    final ListItemView this$0;

    public void onClick(View view)
    {
        if (!b.a().b())
        {
            ai.a(getContext(), 0x7f0903df);
        } else
        if (ListItemView.a(ListItemView.this) != null && !ListItemView.e(ListItemView.this))
        {
            ListItemView.a(ListItemView.this).a(mItem, mViews.layout);
            return;
        }
    }

    w.a()
    {
        this$0 = ListItemView.this;
        super();
    }
}
