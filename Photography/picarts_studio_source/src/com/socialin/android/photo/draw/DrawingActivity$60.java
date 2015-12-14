// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import com.socialin.android.brushlib.controller.h;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.LayerTransformAction;
import java.util.UUID;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.view.r
{

    private h a;
    private DrawingActivity b;

    public final void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131757767 2131757772: default 44
    //                   2131757767 45
    //                   2131757768 73
    //                   2131757769 81
    //                   2131757770 190
    //                   2131757771 300
    //                   2131757772 410;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        a.a();
        DrawingActivity.ap(b);
        com.socialin.android.photo.draw.DrawingActivity.b(b).setEditingMode(com.socialin.android.brushlib.view.Mode.BRUSH);
        return;
_L3:
        a.b();
        return;
_L4:
        view = a;
        b b1 = ((h) (view)).a.c.b;
        if (((h) (view)).k == null || !((h) (view)).k.isRunning())
        {
            view.l = ((h) (view)).a.c.b.a;
            ((h) (view)).m.set(((h) (view)).l);
            ((h) (view)).n.set(((h) (view)).l);
            ((h) (view)).n.preRotate(90F, b1.i() / 2, b1.j() / 2);
            view.a(((h) (view)).m, ((h) (view)).n);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        view = a;
        b b2 = ((h) (view)).a.c.b;
        if (((h) (view)).k == null || !((h) (view)).k.isRunning())
        {
            view.l = ((h) (view)).a.c.b.a;
            ((h) (view)).m.set(((h) (view)).l);
            ((h) (view)).n.set(((h) (view)).l);
            ((h) (view)).n.preScale(-1F, 1.0F, b2.i() / 2, b2.j() / 2);
            view.a(((h) (view)).m, ((h) (view)).n);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
        view = a;
        b b3 = ((h) (view)).a.c.b;
        if (((h) (view)).k == null || !((h) (view)).k.isRunning())
        {
            view.l = ((h) (view)).a.c.b.a;
            ((h) (view)).m.set(((h) (view)).l);
            ((h) (view)).n.set(((h) (view)).l);
            ((h) (view)).n.preScale(1.0F, -1F, b3.i() / 2, b3.j() / 2);
            view.a(((h) (view)).m, ((h) (view)).n);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
        view = a;
        b b4 = ((h) (view)).a.c.b;
        Bitmap bitmap = b4.b;
        Bitmap bitmap1 = b4.b;
        int i = b4.i();
        int j = b4.j();
        Matrix matrix = b4.a;
        Paint paint = new Paint(3);
        Bitmap bitmap2 = Bitmap.createBitmap(i, j, android.graphics._fld8888);
        (new Canvas(bitmap2)).drawBitmap(bitmap1, matrix, paint);
        ActionCollector.a().a(new LayerTransformAction(UUID.fromString(b4.c), new Matrix(b4.a), ((h) (view)).a.c.f.d().key));
        b4.a.reset();
        b4.b = bitmap2;
        b4.j = new Canvas(b4.b);
        bitmap.recycle();
        ((h) (view)).a.c.a(b4);
        ((h) (view)).a.a(true);
        DrawingActivity.ap(b);
        com.socialin.android.photo.draw.DrawingActivity.b(b).setEditingMode(com.socialin.android.brushlib.view.Mode.BRUSH);
        return;
    }

    ansformAction(DrawingActivity drawingactivity, h h1)
    {
        b = drawingactivity;
        a = h1;
        super();
    }
}
