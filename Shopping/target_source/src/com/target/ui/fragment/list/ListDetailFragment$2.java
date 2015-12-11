// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import com.target.ui.fragment.list.presenter.ListDetailPresenter;
import com.target.ui.model.list.ListDetailItem;

// Referenced classes of package com.target.ui.fragment.list:
//            ListDetailFragment

class val.position
    implements com.target.ui.view.common._cls2
{

    final ListDetailFragment this$0;
    final ListDetailItem val$detailItem;
    final int val$position;

    public void a()
    {
        ListDetailFragment.a(ListDetailFragment.this).b(val$detailItem, val$position);
    }

    public void b()
    {
    }

    resenter()
    {
        this$0 = final_listdetailfragment;
        val$detailItem = listdetailitem;
        val$position = I.this;
        super();
    }
}
