// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import myobfuscated.bw.d;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements d
{

    private DrawingActivity a;

    public final void a()
    {
        DrawingView drawingview = DrawingActivity.b(a);
        if (drawingview.c.h == com.socialin.android.brushlib.view.Mode.DRAW)
        {
            drawingview.setDrawingMode(com.socialin.android.brushlib.view.Mode.ERASE);
        } else
        {
            drawingview.setDrawingMode(com.socialin.android.brushlib.view.Mode.DRAW);
        }
        if (DrawingActivity.b(a) != null)
        {
            DrawingActivity.b(a).invalidate();
        }
    }

    public final boolean a(View view, MotionEvent motionevent)
    {
        return true;
    }

    ingMode(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
