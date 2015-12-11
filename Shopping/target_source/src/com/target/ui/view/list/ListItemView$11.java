// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import com.target.ui.e.g;
import com.target.ui.model.list.ListDetailItem;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class this._cls0
    implements android.view.ener
{

    final ListItemView this$0;

    public void onClick(View view)
    {
        if (ListItemView.f(ListItemView.this).a() || ListItemView.e(ListItemView.this) || mItem.k())
        {
            return;
        } else
        {
            d();
            return;
        }
    }

    ()
    {
        this$0 = ListItemView.this;
        super();
    }
}
