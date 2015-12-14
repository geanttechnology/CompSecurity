// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import com.mobeta.android.dslv.i;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity, b

final class a
    implements i
{

    private DrawingActivity a;

    public final void a(int j, int k)
    {
        int l = DrawingActivity.b(a).h();
        DrawingView drawingview = DrawingActivity.b(a);
        drawingview.c.a(l - j - 1, l - k - 1);
        drawingview.c.c();
        DrawingActivity.b(a).invalidate();
        DrawingActivity.r(a).notifyDataSetChanged();
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
