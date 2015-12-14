// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

// Referenced classes of package com.livemixtapes:
//            PullToRefreshListView

private class <init>
    implements android.view.ner
{

    final PullToRefreshListView this$0;

    public void onGlobalLayout()
    {
        int i = PullToRefreshListView.access$9(PullToRefreshListView.this).getHeight();
        if (i > 0)
        {
            PullToRefreshListView.access$10(i);
            if (PullToRefreshListView.access$2() > 0 && PullToRefreshListView.access$0(PullToRefreshListView.this) != this._fld0)
            {
                PullToRefreshListView.access$4(PullToRefreshListView.this, -PullToRefreshListView.access$2());
                requestLayout();
            }
        }
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    private ()
    {
        this$0 = PullToRefreshListView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
