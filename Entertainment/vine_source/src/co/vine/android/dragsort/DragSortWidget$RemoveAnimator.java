// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import android.view.View;
import android.view.ViewPropertyAnimator;
import co.vine.android.animation.SmoothAnimator;
import co.vine.android.views.HorizontalListView;

// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

private class this._cls0 extends SmoothAnimator
{

    private int mWidth;
    final DragSortWidget this$0;

    public void onStart()
    {
        DragSortWidget.access$2102(DragSortWidget.this, DragSortWidget.access$2200(DragSortWidget.this));
        View view = DragSortWidget.access$000(DragSortWidget.this).getChildAt(DragSortWidget.access$2100(DragSortWidget.this) - DragSortWidget.access$000(DragSortWidget.this).getFirstVisiblePosition());
        if (view != null)
        {
            mWidth = view.getWidth();
            if (view != null)
            {
                view.animate().alpha(0.0F).setDuration((long)mDurationF).start();
            }
            ((m)view).hasTransientState = true;
            mRemoving = true;
            return;
        } else
        {
            DragSortWidget.access$2300(DragSortWidget.this);
            cancel();
            return;
        }
    }

    public void onStop()
    {
        View view = DragSortWidget.access$000(DragSortWidget.this).getChildAt(DragSortWidget.access$2100(DragSortWidget.this) - DragSortWidget.access$000(DragSortWidget.this).getFirstVisiblePosition());
        if (view != null)
        {
            view.setVisibility(8);
            view.animate().cancel();
            view.setAlpha(1.0F);
            ((m)view).hasTransientState = false;
        }
        DragSortWidget.access$2300(DragSortWidget.this);
        mRemoving = false;
    }

    public void onUpdate(float f, float f1)
    {
        View view = DragSortWidget.access$000(DragSortWidget.this).getChildAt(DragSortWidget.access$2100(DragSortWidget.this) - DragSortWidget.access$000(DragSortWidget.this).getFirstVisiblePosition());
        if (view != null)
        {
            mWidth = Math.round((float)mWidth * (1.0F - f1));
            android.view.oveAnimator oveanimator = view.getLayoutParams();
            oveanimator.mWidth = mWidth;
            view.setLayoutParams(oveanimator);
            DragSortWidget.access$000(DragSortWidget.this).forceLayout();
        } else
        {
            DragSortWidget.access$2300(DragSortWidget.this);
            mRemoving = false;
            cancel();
        }
        DragSortWidget.access$000(DragSortWidget.this).invalidate();
    }


    public m(float f, int i)
    {
        this$0 = DragSortWidget.this;
        super(DragSortWidget.this, f, i);
    }
}
