// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.view.MotionEvent;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortController, DragSortListView

class istener extends android.view.eOnGestureListener
{

    final DragSortController this$0;

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (!DragSortController.access$0(DragSortController.this) || !DragSortController.access$1(DragSortController.this)) goto _L2; else goto _L1
_L1:
        int i = DragSortController.access$2(DragSortController.this).getWidth() / 5;
        if (f <= DragSortController.access$3(DragSortController.this)) goto _L4; else goto _L3
_L3:
        if (DragSortController.access$4(DragSortController.this) > -i)
        {
            DragSortController.access$2(DragSortController.this).stopDragWithVelocity(true, f);
        }
_L6:
        DragSortController.access$5(DragSortController.this, false);
_L2:
        return false;
_L4:
        if (f < -DragSortController.access$3(DragSortController.this) && DragSortController.access$4(DragSortController.this) < i)
        {
            DragSortController.access$2(DragSortController.this).stopDragWithVelocity(true, f);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    istener()
    {
        this$0 = DragSortController.this;
        super();
    }
}
