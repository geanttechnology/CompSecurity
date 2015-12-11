// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import com.target.ui.model.list.ListDetailItem;

// Referenced classes of package com.target.ui.view.list:
//            BaseListItemView

class this._cls0
    implements android.view.r
{

    final BaseListItemView this$0;

    public void onClick(View view)
    {
        if (mItem.k())
        {
            return;
        } else
        {
            mItem.d(true);
            c();
            return;
        }
    }

    ()
    {
        this$0 = BaseListItemView.this;
        super();
    }
}
