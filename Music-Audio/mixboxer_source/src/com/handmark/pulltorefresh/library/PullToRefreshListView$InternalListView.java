// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshListView

public class mAddedLvFooter extends ListView
    implements EmptyViewMethodAccessor
{

    private boolean mAddedLvFooter;
    final PullToRefreshListView this$0;

    protected void dispatchDraw(Canvas canvas)
    {
        try
        {
            super.dispatchDraw(canvas);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Canvas canvas)
        {
            canvas.printStackTrace();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        try
        {
            flag = super.dispatchTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            motionevent.printStackTrace();
            return false;
        }
        return flag;
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (PullToRefreshListView.access$000(PullToRefreshListView.this) != null && !mAddedLvFooter)
        {
            addFooterView(PullToRefreshListView.access$000(PullToRefreshListView.this), null, false);
            mAddedLvFooter = true;
        }
        super.setAdapter(listadapter);
    }

    public void setEmptyView(View view)
    {
        PullToRefreshListView.this.setEmptyView(view);
    }

    public void setEmptyViewInternal(View view)
    {
        super.setEmptyView(view);
    }

    public (Context context, AttributeSet attributeset)
    {
        this$0 = PullToRefreshListView.this;
        super(context, attributeset);
        mAddedLvFooter = false;
    }
}
