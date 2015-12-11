// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.KeyEvent;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.util.e.a;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

class val.item
    implements android.widget.stener
{

    final ListCollectionItemView this$0;
    final ListCollectionItem val$item;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i != 6 && keyevent != null && keyevent.getAction() != 0)
        {
            return false;
        }
        a.a(ListCollectionItemView.this);
        ListCollectionItemView.b(ListCollectionItemView.this);
        textview = d(ListCollectionItemView.c(ListCollectionItemView.this)).getText().toString();
        if (!o.e(textview) && ListCollectionItemView.d(ListCollectionItemView.this) != null)
        {
            com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this, textview);
            val$item.a(textview);
            ListCollectionItemView.d(ListCollectionItemView.this).g(val$item);
        }
        com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this, false);
        return true;
    }

    ()
    {
        this$0 = final_listcollectionitemview;
        val$item = ListCollectionItem.this;
        super();
    }
}
