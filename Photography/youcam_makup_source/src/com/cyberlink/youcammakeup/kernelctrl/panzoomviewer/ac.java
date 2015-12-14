// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.PointF;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer

class ac
    implements android.view.ScaleGestureDetector.OnScaleGestureListener
{

    final PanZoomViewer a;
    private float b;
    private float c;

    ac(PanZoomViewer panzoomviewer)
    {
        a = panzoomviewer;
        super();
        b = 0.0F;
        c = 0.0F;
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getFocusX();
        float f1 = scalegesturedetector.getFocusY();
        float f2 = f - b;
        float f3 = f1 - c;
        float f4 = scalegesturedetector.getScaleFactor();
        PanZoomViewer.a(a, (new StringBuilder()).append("onScale focus x: ").append(f).append(" focux y: ").append(f1).append(" translate x: ").append(f2).append(" translate y: ").append(f3).append(" scale: ").append(f4).toString());
        scalegesturedetector = new PointF((float)a.getWidth() / 2.0F - f, (float)a.getHeight() / 2.0F - f1);
        PointF pointf = new PointF(f2, f3);
        PanZoomViewer.a(a, scalegesturedetector, pointf, f4);
        b = f;
        c = f1;
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getFocusX();
        float f1 = scalegesturedetector.getFocusY();
        float f2 = scalegesturedetector.getScaleFactor();
        b = f;
        c = f1;
        PanZoomViewer.a(a, (new StringBuilder()).append("onScaleBegin focus x: ").append(f).append(" focux y: ").append(f1).append(" scale: ").append(f2).toString());
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getFocusX();
        float f1 = scalegesturedetector.getFocusY();
        float f2 = f - b;
        float f3 = f1 - c;
        float f4 = scalegesturedetector.getScaleFactor();
        PanZoomViewer.a(a, (new StringBuilder()).append("onScaleEnd focus x: ").append(f).append(" focux y: ").append(f1).append(" translate x: ").append(f2).append(" translate y: ").append(f3).append(" scale: ").append(f4).toString());
        scalegesturedetector = new PointF((float)a.getWidth() / 2.0F - f, (float)a.getHeight() / 2.0F - f1);
        PointF pointf = new PointF(f2, f3);
        PanZoomViewer.b(a, scalegesturedetector, pointf, f4);
        b = 0.0F;
        c = 0.0F;
    }
}
