// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.MotionEvent;
import com.socialin.android.brushlib.view.DrawingView;
import myobfuscated.bw.e;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements e
{

    private DrawingActivity a;

    public final boolean a(MotionEvent motionevent)
    {
        return DrawingActivity.b(a).a(motionevent);
    }

    public final boolean b(MotionEvent motionevent)
    {
        return DrawingActivity.b(a).a(motionevent);
    }

    public final boolean c(MotionEvent motionevent)
    {
        return DrawingActivity.b(a).a(motionevent);
    }

    public final void d(MotionEvent motionevent)
    {
        DrawingView drawingview = DrawingActivity.b(a);
        if (drawingview.b() == com.socialin.android.brushlib.view.Mode.DRAW)
        {
            drawingview.setDrawingMode(com.socialin.android.brushlib.view.Mode.ERASE);
        } else
        {
            drawingview.setDrawingMode(com.socialin.android.brushlib.view.Mode.DRAW);
        }
        if (DrawingActivity.b(a) != null)
        {
            DrawingActivity.b(a).a(motionevent);
            DrawingActivity.b(a).invalidate();
        }
    }

    ingMode(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
