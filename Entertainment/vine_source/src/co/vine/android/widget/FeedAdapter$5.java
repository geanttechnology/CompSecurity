// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package co.vine.android.widget:
//            FeedAdapter, PinnedHeaderListView, TooltipOverlayView

class this._cls0
    implements android.view.stener
{

    final FeedAdapter this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 && (mListView instanceof PinnedHeaderListView))
        {
            TooltipOverlayView tooltipoverlayview = new TooltipOverlayView(mContext, 0x7f0e0134);
            PinnedHeaderListView pinnedheaderlistview = (PinnedHeaderListView)mListView;
            boolean flag = pinnedheaderlistview.isAbsoluteTouchInPinnedHeader(motionevent);
            motionevent = new int[2];
            view.getLocationInWindow(motionevent);
            int i;
            if (flag)
            {
                i = pinnedheaderlistview.getPinnedHeaderBottomAbs();
            } else
            {
                i = motionevent[1] + view.getHeight();
            }
            tooltipoverlayview.showTooltip(i);
            return true;
        } else
        {
            return false;
        }
    }

    View()
    {
        this$0 = FeedAdapter.this;
        super();
    }
}
