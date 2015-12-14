// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.view.r
{

    private DrawingActivity a;

    public final void onClick(View view)
    {
        if (DrawingActivity.b(a).b() == com.socialin.android.brushlib.view.Mode.ERASE && DrawingActivity.b(a).e() == com.socialin.android.brushlib.view.Mode.BRUSH)
        {
            DrawingActivity.aj(a);
        }
        DrawingActivity.b(a).setEditingMode(com.socialin.android.brushlib.view.Mode.BRUSH);
        DrawingActivity.b(a).setDrawingMode(com.socialin.android.brushlib.view.Mode.ERASE);
    }

    ingMode(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
