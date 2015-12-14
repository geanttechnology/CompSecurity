// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.gizmo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.brushlib.gizmo:
//            Gizmo

public abstract class a extends Gizmo
{

    private Paint c;

    protected a(Overlay overlay, DrawingView drawingview)
    {
        super(overlay, drawingview);
        c = new Paint();
        c.setStrokeWidth(2.0F);
        c.setColor(0xff00ff00);
        c.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public abstract void a(Canvas canvas, RectF rectf);

    public final void a(Canvas canvas, Camera camera)
    {
        Transform transform = a.getViewportTransform(camera);
        RectF rectf = a.getTransformedBounds(false);
        rectf.right = rectf.right * camera.e;
        rectf.left = rectf.left * camera.e;
        rectf.top = rectf.top * camera.e;
        rectf.bottom = rectf.bottom * camera.e;
        canvas.save();
        canvas.translate(transform.getCx(), transform.getCy());
        canvas.rotate(transform.getRotation());
        a(canvas, rectf);
        canvas.restore();
    }
}
