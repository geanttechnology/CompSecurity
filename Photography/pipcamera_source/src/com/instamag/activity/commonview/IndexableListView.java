// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListAdapter;
import qf;

// Referenced classes of package com.instamag.activity.commonview:
//            PinnedSectionListView

public class IndexableListView extends PinnedSectionListView
{

    private GestureDetector mGestureDetector;
    private boolean mIsFastScrollEnabled;
    private qf mScroller;

    public IndexableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsFastScrollEnabled = false;
        mScroller = null;
        mGestureDetector = null;
    }

    public IndexableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsFastScrollEnabled = false;
        mScroller = null;
        mGestureDetector = null;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (mScroller != null)
        {
            mScroller.a(canvas);
        }
    }

    public boolean isFastScrollEnabled()
    {
        return mIsFastScrollEnabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (mScroller != null)
        {
            mScroller.a(i, j, k, l);
        }
    }

    public void refreshIndex()
    {
        if (mScroller != null)
        {
            mScroller.b();
        }
        invalidate();
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        super.setAdapter(listadapter);
        if (mScroller != null)
        {
            mScroller.a(listadapter);
        }
    }

    public void setFastScrollEnabled(boolean flag)
    {
        mIsFastScrollEnabled = flag;
        if (mIsFastScrollEnabled)
        {
            if (mScroller == null)
            {
                mScroller = new qf(getContext(), this);
            }
        } else
        if (mScroller != null)
        {
            mScroller.a();
            mScroller = null;
            return;
        }
    }
}
