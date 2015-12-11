// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.KeyEvent;
import com.target.ui.util.e.a;

// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

class this._cls0
    implements com.target.ui.view.ew._cls1
{

    final ListCollectionItemView this$0;

    public boolean a(int i, KeyEvent keyevent)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this))
        {
            flag = flag1;
            if (keyevent.getAction() == 0)
            {
                flag = flag1;
                if (i == 4)
                {
                    com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this, false);
                    ListCollectionItemView.b(ListCollectionItemView.this);
                    com.target.ui.util.e.a.a(ListCollectionItemView.this);
                    flag = true;
                }
            }
        }
        return flag;
    }

    ()
    {
        this$0 = ListCollectionItemView.this;
        super();
    }
}
