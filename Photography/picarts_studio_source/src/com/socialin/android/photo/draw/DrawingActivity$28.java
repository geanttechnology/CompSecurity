// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity, b

final class a
    implements android.view.r
{

    private DrawingActivity a;

    public final void onClick(View view)
    {
        if (DrawingActivity.b(a).h() > 1)
        {
            DrawingActivity.b(a).i();
            view = DrawingActivity.b(a);
            ((DrawingView) (view)).c.a(((DrawingView) (view)).c.b, true);
            ((DrawingView) (view)).c.c();
            DrawingActivity.r(a).notifyDataSetChanged();
        }
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
