// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import com.target.ui.model.list.ListDetailItem;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class this._cls0
    implements com.target.ui.view.View.a
{

    final ListItemView this$0;

    public void a()
    {
        ListItemView.b(ListItemView.this);
    }

    public void a(int i)
    {
        ListDetailItem listdetailitem = mItem;
        if (i <= 0)
        {
            i = -mItem.h();
        }
        listdetailitem.a(i);
        if (ListItemView.a(ListItemView.this) != null)
        {
            ListItemView.a(ListItemView.this).f(mItem);
        }
        ListItemView.a(ListItemView.this, mItem);
    }

    ()
    {
        this$0 = ListItemView.this;
        super();
    }
}
