// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import co.vine.android.animation.SmoothAnimator;

// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

private class this._cls0 extends SmoothAnimator
{

    final DragSortWidget this$0;

    public void onStop()
    {
        DragSortWidget.access$1002(DragSortWidget.this, 0.0F);
        DragSortWidget.access$102(DragSortWidget.this, -1);
        DragSortWidget.access$1100(DragSortWidget.this);
        DragSortWidget.access$1200(DragSortWidget.this);
        invalidate();
    }

    public void onUpdate(float f, float f1)
    {
        f = 0.0F;
        DragSortWidget.access$1002(DragSortWidget.this, (1.0F - f1) * 255F - 50F);
        DragSortWidget dragsortwidget = DragSortWidget.this;
        if (DragSortWidget.access$1000(DragSortWidget.this) >= 0.0F)
        {
            f = DragSortWidget.access$1000(DragSortWidget.this);
        }
        DragSortWidget.access$1002(dragsortwidget, f);
        invalidate();
    }

    public (float f, int i)
    {
        this$0 = DragSortWidget.this;
        super(DragSortWidget.this, f, i);
    }
}
