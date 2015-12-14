// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.graphics.Canvas;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.colorpicker.c;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.LayerFillAction;
import java.util.UUID;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements c
{

    private DrawingActivity a;

    public final void a(int i)
    {
        DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
        if (!drawingview.c.f.b())
        {
            b b1 = drawingview.c.b;
            b1.j.drawColor(i);
            drawingview.c.a(b1);
            drawingview.a(true);
            ActionCollector.a().a(new LayerFillAction(UUID.fromString(b1.c), i, drawingview.c.f.d().key));
        }
    }

    llAction(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
