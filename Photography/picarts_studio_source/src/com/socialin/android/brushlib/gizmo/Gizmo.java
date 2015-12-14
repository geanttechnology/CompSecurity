// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.gizmo;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;

public abstract class Gizmo
{

    protected final Overlay a;
    protected final DrawingView b;

    protected Gizmo(Overlay overlay, DrawingView drawingview)
    {
        a = overlay;
        b = drawingview;
    }

    public abstract TouchResponse a(MotionEvent motionevent);

    public abstract void a(Canvas canvas, Camera camera);

    public abstract void a(RectF rectf);
}
