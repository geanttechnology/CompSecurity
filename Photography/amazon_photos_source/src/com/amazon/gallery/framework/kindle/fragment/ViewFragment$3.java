// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ViewFragment

class this._cls0
    implements android.view.r.OnGlobalLayoutListener
{

    final ViewFragment this$0;

    public void onGlobalLayout()
    {
        int i = getFirstVisiblePosition();
        if (getLastVisiblePosition() - i > 0)
        {
            if (Api.isAtLeastJellyBean())
            {
                mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else
            {
                mRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            ViewFragment.access$100(ViewFragment.this).setGridStatus(mGridStatus);
        }
    }

    cs()
    {
        this$0 = ViewFragment.this;
        super();
    }
}
