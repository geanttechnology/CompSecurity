// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.gizmo.SimpleTransformGizmo;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.overlay.ImageOverlay;
import com.socialin.android.brushlib.overlay.LineOverlay;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.overlay.ShapeOverlay;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.OverlayAdditionAction;
import java.util.UUID;

public final class e extends a
{

    private final DrawingView b;
    private SimpleTransformGizmo c;
    private Paint d;
    private RectF e;
    private RectF f;
    private RectF g;

    public e(DrawingView drawingview)
    {
        d = new Paint();
        e = new RectF();
        f = new RectF();
        g = new RectF();
        b = drawingview;
        d.setColor(0xffff0000);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeWidth(5F);
    }

    public final TouchResponse a(MotionEvent motionevent)
    {
        if (c != null)
        {
            e.set(super.a.getTransformedBounds(true));
            b.d.a(e);
            c.a(g);
            e.union(g);
            com.socialin.android.brushlib.gizmo.Gizmo.TouchResponse touchresponse = c.a(motionevent);
            if (touchresponse == com.socialin.android.brushlib.gizmo.Gizmo.TouchResponse.TRANSFORMED)
            {
                f.set(super.a.getTransformedBounds(true));
                b.d.a(f);
                c.a(g);
                f.union(g);
                e.union(f);
                b.a(e);
                motionevent = touchresponse;
            } else
            {
                motionevent = touchresponse;
                if (touchresponse == com.socialin.android.brushlib.gizmo.Gizmo.TouchResponse.TAP_OUTSIDE)
                {
                    d();
                    b.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
                    motionevent = touchresponse;
                }
            }
        } else
        {
            motionevent = null;
        }
        b.a(true);
        if (motionevent == com.socialin.android.brushlib.gizmo.Gizmo.TouchResponse.TRANSFORMED)
        {
            return TouchResponse.ACCEPT;
        } else
        {
            return TouchResponse.UNDEFINED;
        }
    }

    public final void a()
    {
        a(((Overlay) (null)));
        c = null;
    }

    public final void a(Canvas canvas)
    {
        if (c != null)
        {
            c.a(canvas, b.d);
        }
    }

    public final void a(Canvas canvas, b b1)
    {
        if (super.a != null && b1 == b.c.b && b1.f)
        {
            canvas.save();
            canvas.clipRect(b.j());
            b.d.a(canvas);
            super.a.draw(canvas);
            canvas.restore();
        }
    }

    public final void a(Bundle bundle)
    {
        Overlay overlay = (Overlay)bundle.getSerializable("overlay");
        if (!(overlay instanceof ShapeOverlay)) goto _L2; else goto _L1
_L1:
        ((ShapeOverlay)overlay).setParams((ShapeParams)bundle.getSerializable("overlayParams"));
_L4:
        bundle = (Transform)bundle.getSerializable("overlayTransform");
        if (overlay instanceof ImageOverlay)
        {
            ((ImageOverlay)overlay).initImage(b.c.k.getImageDataFolder());
        }
        a(overlay);
        overlay.getTransform().set(bundle);
        return;
_L2:
        if (overlay instanceof LineOverlay)
        {
            ((LineOverlay)overlay).setParams((ShapeParams)bundle.getSerializable("overlayParams"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(Overlay overlay)
    {
        if (super.a != null && (overlay instanceof ImageOverlay))
        {
            ((ImageOverlay)super.a).recycle();
        }
        if (overlay != null)
        {
            super.a(overlay);
            if (overlay != null)
            {
                super.a.getViewportTransform(b.d).setPosition((float)b.getWidth() / 2.0F, (float)b.getHeight() / 2.0F);
                float f1 = Math.min(b.getWidth(), b.getHeight());
                super.a.setSizeInViewport(f1 / 2.0F, b.d);
                c = SimpleTransformGizmo.a(b.getResources(), super.a, b);
                c.c = true;
                b.a(true);
            }
            return;
        } else
        {
            super.a(overlay);
            return;
        }
    }

    public final void d()
    {
        if (super.a != null)
        {
            if (b.c.b.g())
            {
                Toast.makeText(b.getContext(), 0x7f080406, 0).show();
            } else
            {
                Overlay overlay = super.a;
                overlay.draw(b.c.b.j);
                b.c.a(b.c.b);
                ActionCollector.a().a(new OverlayAdditionAction(overlay, UUID.fromString(b.c.b.c), b.c.f.d().key));
            }
            a();
        }
    }
}
