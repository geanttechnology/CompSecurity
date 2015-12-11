// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.groupon.view.ExpandablePanel;

// Referenced classes of package com.groupon.adapter:
//            TripAdvisorReviewAdapter

private class reviewPos
    implements android.view.stener
{

    private final int reviewPos;
    private final TextView reviewText;
    final TripAdvisorReviewAdapter this$0;

    public void onClick(View view)
    {
        int i = 0x7fffffff;
        if (TripAdvisorReviewAdapter.access$000(TripAdvisorReviewAdapter.this).isExpanding())
        {
            return;
        }
        int j = reviewText.getHeight();
        ViewTreeObserver viewtreeobserver;
        TripAdvisorReviewAdapter tripadvisorreviewadapter;
        TextView textview;
        boolean flag;
        if (reviewText.getMaxLines() == 0x7fffffff)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = reviewText;
        if (flag)
        {
            i = 4;
        }
        view.setMaxLines(i);
        viewtreeobserver = reviewText.getViewTreeObserver();
        tripadvisorreviewadapter = TripAdvisorReviewAdapter.this;
        textview = reviewText;
        i = reviewPos;
        if (flag)
        {
            view = "collapse";
        } else
        {
            view = "expand";
        }
        viewtreeobserver.addOnGlobalLayoutListener(new (tripadvisorreviewadapter, textview, i, j, view));
    }

    public (TextView textview, int i)
    {
        this$0 = TripAdvisorReviewAdapter.this;
        super();
        reviewText = textview;
        reviewPos = i;
    }
}
