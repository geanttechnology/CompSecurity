// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.amazon.retailsearch.data.search.SearchLoaderLogger;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.SearchDataSource;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackView

public class VerticalStackView extends ListView
    implements StackView
{

    private int mCurrentFocusPosition;
    SearchDataSource searchDataSource;
    private boolean touchEventsEnabled;

    public VerticalStackView(Context context)
    {
        super(context);
        touchEventsEnabled = true;
        mCurrentFocusPosition = 0;
        init();
    }

    public VerticalStackView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        touchEventsEnabled = true;
        mCurrentFocusPosition = 0;
        init();
    }

    public VerticalStackView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        touchEventsEnabled = true;
        mCurrentFocusPosition = 0;
        init();
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
    }

    public void disableTouchEvents()
    {
        touchEventsEnabled = false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        boolean flag = true;
        if (keyevent.getAction() != 0 || keyevent.getKeyCode() != 22) goto _L2; else goto _L1
_L1:
        if (mCurrentFocusPosition + 1 >= getAdapter().getCount()) goto _L4; else goto _L3
_L3:
        mCurrentFocusPosition = mCurrentFocusPosition + 1;
_L7:
        flag = super.dispatchKeyEvent(keyevent);
_L4:
        return flag;
_L2:
        if (keyevent.getAction() != 0 || keyevent.getKeyCode() != 21)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mCurrentFocusPosition - 1 < 0) goto _L4; else goto _L5
_L5:
        mCurrentFocusPosition = mCurrentFocusPosition - 1;
        if (true) goto _L7; else goto _L6
_L6:
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

    protected boolean drawChild(Canvas canvas, View view, long l)
    {
        boolean flag = super.drawChild(canvas, view, l);
        if (searchDataSource.getSearchLoaderLogger() != null)
        {
            searchDataSource.getSearchLoaderLogger().addDrewRow(view);
        }
        return flag;
    }

    public void enableTouchEvents()
    {
        touchEventsEnabled = true;
    }

    public View getView()
    {
        return this;
    }

    protected void layoutChildren()
    {
        if (searchDataSource.getSearchLoaderLogger() != null)
        {
            searchDataSource.getSearchLoaderLogger().layoutChildren();
        }
        super.layoutChildren();
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (mCurrentFocusPosition + 1 < getAdapter().getCount())
        {
            View view = getChildAt(mCurrentFocusPosition);
            if (view != null)
            {
                view.onKeyUp(i, keyevent);
            }
        }
        return super.onKeyUp(i, keyevent);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (searchDataSource.getSearchLoaderLogger() != null)
        {
            searchDataSource.getSearchLoaderLogger().setListViewHeight(android.view.View.MeasureSpec.getSize(j));
        }
    }
}
