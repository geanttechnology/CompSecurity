// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

private class r extends r
{

    private int mDropPos;
    private float mInitDeltaX;
    private float mInitDeltaY;
    private int srcPos;
    final DragSortListView this$0;

    private int getTargetY()
    {
        int i = getFirstVisiblePosition();
        int j = (DragSortListView.access$12(DragSortListView.this) + getDividerHeight()) / 2;
        View view = getChildAt(mDropPos - i);
        if (view != null)
        {
            if (mDropPos == srcPos)
            {
                return view.getTop();
            }
            if (mDropPos < srcPos)
            {
                return view.getTop() - j;
            } else
            {
                return (view.getBottom() + j) - DragSortListView.access$13(DragSortListView.this);
            }
        } else
        {
            cancel();
            return -1;
        }
    }

    public void onStart()
    {
        mDropPos = DragSortListView.access$9(DragSortListView.this);
        srcPos = DragSortListView.access$10(DragSortListView.this);
        DragSortListView.access$11(DragSortListView.this, 2);
        mInitDeltaY = DragSortListView.access$6(DragSortListView.this).y - getTargetY();
        mInitDeltaX = DragSortListView.access$6(DragSortListView.this).x - getPaddingLeft();
    }

    public void onStop()
    {
        DragSortListView.access$14(DragSortListView.this);
    }

    public void onUpdate(float f, float f1)
    {
        int i = getTargetY();
        int j = getPaddingLeft();
        f = DragSortListView.access$6(DragSortListView.this).y - i;
        float f2 = DragSortListView.access$6(DragSortListView.this).x - j;
        f1 = 1.0F - f1;
        if (f1 < Math.abs(f / mInitDeltaY) || f1 < Math.abs(f2 / mInitDeltaX))
        {
            DragSortListView.access$6(DragSortListView.this).y = (int)(mInitDeltaY * f1) + i;
            DragSortListView.access$6(DragSortListView.this).x = getPaddingLeft() + (int)(mInitDeltaX * f1);
            DragSortListView.access$8(DragSortListView.this, true);
        }
    }

    public r(float f, int i)
    {
        this$0 = DragSortListView.this;
        super(DragSortListView.this, f, i);
    }
}
