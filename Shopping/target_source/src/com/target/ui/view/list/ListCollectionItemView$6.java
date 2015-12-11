// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

class this._cls0
    implements android.view.ItemView._cls6
{

    final ListCollectionItemView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            ListCollectionItemView.g(ListCollectionItemView.this).ctionItemView();
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = ListCollectionItemView.this;
        super();
    }
}
