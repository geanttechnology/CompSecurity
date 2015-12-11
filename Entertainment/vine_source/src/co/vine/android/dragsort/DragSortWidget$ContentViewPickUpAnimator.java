// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import android.graphics.Rect;
import co.vine.android.animation.SmoothAnimator;

// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

private class this._cls0 extends SmoothAnimator
{

    private int mFloatViewStartHeight;
    private int mFloatViewStartWidth;
    private int mHeightDelta;
    private int mWidthDelta;
    private float mXOffsetRatio;
    private float mYOffsetRatio;
    final DragSortWidget this$0;

    public void onStart()
    {
        mFloatViewStartWidth = DragSortWidget.access$1300(DragSortWidget.this).width();
        mFloatViewStartHeight = DragSortWidget.access$1300(DragSortWidget.this).height();
        DragSortWidget.access$1402(DragSortWidget.this, mFloatViewStartWidth);
        DragSortWidget.access$1502(DragSortWidget.this, mFloatViewStartHeight);
        DragSortWidget.access$1602(DragSortWidget.this, DragSortWidget.access$200(DragSortWidget.this) - DragSortWidget.access$1300(DragSortWidget.this).left);
        DragSortWidget.access$1702(DragSortWidget.this, DragSortWidget.access$1800(DragSortWidget.this) - DragSortWidget.access$1300(DragSortWidget.this).top);
        if (DragSortWidget.access$1300(DragSortWidget.this).width() != 0)
        {
            mXOffsetRatio = (float)DragSortWidget.access$1600(DragSortWidget.this) / ((float)DragSortWidget.access$1300(DragSortWidget.this).width() * 1.0F);
        }
        if (DragSortWidget.access$1300(DragSortWidget.this).height() != 0)
        {
            mYOffsetRatio = (float)DragSortWidget.access$1700(DragSortWidget.this) / ((float)DragSortWidget.access$1300(DragSortWidget.this).height() * 1.0F);
        }
        mWidthDelta = DragSortWidget.access$1400(DragSortWidget.this) - DragSortWidget.access$1900(DragSortWidget.this);
        mHeightDelta = DragSortWidget.access$1500(DragSortWidget.this) - DragSortWidget.access$1900(DragSortWidget.this);
        DragSortWidget.access$2002(DragSortWidget.this, true);
        invalidate();
    }

    public void onStop()
    {
        DragSortWidget.access$2002(DragSortWidget.this, false);
        invalidate();
    }

    public void onUpdate(float f, float f1)
    {
        DragSortWidget.access$1402(DragSortWidget.this, (int)((float)mFloatViewStartWidth - (float)mWidthDelta * f1));
        DragSortWidget.access$1502(DragSortWidget.this, (int)((float)mFloatViewStartHeight - (float)mHeightDelta * f1));
        int i = DragSortWidget.access$1600(DragSortWidget.this);
        int j = DragSortWidget.access$1700(DragSortWidget.this);
        DragSortWidget.access$1602(DragSortWidget.this, (int)((float)DragSortWidget.access$1400(DragSortWidget.this) * mXOffsetRatio));
        DragSortWidget.access$1702(DragSortWidget.this, (int)((float)DragSortWidget.access$1500(DragSortWidget.this) * mYOffsetRatio));
        DragSortWidget.access$702(DragSortWidget.this, (DragSortWidget.access$700(DragSortWidget.this) + i) - DragSortWidget.access$1600(DragSortWidget.this));
        DragSortWidget.access$802(DragSortWidget.this, (DragSortWidget.access$800(DragSortWidget.this) + j) - DragSortWidget.access$1700(DragSortWidget.this));
        invalidate();
    }

    public (float f, int i)
    {
        this$0 = DragSortWidget.this;
        super(DragSortWidget.this, f, i);
    }
}
