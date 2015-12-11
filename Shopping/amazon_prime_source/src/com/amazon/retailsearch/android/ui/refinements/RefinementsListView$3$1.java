// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;


// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView

class val.groupPosition
    implements Runnable
{

    final val.groupPosition this$1;
    final int val$groupPosition;

    public void run()
    {
        setSelectedGroup(val$groupPosition);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$groupPosition = I.this;
        super();
    }

    // Unreferenced inner class com/amazon/retailsearch/android/ui/refinements/RefinementsListView$3

/* anonymous class */
    class RefinementsListView._cls3
        implements android.widget.ExpandableListView.OnGroupExpandListener
    {

        final RefinementsListView this$0;

        public void onGroupExpand(int i)
        {
            RefinementsListView.access$2000(RefinementsListView.this);
            post(i. new RefinementsListView._cls3._cls1());
        }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
    }

}
