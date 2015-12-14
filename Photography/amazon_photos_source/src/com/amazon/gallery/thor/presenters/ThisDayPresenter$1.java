// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.presenters;

import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import com.amazon.gallery.thor.view.AsyncDataLoadingView;

// Referenced classes of package com.amazon.gallery.thor.presenters:
//            ThisDayPresenter

class val.data
    implements Runnable
{

    final ThisDayPresenter this$0;
    final ThisDayViewCollection val$data;

    public void run()
    {
        ThisDayPresenter.access$000(ThisDayPresenter.this).onDataLoaded(val$data);
    }

    ()
    {
        this$0 = final_thisdaypresenter;
        val$data = ThisDayViewCollection.this;
        super();
    }
}
