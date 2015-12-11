// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.amazon.retailsearch.android.ui.HorizontalListView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackView

public class HorizontalStackView extends HorizontalListView
    implements StackView
{

    private int itemWidth;
    private boolean touchEventsEnabled;

    public HorizontalStackView(Context context)
    {
        super(context);
        touchEventsEnabled = true;
        init();
    }

    public HorizontalStackView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        touchEventsEnabled = true;
        init();
    }

    public HorizontalStackView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        touchEventsEnabled = true;
        init();
    }

    private void init()
    {
        itemWidth = getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_split_view_port_item_width);
    }

    public void disableTouchEvents()
    {
        touchEventsEnabled = false;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (touchEventsEnabled)
        {
            return super.dispatchTouchEvent(motionevent);
        } else
        {
            return true;
        }
    }

    public void enableTouchEvents()
    {
        touchEventsEnabled = true;
    }

    protected int getItemWidth()
    {
        return itemWidth;
    }

    public View getView()
    {
        return this;
    }
}
