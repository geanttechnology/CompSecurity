// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;


// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView

class this._cls0
    implements android.widget.roupExpandListener
{

    final RefinementsListView this$0;

    public void onGroupExpand(final int groupPosition)
    {
        RefinementsListView.access$2000(RefinementsListView.this);
        post(new Runnable() {

            final RefinementsListView._cls3 this$1;
            final int val$groupPosition;

            public void run()
            {
                setSelectedGroup(groupPosition);
            }

            
            {
                this$1 = RefinementsListView._cls3.this;
                groupPosition = i;
                super();
            }
        });
    }

    _cls1.val.groupPosition()
    {
        this$0 = RefinementsListView.this;
        super();
    }
}
