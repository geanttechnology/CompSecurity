// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.graphics.PointF;
import android.view.ScaleGestureDetector;

// Referenced classes of package w.panzoomview:
//            PanZoomView

class l
    implements android.view.ScaleGestureDetector.OnScaleGestureListener
{

    final PanZoomView a;
    private float b;
    private float c;

    l(PanZoomView panzoomview)
    {
        a = panzoomview;
        super();
        b = 0.0F;
        c = 0.0F;
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getFocusX();
        float f1 = scalegesturedetector.getFocusY();
        float f2 = b;
        float f3 = c;
        float f4 = scalegesturedetector.getScaleFactor();
        scalegesturedetector = new PointF((float)a.getWidth() / 2.0F - f, (float)a.getHeight() / 2.0F - f1);
        PointF pointf = new PointF(f - f2, f1 - f3);
        PanZoomView.a(a, scalegesturedetector, pointf, f4);
        b = f;
        c = f1;
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getFocusX();
        float f1 = scalegesturedetector.getFocusY();
        b = f;
        c = f1;
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getFocusX();
        float f1 = scalegesturedetector.getFocusY();
        float f2 = b;
        float f3 = c;
        float f4 = scalegesturedetector.getScaleFactor();
        scalegesturedetector = new PointF((float)a.getWidth() / 2.0F - f, (float)a.getHeight() / 2.0F - f1);
        PointF pointf = new PointF(f - f2, f1 - f3);
        PanZoomView.b(a, scalegesturedetector, pointf, f4);
        b = 0.0F;
        c = 0.0F;
    }
}
