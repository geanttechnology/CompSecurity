// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.TextView;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.e.g;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

class val.item
    implements android.view.ItemView._cls5
{

    final ListCollectionItemView this$0;
    final ListCollectionItem val$item;

    public boolean onLongClick(View view)
    {
        if (ListCollectionItemView.e(ListCollectionItemView.this).a() || ListCollectionItemView.a(ListCollectionItemView.this) || val$item.d().isDefaultList())
        {
            return true;
        } else
        {
            ListCollectionItemView.c(ListCollectionItemView.this, b(ListCollectionItemView.c(ListCollectionItemView.this)).getText().toString());
            ListCollectionItemView.f(ListCollectionItemView.this);
            d(ListCollectionItemView.c(ListCollectionItemView.this)).setText(b(ListCollectionItemView.c(ListCollectionItemView.this)).getText());
            return true;
        }
    }

    ummary()
    {
        this$0 = final_listcollectionitemview;
        val$item = ListCollectionItem.this;
        super();
    }
}
