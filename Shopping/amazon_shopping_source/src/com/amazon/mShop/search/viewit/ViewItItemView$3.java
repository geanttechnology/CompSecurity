// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.LayoutInflater;
import android.view.View;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemView, ViewItActivity, ViewItMetricHelper, ViewItPhotoCaptureView, 
//            ViewItSlidingDrawerView, ViewItAllMatchedResultsView, ViewItSlidingDrawerBrowser

class this._cls0
    implements android.view.ner
{

    final ViewItItemView this$0;

    public void onClick(View view)
    {
        ViewItItemView.access$400(ViewItItemView.this).getViewItMetricHelper().logCountMetricsPerSession("history-see-more-tap", 1);
        if (ViewItItemView.access$400(ViewItItemView.this).getPhotoCaptureView().getViewItSlidingDrawerView().isOpened())
        {
            RefMarkerObserver.logRefMarker("fl_max_all_btn");
        } else
        {
            RefMarkerObserver.logRefMarker("fl_mini_all_btn");
        }
        view = (ViewItAllMatchedResultsView)LayoutInflater.from(ViewItItemView.access$400(ViewItItemView.this)).inflate(com.amazon.mShop.android.lib.all_matched_items_view, null);
        view.updateAllMatchedResultsView(ViewItItemView.access$000(ViewItItemView.this), ViewItItemView.access$300(ViewItItemView.this));
        ViewItItemView.access$400(ViewItItemView.this).pushView(view);
        ViewItItemView.access$300(ViewItItemView.this).deleteUndoObject();
    }

    erBrowser()
    {
        this$0 = ViewItItemView.this;
        super();
    }
}
