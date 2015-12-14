// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

private class r extends r
{

    private float mFinalDragDeltaY;
    private float mInitDragDeltaY;
    final DragSortListView this$0;

    public void onStart()
    {
        mInitDragDeltaY = DragSortListView.access$2(DragSortListView.this);
        mFinalDragDeltaY = DragSortListView.access$3(DragSortListView.this);
    }

    public void onUpdate(float f, float f1)
    {
        if (DragSortListView.access$4(DragSortListView.this) != 4)
        {
            cancel();
            return;
        } else
        {
            DragSortListView.access$5(DragSortListView.this, (int)(mFinalDragDeltaY * f1 + (1.0F - f1) * mInitDragDeltaY));
            DragSortListView.access$6(DragSortListView.this).y = DragSortListView.access$7(DragSortListView.this) - DragSortListView.access$2(DragSortListView.this);
            DragSortListView.access$8(DragSortListView.this, true);
            return;
        }
    }

    public r(float f, int i)
    {
        this$0 = DragSortListView.this;
        super(DragSortListView.this, f, i);
    }
}
