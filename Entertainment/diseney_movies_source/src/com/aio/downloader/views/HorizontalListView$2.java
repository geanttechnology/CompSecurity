// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package com.aio.downloader.views:
//            HorizontalListView

class stener extends android.view.eOnGestureListener
{

    final HorizontalListView this$0;

    private boolean isEventWithinView(MotionEvent motionevent, View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int i = ai[0];
        int j = view.getWidth();
        int k = ai[1];
        rect.set(i, k, i + j, k + view.getHeight());
        return rect.contains((int)motionevent.getRawX(), (int)motionevent.getRawY());
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return HorizontalListView.this.onDown(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return HorizontalListView.this.onFling(motionevent, motionevent1, f, f1);
    }

    public void onLongPress(MotionEvent motionevent)
    {
        int i;
        int j;
        j = getChildCount();
        i = 0;
_L5:
        if (i < j) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View view = getChildAt(i);
        if (!isEventWithinView(motionevent, view))
        {
            break; /* Loop/switch isn't completed */
        }
        if (HorizontalListView.access$7(HorizontalListView.this) != null)
        {
            HorizontalListView.access$7(HorizontalListView.this).onItemLongClick(HorizontalListView.this, view, HorizontalListView.access$5(HorizontalListView.this) + 1 + i, mAdapter.getItemId(HorizontalListView.access$5(HorizontalListView.this) + 1 + i));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        synchronized (HorizontalListView.this)
        {
            motionevent1 = HorizontalListView.this;
            motionevent1.mNextX = ((HorizontalListView) (motionevent1)).mNextX + (int)f;
        }
        requestLayout();
        return true;
        motionevent1;
        motionevent;
        JVM INSTR monitorexit ;
        throw motionevent1;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        int i = 0;
_L5:
        if (i < getChildCount()) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        View view = getChildAt(i);
        if (!isEventWithinView(motionevent, view))
        {
            break; /* Loop/switch isn't completed */
        }
        if (HorizontalListView.access$4(HorizontalListView.this) != null)
        {
            HorizontalListView.access$4(HorizontalListView.this).onItemClick(HorizontalListView.this, view, HorizontalListView.access$5(HorizontalListView.this) + 1 + i, mAdapter.getItemId(HorizontalListView.access$5(HorizontalListView.this) + 1 + i));
        }
        if (HorizontalListView.access$6(HorizontalListView.this) != null)
        {
            HorizontalListView.access$6(HorizontalListView.this).onItemSelected(HorizontalListView.this, view, HorizontalListView.access$5(HorizontalListView.this) + 1 + i, mAdapter.getItemId(HorizontalListView.access$5(HorizontalListView.this) + 1 + i));
        }
        if (true) goto _L1; else goto _L3
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    ner()
    {
        this$0 = HorizontalListView.this;
        super();
    }
}
