// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;


// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView, RefinementsAdapter

class this._cls0
    implements Runnable
{

    final RefinementsListView this$0;

    public void run()
    {
        RefinementsListView.access$200(RefinementsListView.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = RefinementsListView.this;
        super();
    }
}
