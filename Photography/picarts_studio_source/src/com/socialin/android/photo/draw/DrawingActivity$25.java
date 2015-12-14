// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.MotionEvent;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.a;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.view.DrawingView;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity, b

final class i extends a
{

    private DrawingActivity i;

    public final int a(MotionEvent motionevent)
    {
        int j = b(motionevent);
        if (j >= 0 && com.socialin.android.photo.draw.DrawingActivity.b(i).c.b == com.socialin.android.photo.draw.b.a(DrawingActivity.r(i)).get(j))
        {
            return j;
        } else
        {
            return -1;
        }
    }

    public final boolean onSingleTapUp(MotionEvent motionevent)
    {
        int j = b(motionevent);
        if (j != -1)
        {
            com.socialin.android.photo.draw.DrawingActivity.b(i).setSelectedLayer((b)com.socialin.android.photo.draw.b.a(DrawingActivity.r(i)).get(j));
            DrawingActivity.r(i).notifyDataSetChanged();
            return true;
        } else
        {
            return false;
        }
    }

    (DrawingActivity drawingactivity, DragSortListView dragsortlistview)
    {
        i = drawingactivity;
        super(dragsortlistview);
    }
}
