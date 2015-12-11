// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import com.target.ui.e.g;
import com.target.ui.model.list.ListCollectionItem;

// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

class val.item
    implements android.view.ItemView._cls4
{

    final ListCollectionItemView this$0;
    final ListCollectionItem val$item;

    public void onClick(View view)
    {
        if (!ListCollectionItemView.e(ListCollectionItemView.this).a() && !ListCollectionItemView.a(ListCollectionItemView.this) && ListCollectionItemView.d(ListCollectionItemView.this) != null)
        {
            ListCollectionItemView.d(ListCollectionItemView.this).e(val$item);
        }
    }

    ()
    {
        this$0 = final_listcollectionitemview;
        val$item = ListCollectionItem.this;
        super();
    }
}
