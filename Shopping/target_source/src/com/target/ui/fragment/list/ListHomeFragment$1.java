// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import com.target.ui.fragment.list.presenter.a;
import com.target.ui.model.list.ListCollectionItem;

// Referenced classes of package com.target.ui.fragment.list:
//            ListHomeFragment

class val.position
    implements com.target.ui.view.common._cls1
{

    final ListHomeFragment this$0;
    final ListCollectionItem val$item;
    final int val$position;

    public void a()
    {
        com.target.ui.fragment.list.ListHomeFragment.a(ListHomeFragment.this).b(val$item, val$position);
    }

    public void b()
    {
        com.target.ui.fragment.list.ListHomeFragment.a(ListHomeFragment.this).b(val$item);
    }

    ()
    {
        this$0 = final_listhomefragment;
        val$item = listcollectionitem;
        val$position = I.this;
        super();
    }
}
