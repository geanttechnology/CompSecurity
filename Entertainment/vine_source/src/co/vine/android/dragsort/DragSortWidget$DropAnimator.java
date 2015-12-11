// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import android.view.View;
import co.vine.android.animation.SmoothAnimator;
import co.vine.android.views.HorizontalListView;

// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

private class this._cls0 extends SmoothAnimator
{

    private float mDeltaX;
    private float mDeltaY;
    private int mTargetPosition;
    private int mTargetX;
    private int mTargetY;
    final DragSortWidget this$0;

    public void onStart()
    {
        mTargetPosition = DragSortWidget.access$100(DragSortWidget.this);
        View view = DragSortWidget.access$000(DragSortWidget.this).getChildAt(mTargetPosition - DragSortWidget.access$000(DragSortWidget.this).getFirstVisiblePosition());
        mDropping = true;
        if (view != null)
        {
            mTargetY = view.getTop() + DragSortWidget.access$000(DragSortWidget.this).getTop();
            mTargetX = view.getLeft() + DragSortWidget.access$000(DragSortWidget.this).getLeft();
        } else
        {
            mDropping = false;
            DragSortWidget.access$600(DragSortWidget.this).start();
            cancel();
        }
        mDeltaX = DragSortWidget.access$700(DragSortWidget.this) - mTargetX;
        mDeltaY = DragSortWidget.access$800(DragSortWidget.this) - mTargetY;
    }

    public void onStop()
    {
        DragSortWidget.access$900(DragSortWidget.this);
    }

    public void onUpdate(float f, float f1)
    {
        int i = mTargetX;
        int j = mTargetY;
        View view = DragSortWidget.access$000(DragSortWidget.this).getChildAt(mTargetPosition - DragSortWidget.access$000(DragSortWidget.this).getFirstVisiblePosition());
        if (view != null)
        {
            j = view.getTop() + DragSortWidget.access$000(DragSortWidget.this).getTop();
            i = view.getLeft() + DragSortWidget.access$000(DragSortWidget.this).getLeft();
        }
        mTargetX = i;
        mTargetY = j;
        f = 1.0F - f1;
        DragSortWidget.access$702(DragSortWidget.this, mTargetX + (int)(mDeltaX * f));
        DragSortWidget.access$802(DragSortWidget.this, mTargetY + (int)(mDeltaY * f));
        invalidate();
    }

    public royAnimator(float f, int i)
    {
        this$0 = DragSortWidget.this;
        super(DragSortWidget.this, f, i);
    }
}
