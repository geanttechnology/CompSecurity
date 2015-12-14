// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.colorpicker.d;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements d
{

    private DrawingActivity a;

    public final void a()
    {
        DrawingActivity.b(a, false);
        DrawingActivity.k(a).setVisibility(0);
        DrawingActivity.k(a).animate().alpha(1.0F).setDuration(300L).setListener(null);
        DrawingActivity.l(a).setVisibility(0);
        DrawingActivity.l(a).animate().alpha(1.0F).setDuration(300L).setListener(null);
        if (DrawingActivity.m(a) == erPanelState.OPENED || DrawingActivity.n(a) == erPanelState.OPENING)
        {
            DrawingActivity.o(a);
        }
        DrawingActivity.b(a).setEditingMode(com.socialin.android.brushlib.view.Mode.COLOR_PICKER);
        DrawingActivity.b(a).a(true);
    }

    public final void b()
    {
        DrawingActivity.b(a, true);
        DrawingActivity.k(a).setVisibility(0);
        DrawingActivity.k(a).animate().alpha(1.0F).setDuration(300L).setListener(null);
        DrawingActivity.l(a).setVisibility(0);
        DrawingActivity.l(a).animate().alpha(1.0F).setDuration(300L).setListener(null);
        if (DrawingActivity.m(a) == erPanelState.OPENED || DrawingActivity.n(a) == erPanelState.OPENING)
        {
            DrawingActivity.o(a);
        }
    }

    ingMode(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
