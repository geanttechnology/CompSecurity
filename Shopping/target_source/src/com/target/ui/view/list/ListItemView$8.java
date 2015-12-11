// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.KeyEvent;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.util.e.a;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class this._cls0
    implements android.widget.orActionListener
{

    final ListItemView this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag = true;
        if (i != 6 && keyevent != null && keyevent.getAction() != 0)
        {
            flag = false;
        } else
        {
            a.a(ListItemView.this);
            ListItemView.b(ListItemView.this);
            ListItemView.this.a(true);
            textview = mViews.editTitleText.getText().toString();
            if (!o.e(textview))
            {
                mItem.a(textview);
            }
            if (com.target.ui.view.list.ListItemView.a(ListItemView.this) != null)
            {
                com.target.ui.view.list.ListItemView.a(ListItemView.this).g(mItem);
                return true;
            }
        }
        return flag;
    }

    ()
    {
        this$0 = ListItemView.this;
        super();
    }
}
