// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.colorpicker.c;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements c
{

    private DrawingActivity a;

    public final void a(int i)
    {
        DrawingActivity.b(a).setDrawingMode(com.socialin.android.brushlib.view.Mode.DRAW);
        DrawingActivity.b(a).setCurrentColor(i);
        DrawingActivity.j(a).run();
    }

    ingMode(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
