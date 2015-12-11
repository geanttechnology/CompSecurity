// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemView, ViewItSlidingDrawerBrowser, ViewItActivity, ViewItPhotoCaptureView, 
//            ViewItAllMatchedResultsView

class this._cls0
    implements android.view.ner
{

    final ViewItItemView this$0;

    public void onClick(View view)
    {
        showUndoButtonContent();
        ViewItItemView.access$300(ViewItItemView.this).updateUndoObject(ViewItItemView.access$000(ViewItItemView.this), ViewItItemView.access$100(ViewItItemView.this), ViewItItemView.access$200(ViewItItemView.this));
        view = ViewItItemView.access$400(ViewItItemView.this).getCurrentView();
        if (view != null)
        {
            if (view instanceof ViewItPhotoCaptureView)
            {
                RefMarkerObserver.logRefMarker("fl_history_del_btn");
            } else
            if (view instanceof ViewItAllMatchedResultsView)
            {
                RefMarkerObserver.logRefMarker("fl_allmatch_del_btn");
                return;
            }
        }
    }

    esultsView()
    {
        this$0 = ViewItItemView.this;
        super();
    }
}
