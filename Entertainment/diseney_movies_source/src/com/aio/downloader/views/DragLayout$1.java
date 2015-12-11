// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.aio.downloader.views:
//            DragLayout, MyRelativeLayout

class er.Callback extends android.support.v4.widget.r.Callback
{

    final DragLayout this$0;

    public int clampViewPositionHorizontal(View view, int i, int j)
    {
        if (DragLayout.access$0(DragLayout.this) + j < 0)
        {
            i = 0;
        } else
        if (DragLayout.access$0(DragLayout.this) + j > DragLayout.access$1(DragLayout.this))
        {
            return DragLayout.access$1(DragLayout.this);
        }
        return i;
    }

    public int getViewHorizontalDragRange(View view)
    {
        return DragLayout.access$2(DragLayout.this);
    }

    public void onViewPositionChanged(View view, int i, int j, int k, int l)
    {
        if (view == DragLayout.access$3(DragLayout.this))
        {
            DragLayout.access$5(DragLayout.this, i);
        } else
        {
            DragLayout draglayout = DragLayout.this;
            DragLayout.access$5(draglayout, DragLayout.access$0(draglayout) + i);
        }
        if (DragLayout.access$0(DragLayout.this) >= 0) goto _L2; else goto _L1
_L1:
        DragLayout.access$5(DragLayout.this, 0);
_L4:
        DragLayout.access$6(DragLayout.this, DragLayout.access$0(DragLayout.this));
        if (view == DragLayout.access$4(DragLayout.this))
        {
            DragLayout.access$4(DragLayout.this).layout(0, 0, DragLayout.access$2(DragLayout.this), DragLayout.access$7(DragLayout.this));
            DragLayout.access$3(DragLayout.this).layout(DragLayout.access$0(DragLayout.this), 0, DragLayout.access$0(DragLayout.this) + DragLayout.access$2(DragLayout.this), DragLayout.access$7(DragLayout.this));
        }
        return;
_L2:
        if (DragLayout.access$0(DragLayout.this) > DragLayout.access$1(DragLayout.this))
        {
            DragLayout.access$5(DragLayout.this, DragLayout.access$1(DragLayout.this));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onViewReleased(View view, float f, float f1)
    {
        super.onViewReleased(view, f, f1);
        if (f > 0.0F)
        {
            open();
            return;
        }
        if (f < 0.0F)
        {
            close();
            return;
        }
        if (view == DragLayout.access$3(DragLayout.this) && (double)DragLayout.access$0(DragLayout.this) > (double)DragLayout.access$1(DragLayout.this) * 0.29999999999999999D)
        {
            open();
            return;
        }
        if (view == DragLayout.access$4(DragLayout.this) && (double)DragLayout.access$0(DragLayout.this) > (double)DragLayout.access$1(DragLayout.this) * 0.69999999999999996D)
        {
            open();
            return;
        } else
        {
            close();
            return;
        }
    }

    public boolean tryCaptureView(View view, int i)
    {
        return true;
    }

    out()
    {
        this$0 = DragLayout.this;
        super();
    }
}
