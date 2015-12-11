// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.TextView;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.model.list.ListCollectionItem;

// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

class val.item
    implements com.target.ui.e.mView._cls3
{

    final ListCollectionItemView this$0;
    final ListCollectionItem val$item;

    public void a()
    {
        ListCollectionItemView.b(ListCollectionItemView.this, b(ListCollectionItemView.c(ListCollectionItemView.this)).getText().toString());
    }

    public void a(View view, Object obj)
    {
        if (ListCollectionItemView.d(ListCollectionItemView.this) != null)
        {
            ListCollectionItemView.d(ListCollectionItemView.this).f(val$item);
        }
    }

    public boolean a(Object obj)
    {
        return !val$item.d().isDefaultList() && !ListCollectionItemView.a(ListCollectionItemView.this);
    }

    ummary()
    {
        this$0 = final_listcollectionitemview;
        val$item = ListCollectionItem.this;
        super();
    }
}
