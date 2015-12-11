// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;


// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

class val.editMode
    implements Runnable
{

    final ListCollectionItemView this$0;
    final boolean val$editMode;

    public void run()
    {
        ListCollectionItemView.d(ListCollectionItemView.this).b(val$editMode);
    }

    ()
    {
        this$0 = final_listcollectionitemview;
        val$editMode = Z.this;
        super();
    }
}
