// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.e.a;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, AdapterHelper

class this._cls0
    implements Runnable
{

    final RecyclerView this$0;

    public void run()
    {
        if (RecyclerView.access$100(RecyclerView.this))
        {
            if (RecyclerView.access$200(RecyclerView.this))
            {
                a.c("RV FullInvalidate");
                dispatchLayout();
                a.l();
                return;
            }
            if (mAdapterHelper.hasPendingUpdates())
            {
                a.c("RV PartialInvalidate");
                eatRequestLayout();
                mAdapterHelper.preProcess();
                if (!RecyclerView.access$300(RecyclerView.this))
                {
                    rebindUpdatedViewHolders();
                }
                resumeRequestLayout(true);
                a.l();
                return;
            }
        }
    }

    ()
    {
        this$0 = RecyclerView.this;
        super();
    }
}
